import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    // 可以直接使用this.$store.commit('increment', 10) 来进行调用
    // 或者使用payload的方式 => this.$store.commit({type: 'increment', num: 10})
    increment (state, payload) {
      if (payload) {
        if (payload.num) {
          state.count = state.count + payload.num
        } else {
          state.count += payload
        }
      } else {
        state.count++
      }
    }
  },
  // 相当于vue对象中的计算属性
  getters: {
    // 在vue视图中执行 this.$store.getters.handleCountIncrOne 时会将count的数量加1
    handleCountIncrOne: state => {
      return state.count
    },
    // 返回一个方法 调用this.$store.getters.handleCountIncrOne时返回 param => {return state.count + param} 方法
    handleCountIncrOneFun: state => param => {
      return state.count + param
    }
  },
  actions: {
    // 使用this.$store.dispatch('increment')的方式触发action中的increment方法
    // 或者使用此种方式触发: this.$store.dispatch({type: 'increment', num: 1000})
    // 在mutations中的操作不支持异步操作, actions中的操作可以支持
    increment (context, payload) {
      // 在控制台中执行如下代码: 
      // vue.$store.dispatch({type: 'increment', num: 1000})
      // vue.$store.dispatch('increment')
      /// vue.$store.dispatch('increment', 10)
      // 异步执行
      setTimeout(() => {
        context.commit('increment', payload)
      }, 1000)
    }
  }
})

