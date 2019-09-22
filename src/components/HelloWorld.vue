<template>
  <div class="hello">
    <button @click="get">测试GET方法</button>
    <button @click="put">测试PUT方法</button>
    <button @click="post">测试POST方法</button>
    <button @click="del">测试DELETE方法</button>
  </div>
</template>

<script>
import { HTTP } from '../plugins'
import API_PATH from '@/constants/apiPath'

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    async get () {
      await HTTP.$axios.get(API_PATH.USER.FETCH_ALL_USER)
    },
    put () {
    },
    async post () {
      const response = await HTTP.$axios.post(API_PATH.USER.LOGIN, {
        userName: 'eugene',
        password: 'abc123_'
      })

      this.$cookie.set('jwt-token', response.data)
    },
    delete () {
    }
  }
}
</script>
