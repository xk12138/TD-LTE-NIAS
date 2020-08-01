CREATE TABLE if not exists tbKPI(
  起始时间 DATETIME,
	周期 INT,
	网元名称 VARCHAR(255),
	小区 VARCHAR(255),
	小区名 VARCHAR(255),
	RRC连接建立完成次数 INT,
	RRC连接请求次数_包括重发 INT,
	RRC建立成功率qf FLOAT,
	E_RAB建立成功总次数 INT,
	E_RAB建立尝试总次数 INT,
	E_RAB建立成功率 FLOAT,
  eNodeB触发的E_RAB异常释放总次数 INT,
	小区切换出E_RAB异常释放总次数 INT,
	E_RAB掉线率_新 FLOAT,
	无线接通率ay FLOAT,
	eNodeB发起的S1_RESET导致的UE_Context释放次数 INT,
	UE_Context异常释放次数 INT,
	UE_Context建立成功总次数 INT,
	无线掉线率 FLOAT,
	eNodeB内异频切换出成功次数 INT,
	eNodeB内异频切换出尝试次数 INT,
	eNodeB内同频切换出成功次数 INT,
	eNodeB内同频切换出尝试次数 INT,
	eNodeB间异频切换出成功次数 INT,
	eNodeB间异频切换出尝试次数 INT,
	eNodeB间同频切换出成功次数 INT,
	eNodeB间同频切换出尝试次数 INT,
	eNB内切换成功率 FLOAT,
	eNB间切换成功率 FLOAT,
	同频切换成功率zsp FLOAT,
	异频切换成功率zsp FLOAT,
	切换成功率 FLOAT,
	小区PDCP层所接收到的上行数据的总吞吐量 INT,
	小区PDCP层所发送的下行数据的总吞吐量 INT,
	RRC重建请求次数 INT,
	RRC连接重建比率 FLOAT,
	通过重建回源小区的eNodeB间同频切换出执行成功次数 INT,
	通过重建回源小区的eNodeB间异频切换出执行成功次数 INT,
	通过重建回源小区的eNodeB内同频切换出执行成功次数 INT,
	通过重建回源小区的eNodeB内异频切换出执行成功次数 INT,
	eNB内切换出成功次数 INT,
	eNB内切换出请求次数 INT,
	PRIMARY KEY (小区名)
	);

