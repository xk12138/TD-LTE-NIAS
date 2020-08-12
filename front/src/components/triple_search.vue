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
        2. 点击“√”进行提交计算；
        3. 点击“导出重叠覆盖干扰三元组结果”进行新表tbC2I3的下载；
        4. 点击“✏”更改x值。
      </el-aside>
      <el-main>
        <el-input v-model="x" placeholder="请输入概率标准x" style="width: 300px">
          <span slot="suffix">%</span>
        </el-input>
        <el-button type="success" icon="el-icon-check" circle @click="submitX" :disabled="disabled"></el-button>
        <el-button type="primary" icon="el-icon-edit" circle @click="editX"></el-button>

        <div v-if="ifSearch">
          <el-table
            id="table"
            :data="tableData"
            height="450px"
            border
            :row-style="{height: '40px'}"
            style="width: 100%"
          >
            <el-table-column
              prop="cell1"
              label="CELL1"
              width="200">
            </el-table-column>
            <el-table-column
              prop="cell2"
              label="CELL2"
              width="200">
            </el-table-column>
            <el-table-column
              prop="cell3"
              label="CELL3"
              width="200">
            </el-table-column>
          </el-table>

          <div>
            <el-button @click="exportTriple" type="primary">导出重叠覆盖干扰三元组结果</el-button>
          </div>

        </div>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
  import FileSaver from "file-saver";
  import XLSX from "xlsx";
    export default {
        name: "triple_search",
      data(){
      return{
        x:'',
        disabled: false,//设置按钮是否禁用
        tableData:[],
        ifSearch:false,
      }
      },
      methods:{
        submitX:function(){
          var that = this;
          this.disabled = true;
          this.ifSearch = true;
          this.$message("提交参数"+this.x);
          $.ajax({
            url: "/api/c2i3/generate",
            type: "GET",
            data: {
              x:this.x*0.01-0.0001
            },
            success: function (res) {
              if (res.code != 0) {
                alert("生成失败!code=" + res.code);
                return;
              }
              console.log(res)
              for(let i=0;i<=res.list.length-1;i++){
                that.tableData.push({
                  cell1: res.list[i][0],
                  cell2: res.list[i][1],
                  cell3: res.list[i][2]
                })
              }
              console.log(that.tableData);
            }
          })
        },

        exportTriple:function(){//导出小区配置信息
          /* 从表生成工作簿对象 */
          var wb = XLSX.utils.table_to_book(document.querySelector("#table"));
          /* 获取二进制字符串作为输出 */
          var wbout = XLSX.write(wb, {
            bookType: "xlsx",
            bookSST: true,
            type: "array"
          });
          try {
            FileSaver.saveAs(
              //Blob 对象表示一个不可变、原始数据的类文件对象。
              //Blob 表示的不一定是JavaScript原生格式的数据。
              //File 接口基于Blob，继承了 blob 的功能并将其扩展使其支持用户系统上的文件。
              //返回一个新创建的 Blob 对象，其内容由参数中给定的数组串联组成。
              new Blob([wbout], { type: "application/octet-stream" }),
              //设置导出文件名称
              "tbC2I3.xlsx"
            );
          } catch (e) {
            if (typeof console !== "undefined") console.log(e, wbout);
          }
          return wbout;
        },

        editX:function(){
          this.disabled = false;
          this.tableData=[];
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
    line-height: 60px;
    height: 600px;
  }
  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: center;
    line-height: 40px;
  }


</style>
