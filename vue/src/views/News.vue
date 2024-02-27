<script>
import axios from "@/axios";
import { quillEditor } from 'vue-quill-editor'
import "quill/dist/quill.core.css"; // import styles
import "quill/dist/quill.snow.css"; // for snow theme
import "quill/dist/quill.bubble.css"; // for bubble theme

export default {
  name: "SelectNews",
  components: {
    quillEditor
  },
  data() {
    return {
      editorOption: {
        modules: {
          toolbar: [
            // 加粗 斜体 下划线 删除线 -----['bold', 'italic', 'underline', 'strike']
            ['bold', 'italic', 'underline', 'strike'],
            // 引用  代码块-----['blockquote', 'code-block']
            ['blockquote', 'code-block'],
            // 1、2 级标题-----[{ header: 1 }, { header: 2 }]
            [{ header: 1 }, { header: 2 }],
            // 有序、无序列表-----[{ list: 'ordered' }, { list: 'bullet' }]
            [{ list: 'ordered' }, { list: 'bullet' }],
            // 上标/下标-----[{ script: 'sub' }, { script: 'super' }]
            [{ script: 'sub' }, { script: 'super' }],
            // 缩进-----[{ indent: '-1' }, { indent: '+1' }]
            [{ indent: '-1' }, { indent: '+1' }],
            // 文本方向-----[{'direction': 'rtl'}]
            [{ direction: 'rtl' }],
            // 字体大小-----[{ size: ['small', false, 'large', 'huge'] }]
            [{ size: ['small', false, 'large', 'huge'] }],
            // 标题-----[{ header: [1, 2, 3, 4, 5, 6, false] }]
            [{ header: [1, 2, 3, 4, 5, 6, false] }],
            // 字体颜色、字体背景颜色-----[{ color: [] }, { background: [] }]
            [{ color: [] }, { background: [] }],
            // 字体种类-----[{ font: [] }]
            [{ font: [] }],
            // 对齐方式-----[{ align: [] }]
            [{ align: [] }],
            // 清除文本格式-----['clean']
            ['clean'],
            // 链接、图片、视频-----['link', 'image', 'video']
            ['image']
          ]
        },
        theme: 'snow'
      },
      tableData: [],
      multipleSelection: [],
      pageNum: 1,
      pageSize: 10,
      newsId: '',
      newsTitle: '',
      newsAddTime: '',
      total: 0,
      search: '',
      form: {},
      dialogFormVisible: false
    }
  },

  created() {
    this.load()
  },

  methods: {
    load() {
      axios.get("/news/page", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          id: this.newsId,
          title: this.newsTitle,
          addtime: this.newsAddTime
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.total = res.data.total
      })
    },

    save() {
      this.form.addtime = new Date().toISOString();

      axios.post("/news", this.form,{
        headers: {
          'Content-Type': 'application/json'
        }
      })
          .then(res => {
            if (res.data) {
              this.$message.success("保存成功!")
              this.dialogFormVisible = false
              this.load()
            } else {
              this.$message.error("保存失败!")
            }
          })
    },

    del(id) {
      axios.delete("/news/" + id)
          .then(res => {
            if (res.data) {
              this.$message.success("删除成功!")
              this.load()
            } else {
              this.$message.error("删除失败!")
            }
          })
    },

    delBatch() {
      let ids = this.multipleSelection.map(v => v.id)

      axios.post("/news/del/batch", ids, {
        headers: {
          'Content-Type': 'application/json'
        }
      })
          .then(res => {
            if (res.data) {
              this.$message.success("删除成功!")
              this.load()
            } else {
              this.$message.error("删除失败!")
            }
          })
    },

    handleAdd() {
      this.dialogFormVisible = true
      this.form = {}
    },

    toggleSelection(rows) {
      if (rows) {
        rows.forEach(row => {
          this.$refs.multipleTable.toggleRowSelection(row);
        });
      } else {
        this.$refs.multipleTable.clearSelection();
      }
    },
    handleSelectionChange(val) {
      console.log(val)
      this.multipleSelection = val;
    },
    handleSizeChange(pageSize) {
      console.log(`每页 ${pageSize} 条`);
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(`当前页: ${pageNum}`);
      this.pageNum = pageNum
      this.load()
    },
    handleEdit(index, row) {
      console.log(index, row);
      this.form = row
      this.dialogFormVisible = true
    }
  }
}
</script>

<template>
  <div>
    <div style="padding: 10px 0;">
      <el-button type="primary" @click="handleAdd">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
      <el-popconfirm
          confirm-button-text='确定'
          cancel-button-text='我再想想'
          icon="el-icon-info"
          icon-color="red"
          title="您确定批量删除这些数据吗？"
          @confirm="delBatch"
          style="margin-left: 10px"
      >
        <el-button type="danger" slot="reference">批量删除 <i class="el-icon-remove-outline"></i></el-button>
      </el-popconfirm>
    </div>
    <el-table
        ref="multipleTable"
        :data="tableData"
        tooltip-effect="dark"
        style="width: 100%"
        @selection-change="handleSelectionChange">
      <el-table-column
          type="selection"
          width="55">
      </el-table-column>
      <el-table-column
          label="新闻id"
          width="120">
        <template slot-scope="scope">{{ scope.row.id }}</template>
      </el-table-column>
      <el-table-column
          prop="title"
          label="新闻标题"
          width="550">
      </el-table-column>
      <el-table-column
          prop="addtime"
          label="发布时间"
          show-overflow-tooltip>
      </el-table-column>
      <el-table-column
          align="right">
        <template slot="header">
          <el-input
              v-model="newsTitle"
              size="mini"
              placeholder="请输入您要搜索的内容"
              @input="load"
          />
        </template>
        <template slot-scope="scope">
          <el-button
              size="mini"
              plain
              class="custom-edit-color"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-popconfirm
              confirm-button-text='确定'
              cancel-button-text='我再想想'
              icon="el-icon-info"
              icon-color="red"
              title="您确定删除吗？"
              @confirm="del(scope.row.id)"
          >
          <el-button
              slot="reference"
              size="mini"
              type="danger"
              style="margin-left: 5px;"
              >删除</el-button>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div class="block">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="pageNum"
          :page-sizes="[2, 5, 10, 20]"
          :page-size="pageSize"
          layout="total, sizes, prev, pager, next, jumper"
          :total="400">
      </el-pagination>
    </div>

    <el-dialog title="用户信息" :visible.sync="dialogFormVisible" width="50%">
      <el-form label-width="80px" size="small">
        <el-form-item label="新闻id" :label-width="formLabelWidth">
          <el-input v-model="form.id" autocomplete="off" disabled="true"></el-input>
        </el-form-item>
        <el-form-item label="新闻标题" :label-width="formLabelWidth">
          <el-input v-model="form.title" autocomplete="off"></el-input>
        </el-form-item>
        <label>新闻内容</label>
        <quill-editor v-model="form.content" :editorOption="editorOption"></quill-editor>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="save">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped>
.custom-edit-color {
  background-color: #42b983;
  color: white;
}
</style>