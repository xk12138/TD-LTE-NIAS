<template>
  <el-tabs v-model="activeName" >
    <el-tab-pane label="小区配置信息查询" name="first">
      <el-dropdown @command="handleCommand0">
      <span class="el-dropdown-link">
        选择小区<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">testA</el-dropdown-item>
          <el-dropdown-item command="b">testB</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <div v-if="ifsearch0">
        <el-table
          :data="tableData"
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
            prop="sector_id"
            label="SECTOR_ID"
            width="100">
          </el-table-column>
          <el-table-column
            fixed
            prop="sector_name"
            label="SECTOR_NAME"
            width="100">
          </el-table-column>
          <el-table-column
            prop="enodeebid"
            label="ENODEEBID"
            width="100">
          </el-table-column>
          <el-table-column
            prop="enodeedname"
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
          <el-table-column
            prop="enodebid"
            label="enodebid"
            width="100">
          </el-table-column>
          <el-table-column
            prop="enoedebname"
            label="enodeb_name"
            width="100">
          </el-table-column>
        </el-table>
      </div>
    </el-tab-pane>
    <el-tab-pane label="基站eNodeB信息查询" name="second">
      <el-dropdown @command="handleCommand1">
      <span class="el-dropdown-link">
        选择基站<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">testA</el-dropdown-item>
          <el-dropdown-item command="b">testB</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <div v-if="ifsearch1">
        <el-table
          :data="tableData"
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
            prop="enodeebid"
            label="ENODEEBID"
            width="100">
          </el-table-column>
          <el-table-column
            prop="enodeedname"
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
          <el-table-column
            fixed
            prop="enodebid"
            label="enodebid"
            width="100">
          </el-table-column>
          <el-table-column
            fixed
            prop="enoedebname"
            label="enodeb_name"
            width="100">
          </el-table-column>
        </el-table>
      </div>
    </el-tab-pane>
    <el-tab-pane label="KPI指标信息查询" name="third">
      <el-dropdown @command="handleCommand2">
      <span class="el-dropdown-link">
        选择网元<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item command="a">testA</el-dropdown-item>
          <el-dropdown-item command="b">testB</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <div v-if="ifsearch2">
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
          <el-button type="primary" icon="el-icon-s-marketing" @click="showChart">展示结果</el-button>
        </div>
      </div>

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
              format="yyyy 年 MM 月 dd 日"
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
</template>

<script>
    export default {
        name: "info_search",
      data(){
        return{
          activeName: 'first',
          ifsearch0: false,//是否开始查询
          ifsearch1: false,//是否开始查询
          ifsearch2: false,//是否开始查询
          ifsearch3: false,//是否开始查询
          tableData: [],//表格数据
          s_e_date: '',//选择查询起止日期（按天）
          s_e_time:'',//选择查询起止时间（按小时）
        };
      },
      methods: {
        handleCommand0(command) {
          this.$message('选择小区 ' + command);
          this.ifsearch0 = true;
        },

        handleCommand1(command) {
          this.$message('选择基站 ' + command);
          this.ifsearch1 = true;
        },


        handleCommand2(command) {
          this.$message('选择网元 ' + command);
          this.ifsearch2 = true;
        },

        handleCommand3(command) {
          this.$message('选择网元 ' + command);
          this.ifsearch3 = true;
        },

        showChart:function () {
          this.$message('展示从折线图'+this.s_e_date);
        },

        showChart0:function () {
          this.$message('展示从折线图'+this.s_e_time);
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
</style>
