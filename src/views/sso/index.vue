<template>
  <el-container direction="vertical" class="out-container">
    <sso-header/>

    <el-container>
      <el-aside width="200px">
        <sso-aside/>
      </el-aside>
      <el-container direction="vertical">
        <sso-breadcrumb/>
        <router-view/>
        <sso-footer/>
      </el-container>
    </el-container>

  </el-container>
</template>

<script>
  import SsoHeader from '@/components/sso/common/ssoHeader'
  import SsoAside from '@/components/sso/common/ssoAside'
  import SsoBreadcrumb from '@/components/sso/common/ssoBreadcrumb'
  import SsoFooter from '@/components/sso/common/ssoFooter'

  export default {
    components: {
      SsoHeader,
      SsoAside,
      SsoBreadcrumb,
      SsoFooter
    }
  }
</script>

<style lang="scss" scoped>
  .out-container {
    width: 1200px;
    height: 100%;
    margin: 0 auto;
  }
</style>