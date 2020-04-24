<template>
  <div style="border: 1px solid blue">
    <p>子组件myButton </p>
    <p v-if="isShow">点击button隐藏我</p>
    <el-button type="success" size="small"  @click="changeStatus()">{{contents}}</el-button>
  </div>
</template>

<script>
export default {
  props: {
    contents: {
      type: String,
      default: '点我隐藏'
    }
  },
  data() {
    return {
      isShow: true
    }
  },
  methods: {
    changeStatus() {
      this.isShow = !this.isShow
    }
  },
  beforeCreate: function() {
    console.group('------子组件myButton beforeCreate创建前状态------');
    console.log("%c%s", "color:red" , "el     : " + this.$el); //undefined
    console.log("%c%s", "color:red","data   : " + this.$data); //undefined 
    console.log("%c%s", "color:red","message: " + this.message) 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  created: function() {
    console.group('------子组件myButton created创建完毕状态------');
    console.log("%c%s", "color:red","el     : " + this.$el); //undefined
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化 
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeMount: function() {
    console.group('------子组件myButton beforeMount挂载前状态------');
    console.log("%c%s", "color:red","el     : " + (this.$el)); //已被初始化
    console.log(this.$el);
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化  
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化  
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  mounted: function() {
    console.group('------子组件myButton mounted 挂载结束状态------');
    console.log("%c%s", "color:red","el     : " + this.$el); //已被初始化
    console.log(this.$el);    
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeUpdate: function () {
    console.group('子组件myButton beforeUpdate 更新前状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);   
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  updated: function () {
    console.group('子组件myButton updated 更新完成状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el); 
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeDestroy: function () {
    console.group('子组件myButton beforeDestroy 销毁前状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);    
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  destroyed: function () {
    console.group('子组件myButton destroyed 销毁完成状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);  
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message)
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  mounted: function() {
    console.group('子组件myButton mounted状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);  
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message)
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  }
}
</script>