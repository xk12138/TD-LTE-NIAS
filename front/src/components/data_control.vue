<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="上传数据" name="first">上传数据</el-tab-pane>
    <el-tab-pane label="下载数据" name="second">下载数据</el-tab-pane>
  </el-tabs>
</template>

<script>
    export default {
      name: "data_control",
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
