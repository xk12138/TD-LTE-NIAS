<!--author:AK
C2I_analyze.vue：主邻小区C2I干扰分析页面
version1.0:2020/8/3，完成构建页面，没有添加接口-->
<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="主邻小区C2I干扰分析"></el-page-header>
    </el-header>
    <el-container>
      <el-aside height="150px">
        主邻小区C2I干扰分析使用规则：
        1. 设置一个参数“计算标准条数x”，将(LteScRSRP, LteNcRSRP)RSRP测量值对条数小于x的内容先筛选掉；
        2. 点击“分析数据”进行tbMROData全表的分析；
        3. 点击“下载tbC2Inew”进行新表tbC2Inew的下载。
      </el-aside>
      <el-main>
        <el-input v-model="x" placeholder="计算标准条数6" disabled></el-input>
<!--        <el-button type="success" icon="el-icon-check" circle @click="submitX" :disabled="disabled"></el-button>-->
<!--        <el-button type="primary" icon="el-icon-edit" circle @click="editX"></el-button>-->
        <el-button type="success"  icon="el-icon-download" @click="generate">生成tbC2Inew</el-button>
        <a href="../static/tbc2inew.txt" download="tbC2Inew.txt">下载tbC2Inew</a>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
    export default {
        name: "C2I_analyze",
      data(){
        return{
          x:'',
          disabled: false,//设置按钮是否禁用
        }
      },
      methods:{
        submitX:function(){
          this.disabled = true;
          this.$message("提交参数"+this.x);
        },

        editX:function(){
          this.disabled = false;
        },


        generate:function(){
          var that = this;
          $.ajax({
            url: "/api/mro/generate",
            type: "GET",
            success: function (res) {
              if (res.code != 0) {
                alert("生成失败!code=" + res.code);
                return;
              }
              else{
                that.$message("分析成功，请导出表格查看")
              }
            }
          })
        },

        // download:function(){
        //   var that = this;
        //   $.ajax({
        //     url:"api/c2i/export",
        //     type:"GET",
        //     success:function(res){
        //       if(res.code!=0){
        //         alert("下载失败！code=" + res.code);
        //         return;
        //       }
        //       console.log(res);
        //   }
        //   })
        // },

        goBack() {
          this.$router.go(-1);
        }
      }
    }
</script>

<style>
  .el-header{
    background-color: #B3C0D1;
    color: #333;
    text-align: center;
    line-height: 20px;
    font-size: small;
    white-space: pre-line;
  }

  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: center;
    line-height: 160px;
    height: 600px;
  }
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 40px;
  }

</style>
