<template>
  <div>
  <el-container>
    <el-header>
      <el-button type="text" v-on:click="changeFunc(1)">登陆</el-button>
      <el-button type="text" v-on:click="changeFunc(0)">注册</el-button>
    </el-header>
    <el-main>
      <div v-if="roll&&func">普通用户登陆界面
        <el-input v-model="user.username" placeholder="请输入用户名"></el-input>
        <el-input type="password" v-model="user.password" placeholder="请输入密码" show-password:true></el-input>
        <el-form-item>
          <el-button type="primary" @click="login">登录</el-button>
        </el-form-item>
      </div>
      <div v-else-if="roll&&!func">普通用户注册界面</div>
      <div v-else-if="!roll&&func">管理员登陆界面</div>
      <div v-else>管理员注册界面</div>
    </el-main>
    <el-footer>
      <el-button type="primary" icon="el-icon-user" v-on:click="changeRoll(1)">普通用户</el-button>
      <el-button type="primary" icon="el-icon-s-custom" v-on:click="changeRoll(0)">管理员</el-button>
    </el-footer>
  </el-container>
  </div>
</template>

<script>
    export default {
      name: "login",
      data(){
        return{
          roll: 0,//roll为1表示普通用户，0表示管理员
          func: 0,//func为1展示登陆界面，0展示注册界面
          user: {
            username: "",
            password: "",
          }
        };
      },
      methods: {
        changeFunc: function(x){
          var that = this;
          if(x==1){
            that.func = 1
            console.log("展示登陆界面"+that.func)
          }
          else{
            that.func = 0
            console.log("展示注册界面"+that.func)
          }
        },

        changeRoll: function(x){
          var that = this;
          if(x==1){
            console.log("普通用户模式"+that.roll)
            that.roll = 1
          }
          else{
            that.roll = 0
            console.log("管理员模式"+that.roll)
          }
        }
      }
    }
</script>

<style>
  .el-header, .el-footer {
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
</style>
