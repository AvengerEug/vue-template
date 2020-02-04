import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
/* Layout */
import Layout from '@/layout'


/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar (recommend set)
    icon: 'svg-name'             the icon show in the sidebar
    noCache: true                if set true, the page will no be cached(default is false)
    affix: true                  if set true, the tag will affix in the tags-view
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/404',
      component: () => import('@/views/404'),
      hidden: true
    },
    {
      path: '/',
      name: 'redirect-login',
      redirect: '/login',
      hidden: true
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login'),
      hidden: true
    },
    {
      path: '/user',
      name: 'user',
      redirect: '/user/index',
      alwaysShow: true,
      component: Layout,
      meta: { title: 'user', icon: 'tree' },
      children: [
        {
          path: 'index',
          name: 'user-list',
          component: () => import('@/views/user/list'),
          meta: { title: 'user-list', icon: 'table' }
        },
        {
          path: 'create',
          name: 'user-create',
          component: () => import('@/views/user/edit'),
          meta: { title: 'user-create', icon: 'dashboard' },
          hidden: true
        },
        {
          path: 'edit',
          name: 'user-edit',
          component: () => import('@/views/user/edit'),
          meta: { title: 'user-edit', icon: 'example' },
          hidden: true
        }
      ]
    },
    {
      path: '/example',
      component: Layout,
      redirect: '/example/table',
      name: 'example',
      meta: { title: 'example', icon: 'example' },
      children: [
        {
          path: 'table',
          name: 'example-table',
          component: () => import('@/views/table'),
          meta: { title: 'example-table', icon: 'list' }
        }
      ]
    },
    {
      path: '/icons',
      component: Layout,
      name: 'icons',
      children: [
        {
          path: 'index',
          component: () => import('@/views/icons/index'),
          name: 'icons-index',
          meta: { title: 'icons', icon: 'icon' }
        }
      ]
    },
    {
      path: '/socket',
      component: Layout,
      name: 'socket',
      children: [
        {
          path: 'index',
          component: () => import('@/views/socket/index'),
          // 面包屑的名称
          name: 'socket-index',
          // title: 侧边栏国际化的key
          meta: { title: 'socket-index', icon: 'peoples'}
        }
      ]
    }
  ]
})

// 全局路由前置守卫
router.beforeEach((to, from, next) => {
  // 逻辑操作

  next()
})

// 全局路由后置守卫
router.afterEach((to, from) => {
  // 逻辑操作
})

export default router
