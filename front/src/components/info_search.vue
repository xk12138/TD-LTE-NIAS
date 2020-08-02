<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="小区配置信息查询" name="first">小区配置信息查询</el-tab-pane>
    <el-tab-pane label="基站eNodeB信息查询" name="second">基站eNodeB信息查询</el-tab-pane>
    <el-tab-pane label="KPI指标信息查询" name="third">KPI指标信息查询</el-tab-pane>
    <el-tab-pane label="PRB信息统计与查询" name="forth">PRB信息统计与查询</el-tab-pane>
  </el-tabs>
</template>

<script>
    export default {
        name: "info_search",
      data(){
        return{
          activeName: 'second'
        };
      },
      methods: {
        handleClick(tab, event) {
          console.log(tab, event);
        }
      }
    }
</script>

<style scoped>

</style>
