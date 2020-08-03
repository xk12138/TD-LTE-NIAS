<!--author:AK
login.vue：登陆页面
version1.0:2020/8/1，完成构建页面并添加接口
version1.1:2020/8/3，更改布局-->
<template>
  <div>
    <el-container>
      <el-header>欢迎使用NIAS系统</el-header>
      <el-main>
        <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
        <el-input type="password" v-model="user.password" placeholder="请输入密码" show-password:true></el-input>
        <el-button type="primary" @click="login">登录</el-button>
        <el-button type="primary" @click="register">注册</el-button>
      </el-main>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      user: {
        username: "",
        password: "",
      },
    };
  },
  methods: {
    login: function () {
      var that = this;
      $.ajax({
        url: "/api/login",
        type: "GET",
        data: {
          account: that.user.username,
          password: that.user.password,
        },
        success: function (res) {
          if (res.code != 0) {
            alert("登录失败!code=" + res.code);
            return;
          }
          console.log(res)
          that.$router.push({
            name:"index",
            params: {
              nickname: that.user.username,
            },
          })
        },
      });
    },

    register: function(){
      var that = this;
      that.$router.push({
        path:"/register"
      })
    }
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
