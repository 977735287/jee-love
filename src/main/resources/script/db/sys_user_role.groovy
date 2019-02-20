package script.db

databaseChangeLog(logicalFilePath: 'sys_user_role.groovy') {
    changeSet(author: 'Sanchar', id: '2018-12-26_sys_user_role') {
        createTable(tableName: 'sys_user_role', remarks: '用户角色关联表') {
            column(name: 'id', type: 'bigint(20)', autoIncrement: 'true', remarks: '表ID，主键，供其他表做外键') {
                constraints(nullable: 'false', primaryKey: 'true', primaryKeyName: 'pk_sys_user_role')
            }
            column(name: 'user_id', type: 'bigint(20)', remarks: '用户ID') {
                constraints(nullable: 'false')
            }
            column(name: 'role_id', type: 'bigint(20)', remarks: '角色ID') {
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
    }
}
