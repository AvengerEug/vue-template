<template>
  <el-container class="no-border">
    <el-header>
      <el-form :inline="true" :model="searchForm" class="search-condition" size="small" ref="searchForm">
        <el-form-item label="关键字" prop="keywords">
          <el-input v-model="searchForm.keywords" placeholder="请输入关键字"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmit">查询</el-button>
          <router-link :to="{name: 'user-create'}">
            <el-button type="success">新建</el-button>
          </router-link>
          <el-button type="warning" @click="reset()">重置</el-button>
        </el-form-item>
      </el-form>
    </el-header>

    <el-main>
      <el-table :data="userTable" border style="width: 100%">
        <el-table-column prop="userId" label="用户ID" width="180" />
        <el-table-column prop="userName" label="用户名" width="180" />
        <el-table-column prop="password" label="密码" />
        <el-table-column fixed="right" label="操作" width="100">
          <template slot-scope="scope">
            <el-button type="primary" icon="el-icon-edit" @click="edit(scope.row)" size="mini"/>
          </template>
        </el-table-column>
      </el-table>
    </el-main>

    <el-footer>
      <el-pagination
        class="common-pagination"
        @size-change="handleSizeChange"
        @current-change="handleIndexChange"
        :current-page="pagination.pageIndex"
        :page-sizes="[5, 10, 15, 20, 25]"
        :page-size="pagination.pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        background
        :total="pagination.totalCount">
      </el-pagination>
    </el-footer>

  </el-container>
</template>

<script>
  import { Pagination } from '@/plugins'
  import userService from '@/service/userService'

  export default {
    data() {
      return {
        userTable: [],
        pagination: (() => {return Object.assign({}, Pagination)})(),
        searchForm: {
          keywords: undefined
        }
      }
    },
    methods: {
      reset() {
        this.$refs['searchForm'].resetFields()
        this.onSubmit()
      },
      async fetchUserInfo(params) {
        const response = await userService.fetchUserInfo(params)
        this.userTable = response.data.items
        this.pagination = response.data.pagination
      },
      init() {
        this.initUserInfo()
      },
      initUserInfo() {
        this.fetchUserInfo({
          params: this.pagination
        })
      },
      handleSizeChange(pageSize) {
        this.pagination.pageSize = pageSize
        this.fetchUserInfo({
          params: Object.assign(this.pagination, {keywords: this.searchForm.keywords})
        })
      },
      handleIndexChange(pageIndex) {
        this.pagination.pageIndex = pageIndex
        this.fetchUserInfo({
          params: Object.assign(this.pagination, {keywords: this.searchForm.keywords})
        })
      },
      onSubmit() {
        this.fetchUserInfo({
          params: Object.assign(this.pagination, {keywords: this.searchForm.keywords})
        })
      },
      edit(currenUser) {
        this.$router.push({name: 'user-edit', params: {id: currenUser.uuid}})
      }
    },
    mounted() {
      this.init()
    }
  }
</script>

<style lang="scss" scoped>
  .search-condition {
    padding-top: 20px;
  }
</style>