// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import { I18n, Vuex } from './plugins'
import './assets/css/index.css'

Vue.config.productionTip = false

/* eslint-disable no-new */
window.vue = new Vue({
  el: '#app',
  // key一定要为store, vuex为plugins/vuex中创建的vuex对象
  store: Vuex,
  i18n: I18n,
  router,
  components: { App },
  template: '<App/>'
})
