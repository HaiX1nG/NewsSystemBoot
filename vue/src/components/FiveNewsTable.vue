<script>
import axios from "@/axios";

export default {
  name: "FiveNewsTable",
  data() {
    return {
      title: '',
      addtime: '',
      newsList: [this.title, this.addtime]
    }
  },
  async created() {
    try {
      await axios.get('/news/findLastFiveNews')
          .then(res => {
            console.log(res.data)
            this.newsList = res.data.map(news => ({
              ...news,
              addtimeFormatted: this.formatDate(news.addtime)
            }))
          })
    } catch (error) {
      console.error('Error fetching news:', error)
    }
  },

  methods: {
    formatDate(dateStr) {
      const date = new Date(dateStr)
      const year = date.getFullYear()
      const month = ('0' + (date.getMonth() + 1)).slice(-2)
      const day = ('0' + date.getDate()).slice(-2)

      return `${year}-${month}-${day}`
    }
  }
}
</script>

<template>
  <diV>
    <table style="width: 584px; height: 207px; margin: 0; padding: 0;">
      <tbody>
      <tr v-for="news in newsList" :key="news">
        <td style="width: 10px; height: 36px; font-size: 14px; text-align: center;">
          <span>·</span>
        </td>
        <td class="news-title" style="width: 478px; height: 36px; font-size: 14px;">
          <router-link :to="{ name: '显示新闻', params: { id: news.id } }" style="text-decoration: none; color: #222222;" :title="news.title">
            {{ news.title }}
          </router-link>
        </td>
        <td style="width: 78px; height: 36px; font-size: 14px; color: #777777">
          {{ news.addtimeFormatted }}
        </td>
      </tr>
      </tbody>
    </table>
  </diV>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Microsoft YaHei", system-ui;
}

.news-title a:hover {
  color: #cc0000 !important;
}
</style>