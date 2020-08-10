<!--author:AK
info_search.vue：信息查询页面
version1.0:2020/8/3，完成构建页面，没有添加接口
version2.0:2020/8/10,重构页面，添加接口
-->
<template>
  <el-container>
    <el-header>
      <el-page-header @back="goBack" content="信息查询"></el-page-header>
    </el-header>
    <el-container>
      <el-main>
        <el-tabs v-model="activeName" >
          <el-tab-pane label="小区配置信息查询" name="first">

            <span class="demonstration">输入小区名称或id</span>
            <el-input style="width: 300px"
                      placeholder="请输入小区名称或id"
                      v-model="inputCell"
                      clearable>
            </el-input>
            <el-button type="primary" @click="searchCell">查询小区信息</el-button>

            <div v-if="ifsearch0">
              <el-table
                :data="tableData1"
                height="400"
                border
                style="width: 100%">
                <el-table-column
                  prop="city"
                  label="CITY"
                  width="100">
                </el-table-column>
                <el-table-column
                  fixed
                  prop="sector_name"
                  label="SECTOR_NAME"
                  width="100">
                </el-table-column>
                <el-table-column
                  fixed
                  prop="sector_id"
                  label="SECTOR_ID"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="enodebid"
                  label="ENODEBID"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="enodebname"
                  label="ENODEB_NAME"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="earfcn"
                  label="EARFCN"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="pci"
                  label="PCI"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="pss"
                  label="PSS"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="sss"
                  label="SSS"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="tac"
                  label="TAC"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="vendor"
                  label="VENDOR"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="longitude"
                  label="LONGITUDE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="latitude"
                  label="LATITUDE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="style"
                  label="STYLE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="azimuth"
                  label="AZIMUTH"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="height"
                  label="HEIGHT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="electtilt"
                  label="ELECTTILT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="mechtilt"
                  label="MECHTILT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="totletilt"
                  label="TOTLETILT"
                  width="100">
                </el-table-column>

              </el-table>
            </div>
          </el-tab-pane>
          <el-tab-pane label="基站eNodeB信息查询" name="second">

            <span class="demonstration">输入EnodeB名称或id</span>
            <el-input style="width: 300px"
                      placeholder="请输入EnodeB名称或id"
                      v-model="inputEnodeB"
                      clearable>
            </el-input>
            <el-button type="primary" @click="searchEnodeB">查询基站信息</el-button>

            <div v-if="ifsearch1">
              <el-table
                :data="tableData2"
                height="400"
                border
                style="width: 100%">
                <el-table-column
                  prop="city"
                  label="CITY"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="sector_id"
                  label="SECTOR_ID"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="sector_name"
                  label="SECTOR_NAME"
                  width="100">
                </el-table-column>
                <el-table-column
                  fixed
                  prop="enodebid"
                  label="ENODEEBID"
                  width="100">
                </el-table-column>
                <el-table-column
                  fixed
                  prop="enodebname"
                  label="ENODEED_NAME"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="earfcn"
                  label="EARFCN"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="pci"
                  label="PCI"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="pss"
                  label="PSS"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="sss"
                  label="SSS"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="tac"
                  label="TAC"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="vendor"
                  label="VENDOR"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="longitude"
                  label="LONGITUDE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="latitude"
                  label="LATITUDE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="style"
                  label="STYLE"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="azimuth"
                  label="AZIMUTH"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="height"
                  label="HEIGHT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="electtilt"
                  label="ELECTTILT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="mechtilt"
                  label="MECHTILT"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="totletilt"
                  label="TOTLETILT"
                  width="100">
                </el-table-column>
              </el-table>
            </div>
          </el-tab-pane>
          <el-tab-pane label="KPI指标信息查询" name="third">
            <span class="demonstration">输入网元名称</span>
            <el-input style="width: 300px"
              placeholder="请输入网元名称"
              v-model="inputKPI"
              clearable>
            </el-input>

            <el-dropdown @command="handleCommand2">
  <span class="el-dropdown-link">
    选择属性<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
              <el-dropdown-menu class="project-dropdown" slot="dropdown">
                <el-dropdown-item command="周期">周期</el-dropdown-item>
                <el-dropdown-item command="RRC连接建立完成次数">RRC连接建立完成次数</el-dropdown-item>
                <el-dropdown-item command="RRC连接请求次数_包括重发">RRC连接请求次数_包括重发</el-dropdown-item>
                <el-dropdown-item command="RRC建立成功率qf">RRC建立成功率qf</el-dropdown-item>
                <el-dropdown-item command="E_RAB建立成功总次数">E_RAB建立成功总次数</el-dropdown-item>
                <el-dropdown-item command="E_RAB建立尝试总次数">E_RAB建立尝试总次数</el-dropdown-item>
                <el-dropdown-item command="E_RAB建立成功率">E_RAB建立成功率</el-dropdown-item>
                <el-dropdown-item command="e_nodeB触发的E_RAB异常释放总次数">e_nodeB触发的E_RAB异常释放总次数</el-dropdown-item>
                <el-dropdown-item command="小区切换出E_RAB异常释放总次数">小区切换出E_RAB异常释放总次数</el-dropdown-item>
                <el-dropdown-item command="E_RAB掉线率_新">E_RAB掉线率_新</el-dropdown-item>
                <el-dropdown-item command="无线接通率ay">无线接通率ay</el-dropdown-item>
                <el-dropdown-item command="e_nodeB发起的S1_RESET导致的UE_Context释放次数">e_nodeB发起的S1_RESET导致的UE_Context释放次数</el-dropdown-item>
                <el-dropdown-item command="UE_Context异常释放次数">UE_Context异常释放次数</el-dropdown-item>
                <el-dropdown-item command="UE_Context建立成功总次数">UE_Context建立成功总次数</el-dropdown-item>
                <el-dropdown-item command="无线掉线率">无线掉线率</el-dropdown-item>
                <el-dropdown-item command="e_nodeB内异频切换出成功次数">e_nodeB内异频切换出成功次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB内异频切换出尝试次数">e_nodeB内异频切换出尝试次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB内同频切换出成功次数">e_nodeB内同频切换出成功次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB内同频切换出尝试次数">e_nodeB内同频切换出尝试次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB间异频切换出成功次数">e_nodeB间异频切换出成功次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB间异频切换出尝试次数">e_nodeB间异频切换出尝试次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB间同频切换出成功次数">e_nodeB间同频切换出成功次数</el-dropdown-item>
                <el-dropdown-item command="e_nodeB间同频切换出尝试次数">e_nodeB间同频切换出尝试次数</el-dropdown-item>
                <el-dropdown-item command="eNB内切换成功率">eNB内切换成功率</el-dropdown-item>
                <el-dropdown-item command="eNB间切换成功率">eNB间切换成功率</el-dropdown-item>
                <el-dropdown-item command="同频切换成功率zsp">同频切换成功率zsp</el-dropdown-item>
                <el-dropdown-item command="异频切换成功率zsp">异频切换成功率zsp</el-dropdown-item>
                <el-dropdown-item command="切换成功率">切换成功率</el-dropdown-item>
                <el-dropdown-item command="小区PDCP层所接收到的上行数据的总吞吐量">小区PDCP层所接收到的上行数据的总吞吐量</el-dropdown-item>
                <el-dropdown-item command="小区PDCP层所发送的下行数据的总吞吐量">小区PDCP层所发送的下行数据的总吞吐量</el-dropdown-item>
                <el-dropdown-item command="RRC重建请求次数">RRC重建请求次数</el-dropdown-item>
                <el-dropdown-item command="RRC连接重建比率">RRC连接重建比率</el-dropdown-item>
                <el-dropdown-item command="通过重建回源小区的e_nodeB间同频切换出执行成功次数">通过重建回源小区的e_nodeB间同频切换出执行成功次数</el-dropdown-item>
                <el-dropdown-item command="通过重建回源小区的e_nodeB间异频切换出执行成功次数">通过重建回源小区的e_nodeB间异频切换出执行成功次数</el-dropdown-item>
                <el-dropdown-item command="通过重建回源小区的e_nodeB内同频切换出执行成功次数">通过重建回源小区的e_nodeB内同频切换出执行成功次数</el-dropdown-item>
                <el-dropdown-item command="通过重建回源小区的e_nodeB内异频切换出执行成功次数">通过重建回源小区的e_nodeB内异频切换出执行成功次数</el-dropdown-item>
                <el-dropdown-item command="eNB内切换出成功次数">eNB内切换出成功次数</el-dropdown-item>
                <el-dropdown-item command="eNB内切换出请求次数">eNB内切换出请求次数</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>

            <div class="block">
              <span class="demonstration">选择起止日期</span>
              <el-date-picker
                type="daterange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期"
                format="yyyy 年 MM 月 dd 日"
                value-format="yyyy-MM-dd"
                v-model="s_e_date">
              </el-date-picker>
              <el-button type="primary" icon="el-icon-s-marketing" @click="showChart0">展示结果</el-button>
            </div>

            <div>
              网元“{{inputKPI}}”在 {{s_e_date}}之间的“{{KPIattribute}}”变化情况
            </div>


              <div id="kpiChart" ></div>


          </el-tab-pane>
          <el-tab-pane label="PRB信息统计与查询" name="forth">
            <el-dropdown @command="handleCommand3">
      <span class="el-dropdown-link">
        选择网元<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item command="a">testA</el-dropdown-item>
                <el-dropdown-item command="b">testB</el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <div v-if="ifsearch3">
              <el-table
                :data="tableData"
                height="400"
                border
                style="width: 100%">
                <el-table-column
                  fixed
                  prop="网元名称"
                  label="网元名称"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="属性1"
                  label="属性1"
                  width="100">
                </el-table-column>
                <el-table-column
                  prop="属性2"
                  label="属性2"
                  width="100">
                </el-table-column>
              </el-table>
              <div class="block">
                <span class="demonstration">选择起止时间</span>
                <el-date-picker
                  format="HH:mm:ss"
                  value-format="yyyy-MM-dd-HH:mm:ss"
                  v-model="s_e_time"
                  type="datetimerange"
                  range-separator="至"
                  start-placeholder="开始日期"
                  end-placeholder="结束日期">
                </el-date-picker>
                <el-button type="primary" icon="el-icon-s-marketing" @click="showChart0">展示结果</el-button>
              </div>
            </div>
          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
