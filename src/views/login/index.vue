<template>
  <el-container>
    <el-header>
      <h1>登&nbsp;录</h1>
    </el-header>
    <el-main>
      <el-form label-position="left" :model="userForm" :rules="rules" ref="userForm" label-width="90px">
        <el-form-item :label="$t('user.userName')" prop="userName">
          <el-input :clearable="true" :placeholder="$t('user.userNamePlaceholder')" v-model="userForm.userName"></el-input>
        </el-form-item>

        <el-form-item :label="$t('user.password')" prop="password">
          <el-input :clearable="true" :placeholder="$t('user.passwordPlaceholder')" v-model="userForm.password" show-password
          @keyup.enter.native="submitForm('userForm')"></el-input>
        </el-form-item>

        <el-form-item style="text-align: center;">
          <el-button type="primary" @click="submitForm('userForm')" size="small" @key.up="submitForm('userForm')">{{ $t('common.login') }}</el-button>
          <el-button @click="resetForm('userForm')" size="small">{{ $t('common.reset') }}</el-button>
        </el-form-item>
      </el-form>
    </el-main>

  </el-container>
</template>

<script>
  import { HTTP, Session } from '@/plugins'
  import API_PATH from '@/constants/apiPath'
  import ERROR_CODE from '@/constants/errorCode'
  import userService from '@/service/userService'
  import util from '@/utils/util'

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
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'blur' },
            { min: 3, max: 15, message: '长度在 3 到 15 个字符', trigger: 'blur' }
          ],
        }
      };
    },
    methods: {
      submitForm(formName) {

        this.$refs[formName].validate(async (valid) => {
          if (valid) {
            const response = await userService.login({
              userName: this.userForm.userName,
              password: this.userForm.password
            })

            if (response.statusCode == 500) {
              this.$message({type: 'error', message: response.errorMessage})

              return
            }

            Session.setToken(response.data)
            this.$router.push({name: 'user-list'})
          } else {
            console.log('error submit!!')
            return false
          }
        })
      },
      resetForm(formName) {
        this.$refs[formName].resetFields()
      }
    }
  }
</script>

<style lang="scss" scoped>
  .el-container {
    width: 500px;
    margin: auto;
    border: transparent;

    .el-header {
      text-align: center;
      font-size: 30px;
    }
  }
</style>
