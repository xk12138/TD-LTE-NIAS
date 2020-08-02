<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="上传数据" name="first">上传数据
      <el-upload
        style="display:inline-block"
        :limit="5"
        class="upload-demo"
        ref="upload"
        :action="uploadUrl"
        :file-list="fileList"
        :http-request="uploadSectionFile"
        :auto-upload="false"
        :before-remove="handleRemove">
        <el-button slot="trigger" size="small" type="primary" plain>选取文件</el-button>
        <el-button style="margin-left: 10px;" size="small" icon="el-icon-upload2" type="success" @click="submitUpload">导入</el-button>
      </el-upload>
    </el-tab-pane>
<!--    limit是限制最多可上传文件的个数；action的地址是将文件传给后台的接口地址； -->
<!--    fileList是选择的文件的全部信息，在事件中作为参数传进去，可以查看其内容；-->
    <el-tab-pane label="下载数据" name="second">下载数据</el-tab-pane>
  </el-tabs>
</template>

<script>
    export default {
      name: "data_control",
      data(){
        return{
          activeName: 'first'
        };
      },
      methods: {
        handleClick(tab, event) {
          console.log(tab, event);
        },

        uploadSectionFile(param){
          var fileObj = param.file;
          // FormData 对象
          var form = new FormData();
          // 文件对象
          form.append("file", fileObj);
          form.append("userId", this.userId);
          form.append("userName", this.userName);
          axios({
            method: 'post',
            url: '',//todo:接口地址
            headers: {
              //'Content-Type': 'multipart/form-data'
            },
            data:form
          }).then(res => {
            //todo：返回后
          })
        },

      }
    }
</script>

<style scoped>

</style>
