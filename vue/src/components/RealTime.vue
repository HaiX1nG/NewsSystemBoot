<script>
export default {
  name: "RealTime",
  data() {
    return {
      currentTime: new Date()
    }
  },
  computed: {
    formattedTime: function () {
      const date = this.currentTime
      const year = date.getFullYear()
      const month = date.getMonth() + 1 // 获取月份并补零
      const day = date.getDate() // 获取日期并补零
      const weekDay = ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'][date.getDay()]
      const hours = ('0' + date.getHours()).slice(-2)
      const minutes = ('0' + date.getMinutes()).slice(-2)
      const seconds = ('0' + date.getSeconds()).slice(-2)

      return `${year}年${month}月${day}日${weekDay}${hours}:${minutes}:${seconds}`
    }
  },
  mounted() {
    setInterval(() => {
      this.currentTime = new Date()
    }, 1000) // 每秒更新一次
  }
}
</script>

<template>
  <div>
    <p style="font-size: 14px; color: white;">
      {{ formattedTime }}
    </p>
  </div>
</template>

<style scoped>

</style>