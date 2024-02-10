<template>
  <div style="margin-top: 46px;">
    <el-carousel :interval="5000" width="470px" height="290px" @change="changeImg" indicator-position="outside" style="top: -35px;">
      <el-carousel-item v-for="(item,index) in images" :key="index">
        <el-image
            :class="className"
            style="width:100%; height:100%"
            :src="item.idView"
            fit="fit">

        </el-image>
        <div class="carousel-item-title">
          <p>{{ item.title }}</p>
        </div>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
export default {
  name: 'ImageCarousel',
  data() {
    return {
      images: [
        {id: 0, idView: require('../assets/images/img1.png'), title: '中国（江西）-东盟产教融合对接交流会成功举办'},
        {id: 1, idView: require('../assets/images/img2.jpg'), title: '江西外语外贸职业学院成功举办2023江西跨境电子商务人才培养国际研讨会'},
        {id: 2, idView: require('../assets/images/img3.jpg'), title: '学院学习贯彻习近平新时代中国特色社会主义思想主题教育专题读书班开班'}
      ],
      className: "",
    }
  },
  mounted() {
    this.className = "lun-img-two";
    setTimeout(() => {
      this.className = "lun-img";
    }, 300);
  },
  methods: {
    changeImg: function () {
      this.className = "lun-img-two";
      setTimeout(() => {
        this.className = "lun-img";
      }, 300);
    }
  }
}
</script>

<style scoped>
.lun-img {
  transition: all 4s;
  transform: scale(1);
}
.lun-img-two {
  transform: scale(0.98);
}
.el-carousel__item.is-animating {
  transition: transform 1s ease-in-out;
}

.carousel-item-title {
  position: absolute;
  width: 400px;
  height: 35px;
  bottom: 0;
  left: 51px;
  color: #fff;
  font-size: 16px;
  background-color: #09a5e9;
  padding: 10px;
}
</style>
