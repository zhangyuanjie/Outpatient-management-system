/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : hos

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2020-07-30 22:34:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_account` varchar(20) DEFAULT NULL,
  `admin_name` varchar(20) DEFAULT NULL,
  `admin_sex` varchar(2) DEFAULT NULL,
  `admin_age` int(11) DEFAULT NULL,
  `admin_pwd` varchar(50) DEFAULT NULL,
  `admin_email` varchar(50) DEFAULT NULL,
  `admin_phone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', '123456789', '张三', '男', '24', 'ce10d975516dde132a64ae181f593ce2', '1152223522@qq.com', '18307932052');
INSERT INTO `t_admin` VALUES ('4', '841566485', '千千', '男', null, 'bc3afe86e1175888cc74f0532becea39', null, null);

-- ----------------------------
-- Table structure for t_bill
-- ----------------------------
DROP TABLE IF EXISTS `t_bill`;
CREATE TABLE `t_bill` (
  `bill_id` varchar(20) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `bill_type` int(11) DEFAULT NULL,
  `join_id` varchar(20) DEFAULT NULL,
  `bill_details` text,
  `bill_price` float DEFAULT NULL,
  `bill_time` datetime DEFAULT NULL,
  PRIMARY KEY (`bill_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_bill
-- ----------------------------
INSERT INTO `t_bill` VALUES ('20040915592810', '10', '0', '022020040910', '挂号费用：5￥；出诊费用：20￥；', '25', '2020-04-09 15:59:28');
INSERT INTO `t_bill` VALUES ('20040912475510', '10', '0', '022020040910', '挂号费用：5￥；出诊费用：20￥；', '25', '2020-04-09 12:47:55');

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(10) DEFAULT NULL,
  `department_details` text,
  PRIMARY KEY (`department_id`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='科室表';

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES ('1', '神经内科', '主要以神经系统为主，具体疾病诸如脑梗死脑出血偏头痛等；');
INSERT INTO `t_department` VALUES ('2', '呼吸内科', '呼吸系统为主，具体疾病诸如急性上呼吸道感人肺炎、COPD、支气管炎、呼吸衰竭、 肺结核等；');
INSERT INTO `t_department` VALUES ('3', '心血管科', '心脏大血管为主，具体疾病如高血压、肺心病、心肌梗死、冠心病、心肌病、感染性心 内膜炎等；');
INSERT INTO `t_department` VALUES ('4', '消化内科', '主要是消化系统，具体疾病如胃炎、胃溃疡、肝硬化、消化道癌症等；');
INSERT INTO `t_department` VALUES ('5', '神经外科', '主要以脑部手术为主。具体疾病如脑疝、蛛网膜下出血、脑部肿瘤等；');
INSERT INTO `t_department` VALUES ('6', '眼科', '具体疾病如：角膜病、白内障、青光眼、近视远视、视网 膜脱离、泪道疾病、眼部外伤等；');
INSERT INTO `t_department` VALUES ('7', '耳鼻喉科', '主要包括耳、鼻、喉部的手术。具体疾病如扁桃体肿大、鼻中隔扭曲、喉部异物、鼻咽 癌等；');
INSERT INTO `t_department` VALUES ('8', '口腔科', '主要包括口腔颌面部。具体疾病如牙周炎、龋齿、口腔部肿瘤及外伤等；');
INSERT INTO `t_department` VALUES ('9', '心胸外科', '主要包括肺。心脏等具体疾病如肋骨骨折、气胸、先天性心脏病、肺癌、心脏瓣膜病等；');
INSERT INTO `t_department` VALUES ('10', '甲乳科', '主要包括乳腺和甲状腺这两个部位。具体疾病如甲状腺肿瘤、乳腺癌等');
INSERT INTO `t_department` VALUES ('11', '泌尿外科', '主要是泌尿系统。具体疾病如肾结石、尿道结石、肾癌、膀胱癌、尿道损伤、阴茎癌等；');
INSERT INTO `t_department` VALUES ('12', '骨科', '主要是全身骨骼。具体疾病如各处骨折、关节损伤、脱臼、骨癌、断指等；');
INSERT INTO `t_department` VALUES ('13', '皮肤科', '包括皮肤病和性病相关；');
INSERT INTO `t_department` VALUES ('14', '妇科', '主要以女性疾病为主，具体如阴道炎、子宫内膜炎、宫颈癌、卵巢癌等等；');
INSERT INTO `t_department` VALUES ('15', '儿科', '主要针对胎儿到青春期的小朋友各种疾病。有儿童内科和外科，具体分类和成人差不多。');
INSERT INTO `t_department` VALUES ('16', '中医科', '中医院分的细还有中医骨科、推拿科\r\n主要治疗以中药、针灸；');
INSERT INTO `t_department` VALUES ('17', '精神科', '主要收治各种心理疾病患者，如抑郁症、躁狂症、精神分裂症等；');
INSERT INTO `t_department` VALUES ('18', '体检科', '各类体检。');

-- ----------------------------
-- Table structure for t_diagnostic
-- ----------------------------
DROP TABLE IF EXISTS `t_diagnostic`;
CREATE TABLE `t_diagnostic` (
  `diagnostic_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `diagnostic_time` datetime DEFAULT NULL,
  `diagnostic_result` text,
  `record_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`diagnostic_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='诊断表';

-- ----------------------------
-- Records of t_diagnostic
-- ----------------------------
INSERT INTO `t_diagnostic` VALUES ('16', '2', '1', '2020-04-09 14:01:51', '患者有些咳嗽', '022020040972');

-- ----------------------------
-- Table structure for t_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_doctor`;
CREATE TABLE `t_doctor` (
  `doctor_id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_account` varchar(20) DEFAULT NULL,
  `doctor_name` varchar(20) DEFAULT NULL,
  `doctor_pwd` varchar(50) DEFAULT NULL,
  `doctor_age` int(11) DEFAULT NULL,
  `doctor_sex` varchar(2) DEFAULT NULL,
  `doctor_type` varchar(10) DEFAULT NULL,
  `doctor_email` varchar(50) DEFAULT NULL,
  `doctor_phone` varchar(20) DEFAULT NULL,
  `doctor_address` varchar(100) DEFAULT NULL,
  `doctor_status` varchar(10) DEFAULT NULL,
  `department_id` int(10) unsigned DEFAULT NULL,
  `work_time` varchar(50) DEFAULT NULL,
  `doctor_details` text,
  `attendance_price` float DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='医生表';

-- ----------------------------
-- Records of t_doctor
-- ----------------------------
INSERT INTO `t_doctor` VALUES ('1', '123', '王伟', '297254e9bfe0b8f39c682eda30bb9be0', '35', '女', '住院医师', '11152235222@qq.com', '18307932052', '江西省南昌市', '坐诊', '2', '上午9点-12点；下午13-18点', '', '20');
INSERT INTO `t_doctor` VALUES ('2', '123456789', '张杰', '297254e9bfe0b8f39c682eda30bb9be0', '36', '女', '住院医师', '11152235222@qq.com', '18307932052', '上海市徐汇区', '停诊', '2', '上午9点-12点；下午13-18点', '', '15');
INSERT INTO `t_doctor` VALUES ('3', '1234567', '张元杰', '297254e9bfe0b8f39c682eda30bb9be0', '38', '男', '主治医师', '18307932052@qq.com', '18307932052', '江西省上饶市', '坐诊', '3', '上午9点-12点；下午13-18点', null, '20');
INSERT INTO `t_doctor` VALUES ('4', '20162421', '吕小布', '1544049e68df9fb79c8a8d8086b57e84', '39', '男', '主任医师', '11152235222@qq.com', '18307932052', '上海市徐汇区', '坐诊', '4', '上午9点-12点；下午13-18点', null, '21');
INSERT INTO `t_doctor` VALUES ('5', '23515131', '王五', 'cd2a9ff1103905ca956d23793b61559d', '50', '男', '主任医生', '1152223522@qq.com', '18179335769', '江西省南昌市', '坐诊', '2', '上午9点-12点；下午13-18点', null, '20');
INSERT INTO `t_doctor` VALUES ('6', '201601', '小王子', '2ac6dd5ed57be575c5ea45b058c14385', '33', '男', '主任医生', null, null, null, '坐诊', '1', '上午9点-12点；下午13-18点', '', '20');

-- ----------------------------
-- Table structure for t_drug
-- ----------------------------
DROP TABLE IF EXISTS `t_drug`;
CREATE TABLE `t_drug` (
  `drug_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_name` varchar(100) DEFAULT NULL,
  `drug_type` varchar(20) DEFAULT NULL,
  `drug_specification` varchar(100) DEFAULT NULL,
  `drug_way` varchar(100) DEFAULT NULL,
  `drug_function` text,
  `drug_stock` int(11) DEFAULT NULL,
  `drug_unit` varchar(10) DEFAULT NULL,
  `drug_price` float DEFAULT NULL,
  `drug_time` varchar(10) DEFAULT NULL,
  `drug_provider` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`drug_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='药品表';

-- ----------------------------
-- Records of t_drug
-- ----------------------------
INSERT INTO `t_drug` VALUES ('1', '999皮炎平', '外敷', '20g/支；', '皮肤外用。取少量涂于患处，并轻揉片刻；一日1~2次', '皮肤外用。取少量涂于患处，并轻揉片刻；一日1~2次', '620', '盒', '20', '俩年', '江中集团');
INSERT INTO `t_drug` VALUES ('9', '连花清瘟胶囊', '口服', '0.35g*24粒/盒', '一次4粒，一日3次', '风热感冒', '47', '盒', '15', '俩年', '石家庄以岭药业股份有限公司');
INSERT INTO `t_drug` VALUES ('10', '999感冒灵', '（非处方药）中成药', '每袋重10克', '一次10克（1袋)，一日3次', '镇痛解热，用于感冒引起的头痛，发热，鼻塞，流涕，咽痛', '25', '盒', '15', '俩年', '华润三九医药股份有限公司委托华润三九枣庄药业有限公司生产');
INSERT INTO `t_drug` VALUES ('11', '白云山板蓝根颗粒', '（非处方药）中成药', '每袋装10克', '开水冲服， 一次5-10g，一日3-4次', '清热解毒，凉血利咽。用于肺胃热盛所致的咽喉肿痛、口咽干燥；急性扁桃体炎见上述证候者', '80', '袋', '17', '俩年', '广州白云山和记黄埔中药有限公司');
INSERT INTO `t_drug` VALUES ('12', '六味地黄丸', '口服', '每8丸重1.44克', '口服，一次8丸，一日3次', '滋阴补肾。用于肾阴亏损，头晕耳鸣，腰膝酸软，骨蒸潮热，盗汗遗精。', '68', '盒', '49', '四年', '北京同仁堂科技发展股份有限公司制药厂');
INSERT INTO `t_drug` VALUES ('13', '复方氨酚烷胺片', '（非处方药）化学药制剂', '6片/板*2板/盒', '口服，成人， 一次1片，一日2次', '适用于缓解普通感冒及流行性感冒引起的发热、头痛、四肢酸痛、打喷嚏、流鼻涕、鼻塞、咽痛等症状。', '87', '盒', '13.4', '三年', '吉林省吴太感康药业有限公司');
INSERT INTO `t_drug` VALUES ('14', '甲硝唑凝胶', '西药', '20g', '局部外用。清洗患处后，取适量本品涂于患处，每日早晚各一次。酒渣鼻红斑以2周为1疗程，连用8周', '用于炎症性丘疹、脓疱疮、酒渣鼻红斑的局部治疗。', '50', '瓶', '18', '\r\n24个月', '江苏知原药业有限公司');
INSERT INTO `t_drug` VALUES ('15', '盐酸特比萘芬喷雾剂', '喷雾剂', '1%*30ml', '外用，喷于患处，一日2～3次。疗程1～2周。', '用于治疗手癣、足癣、体癣、股癣及花斑癣等。', '75', '瓶', '38.9', '三年', '山东京卫制药有限公司');
INSERT INTO `t_drug` VALUES ('16', '十滴水', '（非处方药）中成药', '5ml*10支', '口服。一次2-5毫升，儿童酌减', '健胃、祛暑。用于因中暑而引起的头晕、恶心、腹痛、胃肠不适。', '86', '盒', '4.6', '俩年', '广西慧宝源医药科技有限公司');

-- ----------------------------
-- Table structure for t_drugin
-- ----------------------------
DROP TABLE IF EXISTS `t_drugin`;
CREATE TABLE `t_drugin` (
  `in_id` varchar(20) NOT NULL,
  `drug_id` int(11) DEFAULT NULL,
  `in_sum` int(11) DEFAULT NULL,
  `in_time` datetime DEFAULT NULL,
  `admin_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`in_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_drugin
-- ----------------------------
INSERT INTO `t_drugin` VALUES ('200408193712', '1', '5', '2020-04-08 19:37:12', '1');
INSERT INTO `t_drugin` VALUES ('2004011757101', '1', '3', '2020-04-01 17:57:10', '1');
INSERT INTO `t_drugin` VALUES ('2004011758071', '8', '15', '2020-04-01 17:58:07', '1');
INSERT INTO `t_drugin` VALUES ('2004081952380', '1', '56', '2020-04-08 19:52:38', '1');
INSERT INTO `t_drugin` VALUES ('2004081944140', '1', '56', '2020-04-08 19:48:15', '1');
INSERT INTO `t_drugin` VALUES ('2004081944141', '1', '56', '2020-04-08 19:48:15', '1');
INSERT INTO `t_drugin` VALUES ('2004081952381', '1', '56', '2020-04-08 19:52:38', '1');
INSERT INTO `t_drugin` VALUES ('2004081959360', '1', '2', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959361', '1', '3', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959362', '1', '3', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959363', '1', '56', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959364', '1', '56', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959365', '1', '2', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959366', '1', '5', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959367', '1', '3', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959368', '2', '5', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004081959369', '1', '5', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593610', '1', '56', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593611', '1', '56', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593612', '1', '56', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593613', '1', '3', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593614', '1', '5', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('20040819593615', '1', '5', '2020-04-08 19:59:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001360', '1', '2', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001361', '1', '3', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001362', '1', '3', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001363', '1', '56', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001364', '1', '56', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001365', '1', '2', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001366', '1', '5', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001367', '1', '3', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001368', '2', '5', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082001369', '1', '5', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013610', '1', '56', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013611', '1', '56', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013612', '1', '56', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013613', '1', '3', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013614', '1', '5', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820013615', '1', '5', '2020-04-08 20:01:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003360', '1', '2', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003361', '1', '3', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003362', '1', '3', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003363', '1', '56', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003364', '1', '56', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003365', '1', '2', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003366', '1', '5', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003367', '1', '3', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003368', '2', '5', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082003369', '1', '5', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033610', '1', '56', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033611', '1', '56', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033612', '1', '56', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033613', '1', '3', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033614', '1', '5', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820033615', '1', '5', '2020-04-08 20:03:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005360', '1', '2', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005361', '1', '3', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005362', '1', '3', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005363', '1', '56', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005364', '1', '56', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005365', '1', '2', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005366', '1', '5', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005367', '1', '3', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005368', '2', '5', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082005369', '1', '5', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053610', '1', '56', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053611', '1', '56', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053612', '1', '56', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053613', '1', '3', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053614', '1', '5', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('20040820053615', '1', '5', '2020-04-08 20:05:36', '1');
INSERT INTO `t_drugin` VALUES ('2004082007470', '1', '56', '2020-04-08 20:07:47', '1');
INSERT INTO `t_drugin` VALUES ('2004082007471', '1', '56', '2020-04-08 20:07:47', '1');
INSERT INTO `t_drugin` VALUES ('2004091456330', '1', '5', '2020-04-09 14:56:33', '1');
INSERT INTO `t_drugin` VALUES ('2004091456331', '9', '5', '2020-04-09 14:56:33', '1');

-- ----------------------------
-- Table structure for t_druglist
-- ----------------------------
DROP TABLE IF EXISTS `t_druglist`;
CREATE TABLE `t_druglist` (
  `list_id` int(11) NOT NULL AUTO_INCREMENT,
  `drug_id` varchar(20) DEFAULT NULL,
  `drug_num` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `prescription_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`list_id`)
) ENGINE=MyISAM AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='药品清单表';

-- ----------------------------
-- Records of t_druglist
-- ----------------------------
INSERT INTO `t_druglist` VALUES ('6', '1', '2', '2020-03-27 11:18:12', '2003271117491');
INSERT INTO `t_druglist` VALUES ('7', '1', '3', '2020-03-27 11:18:12', '2003271117491');
INSERT INTO `t_druglist` VALUES ('8', '1', '3', '2020-03-27 11:36:18', '2003271136061');
INSERT INTO `t_druglist` VALUES ('9', '1', '56', '2020-03-27 11:53:07', '2003271152491');
INSERT INTO `t_druglist` VALUES ('10', '1', '56', '2020-03-27 11:53:12', '2003271152491');
INSERT INTO `t_druglist` VALUES ('11', '1', '2', '2020-03-27 12:24:08', '2003271152495');
INSERT INTO `t_druglist` VALUES ('12', '1', '5', '2020-03-27 12:25:53', '2003271225301');
INSERT INTO `t_druglist` VALUES ('13', '1', '3', '2020-03-27 19:01:02', '2003271859581');
INSERT INTO `t_druglist` VALUES ('14', '2', '5', '2020-03-27 19:01:02', '2003271859581');
INSERT INTO `t_druglist` VALUES ('15', '1', '5', '2020-03-28 17:09:50', '2003281709301');
INSERT INTO `t_druglist` VALUES ('16', '1', '56', '2020-03-30 16:45:43', '2003301630521');
INSERT INTO `t_druglist` VALUES ('17', '1', '56', '2020-03-30 16:45:43', '2003301630521');
INSERT INTO `t_druglist` VALUES ('18', '1', '56', '2020-03-30 16:45:43', '2003301630521');
INSERT INTO `t_druglist` VALUES ('19', '1', '3', '2020-04-08 12:36:07', '2004081235551');
INSERT INTO `t_druglist` VALUES ('20', '1', '5', '2020-04-08 12:55:06', '2004081254531');
INSERT INTO `t_druglist` VALUES ('21', '1', '5', '2020-04-08 12:57:39', '2004081257301');
INSERT INTO `t_druglist` VALUES ('22', '1', '5', '2020-04-09 14:56:25', '2004091456151');
INSERT INTO `t_druglist` VALUES ('23', '9', '5', '2020-04-09 14:56:25', '2004091456151');
INSERT INTO `t_druglist` VALUES ('24', '9', '3', '2020-04-25 08:15:05', '2004250814561');

-- ----------------------------
-- Table structure for t_drugout
-- ----------------------------
DROP TABLE IF EXISTS `t_drugout`;
CREATE TABLE `t_drugout` (
  `out_id` varchar(20) NOT NULL,
  `drug_id` int(11) DEFAULT NULL,
  `out_sum` int(11) DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  PRIMARY KEY (`out_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_drugout
-- ----------------------------
INSERT INTO `t_drugout` VALUES ('2004250815051', '9', '3', '2020-04-25 08:15:05');
INSERT INTO `t_drugout` VALUES ('2004091456251', '1', '5', '2020-04-09 14:56:25');

-- ----------------------------
-- Table structure for t_medicalrecord
-- ----------------------------
DROP TABLE IF EXISTS `t_medicalrecord`;
CREATE TABLE `t_medicalrecord` (
  `record_id` varchar(20) NOT NULL,
  `medical_card` varchar(20) DEFAULT NULL,
  `record_status` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`record_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='病历表';

-- ----------------------------
-- Records of t_medicalrecord
-- ----------------------------
INSERT INTO `t_medicalrecord` VALUES ('022020040972', '2003291233142', '0', '2020-04-09 16:14:13');

-- ----------------------------
-- Table structure for t_patient
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient` (
  `patient_id` int(11) NOT NULL AUTO_INCREMENT,
  `medical_card` varchar(20) DEFAULT NULL,
  `patient_name` varchar(20) DEFAULT NULL,
  `patient_sex` varchar(2) DEFAULT NULL,
  `patient_age` int(11) DEFAULT NULL,
  `patient_type` varchar(15) DEFAULT '初诊',
  `patient_phone` varchar(20) DEFAULT NULL,
  `patient_address` varchar(100) DEFAULT NULL,
  `anamnesis` text,
  PRIMARY KEY (`patient_id`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 COMMENT='病人表';

-- ----------------------------
-- Records of t_patient
-- ----------------------------
INSERT INTO `t_patient` VALUES ('70', '2003271456082', '张元杰', '女', '18', '复诊', '18307932052', '江西省上饶市', '');
INSERT INTO `t_patient` VALUES ('71', '2003281706552', '玩', '男', '58', '复诊', '18307932052', '江西省', '');
INSERT INTO `t_patient` VALUES ('68', '2003230824182', '赵六', '男', '18', '复诊', '18307932052', '江西省上饶市', '');
INSERT INTO `t_patient` VALUES ('72', '2003291233142', '星期六', '男', '26', '复诊', '18307932052', '江西省', '');

-- ----------------------------
-- Table structure for t_prescription
-- ----------------------------
DROP TABLE IF EXISTS `t_prescription`;
CREATE TABLE `t_prescription` (
  `prescription_id` varchar(20) NOT NULL,
  `medical_card` varchar(20) DEFAULT NULL,
  `record_id` varchar(20) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `diagnostic` text,
  `prescription_time` datetime DEFAULT NULL,
  `doctor_id` varchar(20) DEFAULT NULL,
  `total_price` float DEFAULT NULL,
  `prescription_status` int(11) DEFAULT '0',
  PRIMARY KEY (`prescription_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='处方表';

-- ----------------------------
-- Records of t_prescription
-- ----------------------------
INSERT INTO `t_prescription` VALUES ('2004091456151', '2003291233142', '022020040972', '2', null, '2020-04-09 14:56:15', '1', '175', '-1');
INSERT INTO `t_prescription` VALUES ('2004250814561', '2003291233142', '022020040972', '2', null, '2020-04-25 08:14:56', '1', '45', '0');

-- ----------------------------
-- Table structure for t_registration
-- ----------------------------
DROP TABLE IF EXISTS `t_registration`;
CREATE TABLE `t_registration` (
  `registration_id` varchar(20) NOT NULL,
  `medical_card` varchar(20) DEFAULT NULL,
  `patient_name` varchar(20) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `doctor_id` int(11) DEFAULT NULL,
  `registration_type` varchar(10) DEFAULT NULL,
  `registration_time` datetime DEFAULT NULL,
  `appointment_time` datetime DEFAULT NULL,
  `registration_price` float DEFAULT '5',
  `registration_status` int(11) DEFAULT '0',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`registration_id`)
) ENGINE=MyISAM AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='挂号表';

-- ----------------------------
-- Records of t_registration
-- ----------------------------
INSERT INTO `t_registration` VALUES ('022020040910', '2003291233142', '星期六', '2', '1', '普通门诊', '2020-04-09 15:59:28', '2020-04-10 15:55:15', '5', '2', '10');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(20) DEFAULT NULL,
  `user_pwd` varchar(50) DEFAULT NULL,
  `user_name` varchar(20) DEFAULT NULL,
  `user_type` varchar(15) DEFAULT NULL,
  `user_sex` varchar(2) DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_phone` varchar(20) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL,
  `user_status` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', '123456', '3980e4044675f6339248ee0c735c7d72', 'ww', '教师', '男', '15', '1152223522@qq.com', '18307932052', '江西省', '1');
INSERT INTO `t_user` VALUES ('10', '1152223522', '62668b3ff9f1ea069e42ffa5d671b6d1', '张小白', '其他用户', '男', '28', '1152223522@qq.com', '18307932052', '江西省上饶市', '0');
INSERT INTO `t_user` VALUES ('4', '123', 'ea41c608e84c0f93403f6ddab7adfd9c', '123', '教师', '女', '22', '12345689@qq.com', '18309320525', '江西省上饶市万年县', null);
INSERT INTO `t_user` VALUES ('5', '20162421', '1544049e68df9fb79c8a8d8086b57e84', '张元杰', '教师', '女', '15', '12345689@qq.com', '18309320525', '北京省', null);
INSERT INTO `t_user` VALUES ('6', '1234567', '5738a98446ac4c00b29281ed4cf0c348', '123456', '其他用户', '男', '56', '12345689@qq.com', '18309320525', '北京省', null);
INSERT INTO `t_user` VALUES ('7', '818643', 'f40baf8f2eed4e77cb6758d5cee08d89', '846451', '教师', '女', '48', '12345689@qq.com', '18309320525', '北京省', null);
INSERT INTO `t_user` VALUES ('8', '753951', '7068ff5fb7ee2671e5b8a9003ff7c739', '纤纤', '其他用户', '男', '25', '1152223522@qq.com', '18307932052', '江西省上饶市', null);
INSERT INTO `t_user` VALUES ('9', '54879948156', 'bcb021e21c3c35b418b74ea949aced58', '123456', '其他用户', '女', '20', '1152223522@qq.com', '18309320525', '北京省', '0');
