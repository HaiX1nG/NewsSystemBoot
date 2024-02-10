<script>
export default {
  name: "TeacherInformation",
  data() {
    return {
      teacherInfo: [
        {
          title: '科技专家',
          teacherImage: [
            {
              img: require('@/assets/images/teacher01.jpg'),
              imgName: '解新华'
            },
            {
              img: require('@/assets/images/teacher02.jpg'),
              imgName: '周婷婷'
            },
            {
              img: require('@/assets/images/teacher03.jpg'),
              imgName: '吴韬'
            },
            {
              img: require('@/assets/images/teacher04.jpg'),
              imgName: '蒋德荣'
            },
            {
              img: require('@/assets/images/teacher05.jpg'),
              imgName: '陈军民'
            },
            {
              img: require('@/assets/images/teacher06.jpg'),
              imgName: '王榕'
            },
            {
              img: require('@/assets/images/teacher07.jpg'),
              imgName: '欧阳潘'
            },
            {
              img: require('@/assets/images/teacher08.jpg'),
              imgName: '张凡永'
            },
            {
              img: require('@/assets/images/teacher09.jpg'),
              imgName: '陶玲'
            },
            {
              img: require('@/assets/images/teacher10.jpg'),
              imgName: '杨子燕'
            },
            {
              img: require('@/assets/images/teacher11.jpg'),
              imgName: '刘瑛'
            },
            {
              img: require('@/assets/images/teacher12.jpg'),
              imgName: '丁旭光'
            }
          ]
        },
        {
          title: '社会科学领域',
          teacherImage: [
            {
              img: require('@/assets/images/teacher01.jpg'),
              imgName: '解新华'
            },
            {
              img: require('@/assets/images/teacher02.jpg'),
              imgName: '周婷婷'
            },
            {
              img: require('@/assets/images/teacher03.jpg'),
              imgName: '吴韬'
            },
            {
              img: require('@/assets/images/teacher04.jpg'),
              imgName: '蒋德荣'
            },
            {
              img: require('@/assets/images/teacher05.jpg'),
              imgName: '陈军民'
            },
            {
              img: require('@/assets/images/teacher06.jpg'),
              imgName: '王榕'
            },
            {
              img: require('@/assets/images/teacher07.jpg'),
              imgName: '欧阳潘'
            },
            {
              img: require('@/assets/images/teacher08.jpg'),
              imgName: '张凡永'
            },
            {
              img: require('@/assets/images/teacher09.jpg'),
              imgName: '陶玲'
            },
            {
              img: require('@/assets/images/teacher10.jpg'),
              imgName: '杨子燕'
            },
            {
              img: require('@/assets/images/teacher11.jpg'),
              imgName: '刘瑛'
            },
            {
              img: require('@/assets/images/teacher12.jpg'),
              imgName: '丁旭光'
            }
          ]
        },
        {
          title: '自然科学领域',
          teacherImage: [
            {
              img: require('@/assets/images/teacher01.jpg'),
              imgName: '解新华'
            },
            {
              img: require('@/assets/images/teacher02.jpg'),
              imgName: '周婷婷'
            },
            {
              img: require('@/assets/images/teacher03.jpg'),
              imgName: '吴韬'
            },
            {
              img: require('@/assets/images/teacher04.jpg'),
              imgName: '蒋德荣'
            },
            {
              img: require('@/assets/images/teacher05.jpg'),
              imgName: '陈军民'
            },
            {
              img: require('@/assets/images/teacher06.jpg'),
              imgName: '王榕'
            },
            {
              img: require('@/assets/images/teacher07.jpg'),
              imgName: '欧阳潘'
            },
            {
              img: require('@/assets/images/teacher08.jpg'),
              imgName: '张凡永'
            },
            {
              img: require('@/assets/images/teacher09.jpg'),
              imgName: '陶玲'
            },
            {
              img: require('@/assets/images/teacher10.jpg'),
              imgName: '杨子燕'
            },
            {
              img: require('@/assets/images/teacher11.jpg'),
              imgName: '刘瑛'
            },
            {
              img: require('@/assets/images/teacher12.jpg'),
              imgName: '丁旭光'
            }
          ],
        }
      ],
      left: 0,
      currentCategory: 0
    }
  },
  methods: {
    carousel() {
      let list = document.querySelector('.list')
      list.innerHTML += list.innerHTML

      setInterval(() => {
        this.left -= 2

        if (this.left === -(12*130+12*3)) {
          this.left = 0
        }

        list.style.left = this.left + 'px'
      }, 30)
    },
    changeCategory(categoryIndex) {
      this.currentCategory = categoryIndex
    },
    handleClick(index) {
      this.currentCategory = index
    }
  },
  mounted() {
    this.carousel()
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
                </span>
              <ul>
                <li v-for="(category, index) in teacherInfo" :key="index" @mouseover="handleClick(index)" :class="{ active: currentCategory === index }">
                  {{ category.title }}
                </li>
              </ul>
            </div>

            <div id="tabBody" style="background-color: white;">
              <div class="box">
                <div class="list">
                  <div class="teacherInfo" v-for="(teacher, index) in teacherInfo[currentCategory].teacherImage" :key="index">
                    <div class="teacherImg">
                      <img :src="teacher.img" :alt="teacher.imgName">
                    </div>
                    <div class="teacherName">{{ teacher.imgName }}</div>
                  </div>
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

#tabBody {
  margin: 0;
  padding: 0;
  width: 584px;
  height: 204px;
}

.box {
  width: 583px;
  height: 194px;
  overflow: hidden;
  position: relative;
}

.box > .list {
  position: absolute;
  left: 0;
  display: flex;
  align-items: center;
}

.list > .teacherInfo{
  width: 130px;
  height: 193px;
  margin-right: 3px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.teacherImg {
  width: 130px;
  height: 160px;
}

.teacherImg > img{
  width: 130px;
  height: 160px;
}

.teacherName {
  width: 130px;
  height: 33px;
  text-align: center;
  padding-top: 5px;
}
</style>