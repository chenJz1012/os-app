


INSERT INTO `sys_function` VALUES ('1', '0', 'index', '1', '1', null, '/index', '1', null, null);
INSERT INTO `sys_function` VALUES ('2', '0', 'sample', '1', '1', null, '/sample*', '1', null, null);

INSERT INTO `sys_role` VALUES ('1', 'role-admin', '/index', '1', null, null);

INSERT INTO `sys_role_function` VALUES ('1', '1');
INSERT INTO `sys_role_function` VALUES ('1', '2');

INSERT INTO `sys_user` VALUES ('1', 'admin', '$2a$10$oWaepJdwE7OjANCEEuQCW.aSxzOCZTsJglNcDpi8cnGXRLRppNZKG', 'admin', '1', '1', '1', '1', null, null, '597160667@qq.com', '18600200791', null, null);

INSERT INTO `sys_user_role` VALUES ('1', '1');
INSERT INTO `sys_user_role` VALUES ('1', '2');
