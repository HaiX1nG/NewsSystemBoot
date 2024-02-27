<script>
import NavMenu from "@/components/NavMenu.vue";
import News from "@/views/News.vue";
import Header from "@/components/Header.vue";

export default {
  name: "NewsManage",
  components: {
    NavMenu,
    News,
    Header
  }
}
</script>

<template>
  <div id="main">
    <div id="navMenu">
      <nav-menu></nav-menu>
    </div>

    <div id="content-main">
      <div id="header">
        <img src="@/assets/images/logo.png" alt="" style="width: 20%; height: 50%; margin-top: 1%;">
        <Header></Header>
      </div>
      <hr>
      <div id="content">
        <News></News>
      </div>
    </div>
  </div>
</template>

<style scoped>
#main {
  display: flex;
  width: 100%;
  height: 100vh;
  border: 1px solid black;
}

#navMenu {
  width: 20%;
  height: 100vh;
  border: 1px solid black;
}

#content-main {
  width: 80%;
}

#header {
  display: flex;
  width: 100%;
  height: 10vh;
  background: #049cde;
}
</style>