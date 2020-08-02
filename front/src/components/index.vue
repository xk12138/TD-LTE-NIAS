<template>
  <div>
    <el-container>
      <el-header>NIAS系统功能</el-header>
      <el-main>
        <el-button type="primary" icon="el-icon-folder" @click="dataControl">数据管理</el-button>
        <el-button type="primary" icon="el-icon-search" @click="infoSearch">信息查询</el-button>
        <el-button type="primary" icon="el-icon-ice-cream-round" @click="C2I">主邻小区C2I干扰分析</el-button>
        <el-button type="primary" icon="el-icon-lollipop" @click="triple">查询重叠覆盖干扰三元组</el-button>
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
    color: #333;
    text-align: center;
    line-height: 60px;
  }

  .el-main {
    background-color: #e9eef3;
    color: #333;
    text-align: center;
    line-height: 160px;
  }
</style>
