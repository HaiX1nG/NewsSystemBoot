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
    </div>

    <div id="nav">
      <drop-down-menu-bar></drop-down-menu-bar>
    </div>

    <div id="box_1"></div>

    <div id="content_title_1">
      <table style="width: 100%; height: 100%;">
          <tr style="height: 98%">
            <td class="bgimg">&nbsp;&nbsp;新闻资讯</td>
            <td class="bgright"><a href="#">MORE+</a></td>
          </tr>
          <tr>
            <td class="bottom-img" colspan="2"></td>
          </tr>
      </table>
    </div>

    <div id="content_1">
      <div id="content_img">
        <image-carousel></image-carousel>
      </div>
      <div id="box_2"></div>
      <div id="content_table_1">
        <eight-news-table></eight-news-table>
      </div>
    </div>

    <div id="box_3"></div>

    <div id="content_2">
      <div id="content_table_2">
        <div id="content_title_2">
          <table style="width: 100%; height: 100%;">
            <tr style="height: 98%">
              <td class="bgimg">&nbsp;&nbsp;通知公告</td>
              <td class="bgright"><a href="#">MORE+</a></td>
            </tr>
            <tr>
              <td class="bottom-img" colspan="2"></td>
            </tr>
          </table>
        </div>
        <div id="content_table_2_1">
          <five-news-table></five-news-table>
        </div>
      </div>

      <div id="box_4"></div>

      <div id="content_table_3">
        <div id="content_title_3">
          <table style="width: 100%; height: 100%;">
            <tr style="height: 98%">
              <td class="bgimg">&nbsp;&nbsp;通知公告</td>
              <td class="bgright"><a href="#">MORE+</a></td>
            </tr>
            <tr>
              <td class="bottom-img" colspan="2"></td>
            </tr>
          </table>
        </div>
        <div id="content_table_3_1">
          <five-news-table></five-news-table>
        </div>
      </div>
    </div>

    <div id="box_5"></div>

    <div id="content_3">
      <div id="content_table_4">
        <tab-news-table></tab-news-table>
      </div>

      <div id="box_6"></div>

      <div id="content_table_5">
        <teacher-information></teacher-information>
      </div>
    </div>

    <div id="box_7"></div>

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

    <div id="box_8"></div>

    <div id="footer">
      <Footer></Footer>
    </div>
  </div>
</template>

<script>
import SearchNews from "@/components/SearchNews.vue";
import RealTime from "@/components/RealTime.vue";
import DropDownMenuBar from "@/components/DropDownMenuBar.vue";
import ImageCarousel from "@/components/ImageCarousel.vue";
import EightNewsTable from "@/components/EightNewsTable.vue";
import FiveNewsTable from "@/components/FiveNewsTable.vue";
import TabNewsTable from "@/components/TabNewsTable.vue";
import TeacherInformation from "@/components/TeacherInformation.vue";
import FooterUrl from "@/components/FooterUrl.vue";
import Footer from "@/components/Footer.vue";

export default {
  name: 'HomePage',
  data() {
    return {

    }
  },

  components: {
    SearchNews,
    RealTime,
    DropDownMenuBar,
    ImageCarousel,
    EightNewsTable,
    FiveNewsTable,
    TabNewsTable,
    TeacherInformation,
    FooterUrl,
    Footer
  }

}
</script>

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
  height: 25px;
}

#content_title_1 {
  width: 1200px;
  height: 40px;
  margin: auto;
}

#content_title_1 table {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
}

#content_title_1 table td {
  padding: 0; /* 取消单元格内的默认内边距 */
  margin: 0;
}

#content_1 {
  display: flex;
  width: 1200px;
  height: 340px;
  background-color: white;
  margin: auto;

}

#content_img {
  width: 474px;
  height: 336px;
}

#box_2 {
  width: 30px;
  height: 336px;
}

#content_table_1 {
  width: 660px;
  height: 336px;
}

#box_3 {
  width: 100%;
  height: 22px;
}

#content_2 {
  display: flex;
  width: 1200px;
  height: 255px;
  margin: auto;
}

#content_title_2 {
  width: 584px;
  height: 35px;
}

#content_title_2 table {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
}

#content_title_2 table td {
  padding: 0; /* 取消单元格内的默认内边距 */
  margin: 0;
}

#content_table_2 {
  width: 584px;
  height: 255px;
}

#content_table_2_1 {
  width: 584px;
  height: 215px;
  background-color: white;
  margin-top: 5px;
}

#box_4 {
  width: 30px;
  height: 255px;
}

#content_title_3 {
  width: 584px;
  height: 35px;
}

#content_title_3 table {
  width: 100%;
  table-layout: fixed;
  border-collapse: collapse;
}

#content_title_3 table td {
  padding: 0; /* 取消单元格内的默认内边距 */
  margin: 0;
}

#content_table_3 {
  width: 584px;
  height: 255px;
}

#content_table_3_1 {
  width: 584px;
  height: 215px;
  background-color: white;
  margin-top: 5px;
}

#box_5 {
  width: 100%;
  height: 22px;
}

#content_3 {
  display: flex;
  width: 1200px;
  height: 255px;
  margin: auto;
}

#content_table_4 {
  width: 584px;
  height: 247px;
}

#box_6 {
  width: 30px;
  height: 247px;
}

#content_table_5 {
  width: 584px;
  height: 247px;
}

#box_7 {
  width: 100%;
  height: 22px;
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

#footer {
  width: 100%;
  height: 85px;
  background-color: white;
}

#box_8 {
  width: 100%;
  height: 22px;
}

.bgimg {
  background: url("../assets/images/btbg.jpg") no-repeat center center;
  width: 123px;
  height: 35px;
  text-align: left;
  color: #fff;
}

.bgright {
  vert-align: middle;
  text-align: right;
}

.bgright > a {
  text-decoration: none;
  color: #666666;
}

.bottom-img {
  width: 100%;
  background: url("../assets/images/dydx.jpg") repeat-x center center;
  height: 5px;
}
</style>
