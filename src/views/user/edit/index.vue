<template>
  <el-container class="no-border ">
    <el-form :model="userForm" :rules="rules" ref="userForm" label-width="100px" class="demo-userForm">
      <el-form-item :label="$t('user.userName')" prop="userName">
        <el-input :placeholder="$t('user.userNamePlaceholder')" v-model="userForm.userName" :disabled="isUpdate"></el-input>
      </el-form-item>

      <el-form-item :label="$t('user.password')" prop="password">
        <el-input :placeholder="$t('user.passwordPlaceholder')" v-model="userForm.password" show-password
        @keyup.enter.native="submitForm('userForm')"></el-input>
      </el-form-item>

      <el-form-item :label="$t('user.email')" prop="email">
        <el-input type="age" v-model="userForm.email" autocomplete="off" />
      </el-form-item>

      <el-form-item :label="$t('user.phone')" prop="phone">
        <el-input type="age" v-model.number="userForm.phone" autocomplete="off" />
      </el-form-item>
      
      <el-form-item style="text-align: center;">
        <el-button type="primary" @click="submitForm('userForm')" size="small" @key.up="submitForm('userForm')">{{ $t('common.submit') }}</el-button>
        <el-button @click="resetForm('userForm')" size="small">{{ $t('common.reset') }}</el-button>
      </el-form-item>
    </el-form>
  </el-container>
</template>

<script>
import ERROR_CODE from '@/constants/errorCode'
import UserService from '@/service/UserService'
import Constants from '@/constants'

export default {
  data() {
    return {
      userForm: {
        userId: '',
        userName: '',
        password: '',
        email: '',
        phone: ''
      },
      rules: {
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, message: '长度不小于6位', trigger: 'blur' },
          { pattern: Constants.PASSWORD_PATTER, message: '密码需包含字母、数字以及特殊符号!', trigger: ['blur', 'change']}
        ],
        email: [
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        phone: [
          { pattern: /^1[3456789]\d{9}$/, message: '请输入正确的手机号', trigger: ['blur', 'change']}
        ]
      },
      isUpdate: this.$route.params.id ? true : false
    };
  },
  methods: {
    submitForm(formName) {

      this.$refs[formName].validate(async (valid) => {
        if (valid) {
          /* let response = undefined
          if (this.isUpdate) {
            response = await UserService.updateUser(this.userForm)
          } else {
            response = await UserService.register(this.userForm)
          }

          if (response.statusCode == 500) {
            this.$message({type: 'error', message: response.errorMessage})

            return
          } */

          this.$message({type: 'success', message: '提交成功'})
          this.$router.push({name: 'user-list'})

        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$message({type: 'warning', message: '暂未实现'})
      return
      this.$refs[formName].resetFields()
    },
    fetchRouteQuery() {
      return this.$route.query
    },
    async getById(id) {
      // const response = await UserService.getById(this.$route.params.id)
      const response = require('@/constants/mock')
      this.userForm = response.data.items.filter(item => {return item.uuid === this.$route.params.id})[0]
      console.log('this.userForm :', this.userForm)
    },
    init() {
      if (this.isUpdate) {
        this.getById()
      } else {
        this.rules.userName = [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ]
      }

    }
  },
  created() {
    this.init()
  }
}
</script>

<style lang="scss" scoped>
.el-container {
  margin-top: 20px;
}
</style>
