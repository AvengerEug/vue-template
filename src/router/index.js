import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)
/* Layout */
import Layout from '@/layout'

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
          meta: { title: 'example-table', icon: 'table' }
        }
      ]
    },
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
