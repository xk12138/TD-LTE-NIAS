<!--author:AK
index.vue：功能索引页面
version1.0:2020/8/1，完成构建页面
version1.1:2020/8/3，更改布局
version2.1:2020/8/7，界面美化
-->
<template>
  <div>
    <el-container>
      <el-header>NIAS系统功能</el-header>
      <el-main>

        <el-row>
          <el-button type="primary" icon="el-icon-folder" @click="dataControl">数据管理</el-button>
        </el-row>
        <el-row>
          <el-button type="primary" icon="el-icon-search" @click="infoSearch">信息查询</el-button>
        </el-row>
        <el-row>
          <el-button type="primary" icon="el-icon-ice-cream-round" @click="C2I">主邻小区C2I干扰分析</el-button>
        </el-row>
        <el-row>
          <el-button type="primary" icon="el-icon-lollipop" @click="triple">查询重叠覆盖干扰三元组</el-button>
        </el-row>

      </el-main>
    </el-container>
  </div>
</template>

<script>
    export default {
      name: "index",
      data() {
        return {
          nickname: this.$route.params.nickname,
        };
      },
      mounted(){
        console.log(this.$route.params.nickname, this.nickname)
      },
      methods:{
        dataControl:function(){
          var that = this;
          that.$router.push({
            path:"/data_control"
          })
        },

        infoSearch:function(){
          var that = this;
          that.$router.push({
            path:"/info_search"
          })
        },

        C2I:function(){
          var that = this;
          that.$router.push({
            path:"/C2I_analyze"
          })
        },

        triple:function(){
          var that = this;
          that.$router.push({
            path:"/triple_search"
          })
        },
      }
    }

</script>

<style>
  .el-header,
  .el-footer {
    background-color: #b3c0d1;
    color: midnightblue;
    text-align: center;
    line-height: 60px;
    font-family: "Arial Black";
    font-size: larger;
  }

  .el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 60px;
    height: 600px;
  }

  .el-row {
    margin-bottom: 60px;
  }
</style>
