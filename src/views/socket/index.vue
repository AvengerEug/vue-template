<template>
  <el-container>
    <el-header style="display: table;">
      <template v-if="message.length">
        <div v-for="(item, index) of message" :key="index">
          <h3>{{ item }}</h3>
        </div>
      </template>
    </el-header>
    <el-main>
      <el-form :inline="true" :model="socketForm" size="small" @submit.native.prevent>
        <el-form-item :label="$t('socket.barrage')" prop="userName">
          <el-input v-model="socketForm.userName" :placeholder="$t('socket.talk')" @keyup.enter.native="sendMsg()"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="sendMsg" >{{$t('common.sendMsg')}}</el-button>
        </el-form-item>
      </el-form>
    </el-main>

    <el-footer>
      <h2>count1: {{count1}}</h2>
      <h2>count: {{count}}</h2>
      <h2>countAlias: {{count}}</h2>
      <h2>handleCount: {{handleCount}}</h2>

      <el-button type="success" @click="incrementCount()">increment count</el-button>
    </el-footer>

  </el-container>
</template>

<script>
import { mapState, mapMutations, mapActions } from 'vuex'

export default {
  data() {
    return {
      socket: undefined,
      stompClient: undefined,
      message: [],
      socketForm: {
        userName: ''
      }
    }
  },
  computed: {
    // 计算属性别使用箭头函数, 否则this无法获取到当前vue对象
    count1() {
      return this.$store.state.count
    },
    // 使用mapState方法省去计算属性的编写, 即可直接获取vuex中state对象中的属性
    // mapState函数返回的是一个对象, ... 三个点是对象链接扩展符, 会将所有对象链接起来
    ...mapState(['count']),
    ...mapState({
      count: state => state.count, // 类似于 (state) => { return state.count }  
      countAlias: 'count', // count计算属性的别名, 要与上面key一样, count: state => state.count 中的count
      handleCount(state) {
        return state.count + 10
      }
    })
  },
  methods: {
    ...mapMutations({
      incrementCount: 'increment' // 将 `this.add()` 映射为 `this.$store.commit('increment')`
    }),
    resetSocketUserName() {
      this.socketForm.userName = ''
    },
    conn() {
      this.socket = new SockJS('http://49.235.135.230:8080/gs-guide-websocket')
      
      this.stompClient = Stomp.over(this.socket)
      const vm = this

      vm.stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        vm.stompClient.subscribe('/topic/greetings', function (greeting) {
          const h = vm.$createElement
          var content = JSON.parse(greeting.body).content
          vm.message.push(content)
          vm.$notify({
            title: 'web socket 信息',
            message: h('i', { style: 'color: teal'}, content)
          })
        })
      })

    },
    sendMsg() {
      this.stompClient.send("/app/hello", {}, JSON.stringify({'name': this.socketForm.userName}))
      this.resetSocketUserName()
    }
  },
  mounted() {
    this.conn()
  }
}
</script>