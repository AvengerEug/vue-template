<template>
  <el-dropdown @command="handleCommand">
    <!-- 插槽内容 -->
    <slot/>

    <el-dropdown-menu slot="dropdown" size="mini">
      <template v-for="(item, index) of items">
        <el-dropdown-item 
          :icon="item.icon || ''" 
          :key="index"
          :command="item.callback">
          {{ item.content }}
        </el-dropdown-item>
      </template>
    </el-dropdown-menu>
  </el-dropdown>
</template>

<script>
  export default {
    props: {
      /**
       * items结构例子: 
       * [{content: '黄金糕', icon: 'el-icon-plus', callback: () => {console.log('callback')}}]
       */
      items: {
        type: Array,
        default: () => { return [
          {content: 'defaultContent', icon: 'el-icon-plus', callback: () => {console.log('callback')}}
          ]
        }
      }
    },
    methods: {
      handleCommand(callback) {
        callback()
      }
    }
  }
</script>

<style lang="scss" scoped>

</style>