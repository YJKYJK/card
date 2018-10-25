/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50067
Source Host           : localhost:3306
Source Database       : card

Target Server Type    : MYSQL
Target Server Version : 50067
File Encoding         : 65001

Date: 2018-10-25 23:43:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `buy_record`
-- ----------------------------
DROP TABLE IF EXISTS `buy_record`;
CREATE TABLE `buy_record` (
  `buyId` varchar(32) NOT NULL COMMENT '购买记录id',
  `commodityId` int(11) default NULL COMMENT '商品ID',
  `commodityName` varchar(255) default NULL COMMENT '商品名称',
  `cardNumber` varchar(255) default NULL COMMENT ' 卡密 卡号',
  `cardPassword` varchar(255) default NULL COMMENT '卡密 密码',
  `buyTm` datetime default NULL COMMENT '购买时间',
  `price` decimal(10,2) default NULL COMMENT '价格',
  `userName` varchar(50) default NULL COMMENT '购买用户名',
  `userId` varchar(32) default NULL COMMENT '用户id',
  `userKey` varchar(255) default NULL COMMENT '用户未登录时购买',
  `merchantId` varchar(32) default NULL COMMENT '商家id',
  `merchantName` varchar(255) default NULL COMMENT '商家名称',
  PRIMARY KEY  (`buyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购买记录表';

-- ----------------------------
-- Records of buy_record
-- ----------------------------

-- ----------------------------
-- Table structure for `commodity_detail`
-- ----------------------------
DROP TABLE IF EXISTS `commodity_detail`;
CREATE TABLE `commodity_detail` (
  `commodityId` int(11) default NULL COMMENT '商品ID',
  `cardNumber` varchar(255) default NULL COMMENT '卡号',
  `cardPassword` varchar(255) default NULL COMMENT '卡密',
  `isSell` char(1) default NULL COMMENT '是否出售',
  `createTm` datetime default NULL COMMENT '创建时间',
  `sellTm` datetime default NULL COMMENT '出售时间',
  `cardId` int(11) NOT NULL auto_increment COMMENT 'id ',
  `merchantId` varchar(32) default NULL COMMENT '商家id',
  PRIMARY KEY  (`cardId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='卡密表';

-- ----------------------------
-- Records of commodity_detail
-- ----------------------------
INSERT INTO `commodity_detail` VALUES ('900', 'q', 'q\r', 'N', '2018-10-25 22:09:53', null, '1', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('900', 'q', 'q\r', 'N', '2018-10-25 22:09:53', null, '2', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('900', '-', '\r', 'N', '2018-10-25 22:09:53', null, '3', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('900', '-', 'q', 'N', '2018-10-25 22:09:53', null, '4', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'a', 'aa', 'N', '2018-10-25 22:14:59', null, '5', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'q', 'q', 'N', '2018-10-25 22:14:59', null, '6', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', '-', '', 'N', '2018-10-25 22:14:59', null, '7', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', '-', 'q', 'N', '2018-10-25 22:14:59', null, '8', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'q', 'q-', 'N', '2018-10-25 22:14:59', null, '9', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qqq', '', 'N', '2018-10-25 22:20:47', null, '10', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'wq', '', 'N', '2018-10-25 22:20:47', null, '11', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qqq', '', 'N', '2018-10-25 22:20:47', null, '12', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'wq', '', 'N', '2018-10-25 22:20:47', null, '13', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qqqq-qqq', '', 'N', '2018-10-25 23:02:19', null, '14', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'www-wwww', '', 'N', '2018-10-25 23:02:19', null, '15', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'eeeeee-eeee', '', 'N', '2018-10-25 23:02:19', null, '16', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', '1', '1', 'N', '2018-10-25 23:18:27', null, '17', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'q', 'q', 'N', '2018-10-25 23:18:27', null, '18', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qqq', 'qqqqq', 'N', '2018-10-25 23:20:56', null, '19', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'www', 'w-wwwww', 'N', '2018-10-25 23:20:56', null, '20', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qq', 'qqq', 'N', '2018-10-25 23:26:13', null, '21', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'ww', '-www', 'N', '2018-10-25 23:26:13', null, '22', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'dd', '-ddd', 'N', '2018-10-25 23:26:13', null, '23', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', '2', '2121', 'N', '2018-10-25 23:28:27', null, '24', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'wwww', '', 'N', '2018-10-25 23:28:55', null, '25', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'q', 'q', 'N', '2018-10-25 23:31:32', null, '26', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'q', 'wwe', 'N', '2018-10-25 23:31:32', null, '27', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qwww', '', 'N', '2018-10-25 23:32:10', null, '28', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'qqq', 'www', 'N', '2018-10-25 23:34:27', null, '29', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'eee', '-qqq', 'N', '2018-10-25 23:34:27', null, '30', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'ddd', 'qqq', 'N', '2018-10-25 23:34:27', null, '31', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'fff', '-ffffff', 'N', '2018-10-25 23:34:27', null, '32', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', '---', 'fffff', 'N', '2018-10-25 23:34:27', null, '33', '154010185212168464cdd-e24');
INSERT INTO `commodity_detail` VALUES ('902', 'fff', '--', 'N', '2018-10-25 23:34:27', null, '34', '154010185212168464cdd-e24');

-- ----------------------------
-- Table structure for `commodity_info`
-- ----------------------------
DROP TABLE IF EXISTS `commodity_info`;
CREATE TABLE `commodity_info` (
  `commodityId` int(11) NOT NULL auto_increment COMMENT '商品id',
  `className` varchar(255) default NULL COMMENT '类名',
  `classId` int(11) default NULL COMMENT '类别id',
  `commodityName` varchar(255) default NULL COMMENT '商品名称',
  `merchantId` varchar(32) default NULL COMMENT '商家id',
  `price` decimal(10,2) default '0.00' COMMENT '商品价格',
  `num` int(11) default NULL COMMENT '商品数量',
  `remark` varchar(255) default NULL COMMENT '商品说明',
  `pic` varchar(1024) default NULL COMMENT '图片',
  `createTm` datetime default NULL COMMENT '创建时间',
  `operTm` datetime default NULL COMMENT '操作时间',
  `selled` int(11) default NULL COMMENT '已售数量',
  PRIMARY KEY  (`commodityId`)
) ENGINE=InnoDB AUTO_INCREMENT=908 DEFAULT CHARSET=utf8 COMMENT='商品表';

-- ----------------------------
-- Records of commodity_info
-- ----------------------------
INSERT INTO `commodity_info` VALUES ('891', '45544', '62', 'fff', '15398707308272b52102f-f99', '444.00', '0', 'eeee', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1127007233,3582198732&fm=27&gp=0.jpg', '2018-10-21 15:16:27', '2018-10-21 15:16:27', null);
INSERT INTO `commodity_info` VALUES ('899', '45544', '62', 'erwerwer', '15398707308272b52102f-f99', '222.00', '0', 'werwer', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1127007233,3582198732&fm=27&gp=0.jpg', '2018-10-21 20:40:22', '2018-10-21 21:01:19', null);
INSERT INTO `commodity_info` VALUES ('900', '多喝点还记得', '65', '饿了么15', '154010185212168464cdd-e24', '12.00', '0', '1212', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1127007233,3582198732&fm=27&gp=0.jpg', '2018-10-22 21:09:39', '2018-10-22 21:09:39', null);
INSERT INTO `commodity_info` VALUES ('901', 'xxcc', '64', '对对对', '154010185212168464cdd-e24', '12.00', '0', '就是就是觉得', 'http://img4.imgtn.bdimg.com/it/u=3861445641,227716651&fm=26&gp=0.jpg', '2018-10-22 21:10:02', '2018-10-22 21:10:02', null);
INSERT INTO `commodity_info` VALUES ('902', '红红火火恍恍惚惚', '66', '略略略', '154010185212168464cdd-e24', '1213.00', '0', '大家觉得就地解决等到你', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3749762551,3121307144&fm=27&gp=0.jpg', '2018-10-22 22:00:45', '2018-10-22 22:00:45', null);
INSERT INTO `commodity_info` VALUES ('903', '红红火火恍恍惚惚', '66', '古古怪怪', '154010185212168464cdd-e24', '45.00', '0', '你到几点九点多', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2613104448,3119831597&fm=27&gp=0.jpg', '2018-10-22 22:00:55', '2018-10-22 22:00:55', null);
INSERT INTO `commodity_info` VALUES ('904', '多喝点还记得', '65', '哈哈哈哈哈哈', '154010185212168464cdd-e24', '12.00', '0', '干活哈哈', 'https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2761811692,1021475759&fm=27&gp=0.jpg', '2018-10-22 22:11:10', '2018-10-22 22:11:10', null);
INSERT INTO `commodity_info` VALUES ('905', 'xxcc', '64', '易语言', '154010185212168464cdd-e24', '55.60', '0', '方法覆盖', 'http://img1.imgtn.bdimg.com/it/u=1782215054,2264155343&fm=26&gp=0.jpg', '2018-10-22 22:11:23', '2018-10-23 22:36:49', null);
INSERT INTO `commodity_info` VALUES ('906', '红红火火恍恍惚惚', '66', 'gggg', '154010185212168464cdd-e24', '0.01', '0', 'ww', null, '2018-10-24 19:58:39', '2018-10-24 19:58:39', null);
INSERT INTO `commodity_info` VALUES ('907', '红红火火恍恍惚惚', '66', 'www', '154010185212168464cdd-e24', '12.00', '0', '12', null, '2018-10-25 23:27:21', '2018-10-25 23:27:21', null);

-- ----------------------------
-- Table structure for `goods_class`
-- ----------------------------
DROP TABLE IF EXISTS `goods_class`;
CREATE TABLE `goods_class` (
  `classId` int(11) NOT NULL auto_increment COMMENT '类别id',
  `className` varchar(50) default NULL COMMENT '类别名称',
  `merchantId` varchar(32) default NULL COMMENT '商家id',
  `remark` varchar(255) default NULL COMMENT '说明',
  `createTm` datetime default NULL,
  `operTm` datetime default NULL,
  PRIMARY KEY  (`classId`)
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 COMMENT='商品类别表';

-- ----------------------------
-- Records of goods_class
-- ----------------------------
INSERT INTO `goods_class` VALUES ('31', '1234', '15398707308272b52102f-f99', '45464', '2018-10-20 16:50:39', '2018-10-20 16:50:39');
INSERT INTO `goods_class` VALUES ('32', 'wwwww', '15398707308272b52102f-f99', 'www', '2018-10-20 17:14:20', '2018-10-20 17:14:20');
INSERT INTO `goods_class` VALUES ('33', 'retrt', '15398707308272b52102f-f99', 'ret', '2018-10-20 17:15:00', '2018-10-20 17:15:00');
INSERT INTO `goods_class` VALUES ('34', 'werw', '15398707308272b52102f-f99', 'wer', '2018-10-20 17:15:48', '2018-10-20 17:15:48');
INSERT INTO `goods_class` VALUES ('35', 'werw', '15398707308272b52102f-f99', 'wer', '2018-10-20 17:15:53', '2018-10-20 17:15:53');
INSERT INTO `goods_class` VALUES ('36', 'sdfdfds', '15398707308272b52102f-f99', 'sdfsdf', '2018-10-20 17:18:54', '2018-10-20 17:18:54');
INSERT INTO `goods_class` VALUES ('37', 'wrwer', '15398707308272b52102f-f99', 'werwe', '2018-10-20 17:20:12', '2018-10-20 17:20:12');
INSERT INTO `goods_class` VALUES ('38', 'shhshs', '15398707308272b52102f-f99', 'uwijww', '2018-10-20 18:17:50', '2018-10-20 18:17:50');
INSERT INTO `goods_class` VALUES ('39', 'www', '15398707308272b52102f-f99', 'zjzjs', '2018-10-20 18:23:50', '2018-10-20 18:23:50');
INSERT INTO `goods_class` VALUES ('40', 'qqqqqqqqqqqqqqqqqqqqqq', '15398707308272b52102f-f99', 'qqqq', '2018-10-20 18:27:12', '2018-10-20 18:27:12');
INSERT INTO `goods_class` VALUES ('41', 'werwer', '15398707308272b52102f-f99', 'werw', '2018-10-20 19:52:15', '2018-10-20 19:52:15');
INSERT INTO `goods_class` VALUES ('42', 'werwer', '15398707308272b52102f-f99', 'werw', '2018-10-20 19:52:25', '2018-10-20 19:52:25');
INSERT INTO `goods_class` VALUES ('43', 'fsdfdfs', '15398707308272b52102f-f99', 'sdf', '2018-10-20 21:28:40', '2018-10-20 21:28:40');
INSERT INTO `goods_class` VALUES ('44', 'wqeqwe', '15398707308272b52102f-f99', 'qweq', '2018-10-20 21:31:29', '2018-10-20 21:31:29');
INSERT INTO `goods_class` VALUES ('45', 'ddssd', '15398707308272b52102f-f99', 'sdsd', '2018-10-20 21:43:49', '2018-10-20 21:43:49');
INSERT INTO `goods_class` VALUES ('46', '玩儿玩儿', '15398707308272b52102f-f99', '热热', '2018-10-20 21:59:43', '2018-10-20 21:59:43');
INSERT INTO `goods_class` VALUES ('47', 'sfsdfsdfs', '15398707308272b52102f-f99', 'dsfsdf', '2018-10-20 22:11:34', '2018-10-20 22:11:34');
INSERT INTO `goods_class` VALUES ('48', 'werewrw', '15398707308272b52102f-f99', 'werwe', '2018-10-20 22:12:22', '2018-10-20 22:12:22');
INSERT INTO `goods_class` VALUES ('49', 'erwewe', '15398707308272b52102f-f99', 'werwe', '2018-10-20 22:13:57', '2018-10-20 22:13:57');
INSERT INTO `goods_class` VALUES ('51', '士大夫士大夫', '15398707308272b52102f-f99', '是否', '2018-10-20 22:25:03', '2018-10-20 22:25:03');
INSERT INTO `goods_class` VALUES ('60', '而威尔', '15398707308272b52102f-f99', ' 围绕', '2018-10-20 22:39:18', '2018-10-20 22:39:18');
INSERT INTO `goods_class` VALUES ('61', '222', '15398707308272b52102f-f99', '22', '2018-10-20 22:45:00', '2018-10-21 00:06:05');
INSERT INTO `goods_class` VALUES ('62', '45544', '15398707308272b52102f-f99', '54544', '2018-10-20 23:19:30', '2018-10-20 23:19:30');
INSERT INTO `goods_class` VALUES ('64', 'xxcc', '154010185212168464cdd-e24', '1225', '2018-10-21 20:47:26', '2018-10-21 20:47:26');
INSERT INTO `goods_class` VALUES ('65', '多喝点还记得', '154010185212168464cdd-e24', '技术监督局', '2018-10-21 22:34:11', '2018-10-21 22:34:11');
INSERT INTO `goods_class` VALUES ('66', '红红火火恍恍惚惚', '154010185212168464cdd-e24', '1212', '2018-10-22 21:19:49', '2018-10-22 21:19:49');

-- ----------------------------
-- Table structure for `merchant_info`
-- ----------------------------
DROP TABLE IF EXISTS `merchant_info`;
CREATE TABLE `merchant_info` (
  `merchantId` varchar(32) NOT NULL COMMENT '商家id',
  `userName` varchar(50) default NULL COMMENT '商家名称',
  `password` varchar(255) default NULL COMMENT '商家密码',
  `phone` varchar(11) default NULL COMMENT '商家手机号',
  `qq` varchar(11) default NULL COMMENT '商家QQ',
  `createTm` datetime default NULL COMMENT '创建时间',
  `balance` decimal(10,2) default '0.00' COMMENT '用户余额',
  `operTm` datetime default NULL COMMENT '用户最后操作时间',
  PRIMARY KEY  (`merchantId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商家表';

-- ----------------------------
-- Records of merchant_info
-- ----------------------------
INSERT INTO `merchant_info` VALUES ('15398707308272b52102f-f99', 'ww', 'ww', 'ww', 'ww', '2018-10-18 21:52:10', null, '2018-10-18 21:52:10');
INSERT INTO `merchant_info` VALUES ('154010185212168464cdd-e24', 'cc', 'cc', 'cc', 'cc', '2018-10-21 14:04:12', null, '2018-10-21 14:04:12');

-- ----------------------------
-- Table structure for `shop_order`
-- ----------------------------
DROP TABLE IF EXISTS `shop_order`;
CREATE TABLE `shop_order` (
  `orderId` varchar(32) NOT NULL default '',
  `classId` int(11) default NULL COMMENT '商品类型名称',
  `commodityId` varchar(32) default NULL COMMENT '商品ID',
  `commodityName` varchar(255) default NULL,
  `number` int(6) default NULL COMMENT '商品数量',
  `price` decimal(10,2) default NULL COMMENT '商品价格',
  `totalPrice` decimal(10,2) default NULL COMMENT '商品总价',
  `isPay` char(2) default NULL COMMENT '是否支付',
  `oprtTm` datetime default NULL COMMENT '操作时间',
  `merchantId` varchar(32) default NULL COMMENT '商家id',
  `buyUser` varchar(255) default NULL COMMENT '购买人(用于用户未登录)',
  `buyUserId` varchar(32) default NULL COMMENT '购买人id',
  `payType` varchar(6) default NULL,
  PRIMARY KEY  (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shop_order
-- ----------------------------
INSERT INTO `shop_order` VALUES ('1540388621815747286', '66', '902', '略略略', '1', '1213.00', '1213.00', 'N', '2018-10-24 21:43:41', null, '', null, 'alipay');
INSERT INTO `shop_order` VALUES ('154038868070754b021', '66', '906', 'gggg', '1', '0.01', '0.01', 'N', '2018-10-24 21:44:40', null, '363133605', null, 'wxpay');
INSERT INTO `shop_order` VALUES ('1540388916579dbe217', '66', '906', 'gggg', '1', '0.01', '0.01', 'N', '2018-10-24 21:48:36', null, '', null, 'qqpay');
INSERT INTO `shop_order` VALUES ('15403890169169716b3', '66', '906', 'gggg', '1', '0.01', '0.01', 'N', '2018-10-24 21:50:16', null, '363133605', null, 'alipay');
INSERT INTO `shop_order` VALUES ('154038948704809a04c', '66', '906', 'gggg', '1', '0.01', '0.01', 'N', '2018-10-24 21:58:07', null, '343443', null, 'qqpay');
INSERT INTO `shop_order` VALUES ('154038961105318e863', '66', '906', 'gggg', '1', '0.01', '0.01', 'N', '2018-10-24 22:00:11', null, '343443', null, 'alipay');

-- ----------------------------
-- Table structure for `top_up_apply`
-- ----------------------------
DROP TABLE IF EXISTS `top_up_apply`;
CREATE TABLE `top_up_apply` (
  `userId` varchar(32) default '' COMMENT '用户id',
  `userName` varchar(50) default '' COMMENT '用户名称',
  `alipayNo` varchar(50) default NULL COMMENT '支付宝流水号',
  `applyTm` datetime default NULL COMMENT '申请时间',
  `isFinish` char(1) default NULL COMMENT '是否完成',
  `applyId` varchar(32) NOT NULL COMMENT '申请id',
  PRIMARY KEY  (`applyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值申请表';

-- ----------------------------
-- Records of top_up_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `top_up_cache`
-- ----------------------------
DROP TABLE IF EXISTS `top_up_cache`;
CREATE TABLE `top_up_cache` (
  `alipayNo` varchar(50) default NULL COMMENT '支付宝流水号',
  `topUpTm` date default NULL COMMENT '充值时间',
  `isTopUp` char(1) default NULL COMMENT '是否已充值 Y已充值 N 未充值',
  `money` decimal(10,2) default NULL COMMENT '金额',
  `cacheId` int(11) NOT NULL auto_increment COMMENT '充值缓存id',
  `createTm` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`cacheId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值缓存表';

-- ----------------------------
-- Records of top_up_cache
-- ----------------------------

-- ----------------------------
-- Table structure for `top_up_records`
-- ----------------------------
DROP TABLE IF EXISTS `top_up_records`;
CREATE TABLE `top_up_records` (
  `userId` varchar(32) NOT NULL COMMENT '用户id',
  `userName` varchar(50) NOT NULL COMMENT '用户名称',
  `balance` decimal(10,2) NOT NULL default '0.00' COMMENT '充值金额',
  `topUpTm` datetime NOT NULL COMMENT '充值时间',
  `alipayNo` varchar(50) NOT NULL COMMENT '支付宝流水号',
  `topUpType` char(255) default '' COMMENT '充值类型',
  `topUpId` varchar(32) NOT NULL default '' COMMENT '充值id',
  PRIMARY KEY  (`topUpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='充值记录表';

-- ----------------------------
-- Records of top_up_records
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `userId` varchar(32) NOT NULL COMMENT '用户id',
  `userName` varchar(50) NOT NULL COMMENT '用户名称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `phone` varchar(11) NOT NULL COMMENT '用户手机号',
  `qq` varchar(11) NOT NULL COMMENT '用户QQ',
  `createTm` datetime default NULL COMMENT '创建时间',
  `balance` decimal(10,2) unsigned zerofill default '00000000.00' COMMENT '用户余额',
  `operTm` datetime default NULL COMMENT '用户最后操作时间',
  PRIMARY KEY  (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1539412063959545b0075-a3a', 'yanjiakang', '123456', '18816473899', '363133605', '2018-10-13 14:27:43', '00000012.00', '2018-10-13 14:27:43');
INSERT INTO `user_info` VALUES ('1539412478318b5db1c6f-076', 'aaa', 'bbbbb', '12123', 'cccc', '2018-10-13 14:34:38', null, '2018-10-13 14:34:38');
INSERT INTO `user_info` VALUES ('1539448596696e9009d62-621', 'wqew', 'qweqw', 'qe', 'qwe', '2018-10-14 00:36:36', null, '2018-10-14 00:36:36');
INSERT INTO `user_info` VALUES ('1539448862912634f48e0-f4a', 'ww', 'ww', 'ww', 'ww', '2018-10-14 00:41:02', null, '2018-10-14 00:41:02');
INSERT INTO `user_info` VALUES ('1539448946207b263bc34-023', 'www', 'ee', 'ee', 'ww', '2018-10-14 00:42:26', null, '2018-10-14 00:42:26');
INSERT INTO `user_info` VALUES ('153944895549086059ea5-136', 'www11', 'ee', 'ee', 'ww', '2018-10-14 00:42:35', null, '2018-10-14 00:42:35');
INSERT INTO `user_info` VALUES ('15394490087880009d693-a0f', 'wew', 'weewr', 'wer', 'werwe', '2018-10-14 00:43:28', null, '2018-10-14 00:43:28');
INSERT INTO `user_info` VALUES ('15394490262267935d75f-eed', 'wewww', 'weewr', 'wer', 'werwe', '2018-10-14 00:43:46', null, '2018-10-14 00:43:46');
INSERT INTO `user_info` VALUES ('153944910567803db058f-468', '玩玩', 'shwhjw', '64646', '上海市', '2018-10-14 00:45:05', null, '2018-10-14 00:45:05');
INSERT INTO `user_info` VALUES ('1539449134799a50bc498-9b3', 'hsjsjs', 'shsh', 'jsjse', 'jsjsjs', '2018-10-14 00:45:34', null, '2018-10-14 00:45:34');
INSERT INTO `user_info` VALUES ('1539449173794c4b17a00-0b8', 'ewre', 'werwe', 'wer', 'werwe', '2018-10-14 00:46:13', null, '2018-10-14 00:46:13');
INSERT INTO `user_info` VALUES ('153944938406051199ce6-653', 'hhhhh', '1233456', '1811115511', '1213', '2018-10-14 00:49:44', null, '2018-10-14 00:49:44');
INSERT INTO `user_info` VALUES ('15395000782140d5d2e54-f32', 'www444', 'ssss', '46464', '454546', '2018-10-14 14:54:38', null, '2018-10-14 14:54:38');
