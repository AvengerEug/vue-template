<template>
  <el-breadcrumb separator-class="el-icon-arrow-right" class="sso-breadcrumb common-padding">
    <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
    <el-breadcrumb-item :to="{ path: '/' }">活动管理</el-breadcrumb-item>
    <el-breadcrumb-item :to="{ path: '/' }">活动列表</el-breadcrumb-item>
    <el-breadcrumb-item>活动详情</el-breadcrumb-item>
  </el-breadcrumb>
</template>

<style lang="scss" scpoed>
  .sso-breadcrumb {
    height: 40px;
    line-height: 40px;
  }
</style>