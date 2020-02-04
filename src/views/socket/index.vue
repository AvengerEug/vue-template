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

  </el-container>
</template>

<script>
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
  methods: {
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