<!--author:AK
register.vue：注册页面
version1.0:2020/8/1，完成构建页面并添加接口
version1.1:2020/8/3，更改布局-->
<template>
  <div>
    <el-container>
      <el-header>注册NIAS系统账户</el-header>
      <el-main>
        <div>
          用户名：<el-input v-model="user.username" placeholder="请输入用户名"></el-input>
        </div>

        <div>
          密码：<el-input type="password" v-model="user.password" placeholder="请输入密码" show-password:true></el-input>
        </div>

        <el-button type="primary" @click="register">注册</el-button>
      </el-main>
    </el-container>
  </div>
</template>

<script>
  export default {
    name: "register",
    data() {
      return {
        user: {
          username: "",
          password: "",
        },
      };
    },
    methods: {
      register: function () {
        var that = this;
        $.ajax({
          url: "/api/register",
          type: "POST",
          data: {
            account: that.user.username,
            password: that.user.password,
          },
          success: function (res) {
            if (res.code != 0) {
              alert("注册失败!code=" + res.code);
              return;
            }
            that.$message({
              message: '注册成功',
              type: 'success'
            });
            that.$router.go(-1)//跳转回上个页面
          },
        });
      },
    },
  };
</script>

<style>
  .el-header,
  .el-footer {
    background-color: #b3c0d1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 160px;
    height: 600px;
  }
</style>
