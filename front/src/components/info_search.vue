<!--author:AK
info_search.vue：信息查询页面
version1.0:2020/8/3，完成构建页面，没有添加接口
version2.0:2020/8/10,重构页面，添加接口,完成全部查询功能
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
                id="cellInfo"
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

              <div>
                <el-button @click="exportCell" type="primary">导出小区配置信息结果</el-button>
              </div>

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
                id="enodebInfo"
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

              <div>
                <el-button @click="exportEnodeB" type="primary">导出基站EnodeB配置信息结果</el-button>
              </div>

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
              <div ref="chart">
                <el-button type="primary" icon="el-icon-s-marketing" @click="showChart0">展示结果</el-button>
                <el-button type="primary" @click="exportKPI">导出图表</el-button>
              </div>

            </div>

            <div>
              网元“{{inputKPI}}”在 {{s_e_date}}之间的“{{KPIattribute}}”变化情况
            </div>


              <div id="kpiChart" ></div>


          </el-tab-pane>
          <el-tab-pane label="PRB信息统计与查询" name="forth">
            <span class="demonstration">输入网元名称</span>
            <el-input style="width: 300px"
                      placeholder="请输入网元名称"
                      v-model="inputPRB"
                      clearable>
            </el-input>

            <el-dropdown @command="handleCommand3">
  <span class="el-dropdown-link">
    选择属性<i class="el-icon-arrow-down el-icon--right"></i>
  </span>
              <el-dropdown-menu class="project-dropdown" slot="dropdown">
                <el-dropdown-item command="周期">周期</el-dropdown-item>
                <el-dropdown-item command="第0个PRB上检测到的干扰噪声的平均值">第0个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第1个PRB上检测到的干扰噪声的平均值">第1个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第2个PRB上检测到的干扰噪声的平均值">第2个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第3个PRB上检测到的干扰噪声的平均值">第3个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第4个PRB上检测到的干扰噪声的平均值">第4个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第5个PRB上检测到的干扰噪声的平均值">第5个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第6个PRB上检测到的干扰噪声的平均值">第6个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第7个PRB上检测到的干扰噪声的平均值">第7个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第8个PRB上检测到的干扰噪声的平均值">第8个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第9个PRB上检测到的干扰噪声的平均值">第9个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第10个PRB上检测到的干扰噪声的平均值">10个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第11个PRB上检测到的干扰噪声的平均值">第11个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第12个PRB上检测到的干扰噪声的平均值">第12个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第13个PRB上检测到的干扰噪声的平均值">第13个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第140PRB上检测到的干扰噪声的平均值">第14个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第15个PRB上检测到的干扰噪声的平均值">第15个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第16个PRB上检测到的干扰噪声的平均值">第16个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第17个PRB上检测到的干扰噪声的平均值">第17个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第18个PRB上检测到的干扰噪声的平均值">第18个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第19个PRB上检测到的干扰噪声的平均值">第19个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第20个PRB上检测到的干扰噪声的平均值">第20个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第21个PRB上检测到的干扰噪声的平均值">第21个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第22个PRB上检测到的干扰噪声的平均值">第22个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第23个PRB上检测到的干扰噪声的平均值">第23个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第24个PRB上检测到的干扰噪声的平均值">第24个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第25个PRB上检测到的干扰噪声的平均值">第25个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第26个PRB上检测到的干扰噪声的平均值">第26个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第27个PRB上检测到的干扰噪声的平均值">第27个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第28个PRB上检测到的干扰噪声的平均值">第28个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第29个PRB上检测到的干扰噪声的平均值">第29个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第30个PRB上检测到的干扰噪声的平均值">第30个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第31个PRB上检测到的干扰噪声的平均值">第31个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第32个PRB上检测到的干扰噪声的平均值">第32个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第33个PRB上检测到的干扰噪声的平均值">第33个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第34个PRB上检测到的干扰噪声的平均值">第34个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第35个PRB上检测到的干扰噪声的平均值">第35个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第36个PRB上检测到的干扰噪声的平均值">第36个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第37个PRB上检测到的干扰噪声的平均值">第37个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第38个PRB上检测到的干扰噪声的平均值">第38个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第39个PRB上检测到的干扰噪声的平均值">第39个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第40个PRB上检测到的干扰噪声的平均值">第40个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第41个PRB上检测到的干扰噪声的平均值">第41个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第42个PRB上检测到的干扰噪声的平均值">第42个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第43个PRB上检测到的干扰噪声的平均值">第43个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第44个PRB上检测到的干扰噪声的平均值">第44个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第45个PRB上检测到的干扰噪声的平均值">第45个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第46个PRB上检测到的干扰噪声的平均值">第46个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第47个PRB上检测到的干扰噪声的平均值">第47个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第48个PRB上检测到的干扰噪声的平均值">第48个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第49个PRB上检测到的干扰噪声的平均值">第49个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第50个PRB上检测到的干扰噪声的平均值">第50个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第51个PRB上检测到的干扰噪声的平均值">第51个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第52个PRB上检测到的干扰噪声的平均值">第52个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第53个PRB上检测到的干扰噪声的平均值">第53个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第54个PRB上检测到的干扰噪声的平均值">第54个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第55个PRB上检测到的干扰噪声的平均值">第55个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第56个PRB上检测到的干扰噪声的平均值">第56个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第57个PRB上检测到的干扰噪声的平均值">第57个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第58个PRB上检测到的干扰噪声的平均值">第58个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第59个PRB上检测到的干扰噪声的平均值">第59个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第60个PRB上检测到的干扰噪声的平均值">第60个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第61个PRB上检测到的干扰噪声的平均值">第61个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第62个PRB上检测到的干扰噪声的平均值">第62个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第63个PRB上检测到的干扰噪声的平均值">第63个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第64个PRB上检测到的干扰噪声的平均值">第64个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第65个PRB上检测到的干扰噪声的平均值">第65个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第66个PRB上检测到的干扰噪声的平均值">第66个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第67个PRB上检测到的干扰噪声的平均值">第67个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第68个PRB上检测到的干扰噪声的平均值">第68个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第69个PRB上检测到的干扰噪声的平均值">第69个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第70个PRB上检测到的干扰噪声的平均值">第70个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第71个PRB上检测到的干扰噪声的平均值">第71个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第72个PRB上检测到的干扰噪声的平均值">第72个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第73个PRB上检测到的干扰噪声的平均值">第73个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第74个PRB上检测到的干扰噪声的平均值">第74个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第75个PRB上检测到的干扰噪声的平均值">第75个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第76个PRB上检测到的干扰噪声的平均值">第76个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第77个PRB上检测到的干扰噪声的平均值">第77个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第78个PRB上检测到的干扰噪声的平均值">第78个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第79个PRB上检测到的干扰噪声的平均值">第79个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第80个PRB上检测到的干扰噪声的平均值">第80个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第81个PRB上检测到的干扰噪声的平均值">第81个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第82个PRB上检测到的干扰噪声的平均值">第82个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第83个PRB上检测到的干扰噪声的平均值">第83个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第84个PRB上检测到的干扰噪声的平均值">第84个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第85个PRB上检测到的干扰噪声的平均值">第85个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第86个PRB上检测到的干扰噪声的平均值">第86个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第87个PRB上检测到的干扰噪声的平均值">第87个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第88个PRB上检测到的干扰噪声的平均值">第88个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第89个PRB上检测到的干扰噪声的平均值">第89个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第90个PRB上检测到的干扰噪声的平均值">第90个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第91个PRB上检测到的干扰噪声的平均值">第91个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第92个PRB上检测到的干扰噪声的平均值">第92个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第93个PRB上检测到的干扰噪声的平均值">第93个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第94个PRB上检测到的干扰噪声的平均值">第94个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第95个PRB上检测到的干扰噪声的平均值">第95个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第96个PRB上检测到的干扰噪声的平均值">第96个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第97个PRB上检测到的干扰噪声的平均值">第97个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第98个PRB上检测到的干扰噪声的平均值">第98个PRB上检测到的干扰噪声的平均值</el-dropdown-item>
                <el-dropdown-item command="第99个PRB上检测到的干扰噪声的平均值">第99个PRB上检测到的干扰噪声的平均值</el-dropdown-item>

              </el-dropdown-menu>
            </el-dropdown>

            <div class="block">
              <span class="demonstration">选择起止日期</span>
              <el-date-picker
                format="HH:mm:ss"
                value-format="yyyy-MM-dd HH"
                v-model="s_e_time"
                type="datetimerange"
                range-separator="至"
                start-placeholder="开始日期"
                end-placeholder="结束日期">
              </el-date-picker>
              <div ref="chart">
                <el-button type="primary" icon="el-icon-s-marketing" @click="showChart1">展示结果</el-button>
                <el-button type="primary" @click="exportPRB">导出图表</el-button>
              </div>
            </div>

            <div>
              网元“{{inputPRB}}”在 {{s_e_time}}之间的“{{PRBattribute}}”变化情况
            </div>

            <div id="prbChart" ></div>


          </el-tab-pane>
        </el-tabs>
      </el-main>
    </el-container>
  </el-container>

