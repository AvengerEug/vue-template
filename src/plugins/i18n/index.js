import Vue from 'vue'
import VueI18n from 'vue-i18n'
import Env from '../../environment/index.js'

Vue.use(VueI18n)

const i18n = new VueI18n({
  locale: Env.locale,
  messages: {
    'zn-CN': require('@/constants/lang/zn'),
    'en-US': require('@/constants/lang/en')
  }
})

console.log('i18n', i18n)

export default i18n