import echarts from "echarts"
    export default {
        name: "info_search",
      data(){
        return{
          activeName: 'first',
          ifsearch0: false,//是否开始查询
          ifsearch1: false,//是否开始查询
          ifsearch2: false,//是否开始查询
          ifsearch3: false,//是否开始查询
          tableData1: [{
            azimuth: '',
            city: '',
            earfcn: '',
            electtilt: '',
            enodebid: '',
            enodebname: '',
            height: '',
            latitude: '',
            longitude: '',
            mechtilt: '',
            pci: '',
            pss:'',
            sector_id: '',
            sector_name: '',
            sss: '',
            style: '',
            tac: '',
            totletilt: '',
            vendor: ''
          }],//查询1的表格数据
          tableData2:[],//查询2的表格数据
          s_e_date: '',//选择查询起止日期（按天）
          s_e_time:'',//选择查询起止时间（按小时）
          inputKPI:'',//输入kpi网元名称
          KPIattribute:'',//选择要查询的kpi属性
          inputCell:'',//输入小区名字或id
          inputEnodeB:'',//输入enodeB名字或id
        };
      },

      methods: {
        handleCommand2(command) {
          this.KPIattribute = command;
        },

        handleCommand3(command) {
          this.$message('选择网元 ' + command);
          this.ifsearch3 = true;
        },

        showChart1:function () {
          this.$message('展示从折线图'+this.s_e_date);
        },

        showChart0:function () {
          var that = this
          var sdate = this.s_e_date.toString().split(',')[0] + " 00:00:00";//开始日期
          var edate = this.s_e_date.toString().split(',')[1] + " 00:00:00";//结束日期
          $.ajax({
            url: "/api/kpi/search",
            type: "GET",
            data: {
              keyword: this.KPIattribute,
              name: this.inputKPI,
              start_time: sdate,
              end_time: edate,
            },
            success: function (res) {
              if (res.code != 0) {
                alert("查询失败!code=" + res.code);
                return;
              }
              console.log(res)
              var xList = [];
              var yList = [];
              for(let i=0; i<=res.list.length-1; i++){
                xList.push(res.list[i][1]);
                yList.push(res.list[i][0]);
              }
              that.drawKpiChart(xList,yList)
            }
          })
        },

        goBack() {
          this.$router.go(-1);
        },

        searchCell:function(){
          var that = this
          this.ifsearch0=true;
          $.ajax({
            url: "/api/cell/search_by_sector",
            type: "GET",
            data: {
              keyword: this.inputCell
            },
            success: function (res) {
              if (res.code != 0) {
                alert("查询失败!code=" + res.code);
                return;
              }
                that.tableData1[0].city=res.list[0][0];
                that.tableData1[0].sector_id=res.list[0][1];
                that.tableData1[0].sector_name=res.list[0][2];
                that.tableData1[0].enodebid=res.list[0][3];
                that.tableData1[0].enodebname=res.list[0][4];
                that.tableData1[0].earfcn=res.list[0][5];
                that.tableData1[0].pci=res.list[0][6];
                that.tableData1[0].pss=res.list[0][7];
                that.tableData1[0].sss=res.list[0][8];
                that.tableData1[0].tac=res.list[0][9];
                that.tableData1[0].vendor=res.list[0][10];
                that.tableData1[0].longitude=res.list[0][11];
                that.tableData1[0].latitude=res.list[0][12];
                that.tableData1[0].style=res.list[0][13];
                that.tableData1[0].azimuth=res.list[0][14];
                that.tableData1[0].height=res.list[0][15];
                that.tableData1[0].electtilt=res.list[0][16];
                that.tableData1[0].mechtilt=res.list[0][17];
                that.tableData1[0].totletilt=res.list[0][18];
            }
          })
        },

        searchEnodeB:function(){
          var that = this
          this.ifsearch1=true;
          $.ajax({
            url: "/api/cell/search_by_enodeB",
            type: "GET",
            data: {
              keyword: this.inputEnodeB
            },
            success: function (res) {
              if (res.code != 0) {
                alert("查询失败!code=" + res.code);
                return;
              }
              for(let i=0;i<=res.list.length-1;i++){
                that.tableData2.push({
                  city:res.list[i][0],
                  sector_id:res.list[i][1],
                  city:res.list[i][0],
                  sector_id:res.list[i][1],
                  sector_name:res.list[i][2],
                  enodebid:res.list[i][3],
                  enodebname:res.list[i][4],
                  earfcn:res.list[i][5],
                  pci:res.list[i][6],
                  pss:res.list[i][7],
                  sss:res.list[i][8],
                  tac:res.list[i][9],
                  vendor:res.list[i][10],
                  longitude:res.list[i][11],
                  latitude:res.list[i][12],
                  style:res.list[i][13],
                  azimuth:res.list[i][14],
                  height:res.list[i][15],
                  electtilt:res.list[i][16],
                  mechtilt:res.list[i][17],
                  totletilt:res.list[i][18],
                })
              }
            }
          })
        },

        drawKpiChart(x,y) {
          console.log(x,y);
          let kpiChart = echarts.init(document.getElementById('kpiChart'))
          // 绘制kpi图表
          kpiChart.setOption({
            tooltip: {},
            xAxis: {
              data: x
            },
            yAxis: {
            },
            series: [{
              name: this.KPIattribute,
              type: 'bar',
              data: y,
            }]
          });
        }
      }
    }
</script>

<style>
  .el-dropdown-link {
    cursor: pointer;
    color: #409EFF;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }
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
    line-height: 40px;
    height: 600px;
  }

  .project-dropdown{
    height:300px;
    overflow: auto;
  }
  .project-dropdown::-webkit-scrollbar
  {
    width: 5px;
    height: 5px;
    background-color: #F5F5F5;
  }
  .project-dropdown::-webkit-scrollbar-track
  {
  //-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    border-radius: 10px;
    background-color: #F5F5F5;
  }

  #kpiChart{
    width: 80%;
    height: 350px;
    border: 1px solid black;
    margin: 0 auto;
  }

  h2{
    text-align: center;
    padding: 30px;
    font-size: 18px;
  }

</style>
