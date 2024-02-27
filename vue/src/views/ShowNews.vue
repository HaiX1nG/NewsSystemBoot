<script>
import SearchNews from "@/components/SearchNews.vue";
import RealTime from "@/components/RealTime.vue";
import DropDownMenuBar from "@/components/DropDownMenuBar.vue";
import FooterUrl from "@/components/FooterUrl.vue";
import Footer from "@/components/Footer.vue";
import axios from "@/axios";

export default {
  name: "ShowNews",
  components: {
    Footer,
    FooterUrl,
    DropDownMenuBar,
    RealTime,
    SearchNews
  },

  data() {
    return {
      news: {}
    }
  },

  async created() {
    const newsId = this.$route.params.id
    try {
      const response = await axios.get(`/news/shownews?id=${newsId}`)
      this.news = response.data
    } catch (error) {
      console.log('Error fetching news:', error)
    }
  }
}
</script>

<template>
  <div id="body">
    <div id="header">
      <div id="logo">
        <img src="../assets/images/logo.png" alt="logo">
      </div>

      <div id="plugin">
        <div id="timer">
          <real-time></real-time>
        </div>

        <div id="search_news">
          <search-news></search-news>
        </div>
      </div>

      <div id="nav">
        <drop-down-menu-bar></drop-down-menu-bar>
      </div>

      <div id="box_1">

      </div>

      <div id="news">
        <table style="width: 100%; height: 100%;">
          <tr style="height: 98%">
            <td style="font-size: 20px; font-weight: bold">&nbsp;&nbsp;新闻资讯</td>
          </tr>
          <tr>
            <td class="bottom-img" colspan="2"></td>
          </tr>
        </table>

        <div id="news-title" style="background-color: white; text-align: center; padding: 10px;">
          <h2>{{ news.title }}</h2>
        </div>

        <div id="news-time" style="background-color: white; text-align: center; padding: 10px;">
          <p>{{news.addtime}}</p>
        </div>

        <div id="news-content" style="background-color: white; padding: 10px;">
          <div v-html="news.content"></div>
        </div>
      </div>

      <div id="footer_nav">
        <div id="footer_title">
          <table style="width: 100%; height: 100%;">
            <tr style="height: 98%;">
              <td class="bgimg">&nbsp;友情链接</td>
              <td class="bgright"></td>
            </tr>
            <tr>
              <td class="bottom-img" colspan="2"></td>
            </tr>
          </table>
        </div>

        <div id="footer_url">
          <footer-url></footer-url>
        </div>
      </div>

      <div id="box_2">

      </div>

      <div id="footer">
        <Footer></Footer>
      </div>
    </div>
  </div>
</template>

<style scoped>
* {
  margin: 0;
  padding: 0;
  font-family: "Microsoft YaHei", system-ui;
}

#body {
  width: 100%;
  height: 1341px;
  background: url("../assets/images/bg.jpg");
}

#header {
  width: 100%;
  height: 115px;
  background-color: #049cde;
}

#logo {
  width: 300px;
}

#logo > img {
  margin-top: 8%;
  margin-left: 35%;
}

#plugin {
  position: relative; /* 添加相对定位 */
  width: 300px;
  height: 100px;
  margin-left: auto;
  margin-top: -5.5%;
  margin-right: 13%;
}

#timer {
  position: absolute; /* 子组件绝对定位 */
  top: 0; /* 首先让顶部与父容器对齐 */
  right: 0; /* 靠右对齐 */
  display: flex;
  align-items: center; /* 使用flex布局使其内容垂直居中 */
  justify-content: flex-end; /* 内容向右侧对齐 */
  width: 300px;
  height: 50px;
}

#search_news {
  position: absolute; /* 子组件绝对定位 */
  top: 50%; /* 首先让顶部与父容器对齐 */
  right: 0; /* 靠右对齐 */
  display: flex;
  align-items: center; /* 使用flex布局使其内容垂直居中 */
  justify-content: flex-end; /* 内容向右侧对齐 */
  width: 300px;
  height: 50px;
}

#nav {
  width: 100%;
  height: 50px;
  background-color: #00549c;
}

#box_1 {
  width: 100%;
  height: 22px;
}

#news {
  width: 50%;
  height: auto;
  margin: auto;
}

#footer_nav {
  width: 1200px;
  height: 100px;
  margin: auto;
}

#footer_title {
  width: 1200px;
  height: 35px;
}

#footer_title table {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
}

#footer_title table td {
  padding: 0; /* 取消单元格内的默认内边距 */
  margin: 0;
}

#footer_url {
  width: 1200px;
  height: 60px;
  background-color: darkslategrey;
  margin-top: 5px;
}

#box_2 {
  width: 100%;
  height: 22px;
}

#footer {
  width: 100%;
  height: 85px;
  background-color: white;
}

.bgimg {
  background: url("../assets/images/btbg.jpg") no-repeat center center;
  width: 123px;
  height: 35px;
  text-align: left;
  color: #fff;
}

.bottom-img {
  width: 100%;
  background: url("../assets/images/dydx.jpg") repeat-x center center;
  height: 5px;
}
</style>