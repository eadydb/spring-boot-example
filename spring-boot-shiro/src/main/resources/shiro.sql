INSERT INTO shiro_sys_permission VALUES ('1', '1', '用户管理', '0', '0/', 'sysuser:view', 'menu', 'user/userList');
INSERT INTO shiro_sys_permission VALUES ('2', '1', '用户添加', '1', '0/1', 'sysuser:add', 'button', 'user/userAdd');
INSERT INTO shiro_sys_permission VALUES ('3', '1', '用户删除', '1', '0/1', 'sysuser:del', 'button', 'user/userDel');


INSERT INTO shiro_sys_role VALUES ('1', '1', '管理员', 'admin');
INSERT INTO shiro_sys_role VALUES ('2', '1', 'VIP会员', 'vip');

INSERT INTO shiro_sys_role_permission VALUES ('1', '1');
INSERT INTO shiro_sys_role_permission VALUES ('1', '2');

INSERT INTO shiro_sys_user VALUES ('1', '管理员', 'admin', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0');

INSERT INTO shiro_sys_user_role VALUES ('1', '1');
INSERT INTO shiro_sys_user_role VALUES ('1', '2');