</template>

<script>
import echarts from "echarts";
import FileSaver from "file-saver";
import XLSX from "xlsx";
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
          PRBattribute:'',//选择要查询的网元属性
          inputCell:'',//输入小区名字或id
          inputPRB:'',//输入网元名字
          inputEnodeB:'',//输入enodeB名字或id
        };
      },

      methods: {
        handleCommand2(command) {
          this.KPIattribute = command;
        },

        handleCommand3(command) {
          this.PRBattribute = command;
        },

        exportCell:function(){//导出小区配置信息
          /* 从表生成工作簿对象 */
          var wb = XLSX.utils.table_to_book(document.querySelector("#cellInfo"));
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
              "tbCell_info.xlsx"
            );
          } catch (e) {
            if (typeof console !== "undefined") console.log(e, wbout);
          }
          return wbout;
        },

        exportEnodeB:function(){//导出小区配置信息
          /* 从表生成工作簿对象 */
          var wb = XLSX.utils.table_to_book(document.querySelector("#enodebInfo"));
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
              "EnodeB_info.xlsx"
            );
          } catch (e) {
            if (typeof console !== "undefined") console.log(e, wbout);
          }
          return wbout;
        },

        exportCharts: function(fileName, pngid) {
          if (document.querySelector(pngid)) {
            let chartsCanvas = document
              .querySelector(pngid)
              .querySelectorAll("canvas")[0];
            let mime = "image/png";
            if (chartsCanvas) {
              // toDataURL()是canvas对象的一种方法，用于将canvas对象转换为base64位编码
              let imageUrl = chartsCanvas && chartsCanvas.toDataURL(mime);
              if (navigator.userAgent.indexOf("Trident") > -1) {
                // IE11
                let arr = imageUrl.split(",");
                // atob() 函数对已经使用base64编码编码的数据字符串进行解码
                let bstr = atob(arr[1]);
                let bstrLen = bstr.length;
                // Uint8Array, 开辟 8 位无符号整数值的类型化数组。内容将初始化为 0
                let u8arr = new Uint8Array(bstrLen);
                while (bstrLen--) {
                  // charCodeAt() 方法可返回指定位置的字符的 Unicode 编码
                  u8arr[bstrLen] = bstr.charCodeAt(bstrLen);
                }
                //  msSaveOrOpenBlob 方法允许用户在客户端上保存文件，方法如同从 Internet 下载文件，这是此类文件保存到“下载”文件夹的原因
                window.navigator.msSaveOrOpenBlob(
                  new Blob([u8arr], { type: mime }),
                  fileName + ".png"
                );
              } else {
                // 其他浏览器
                let $a = document.createElement("a");
                $a.setAttribute("href", imageUrl);
                $a.setAttribute("download", fileName);
                $a.click();
              }
            }
          }

        },


        //导出kpi
        exportKPI() {
          let pngid = "#kpiChart";
          let fileName = "kpiChart";
          this.exportCharts(fileName, pngid);
        },

        //导出prb
        exportPRB() {
          let pngid = "#prbChart";
          let fileName = "prbChart";
          this.exportCharts(fileName, pngid);
        },

        showChart1:function () {
          var that = this;
          var stime = this.s_e_time.toString().split(',')[0] ;//开始日期和时间
          var etime = this.s_e_time.toString().split(',')[1];//结束日期和时间
          console.log(this.s_e_time);
          $.ajax({
            url: "/api/prb/search",
            type: "GET",
            data: {
              keyword: this.PRBattribute,
              name: this.inputPRB,
              start_time: stime,
              end_time: etime,
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
              console.log(xList,yList)
              that.drawPrbChart(xList,yList)
            }
          })
        },

        showChart0:function () {//展示KPI指标信息
          var that = this;
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

        searchCell:function(){//查询小区配置信息
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

        searchEnodeB:function(){//查询基站配置信息
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

        drawKpiChart(x,y) {//画统计柱状图
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
        },

        drawPrbChart(x,y) {//画统计柱状图
          console.log(x,y);
          let prbChart = echarts.init(document.getElementById('prbChart'))
          // 绘制prb图表
          prbChart.setOption({
            tooltip: {},
            xAxis: {
              data: x
            },
            yAxis: {
            },
            series: [{
              name: this.PRBattribute,
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

  #prbChart{
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
