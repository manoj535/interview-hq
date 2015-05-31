CREATE DATABASE interview_hq CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE DATABASE interview_hq_test CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE USER 'boot_u'@'%' IDENTIFIED by 'b00t!ful';
GRANT ALL PRIVILEGES ON interview_hq.* TO 'boot_u'@'%' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON interview_hq_test.* TO 'boot_u'@'%' WITH GRANT OPTION;
CREATE USER 'boot_u'@'localhost' IDENTIFIED by 'b00t!ful';
GRANT ALL PRIVILEGES ON interview_hq.* TO 'boot_u'@'localhost' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON interview_hq_test.* TO 'boot_u'@'localhost' WITH GRANT OPTION;
