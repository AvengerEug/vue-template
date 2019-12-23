<template>
  <el-container direction="vertical" class="out-container no-border">
    <el-container class="main-content no-border">
      <el-aside width="auto" class="default-background-color common-containne no-border">
        <common-aside ref="commonAside"/>
      </el-aside>
      <el-container direction="vertical" class="no-border">
        <common-header class="default-background-color" @collapse="collapse" :collapse="isCollapse"/>
        <common-breadcrumb class="default-background-color" :breadcrumb="breadcrumb" />
        <router-view class="default-background-color"/>
        <common-footer class="default-background-color"/>
      </el-container>
    </el-container>

  </el-container>
</template>

<script>
  import CommonHeader from '@/components/common/commonHeader'
  import CommonAside from '@/components/common/commonAside'
  import CommonBreadcrumb from '@/components/common/commonBreadcrumb'
  import CommonFooter from '@/components/common/commonFooter'
  import Breadcrumb from '@/constants/breadcrumb'

  export default {
    components: {
      CommonHeader,
      CommonAside,
      CommonBreadcrumb,
      CommonFooter
    },
    data() {
      return {
        isCollapse: undefined,
        breadcrumb: []
      }
    },
    methods: {
      collapse() {
        this.isCollapse = this.$refs['commonAside'].collapse()
        return this.isCollapse
      },
      parseBreadcrumb(currentRoute) {
        const breadcrumbKeys = Object.keys(Breadcrumb)
        for (let i = 0; i < breadcrumbKeys.length; i++) {
          if (breadcrumbKeys[i] === currentRoute.name) {
            return Breadcrumb[breadcrumbKeys[i]]
          }
        }
      },
      doProcecommonrBreadcrumb(currentRoute) {
        this.breadcrumb = this.parseBreadcrumb(currentRoute)
      }
    },
    mounted() {
      this.isCollapse = this.$refs['commonAside'].isCollapse
      this.doProcecommonrBreadcrumb(this.$route)
    },
    watch: {
      $route: function(newRoute, oldRoute) {
        if (newRoute) {
          this.doProcecommonrBreadcrumb(newRoute)
        }
      }
    }
  }
</script>

<style lang="scss" scoped>
  .out-container {
    width: 1200px;
    height: 100%;
    margin: 0 auto;

    .el-aside {
      margin: 5px 0;
    }

    .main-content {
      min-height: 800px;
    }

  }
</style>