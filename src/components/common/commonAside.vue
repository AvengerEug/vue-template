<template>
  <div>
    <!-- {{ $t('sso.common.system.title') }} -->
    <el-menu
      :default-active="activeMenu"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#f4f4f4"
      :collapse="isCollapse"
      :router="true"
      ref="elMenu">
      <el-submenu index="1">
        <template slot="title">
          <i class="el-icon-location"></i>
          <span>用户管理</span>
        </template>

        <el-menu-item-group>
          <el-menu-item index="/user/index">
            <i class="el-icon-menu"></i>
            <span slot="title">列表</span>
          </el-menu-item>
        </el-menu-item-group>
      </el-submenu>

      <el-menu-item index="2">
        <i class="el-icon-menu"></i>
        <span slot="title">模块二</span>
      </el-menu-item>
      <el-menu-item index="3">
        <i class="el-icon-document"></i>
        <span slot="title">模块三</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-setting"></i>
        <span slot="title">导航四</span>
      </el-menu-item>
    </el-menu>
  </div>
</template>

<style>
  .el-menu-vertical-demo:not(.el-menu--collapse) {
    min-height: 400px;
  }

</style>

<script>
  export default {
    name: 'sso-aside',
    data() {
      return {
        isCollapse: false
      };
    },
    computed: {
      activeMenu: vm => {
        return vm.$route.path
      }
    },
    methods: {
      handleOpen(key, keyPath) {
        console.log(key, keyPath);
      },
      handleClose(key, keyPath) {
        console.log(key, keyPath);
      },
      collapse() {
        this.isCollapse = !this.isCollapse
        return this.isCollapse
      }
    },
    mounted() {
      // 临时处理访问更改页面, 侧边栏不下拉的问题
      //this.$refs['elMenu'].open("1")
    }
  }
</script>