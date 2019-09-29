import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '*',
      redirect: '/sso-login'
    },
    {
      path: '/hello-world',
      name: 'hello-world',
      component: HelloWorld
    },
    {
      path: '/sso-login',
      name: 'sso-login',
      // 路由懒加载
      component: () => import('@/views/login/sso')
    },
    {
      path: '/admin-login',
      name: 'admin-login',
      component: () => import('@/views/login/admin')
    },
    {
      path: '/sso/account',
      name: 'sso',
      component: () => import('@/views/sso'),
      children: [
        {
          path: 'index',
          name: 'account',
          component: () => import('@/views/sso/account')
        },
        {
          path: 'edit',
          name: 'edit',
          component: () => import('@/views/sso/account/edit')
        }
      ]
    }
  ]
})

const checkIsExist = currentRouter => {
  return router.options.routes.some(_ => _['path'] === currentRouter.path)
}

// 全局路由前置守卫
router.beforeEach((to, from, next) => {
  // 逻辑操作

  // 1. 获取当前路由, 若未在路由中定义则跳转到默认页面(这个默认页面暂未定义)
  /*if (!checkIsExist(to)) {
    next('/sso-login')
  }*/

  // 2. 若默认页面需要登录后才能访问, 再走是否跳转登录页面逻辑
  next()
})

// 全局路由后置守卫
router.afterEach((to, from) => {
  // 逻辑操作
})

export default router
