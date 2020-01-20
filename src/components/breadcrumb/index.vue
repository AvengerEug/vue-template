<template>
  <el-breadcrumb class="app-breadcrumb" separator="/">
    <transition-group name="breadcrumb">
      <el-breadcrumb-item v-for="(element, index) in breadcrumb" :key="element.displayName">
        <span v-if="index == breadcrumb.length - 1" class="no-redirect">{{ $t(element.displayName) }}</span>
        <a v-else @click.prevent="handleLink(element)">{{ $t(element.displayName) }}</a>
      </el-breadcrumb-item>
    </transition-group>
  </el-breadcrumb>
</template>

<script>
import Utils from '@/utils'

export default {
  data() {
    return {
      levelList: null,
      breadcrumb: []
    }
  },
  watch: {
    $route: function(newRoute, oldRoute) {
      if (newRoute) {
        this.breadcrumb = Utils.doProcecommonrBreadcrumb(newRoute)
        console.log('this.breadcrumb :', this.breadcrumb)
      }
    }
  },
  methods: {
    handleLink(element) {
      this.$router.push({ name: element.routeName})
    }
  },
  mounted() {
    this.breadcrumb = Utils.doProcecommonrBreadcrumb(this.$route)
  }
}
</script>

<style lang="scss" scoped>
.app-breadcrumb.el-breadcrumb {
  display: inline-block;
  font-size: 14px;
  line-height: 50px;
  margin-left: 8px;

  .no-redirect {
    color: #97a8be;
    cursor: text;
  }
}
</style>
