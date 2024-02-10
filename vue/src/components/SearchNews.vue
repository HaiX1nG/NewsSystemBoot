<script>

import axios from "@/axios";

export default {
  name: "SearchNews",
  data() {
    return {
      newsList: [{
        value: '1',
        address: '1',
        title: '1',
        image: require('@/assets/images/search.jpg')
      }],
      searchQuery: '',
      placeholderImage: require('@/assets/images/search.jpg'),
      timeout:  null
    };
  },
  methods: {
// 新增从服务器获取新闻的方法
    async fetchNews(queryString) {
      try {
        return await axios.get(`/news/search?title=${queryString}`)
      }catch (error) {
        console.log('Error fetching news:', error)
      }
    },

    querySearchAsync(queryString, cb) {
      clearTimeout(this.timeout)

      if (queryString.trim()) {
        this.timeout = setTimeout(() => {
          this.fetchNews(queryString).then((r) => {
            const result = r.data.filter(item => {
                  item.value = item.title
                  item.address = item.id
                  return item.title.toLowerCase().indexOf(queryString.toLowerCase()) !== -1
                }
            )

            cb(result)
          })
        }, 300 * Math.random())
      } else {
        cb([])
      }
    },

    handleSelect(item) {
      console.log(item);
    }
  },
  mounted() {
    this.fetchNews("''")
  }
}
</script>

<template>
  <div class="search-container">
      <div class="search-input-flex">
        <p style="font-size: 14px; color: white">搜索:</p>
        <el-autocomplete
            v-model="searchQuery"
            :fetch-suggestions="querySearchAsync"
            style="width: 152px; height: 29px;"
            label="搜索"
            @select="handleSelect"
        >
        </el-autocomplete>

        <input type="image" :src="placeholderImage" valign="bottom" style="cursor: hand;">
      </div>
  </div>
</template>

<style scoped>.search-container {
  display: flex;
  flex-direction: column;
}

.search-input-flex {
  display: flex;
  align-items: center;
}
</style>