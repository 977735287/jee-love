package ${packageName};

import javax.persistence.Column;
import javax.persistence.Table;
<#if table.existDate == 1>
import java.util.Date;
</#if>
/**
 * description: ${table.comments}
 *
 * @author ${author}
 * @date ${date?string('yyyy-MM-dd hh:mm')}
 * lastUpdateBy: ${author}
 * lastUpdateDate: ${date?string('yyyy-MM-dd hh:mm')}
 */
@Table(name="${table.tableName}")
public class ${table.className} {

<#if table.columns?exists>
    <#list table.columns as column>
    /**
    *${column.comments!}
    */
    @Column(name = "${column.columnName}",columnDefinition = "${column.dataType}")
    private ${column.attrType} ${column.attrName?uncap_first};

    </#list>
</#if>

<#if table.columns?exists>
    <#list table.columns as column>
    public ${column.attrType} get${column.attrName}() {
        return this.${column.attrName?uncap_first};
    }

    public void set${column.attrName}(${column.attrType} ${column.attrName?uncap_first}) {
        this.${column.attrName?uncap_first} = ${column.attrName?uncap_first};
    }

    </#list>
</#if>

}
