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

export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  },
  methods: {
    get () {
      HTTP.get('1', 2).then((data) => {
        console.log('data :', data)
      }).catch((error) => {
        console.log('error :', error)
      })
    }
  }
}
</script>
