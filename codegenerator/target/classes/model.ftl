package ${packageName}.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ${table.className} implements Serializable {

    <#list table.columnList as column>
    //${column.columnRemark}
    private ${column.columnType} ${column.columnName};
    </#list>

<#list table.columnList as column>

    public void set${column.firstUpperCaseColumnName}(${column.columnType} ${column.columnName}) {
        this.${column.columnName} = ${column.columnName};
    }

    public ${column.columnType} get${column.firstUpperCaseColumnName}() {
        return this.${column.columnName};
    }
</#list>
}
