<template>
  <div class="nav" style="width: 1200px; height: 100%; margin: auto;">
    <div class="nav-item" v-for="(item, index) in navItems" :key="index">
      <span class="nav-link" @mouseover="showDropdown(index)" @mouseout="hideDropdown(index)">
        {{ item.title }}
      </span>
      <div v-if="activeIndex === index" class="dropdown">
        <a v-for="(link, linkIndex) in item.links" :key="linkIndex" :href="link.url" class="dropdown-link">
          {{ link.label }}
        </a>
      </div>
    </div>

  </div>
</template>

<script>
export default {
  name: "DropDownMenuBar",
  data() {
    return {
      activeIndex: -1,
      navItems: [
        {
          title: '首页',
          links: []
        },
        {
          title: '科技成果',
          links: [
            {label: '科技成果', url: '#'},
          ]
        },
        {
          title: '专利信息',
          links: [
            {label: '发明专利', url: '#'},
            {label: '使用新型', url: '#'},
            {label: '外观设计', url: '#'},
          ]
        },
        {
          title: '科技专家',
          links: [
            {label: '社会科学领域', url: '#'},
            {label: '自然科学领域', url: '#'},
          ]
        },
        {
          title: '研究平台',
          links: [
            {label: '省部级平台', url: '#'},
            {label: '市厅级平台', url: '#'},
            {label: '校级平台', url: '#'},
          ]
        },
        {
          title: '政策法规',
          links: [
            {label: '国家政策', url: '#'},
            {label: '地方政策', url: '#'},
            {label: '校内政策', url: '#'},
          ]
        },
        {
          title: '下载中心',
          links: [
            {label: '下载中心', url: '#'},
          ]
        },
        {
          title: '联系我们',
          links: [
            {label: '联系我们', url: '#'},
          ]
        },
        // 添加更多菜单项...
      ]
    };
  },
  methods: {
    showDropdown(index) {
      this.activeIndex = index;
    },
    hideDropdown() {
      this.activeIndex = -1;
    }
  }
}
</script>

<style scoped>
.nav {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #00549c;
  color: white;
  text-align: center;
  padding: 0;
}

.nav-item {
  display: flex;
  justify-content: center;
  position: relative;
  width: 150px;
  height: 40px;
  text-align: center;
  align-items: center;
}

.nav-link {
  cursor: pointer;
  text-align: center;
}

.dropdown {
  display: none;
  position: absolute;
  top: 100%;
  left: 0;
  //margin: 10px;
  background-color: #00549c;
  text-align: center;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  width: 150px; /* 添加这一行，确保下拉菜单宽度与.nav-item相同 */
}

.dropdown-link {
  display: block;
  width: 100%; /* 将宽度设置为100%，以便于内容根据容器大小调整 */
  height: 40px;
  color: white;
  text-decoration: none;
  //padding: 10px; /* 添加内边距，使文字居中 */
  padding-top: 10px;
}

.nav-item:hover .dropdown {
  display: block;
}
</style>
