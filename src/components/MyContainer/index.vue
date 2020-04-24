<template>
  <div style="border: 1px solid red">
    <div>父组件</div>
    <div><my-button content="自定义按钮"></my-button></div>
  </div>
</template>


<script>
import MyButton from '@/components/MyButton'

export default {
  components: {
    MyButton
  },
  props: {
    contents: {
      type: String,
      default: 'default-content'
    }
  },
  beforeCreate: function() {
    console.group('------组件myContainer beforeCreate创建前状态------');
    console.log("%c%s", "color:red" , "el     : " + this.$el); //undefined
    console.log("%c%s", "color:red","data   : " + this.$data); //undefined 
    console.log("%c%s", "color:red","message: " + this.message) 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  created: function() {
    console.group('------组件myContainer created创建完毕状态------');
    console.log("%c%s", "color:red","el     : " + this.$el); //undefined
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化 
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeMount: function() {
    console.group('------组件myContainer beforeMount挂载前状态------');
    console.log("%c%s", "color:red","el     : " + (this.$el)); //已被初始化
    console.log(this.$el);
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化  
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化  
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  mounted: function() {
    console.group('------组件myContainer mounted 挂载结束状态------');
    console.log("%c%s", "color:red","el     : " + this.$el); //已被初始化
    console.log(this.$el);    
    console.log("%c%s", "color:red","data   : " + this.$data); //已被初始化
    console.log("%c%s", "color:red","message: " + this.message); //已被初始化 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeUpdate: function () {
    console.group('组件myContainer beforeUpdate 更新前状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);   
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  updated: function () {
    console.group('组件myContainer updated 更新完成状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el); 
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  beforeDestroy: function () {
    console.group('组件myContainer beforeDestroy 销毁前状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);    
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message); 
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  destroyed: function () {
    console.group('组件myContainer destroyed 销毁完成状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);  
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message)
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  },
  mounted: function() {
    console.group('组件myContainer mounted状态===============》');
    console.log("%c%s", "color:red","el     : " + this.$el);
    console.log(this.$el);  
    console.log("%c%s", "color:red","data   : " + this.$data); 
    console.log("%c%s", "color:red","message: " + this.message)
    console.log("%c%s", "color:red","handleMessage: " + this.handleMessage) 
  }
}
</script>