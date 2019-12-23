<template>
  <el-breadcrumb separator-class="el-icon-arrow-right" class="sso-breadcrumb common-padding">
    <el-breadcrumb-item 
      v-for="element of breadcrumb" 
      :key="element.routeName"
      :to="{name: element.routeName}">
      {{element.name}}
    </el-breadcrumb-item>
  </el-breadcrumb>
</template>

<script>
export default {
  props: {
    breadcrumb: {
      type: Array,
      required: true
    }
  },
  data() {
    return {
      breadcrumbInner: this.breadcrumb
    }
  },
  watch: {
    breadcrumb: {
      self: this,
      deep: true,
      handler: (newValue, oldValue) => {
        if (newValue) {
          this.breadcrumbInner = newValue
        }
      }
    }
  }
}
</script>

<style lang="scss" scpoed>
  .sso-breadcrumb {
    height: 40px;
    line-height: 40px;
    margin: 5px 5px;
  }
</style>