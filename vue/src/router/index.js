import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: () => import('../views/HomePage.vue'),
        redirect: '/home',
        children: [
            {
                path: 'home',
                name: '首页',
                component: () => import('../views/HomePage.vue')
            },
            {
                path: 'searchnews',
                name: '新闻搜索框',
                component: () => import('../components/SearchNews.vue')
            },
            {
                path: 'realtime',
                name: '当前时间',
                component: () => import('../components/RealTime.vue')
            },
            {
                path: 'dropdownmenubar',
                name: '下拉菜单',
                component: () => import('../components/DropDownMenuBar.vue')
            },
            {
                path: 'imagecarousel',
                name: '轮播图',
                component: () => import('../components/ImageCarousel.vue')
            },
            {
                path: 'eightnewstable',
                name: '八条新闻表格',
                component: () => import('../components/EightNewsTable.vue')
            },
            {
                path: 'fivenewstable',
                name: '五条新闻表格',
                component: () => import('../components/FiveNewsTable.vue')
            },
            {
                path: 'tabnewstable',
                name: 'tab新闻表格',
                component: () => import('../components/TabNewsTable.vue')
            },
            {
                path: 'teacherinformation',
                name: '教师信息',
                component: () => import('../components/TeacherInformation.vue')
            },
            {
                path: 'footerurl',
                name: '友情链接',
                component: () => import('../components/FooterUrl.vue')
            },
            {
                path: 'footer',
                name: '底部',
                component: () => import('../components/Footer.vue')
            }
        ]
    },
    {
        path: '/about',
        name: 'About',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    },
    {
        path: '/searchnews',
        name: 'SearchNews',
        component: () => import('../components/SearchNews.vue')
    },
    {
        path: '/realtime',
        name: '当前时间',
        component: () => import('../components/RealTime.vue')
    },
    {
        path: '/dropdownmenubar',
        name: '下拉菜单',
        component: () => import('../components/DropDownMenuBar.vue')
    },
    {
        path: '/imagecarousel',
        name: '轮播图',
        component: () => import('../components/ImageCarousel.vue')
    },
    {
        path: '/eightnewstable',
        name: '八条新闻表格',
        component: () => import('../components/EightNewsTable.vue')
    },
    {
        path: '/fivenewstable',
        name: '五条新闻表格',
        component: () => import('../components/FiveNewsTable.vue')
    },
    {
        path: '/tabnewstable',
        name: 'tab新闻表格',
        component: () => import('../components/TabNewsTable.vue')
    },
    {
        path: '/teacherinformation',
        name: '教师信息',
        component: () => import('../components/TeacherInformation.vue')
    },
    {
        path: '/footerurl',
        name: '友情链接',
        component: () => import('../components/FooterUrl.vue')
    },
    {
        path: '/footer',
        name: '底部',
        component: () => import('../components/Footer.vue')
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router
