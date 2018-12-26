package script.db

databaseChangeLog(logicalFilePath: 'sys_menu.groovy') {
    changeSet(author: 'Sanchar', id: '2018-12-26_sys_menu') {
        createTable(tableName: 'sys_menu', remarks: '菜单信息表') {
            column(name: 'id', type: 'bigint(20)', autoIncrement: 'true', remarks: '表ID，主键，供其他表做外键') {
                constraints(nullable: 'false', primaryKey: 'true', primaryKeyName: 'pk_sys_menu')
            }
            column(name: 'name', type: 'varchar(255)', remarks: '菜单的标识') {
                constraints(nullable: 'false')
            }
            column(name: 'code', type: 'varchar(128)', remarks: '菜单名') {
                constraints(nullable: 'false')
            }
            column(name: 'level', type: 'varchar(128)', remarks: '菜单层级')
            column(name: 'parent_id', type: 'bigint(20)', defaultValue: '0', remarks: '父级菜单id') {
                constraints(nullable: 'false')
            }
            column(name: 'type', type: 'varchar(128)', defaultValue: 'menu', remarks: '菜单类型， 包括三种（root, dir, menu）') {
                constraints(nullable: 'false')
            }
            column(name: 'sort', type: 'bigint(20)', remarks: '菜单顺序')
            column(name: 'is_default', type: 'Tinyint(3)', defaultValue: '1', remarks: '是否是默认菜单,0不是默认菜单，1是默认菜单') {
                constraints(nullable: 'false')
            }
            column(name: 'icon', type: 'varchar(128)', remarks: '图标的code值')
            column(name: 'route', type: 'varchar(255)', remarks: '路由')
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
        createIndex(tableName: 'sys_menu', indexName: 'index_code') {
            column(name: 'code')
        }
    }
}
