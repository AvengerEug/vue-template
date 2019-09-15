<template>
  <div class="hello">
    <button @click="test">测试</button>
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
    test () {
      HTTP.get('1', 2).then((data) => {
        console.log('data :', data)
      }).catch((error) => {
        console.log('error :', error)
      })
    }
  }
}
</script>
