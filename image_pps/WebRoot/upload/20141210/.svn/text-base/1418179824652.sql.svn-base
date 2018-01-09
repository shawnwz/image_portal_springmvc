

CREATE TABLE `system_operate_log` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `module_id` int(10) DEFAULT NULL,
  `entity_name` varchar(200) DEFAULT NULL,
  `entity_id` bigint(20) DEFAULT NULL,
  `intro` varchar(300) DEFAULT NULL,
  `old_data` mediumtext,
  `new_data` mediumtext,
  `user_ip` varchar(20) DEFAULT NULL,
  `op_type` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_module_id` (`module_id`),
  KEY `idx_entity_name` (`entity_name`),
  KEY `idx_entity_id` (`entity_id`),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_ip_type` (`user_ip`,`op_type`)
) ENGINE=MyISAM AUTO_INCREMENT=2269 DEFAULT CHARSET=utf8