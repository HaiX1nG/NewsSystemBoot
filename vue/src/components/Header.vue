<script>
export default {
  name: "ManageHeader"
}
</script>

<template>
  <div>
    <el-header style="width: 1000px; text-align: right; font-size: 12px;">
      <el-dropdown style=" top:50%; color: white">
        <span>王小虎</span>
        <i class="el-icon-setting" style="margin-right: 15px"></i>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>更新资料</el-dropdown-item>
          <el-dropdown-item>切换用户</el-dropdown-item>
          <el-dropdown-item>注销</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </el-header>
  </div>
</template>

<style scoped>

</style>