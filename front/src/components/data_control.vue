<!--author:AK
data_control.vue：数据控制页面
version1.0:2020/8/3，完成构建页面，没有添加接口
version1.1:2020/8/6，重新布局页面，完成接口
version2.1:2020/8/7，界面美化
version2.2:2020/8/7，修复上传MRO表按钮无响应bug
-->
<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="数据管理"></el-page-header>
    </el-header>

    <el-container>
      <el-main>
        <el-tabs v-model="activeName" @tab-click="handleClick">
          <el-tab-pane label="上传数据" name="first">
            <el-row justify="center" type="flex">

              <el-col :span="6">
                <el-upload
                  ref="uploadCELL"
                  action = 'http://127.0.0.1:8080/cell/import'
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
                  <el-button size="small" plain @click="active(0)">选择Cell文件</el-button>
                  <div slot="tip" class="el-upload__tip">
                    只能上传xlsx/csv文件，且文件大小不超过50M
                  </div>
                </el-upload>
              </el-col>
              <el-col :span="6">
                <el-upload
                  ref="uploadKPI"
                  action = 'http://127.0.0.1:8080/kpi/import'
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
                  <el-button size="small" plain @click="active(1)">选择KPI文件</el-button>
                  <div slot="tip" class="el-upload__tip">
                    只能上传xlsx/csv文件，且文件大小不超过50M
                  </div>
                </el-upload>
              </el-col>

            </el-row>
            <el-row justify="center" type="flex">
              <el-col :span="6">
                <el-upload
                  ref="uploadPRB"
                  action = 'http://127.0.0.1:8080/prb/import'
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
                  <el-button size="small" plain @click=" active(2)">选择PRB文件</el-button>
                  <div slot="tip" class="el-upload__tip">
                    只能上传xlsx/csv文件，且文件大小不超过50M
                  </div>
                </el-upload>
              </el-col>
              <el-col :span="6">
                <el-upload
                  ref="uploadMRO"
                  action = 'http://127.0.0.1:8080/mro/import'
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
                  <el-button size="small" plain @click =" active(3)">选择MRO文件</el-button>
                  <div slot="tip" class="el-upload__tip">
                    只能上传xlsx/csv文件，且文件大小不超过50M
                  </div>
                </el-upload>
              </el-col>
            </el-row>


            <el-button type="primary" @click="uploadClick" >确认上传</el-button>
          </el-tab-pane>
          <!--    limit是限制最多可上传文件的个数；action的地址是将文件传给后台的接口地址； -->
          <!--    fileList是选择的文件的全部信息，在事件中作为参数传进去，可以查看其内容；-->
          <el-tab-pane label="下载数据" name="second">

            <el-row justify="center" type="flex">
              <el-col :span="6">
                <el-button type="success" icon="el-icon-download" @click="download(0)">加载tbCell</el-button>
                <a href="../static/tbcell.txt" download="tbCell.txt">下载tbCell</a>
              </el-col>
              <el-col :span="6">
                <el-button type="success" icon="el-icon-download" @click="download(1)">加载tbKPI</el-button>
                <a href="../static/tbkpi.txt" download="tbKPI.txt">下载tbKPI</a>
              </el-col>

            </el-row>

            <el-row justify="center" type="flex">
              <el-col :span="6">
                <el-button type="success" icon="el-icon-download" @click="download(2)">加载tbPRB</el-button>
                <a href="../static/tbprb.txt" download="tbPRB.txt">下载tbPRB</a>
              </el-col>
              <el-col :span="6">
                <el-button type="success" icon="el-icon-download" @click="download(3)">加载tbMRO</el-button>
                <a href="../static/tbmro.txt" download="tbMRO.txt">下载tbMRO</a>
              </el-col>

              <el-col :span="6">
                <el-button type="success" icon="el-icon-download" @click="download(4)">加载tbPRBnew</el-button>
                <a href="../static/tbprbnew.txt" download="tbPRBnew.txt">下载tbPRBnew</a>
              </el-col>

            </el-row>


          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>

  </el-container>
</template>

<script>
    export default {
      name: "data_control",
      data(){
        return{
          activeName: 'first',
          limitNum: 5,//最多上传五个文件
          fileList: [],
          x:0,//0激活cell上传，1激活kpi上传，2激活prb上传，3激活mro上传
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
          if (!(extension=='xlsx'||extension=='csv')) {
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
          this.$refs.uploadCELL.clearFiles()// 清除上次上传记录
          this.$refs.uploadKPI.clearFiles()
          this.$refs.uploadPRB.clearFiles()
          this.$refs.uploadMRO.clearFiles()
        },
        // 文件上传失败时的钩子
        handleError(err, file, fileList) {
          this.$message({
            message:'文件上传失败',
            type:'error'
          })
        },

        active:function(x){
          this.x = x;
        },

        uploadClick() {//上传文件手动提交
          if(this.x == 0){
            this.$refs.uploadCELL.submit()
          }
          if(this.x == 1){
            this.$refs.uploadKPI.submit()
          }
          if(this.x == 2){
            this.$refs.uploadPRB.submit()
          }
          if(this.x == 3){
            this.$refs.uploadMRO.submit()
          }

        },

        download:function(x){
          var that = this;
          var URL = '';
          if(x==0){
            URL = '/api/cell/export';
          }
          else if(x==1){
            URL = '/api/kpi/export';
          }
          else if(x==2){
            URL = '/api/prb/export';
          }
          else if(x==3){
            URL = '/api/mro/export';
          }
          else if(x==4){
            URL = '/api/prb/generate';
          }
          $.ajax({
            //url: '/api/kpi/export',
            url: URL,
            success: function(res) {
              console.log(res);
            }
          })
          this.$message({
            type:"success",
            message:"加载成功！"
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
    line-height: 20px;
    height: 600px;
  }

  .el-row {
    margin-bottom: 50px;

  }
</style>