CREATE TABLE if not exists tbPRB(
  起始时间 DATETIME,
	周期 INT,
	网元名称 VARCHAR(255),
	小区 VARCHAR(255),
	小区名 VARCHAR(255),
	第0个PRB上检测到的干扰噪声的平均值 INT,
	第1个PRB上检测到的干扰噪声的平均值 INT,
	第2个PRB上检测到的干扰噪声的平均值 INT,
	第3个PRB上检测到的干扰噪声的平均值 INT,
	第4个PRB上检测到的干扰噪声的平均值 INT,
	第5个PRB上检测到的干扰噪声的平均值 INT,
	第6个PRB上检测到的干扰噪声的平均值 INT,
	第7个PRB上检测到的干扰噪声的平均值 INT,
	第8个PRB上检测到的干扰噪声的平均值 INT,
	第9个PRB上检测到的干扰噪声的平均值 INT,
	第10个PRB上检测到的干扰噪声的平均值 INT,
	第11个PRB上检测到的干扰噪声的平均值 INT,
	第12个PRB上检测到的干扰噪声的平均值 INT,
	第13个PRB上检测到的干扰噪声的平均值 INT,
	第14个PRB上检测到的干扰噪声的平均值 INT,
	第15个PRB上检测到的干扰噪声的平均值 INT,
	第16个PRB上检测到的干扰噪声的平均值 INT,
	第17个PRB上检测到的干扰噪声的平均值 INT,
	第18个PRB上检测到的干扰噪声的平均值 INT,
	第19个PRB上检测到的干扰噪声的平均值 INT,
	第20个PRB上检测到的干扰噪声的平均值 INT,
	第21个PRB上检测到的干扰噪声的平均值 INT,
	第22个PRB上检测到的干扰噪声的平均值 INT,
	第23个PRB上检测到的干扰噪声的平均值 INT,
	第24个PRB上检测到的干扰噪声的平均值 INT,
	第25个PRB上检测到的干扰噪声的平均值 INT,
	第26个PRB上检测到的干扰噪声的平均值 INT,
	第27个PRB上检测到的干扰噪声的平均值 INT,
	第28个PRB上检测到的干扰噪声的平均值 INT,
	第29个PRB上检测到的干扰噪声的平均值 INT,
	第30个PRB上检测到的干扰噪声的平均值 INT,
	第31个PRB上检测到的干扰噪声的平均值 INT,
	第32个PRB上检测到的干扰噪声的平均值 INT,
	第33个PRB上检测到的干扰噪声的平均值 INT,
	第34个PRB上检测到的干扰噪声的平均值 INT,
	第35个PRB上检测到的干扰噪声的平均值 INT,
	第36个PRB上检测到的干扰噪声的平均值 INT,
	第37个PRB上检测到的干扰噪声的平均值 INT,
	第38个PRB上检测到的干扰噪声的平均值 INT,
	第39个PRB上检测到的干扰噪声的平均值 INT,
	第40个PRB上检测到的干扰噪声的平均值 INT,
	第41个PRB上检测到的干扰噪声的平均值 INT,
	第42个PRB上检测到的干扰噪声的平均值 INT,
	第43个PRB上检测到的干扰噪声的平均值 INT,
	第44个PRB上检测到的干扰噪声的平均值 INT,
	第45个PRB上检测到的干扰噪声的平均值 INT,
	第46个PRB上检测到的干扰噪声的平均值 INT,
	第47个PRB上检测到的干扰噪声的平均值 INT,
	第48个PRB上检测到的干扰噪声的平均值 INT,
	第49个PRB上检测到的干扰噪声的平均值 INT,
	第50个PRB上检测到的干扰噪声的平均值 INT,
	第51个PRB上检测到的干扰噪声的平均值 INT,
	第52个PRB上检测到的干扰噪声的平均值 INT,
	第53个PRB上检测到的干扰噪声的平均值 INT,
	第54个PRB上检测到的干扰噪声的平均值 INT,
	第55个PRB上检测到的干扰噪声的平均值 INT,
	第56个PRB上检测到的干扰噪声的平均值 INT,
	第57个PRB上检测到的干扰噪声的平均值 INT,
	第58个PRB上检测到的干扰噪声的平均值 INT,
	第59个PRB上检测到的干扰噪声的平均值 INT,
	第60个PRB上检测到的干扰噪声的平均值 INT,
	第61个PRB上检测到的干扰噪声的平均值 INT,
	第62个PRB上检测到的干扰噪声的平均值 INT,
	第63个PRB上检测到的干扰噪声的平均值 INT,
	第64个PRB上检测到的干扰噪声的平均值 INT,
	第65个PRB上检测到的干扰噪声的平均值 INT,
	第66个PRB上检测到的干扰噪声的平均值 INT,
	第67个PRB上检测到的干扰噪声的平均值 INT,
	第68个PRB上检测到的干扰噪声的平均值 INT,
	第69个PRB上检测到的干扰噪声的平均值 INT,
	第70个PRB上检测到的干扰噪声的平均值 INT,
	第71个PRB上检测到的干扰噪声的平均值 INT,
	第72个PRB上检测到的干扰噪声的平均值 INT,
	第73个PRB上检测到的干扰噪声的平均值 INT,
	第74个PRB上检测到的干扰噪声的平均值 INT,
	第75个PRB上检测到的干扰噪声的平均值 INT,
	第76个PRB上检测到的干扰噪声的平均值 INT,
	第77个PRB上检测到的干扰噪声的平均值 INT,
	第78个PRB上检测到的干扰噪声的平均值 INT,
	第79个PRB上检测到的干扰噪声的平均值 INT,
	第80个PRB上检测到的干扰噪声的平均值 INT,
	第81个PRB上检测到的干扰噪声的平均值 INT,
	第82个PRB上检测到的干扰噪声的平均值 INT,
	第83个PRB上检测到的干扰噪声的平均值 INT,
	第84个PRB上检测到的干扰噪声的平均值 INT,
	第85个PRB上检测到的干扰噪声的平均值 INT,
	第86个PRB上检测到的干扰噪声的平均值 INT,
	第87个PRB上检测到的干扰噪声的平均值 INT,
	第88个PRB上检测到的干扰噪声的平均值 INT,
	第89个PRB上检测到的干扰噪声的平均值 INT,
	第90个PRB上检测到的干扰噪声的平均值 INT,
	第91个PRB上检测到的干扰噪声的平均值 INT,
	第92个PRB上检测到的干扰噪声的平均值 INT,
	第93个PRB上检测到的干扰噪声的平均值 INT,
	第94个PRB上检测到的干扰噪声的平均值 INT,
	第95个PRB上检测到的干扰噪声的平均值 INT,
	第96个PRB上检测到的干扰噪声的平均值 INT,
	第97个PRB上检测到的干扰噪声的平均值 INT,
	第98个PRB上检测到的干扰噪声的平均值 INT,
	第99个PRB上检测到的干扰噪声的平均值 INT,
	PRIMARY KEY (小区名)
	);

	CREATE TABLE if not exists tbC2I(
  CITY VARCHAR(255),
	SCELL VARCHAR(255),
	NCELL VARCHAR(255),
	PrC2I9 FLOAT,
	C2I_Mean FLOAT,
	Std FLOAT,
	SampleCount FLOAT,
	WeightedC2I FLOAT,
	PRIMARY KEY (SCELL,NCELL)
	);

	CREATE TABLE if not exists tbCell(
    CITY VARCHAR(255),
		SECTOR_ID VARCHAR(50),
		SECTOR_NAME VARCHAR(255),
		ENODEEBID INT NOT NULL,
		ENODEED_NAME VARCHAR(255) NOT NULL,
		EARFCN INT NOT NULL,
		PCI INT NOT NULL,
		PSS INT,
		SSS INT,
		TAC INT,
		VENDOR VARCHAR(255),
		LONGITUDE FLOAT NOT NULL,
		LATITUDE FLOAT NOT NULL,
		STYLE VARCHAR(255),
		AZIMUTH FLOAT NOT NULL,
		HEIGHT FLOAT,
		ELECTTILT FLOAT,
		MECHTILT FLOAT,
		TOTLETILT FLOAT NOT NULL,
		PRIMARY KEY (SECTOR_ID),
		CHECK (PCI BETWEEN 0 AND 503)
		);

  CREATE TABLE if not exists tbMROData(
    TimeStamp VARCHAR(30),
	ServingSector VARCHAR(50),
	InterferingSector VARCHAR(50),
	LteScRSRP FLOAT,
	LteNcRSRP FLOAT,
	LteNcEarfcn INT,
	LteNcPci SMALLINT,
	PRIMARY KEY (TimeStamp,ServingSector,InterferingSector)
	);
create table if not exists cookie (
	cookie_id varchar(255) primary key,
	user_id int not null,
	expiry_time datetime not null
) comment '用户cookie表';

create table if not exists user (
	user_id int primary key auto_increment,
	account varchar(20) not null,
	password varchar(255) not null
) comment '用户实体表';