<script>
import axios from "@/axios";

export default {
  name: "TabNewsTable",
  data() {
    return {
      newsTitle: '',
      newsAddTime: '',
      tabData: [
        {
          title: '专利信息',
          newsList: [this.newsTitle, this.newsAddTime]
        },
        {
          title: '发明专利',
          newsList: [this.newsTitle, this.newsAddTime]
        },
        {
          title: '实用新型',
          newsList: [this.newsTitle, this.newsAddTime]
        },
        {
          title: '外观设计',
          newsList: [this.newsTitle, this.newsAddTime]
        }
      ],
      currentCategory: 0
    }
  },

  async created() {
    try {
      await axios.get('/news/findLastFiveNews')
          .then(res => {
            this.tabData.forEach(category => {
              category.newsList = res.data.map(news => ({
                ...news,
                addtimeFormatted: this.formatDate(news.addtime)
              }))
            })
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
    },
    changeCategory(categoryIndex) {
      this.currentCategory = categoryIndex
    },
    handleClick(index) {
      this.currentCategory = index
    }
  }
}
</script>

<template>
  <div style="width: 583px; height: 247px;">
    <table>
      <tbody>
      <tr>
        <td>
          <div>
            <div id="header">
                <span class="more">
                  <a href="#" @click.prevent="changeCategory(0)" :class="{ active: currentCategory === 0 }">MORE+</a>
                  <a href="#" @click.prevent="changeCategory(1)" :class="{ active: currentCategory === 1 }">MORE+</a>
                  <a href="#" @click.prevent="changeCategory(2)" :class="{ active: currentCategory === 2 }">MORE+</a>
                  <a href="#" @click.prevent="changeCategory(3)" :class="{ active: currentCategory === 3 }">MORE+</a>
                </span>
              <ul>
                <li v-for="(category, index) in tabData" :key="index" @mouseover="handleClick(index)" :class="{ active: currentCategory === index }">
                  {{ category.title }}
                </li>
              </ul>
            </div>
            <div id="tabBody">
              <div id="conWrap">
                <div class="con" v-for="(category, index) in tabData" :key="index" v-show="currentCategory === index">
                  <ul>
                    <table style="width: 583px; height: 184px; margin: 0; padding: 0; background-color: white;">
                      <tbody>
                      <tr v-for="news in category.newsList" :key="news.id">
                        <td style="width: 10px; height: 36px; font-size: 14px; text-align: center;"><span>·</span></td>
                        <td class="news-title" style="width: 482px; height: 36px; font-size: 14px;">
                          <a href="#" :title="news.title">
                            {{ news.title }}
                          </a>
                        </td>
                        <td style="width: 78px; height: 36px; font-size: 14px; color: #777777">
                          {{ news.addtimeFormatted }}
                        </td>
                      </tr>
                      </tbody>
                    </table>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  list-style: none;
  font-family: "Microsoft YaHei", serif;
}

#header {
  display: block;
  width: 583px;
  height: 40px;
  border-bottom: 3px solid #0353a2;
  position: relative;
}

.more {
  float: right;
  font-size: 14px;
  line-height: 40px;
  color: #666666;
}

.more > a {
  display: none;
  text-decoration: none;
  color: #333;
}

.more > a.active {
  color: rgb(102, 102, 102);
  display: inline;
}

#header > ul {
  z-index: 5;
  position: absolute;
  width: 492px;
  height: 40px;
  line-height: 40px;
  overflow: hidden;
  zoom: 1;
}

#header > ul > li {
  width: 103px;
  height: 40px;
  float: left;
  padding: 0 10px;
  cursor: pointer;
}

#header > ul > li.active {
  background-image: url("@/assets/images/btbg.jpg");
  background-repeat: no-repeat;
  color: white;
}

.news-title > a {
  color: #222222;
  text-decoration: none;
}

.news-title > a:hover {
  color: #cc0000 !important;
}
</style>