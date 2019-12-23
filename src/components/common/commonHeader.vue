<template>
  <el-container class="no-border">
    <el-header>
      <div class="collapse cursor-pointer">
        <i :class="!collapse ? 'el-icon-s-fold' : 'el-icon-s-unfold'" @click="$emit('collapse')"/>
      </div>

      <dropdown :items="items">
        <div class="cursor-pointer">
          <el-avatar class="el-dropdown-link" size="small" :src="avatar"/>
          <span>用户名</span><i class="el-icon-arrow-down el-icon--right"></i>
        </div>
      </dropdown>

    </el-header>
  </el-container>
</template>

<script>
  import Dropdown from '@/components/dropdown'
  import { Session } from '@/plugins'

  export default {
    components: {
      Dropdown
    },
    props: ['collapse'],
    data() {
      return {
        // 按照路径存放默认头像
        avatar: '', // require('@/assets/images/default-avatar.png'),
        items: [{content: '注销', callback: this.logout }]
      }
    },
    methods: {
      logout() {
        Session.removeToken()
        this.$router.push({path: '/admin-login'})
      }
    },
    watch: {
      collapse: (newValue, oldValue) => {
        this.collapse = newValue
      }
    }
  }
</script>

<style lang="scss" scoped>
  .el-container {
    text-align: center;
    line-height: 45px;
    max-height: 45px;
    margin: 0 5px;

    .el-header {
      height: 45px !important;
      max-height: 45px;
    }

    .collapse {
      float: left;
    }

    .el-dropdown {
      float: right;

      .el-avatar {
        transform: translateY(30%);
      }
    }
  }
</style>
