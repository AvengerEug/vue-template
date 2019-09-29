<template>
  <el-container>
    <el-header>
      <h1>{{ $t('sso.user.title') }}</h1>
    </el-header>

    <el-main>
      <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-userForm">
        <el-form-item :label="$t('sso.user.userName')" prop="userName">
          <el-input :placeholder="$t('sso.user.userNamePlaceholder')" v-model="userForm.userName"></el-input>
        </el-form-item>

        <el-form-item :label="$t('sso.user.password')" prop="password">
          <el-input :placeholder="$t('sso.user.passwordPlaceholder')" v-model="userForm.password" show-password
          @keyup.enter.native="submitForm('userForm')"></el-input>
        </el-form-item>
        
        <el-form-item style="text-align: center;">
          <el-button type="primary" @click="submitForm('userForm')" size="small" @key.up>{{ $t('sso.common.login') }}</el-button>
          <el-button @click="resetForm('userForm')" size="small">{{ $t('sso.common.reset') }}</el-button>
        </el-form-item>
      </el-form>
    </el-main>

  </el-container>
</template>

<script>
  import { HTTP } from '@/plugins'
  import API_PATH from '@/constants/apiPath'
  import ERROR_CODE from '@/constants/errorCode'

  export default {
    data() {
      return {
        userForm: {
          userName: '',
          password: ''
        },
        rules: {
          userName: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {
        if (!this.$route.query.url) {
          this.$message({type: 'error', message: '无跳转url，无法登录'})
          return
        }

        this.$refs[formName].validate(async (valid) => {
          if (valid) {
            const response = await HTTP.$axios.post(API_PATH.USER.LOGIN, {
              userName: this.userForm.userName,
              password: this.userForm.password
            })

            if (response.statusCode == 500) {
              if (response.errorCode === ERROR_CODE.LOGIN_ERROR) {
                this.$message({type: 'error', message: response.errorMessage})
              }

              return
            }

            window.location.href = this.buildRedirectUrl(response.data)
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      },
      fetchRouteQuery() {
        return this.$route.query
      },
      buildRedirectUrl(token) {
        let query = this.fetchRouteQuery()
        query['token'] = token

        let url = query.url + '?'
        const queryKeys = Object.keys(query)
        let queryUrl = ''

        for (let i = 0; i < queryKeys.length; i++) {
          let item = queryKeys[i]
          if (item === 'url') {
            continue
          }

          queryUrl += (queryUrl ? '&' : '' ) + item + '=' + query[item]
        }

        return url + queryUrl
      }
    },
    mounted () {

    }
  }
</script>

<style lang="scss" scoped>
  .el-container {
    margin: 60px auto 0;
    width: 545px;
    border: transparent;

    .el-header {
      text-align: center;
    }
  }
</style>

