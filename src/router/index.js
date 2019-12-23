import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '*',
      redirect: '/login'
    },
    {
      path: '/hello-world',
      name: 'hello-world',
      component: HelloWorld
    },
    {
      path: '/',
      name: 'redirect-login',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/login')
    },
    {
      path: '/user',
      name: 'user',
      redirect: '/user/index',
      component: () => import('@/views/user'),
      children: [
        {
          path: 'index',
          name: 'user-list',
          component: () => import('@/views/user/list')
        },
        {
          path: 'create',
          name: 'user-create',
          component: () => import('@/views/user/edit')
        },
        {
          path: 'edit',
          name: 'user-edit',
          component: () => import('@/views/user/edit')
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
