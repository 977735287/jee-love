package script.db

databaseChangeLog(logicalFilePath: 'sys_user.groovy') {
    changeSet(author: 'Sanchar', id: '2018-12-23_sys_user') {
        createTable(tableName: 'sys_user', remarks: '用户信息表') {
            column(name: 'id', type: 'bigint(20)', autoIncrement: 'true', remarks: '表ID，主键，供其他表做外键') {
                constraints(nullable: 'false', primaryKey: 'true', primaryKeyName: 'pk_sys_user')
            }
            column(name: 'user_name', type: 'varchar(128)', remarks: '用户名') {
                constraints(nullable: 'false')
            }
            column(name: 'password', type: 'varchar(255)', remarks: 'Hash后的用户密码') {
                constraints(nullable: 'false')
            }
            column(name: 'email', type: 'varchar(128)', remarks: '电子邮箱地址')
            column(name: 'phone', type: 'varchar(128)', remarks: '手机号')
            column(name: 'real_name', type: 'varchar(128)', remarks: '用户真实姓名')
            column(name: 'image_url', type: 'varchar(255)', remarks: '用户头像url')
            column(name: 'profile_photo', type: 'clob', remarks: '用户二进制头像')
            column(name: 'language', type: 'varchar(64)', defaultValue: 'zh_CN', remarks: '语言') {
                constraints(nullable: 'false')
            }
            column(name: 'time_zone', type: 'varchar(64)', defaultValue: 'CTT', remarks: '时区') {
                constraints(nullable: 'false')
            }
            column(name: 'last_password_updated_at', type: 'datetime', defaultValueComputed: 'CURRENT_TIMESTAMP', remarks: '上一次密码更新时间') {
                constraints(nullable: 'false')
            }
            column(name: 'last_login_at', type: 'datetime', remarks: '上一次登陆时间')
            column(name: 'is_enabled', type: 'Tinyint(3)', defaultValue: '1', remarks: '用户是否启用。1启用，0未启用') {
                constraints(nullable: 'false')
            }
            column(name: 'is_locked', type: 'Tinyint(3)', defaultValue: '0', remarks: '是否锁定账户') {
                constraints(nullable: 'false')
            }
            column(name: 'is_admin', type: 'Tinyint(3)', defaultValue: '0', remarks: '是否为管理员用户。1表示是，0表示不是') {
                constraints(nullable: 'false')
            }
            column(name: 'locked_until_at', type: 'datetime', remarks: '锁定账户截止时间')
            column(name: 'password_attempt', type: 'Tinyint(3)', defaultValue: '0', remarks: '密码输错累积次数') {
                constraints(nullable: 'false')
            }
            column(name: 'created_by', type: 'bigint(20)', defaultValue: '0', remarks: '创建人') {
                constraints(nullable: 'false')
            }
            column(name: 'creation_date', type: 'datetime', defaultValueComputed: 'CURRENT_TIMESTAMP', remarks: '创建时间') {
                constraints(nullable: 'false')
            }
            column(name: 'last_updated_by', type: 'bigint(20)', defaultValue: '0', remarks: '更新人') {
                constraints(nullable: 'false')
            }
            column(name: 'last_update_date', type: 'datetime', defaultValueComputed: 'CURRENT_TIMESTAMP', remarks: '更新时间') {
                constraints(nullable: 'false')
            }
            column(name: 'is_deleted', type: 'Tinyint(3)', defaultValue: '0', remarks: '删除状态，1表示是，0表示否') {
                constraints(nullable: 'false')
            }
            column(name: 'object_version_number', type: 'bigint(20)', defaultValue: '1', remarks: '版本控制') {
                constraints(nullable: 'false')
            }
            column(name: 'attribute_category', type: 'varchar(150)', remarks: '弹性域字段')
            column(name: 'attribute1', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute2', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute3', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute4', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute5', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute6', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute7', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute8', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute9', type: 'varchar(240)', remarks: '弹性域字段')
            column(name: 'attribute10', type: 'varchar(240)', remarks: '弹性域字段')
        }
        createIndex(tableName: 'sys_user', indexName: 'index_user_name') {
            column(name: 'user_name')
        }
    }
}
