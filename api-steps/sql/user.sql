
/*
 Navicat Premium Data Transfer


 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : 127.0.0.1:3306
 Source Schema         : kohala_uc

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 26/03/2019 18:47:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for uc_config_account
-- ----------------------------
DROP TABLE IF EXISTS `uc_config_account`;
CREATE TABLE `uc_config_account` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `account_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户类型',
  `max_account_number` int(11) NOT NULL COMMENT '会员最大的账户数,-1表示无限制',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态: 可用,不可用',
  `support_member_types` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支持的会员类型,多个使用,分隔',
  `share_base_pwd` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否共享基本户的支付密码,-是-否',
  `account_attribute` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户属性,对公,对私',
  `account_sub_types` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户子类型: 基本户,一般户,专用户,临时户,保证金户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='账户配置表';

-- ----------------------------
-- Table structure for uc_config_pay_product
-- ----------------------------
DROP TABLE IF EXISTS `uc_config_pay_product`;
CREATE TABLE `uc_config_pay_product` (
  `product_id` int(30) NOT NULL COMMENT '自增id',
  `product_no` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付产品编码',
  `product_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '支付产品名称',
  `transaction_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '交易形式:即时到账,担保交易',
  `pay_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付方式:快捷,网银,代扣,POS',
  `sign_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '签约方式:线上,线下',
  `payment_period` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '到账周期: T+N,D+N,月结',
  `payment_rate_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '费率类型',
  `payment_rate` double(10,5) DEFAULT NULL COMMENT '费率',
  `payment_rate_startdate` datetime DEFAULT NULL COMMENT '费率执行开始时间',
  `payment_rate_enddate` datetime DEFAULT NULL COMMENT '费率执行结束时间',
  `amount` bigint(50) DEFAULT NULL COMMENT '额度',
  `support_card_types` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付卡类型,多个用,分隔',
  `is_return_fee` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否退回手续费:是,否',
  `transfer_account` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '转出账户:中转账户,现金户',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '启用,禁用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`product_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='支付产品配置';

-- ----------------------------
-- Table structure for uc_config_pwd_lock
-- ----------------------------
DROP TABLE IF EXISTS `uc_config_pwd_lock`;
CREATE TABLE `uc_config_pwd_lock` (
  `id` int(30) NOT NULL COMMENT '自增id',
  `pwd_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码类型:登录密码,交易密码',
  `lock_strategy` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '锁定策略',
  `input_detect_span` int(10) NOT NULL COMMENT '错误输入检测时间段(分)',
  `wrong_input_count` int(10) NOT NULL COMMENT '触发锁定的错误输入次数',
  `lock_span` int(10) NOT NULL COMMENT '锁定时间(分)',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态,可用,不可用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='密码锁定配置表';

-- ----------------------------
-- Table structure for uc_config_pwd_set
-- ----------------------------
DROP TABLE IF EXISTS `uc_config_pwd_set`;
CREATE TABLE `uc_config_pwd_set` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `strategy_key` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '策略类型',
  `stragegy_value` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '策略值',
  `status` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态:可用,不可用',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='密码策略配配置表';

-- ----------------------------
-- Table structure for uc_config_pwd_strategy
-- ----------------------------
DROP TABLE IF EXISTS `uc_config_pwd_strategy`;
CREATE TABLE `uc_config_pwd_strategy` (
  `id` int(30) NOT NULL COMMENT '自增id',
  `strategy_key` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '策略类型:过期时间,特殊字符,历史不可用,密码最小长度,密码最大长度,大小写,黑名单,不能是用户名,不能是登录密码,正则表达式',
  `status` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '状态:可用,不可用',
  `default_strategy_value` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '策略默认值',
  `key_field_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Key字段类型: 数字型,字符型,时间型,不可输入型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='密码策略集';

-- ----------------------------
-- Table structure for uc_event_log
-- ----------------------------
DROP TABLE IF EXISTS `uc_event_log`;
CREATE TABLE `uc_event_log` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `event_no` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件编码',
  `module` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '模块',
  `event_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '事件类型: 错误,警告,常规',
  `event_level` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '事件级别:定义不同级别',
  `event_result` text COLLATE utf8mb4_unicode_ci COMMENT '事件执行结果',
  `event_detail` text COLLATE utf8mb4_unicode_ci COMMENT '事件详细',
  `event_user` int(30) DEFAULT NULL COMMENT '事件用户',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='事件记录表';

-- ----------------------------
-- Table structure for uc_member
-- ----------------------------
DROP TABLE IF EXISTS `uc_member`;
CREATE TABLE `uc_member` (
  `user_id` int(30) NOT NULL COMMENT '会员ID:10-开头为个人会员,20-开头为企业会员',
  `user_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '会员名称',
  `user_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '会员类型: PERSON-个人,COMPANY-公司',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '会员状态: UNACTIVED-未激活,NORMAL-正常,SLEEP-休眠,LOGOUT-注销',
  `lock_status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '锁定状态: UNLOCK-未锁定,LOCKED-已锁定',
  `active_time` datetime DEFAULT NULL COMMENT '激活时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员信息表';

-- ----------------------------
-- Table structure for uc_member_account
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_account`;
CREATE TABLE `uc_member_account` (
  `account_id` int(30) NOT NULL COMMENT '账户id',
  `user_id` int(30) NOT NULL COMMENT '用户id',
  `original_request_no` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '开户接口请求号',
  `account_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户类型:1,2,3类户',
  `account_attribute` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户属性(对公,对私)',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户状态: 未激活,正常,锁定,止出,止入',
  `alias` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户别名',
  `bank_account_id` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '关联银行卡ID',
  `outside_account_identity` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '外部账户标识',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`account_id`) USING BTREE,
  KEY `account_id` (`account_id`),
  KEY `f_member_accout` (`user_id`),
  CONSTRAINT `f_member_accout` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户账户表';

-- ----------------------------
-- Table structure for uc_member_bank
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_bank`;
CREATE TABLE `uc_member_bank` (
  `id` int(30) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(30) NOT NULL COMMENT '用户id',
  `bank_id` int(30) NOT NULL COMMENT '银行编号',
  `bank_id_type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行编号类型',
  `bank_name` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行名称',
  `bank_branch` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支行名称',
  `bank_account_no` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '银行卡号',
  `bank_account_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '户名',
  `card_attribute` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '卡属性(对公,对私)',
  `card_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '卡类型(借记卡,信用卡,存折,其它)',
  `agreement_no` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '协议号',
  `alias` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '别名',
  `account_no_summary` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '账户摘要',
  `provice` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省份',
  `city` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城市',
  `is_verified` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '认证状态(未认证,已认证)',
  `is_signing` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '是否签约',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '状态(失效,正常,锁定)',
  `sign_no` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '签约协议号',
  `sign_id` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内部协议号',
  `cert_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件类型',
  `cert_no` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `card_valid_date` varchar(0) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '卡片有效期',
  `agreement_valid_date` timestamp NULL DEFAULT NULL COMMENT '协议有效期',
  `mobile` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `pay_attribute` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '支付属性',
  `is_fill_cert_no` int(11) DEFAULT NULL COMMENT '是否填充证件号',
  `channel_code` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '渠道编号',
  `activate_date` datetime DEFAULT NULL COMMENT '激活时间',
  `branch_no` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '分行号',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `f_member_bank` (`user_id`),
  CONSTRAINT `f_member_bank` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户签约表';

-- ----------------------------
-- Table structure for uc_member_company
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_company`;
CREATE TABLE `uc_member_company` (
  `user_id` int(30) NOT NULL COMMENT '用户id',
  `industry` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行业类型:字典',
  `license_no` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '营业执照',
  `license_expire_date` date DEFAULT NULL COMMENT '营业执照失效时间',
  `company_no` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业编号',
  `legal_person` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '法人代表',
  `scale` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业规模:字典',
  `website` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业网站',
  `company_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业全称',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '企业地址',
  `license_address` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '营业执照地址',
  `business_scope` text COLLATE utf8mb4_unicode_ci COMMENT '营业范围',
  `telephone` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `organization_no` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组织机构代码',
  `summary` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业简介',
  `license_no_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业营业执照附件',
  `organization_no_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组织机构代码附件',
  `tax_no_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '税务登记证附件',
  `clearing_account_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '单位银行结算账户开户证附件',
  `institution_license_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '机构信用代码证附件',
  `icp_license_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'ICP备案许可附件',
  `industry_license_file` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行业许可证附件',
  `legal_person_mobile` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法人手机号码',
  `company_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业类型',
  `legal_persion_id_valid_date` date DEFAULT NULL COMMENT '法人身份证有效期',
  `business_website` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经营网址',
  `proxy_persion` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '代理人名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `f_compnay_userid` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='公司用户表';

-- ----------------------------
-- Table structure for uc_member_identity
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_identity`;
CREATE TABLE `uc_member_identity` (
  `id` int(30) NOT NULL,
  `user_id` int(30) DEFAULT NULL COMMENT '用户id',
  `full_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '真实姓名',
  `cert_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件类型',
  `cert_no` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `f_uc_member_identity` (`user_id`),
  CONSTRAINT `f_uc_member_identity` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户实名认证表';

-- ----------------------------
-- Table structure for uc_member_login
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_login`;
CREATE TABLE `uc_member_login` (
  `login_id` int(30) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `user_id` int(30) DEFAULT NULL COMMENT '用户id',
  `source_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '来源类型: UUS,KOHALA',
  `login_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录用户名',
  `login_name_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登录名类型:uus通行证,用户名,邮箱,手机',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`login_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户登录信息表';

-- ----------------------------
-- Table structure for uc_member_merchant
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_merchant`;
CREATE TABLE `uc_member_merchant` (
  `id` int(11) NOT NULL,
  `user_id` int(30) NOT NULL COMMENT '用户id',
  `merchant_id` int(11) NOT NULL COMMENT '商户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='会员与商户关联表';

-- ----------------------------
-- Table structure for uc_member_personal
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_personal`;
CREATE TABLE `uc_member_personal` (
  `user_id` int(30) NOT NULL,
  `full_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `cert_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件类型',
  `id_no` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证件号码',
  `gender` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `position` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职位',
  `career` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职业',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `f_person_userid` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='个人用户表';

-- ----------------------------
-- Table structure for uc_member_pwd
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_pwd`;
CREATE TABLE `uc_member_pwd` (
  `user_id` int(30) NOT NULL COMMENT '用户id',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `crypto_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加密算法',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`user_id`) USING BTREE,
  CONSTRAINT `f_member_pwd` FOREIGN KEY (`user_id`) REFERENCES `uc_member` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='用户登录密码';

-- ----------------------------
-- Table structure for uc_member_trpwd
-- ----------------------------
DROP TABLE IF EXISTS `uc_member_trpwd`;
CREATE TABLE `uc_member_trpwd` (
  `account_id` int(30) NOT NULL COMMENT '账户id',
  `password` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `crypto_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '加密算法',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`account_id`) USING BTREE,
  CONSTRAINT `f_member_trpwd` FOREIGN KEY (`account_id`) REFERENCES `uc_member_account` (`account_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='交易密码表';

-- ----------------------------
-- Table structure for uc_merchant
-- ----------------------------
DROP TABLE IF EXISTS `uc_merchant`;
CREATE TABLE `uc_merchant` (
  `merchant_id` int(30) NOT NULL COMMENT '商户id',
  `merchant_name` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户名',
  `merchant_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '商户类型',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '会员状态: UNACTIVED-未激活,NORMAL-正常,SLEEP-休眠,LOGOUT-注销',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `create_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '创建人',
  `update_user` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '修改人',
  `memo` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`merchant_id`) USING BTREE,
  KEY `merchant_id` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商户表';

-- ----------------------------
-- Table structure for uc_merchant_app
-- ----------------------------
DROP TABLE IF EXISTS `uc_merchant_app`;
CREATE TABLE `uc_merchant_app` (
  `id` int(30) NOT NULL COMMENT '自增id',
  `merchant_id` int(30) DEFAULT NULL COMMENT '商户id',
  `app_id` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'appid',
  `app_name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'app名称',
  `sign_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '签名方式',
  `secrect_private` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '私钥',
  `secrect_public` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公钥',
  KEY `f_merchant_app` (`merchant_id`),
  CONSTRAINT `f_merchant_app` FOREIGN KEY (`merchant_id`) REFERENCES `uc_merchant` (`merchant_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='商户应用配置';

SET FOREIGN_KEY_CHECKS = 1;
