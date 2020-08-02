<template>
  <el-menu
    :default-active="activeIndex"
    class="el-menu-demo"
    mode="horizontal"
    @select="handleSelect"
    background-color="#545c64"
    text-color="#fff"
    active-text-color="#ffd04b">
    <el-submenu index="1">
      <template slot="title">数据导入</template>
      <el-menu-item index="1-1">导入tbCell</el-menu-item>
      <el-menu-item index="1-2">导入tbKPI</el-menu-item>
      <el-menu-item index="1-3">导入tbPRB</el-menu-item>
      <el-menu-item index="1-4">导入tbMROData</el-menu-item>
    </el-submenu>
    <el-menu-item index="2" disabled>数据下载</el-menu-item>
  </el-menu>
</template>

<script>
    export default {
      name: "data_control",
      data(){
        return{
          activeIndex:'1'
        };
      },
      methods: {
        handleSelect(key, keyPath) {
          console.log(key, keyPath);
        }
      }
    }
</script>

<style scoped>

</style>
