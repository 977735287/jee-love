package script.db

databaseChangeLog(logicalFilePath: 'sys_permission.groovy') {
    changeSet(author: 'Sanchar', id: '2018-12-26_sys_permission') {
        createTable(tableName: 'sys_permission', remarks: '权限信息表') {
            column(name: 'id', type: 'bigint(20)', autoIncrement: 'true', remarks: '表ID，主键，供其他表做外键') {
                constraints(nullable: 'false', primaryKey: 'true', primaryKeyName: 'pk_sys_permission')
            }
            column(name: 'code', type: 'varchar(255)', remarks: '权限的标识') {
                constraints(nullable: 'false')
            }
            column(name: 'path', type: 'varchar(255)', remarks: '权限对应的api路径') {
                constraints(nullable: 'false')
            }
            column(name: 'method', type: 'varchar(128)', remarks: '请求的http方法')
            column(name: 'level', type: 'varchar(128)', remarks: '权限的层级')
            column(name: 'description', type: 'varchar(1024)', remarks: '权限描述')
            column(name: 'action', type: 'varchar(128)', remarks: '权限对应的方法名')
            column(name: 'resource', type: 'varchar(128)', remarks: '权限资源类型')
            column(name: 'public_access', type: 'bigint(3)', defaultValue: '0', remarks: '是否公开的权限') {
                constraints(nullable: 'false')
            }
            column(name: 'login_access', type: 'bigint(3)', defaultValue: '1', remarks: '是否需要登录才能访问的权限') {
                constraints(nullable: 'false')
            }
            column(name: 'service_name', type: 'varchar(128)', remarks: '权限所在的服务名称')
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
        createIndex(tableName: 'sys_permission', indexName: 'index_code') {
            column(name: 'code')
        }
    }
}
