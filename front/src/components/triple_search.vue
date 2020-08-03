<!--author:AK
triple_search.vue：查询重叠覆盖干扰三元组页面-
version1.0:2020/8/3，完成构建页面，没有添加接口-->
<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="查询重叠覆盖干扰三元组"></el-page-header>
    </el-header>

    <el-container>
      <el-aside weight="100px">
        查询重叠覆盖干扰三元组方法：
        1. 设置一个参数“RSRP差值的绝对值小于6的概率标准x”；
        2. 点击“计算”进行tbC2Inew全表的分析计算；
        3. 点击“下载tbC2I3”进行新表tbC2I3的下载
      </el-aside>
      <el-main>
        <el-input v-model="x" placeholder="请输入概率标准x">
          <span slot="suffix">%</span>
        </el-input>
        <el-button type="success" icon="el-icon-check" circle @click="submitX" :disabled="disabled"></el-button>
        <el-button type="primary" icon="el-icon-edit" circle @click="editX"></el-button>
        <el-button type="info" :disabled="!disabled" @click="calculate">计算</el-button>
        <el-button type="success" :disabled="!disabled" icon="el-icon-download" @click="download">下载tbC2I3</el-button>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
    export default {
        name: "triple_search",
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

        calculate:function(){
          this.$message({
            type:"success",
            message:"计算完毕，请下载"
          })
        },

        download:function(){
          this.$message({
            type:"success",
            message:"下载成功！"
          })
        },

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
