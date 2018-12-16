package ${package_name}.domain;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * description: ${table_annotation}
 *
 * @author ${author}
 * @date ${date}
 * lastUpdateBy: ${author}
 * lastUpdateDate: ${date}
 */
@Table(name="${table_name}")
public class ${entity_name} {

<#if entity_column?exists>
    <#list entity_column as entity>
    /**
    *${entity.columnComment!}
    */
        <#if (entity.columnType = 'varchar' || entity.columnType = 'text')>
    @Column(name = "${entity.columnName}",columnDefinition = "VARCHAR")
    private String ${entity.changeColumnName?uncap_first};

        </#if>
        <#if model.columnType = 'timestamp' >
    @Column(name = "${model.columnName}",columnDefinition = "TIMESTAMP")
    private Date ${model.changeColumnName?uncap_first};

        </#if>
    </#list>
</#if>

<#if model_column?exists>
    <#list model_column as model>
        <#if (model.columnType = 'varchar' || model.columnType = 'text')>
    public String get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(String ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

        </#if>
        <#if model.columnType = 'timestamp' >
    public Date get${model.changeColumnName}() {
        return this.${model.changeColumnName?uncap_first};
    }

    public void set${model.changeColumnName}(Date ${model.changeColumnName?uncap_first}) {
        this.${model.changeColumnName?uncap_first} = ${model.changeColumnName?uncap_first};
    }

        </#if>
    </#list>
</#if>

}
---------------------
作者：阿_毅
来源：CSDN
原文：https://blog.csdn.net/huangwenyi1010/article/details/71249258
版权声明：本文为博主原创文章，转载请附上博文链接！