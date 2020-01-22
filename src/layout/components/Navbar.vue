<template>
  <div class="navbar">
    <hamburger :is-active="active" class="hamburger-container" @toggleClick="toggleSideBar" />

    <breadcrumb class="breadcrumb-container"/>

    <div class="right-menu">

      <dropdown :items="i18nItems" class="i18n-container">
        <div class="i18n-wrapper">
          <svg-icon icon-class="language" />
        </div>
      </dropdown>

      <dropdown :items="avatarItems" class="avatar-container">
        <div class="avatar-wrapper">
          <img src="@/assets/static/avatar.gif" class="user-avatar">
          <i class="el-icon-caret-bottom" />
        </div>
      </dropdown>

    </div>
  </div>
</template>

<script>
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'
import Dropdown from '@/components/Dropdown'

export default {
  components: {
    Breadcrumb,
    Hamburger,
    Dropdown
  },
  data() {
    return {
      avatar: '',
      active: true,
      i18nItems: [
        { content: '中文', icon: '', callback: () => { this.changeI18n('zn') }},
        { content: 'English', icon: '', callback: () => { this.changeI18n('en') }}
      ],
      avatarItems: [
        { content: '注销', icon: '', callback: () => { this.logout() } }
      ]
    }
  },
  methods: {
    changeI18n(i18nType) {
      switch(i18nType) {
        case 'en': vue.$i18n.locale = "es-US"; break;
        case 'zn': vue.$i18n.locale = "zn-CN"; break;
      }
    },
    toggleSideBar() {
      this.$emit('toggleClick')
      this.active = !this.active
    },
    async logout() {
      this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    }
  }
}
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .right-menu {
    float: right;
    height: 100%;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background .3s;

        &:hover {
          background: rgba(0, 0, 0, .025)
        }
      }
    }

    .i18n-container {
      font-size: 25px;
      width: 1.5em;
      height: 1em;
      vertical-align: -0.24em;
      cursor: pointer;
    }

    .avatar-container {
      margin-right: 30px;
      cursor: pointer;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>
