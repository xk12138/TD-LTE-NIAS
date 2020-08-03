<template>
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="上传数据" name="first">上传数据
      <el-upload
        ref="uploadExcel"
        action="http://127.0.0.1:8080/kpi/import"
        :limit="limitNum"
        :auto-upload="false"
        accept=".xlsx,.csv"
        :before-upload="beforeUploadFile"
        :on-change="fileChange"
        :on-exceed="exceedFile"
        :on-success="handleSuccess"
        :on-error="handleError"
        :file-list="fileList"

      >
        <el-button size="small" plain>选择文件</el-button>
        <div slot="tip" class="el-upload__tip">
          只能上传xlsx/csv文件，且文件大小不超过50M
        </div>
      </el-upload>
      <el-button type="primary" @click="uploadClick">确 定</el-button>
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
          activeName: 'first',
          limitNum: 5,//最多上传五个文件
          fileList: []
        };
      },
      methods: {
        handleClick(tab, event) {
          console.log(tab, event);
        },

        // 上传文件之前的钩子, 参数为上传的文件,若返回 false 或者返回 Promise 且被 reject，则停止上传
        beforeUploadFile(file) {
           console.log(file)
          const extension = file.name.substring(file.name.lastIndexOf('.') + 1)//文件后缀
          const size = file.size / 1024 / 1024
          if (extension !== 'xlsx') {
            this.$notify.warning({//文件类型控制
              title: '警告',
              message: `只能上传Excel或csv的文件`
            })
          }
          if (size > 50) {
            this.$notify.warning({//文件大小控制
              title: '警告',
              message: `文件大小不得超过50M`
            })
          }
        },
        // 文件状态改变时的钩子
        fileChange(file, fileList) {
           // console.log(file)
           // console.log(fileList)
        },
        // 文件超出个数限制时的钩子
        exceedFile(files, fileList) {
          this.$notify.warning({
            title: '警告',
            message: `只能选择 ${
              this.limitNum
            } 个文件，当前共选择了 ${files.length + fileList.length} 个`
          })
        },
        // 文件上传成功时的钩子
        handleSuccess(res, file, fileList) {
          console.log(res)
          // this.formData.url = res.data  //服务器返回的文件地址
          this.$message({
            message: '文件上传成功',
            type: 'success'
          })
          this.$refs.uploadExcel.clearFiles()// 清除上次上传记录
        },
        // 文件上传失败时的钩子
        handleError(err, file, fileList) {
          this.$message({
            message:'文件上传失败',
            type:'error'
          })
        },

        uploadClick() {//上传文件
          this.$refs.uploadExcel.submit()
        },

      }
    }
</script>

<style scoped>

</style>
