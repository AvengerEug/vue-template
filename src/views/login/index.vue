<template>
  <el-container>
    <el-header>
      <h1>单点登录</h1>
    </el-header>

    <el-main>
      <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="用户名" prop="userName">
          <el-input placeholder="请输入用户名" v-model="ruleForm.userName"></el-input>
        </el-form-item>

        <el-form-item label="密码" prop="password">
          <el-input placeholder="请输入密码" v-model="ruleForm.password" show-password></el-input>
        </el-form-item>
        
        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">立即创建</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </el-main>

  </el-container>
</template>

<script>
  import { HTTP } from '@/plugins'
  import API_PATH from '@/constants/apiPath'

  export default {
    data() {
      return {
        ruleForm: {
          userName: '',
          password: ''
        },
        rules: {
          userName: [
            { required: true, message: '请输入用户名', trigger: 'blur' },
            { min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur' }
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
        this.$refs[formName].validate(async (valid) => {
          if (valid) {
            const response = await HTTP.$axios.post(API_PATH.USER.LOGIN, {
              userName: 'eugene',
              password: 'abc123_'
            })

            this.$cookie.set('jwt-token', response.data)
            console.log(this.$route)
            window.location.href = this.$route.query.url
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style>
  .el-container {
    width: 545px;
    margin: 0 auto;
  }
</style>

