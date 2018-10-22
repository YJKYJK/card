package com.ytzl.itrip.beans;

/**
 * Created by sam on 2018/4/19.
 */
public class Column {
    //字段名称
    private String columnName;
    //字段类型
    private String columnType;
    //首字母大写字段名称
    private String firstUpperCaseColumnName;
    //字段描述
    private String columnRemark;


    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getFirstUpperCaseColumnName() {
        return firstUpperCaseColumnName;
    }

    public void setFirstUpperCaseColumnName(String firstUpperCaseColumnName) {
        this.firstUpperCaseColumnName = firstUpperCaseColumnName;
    }

    public String getColumnRemark() {
        return columnRemark;
    }

    public void setColumnRemark(String columnRemark) {
        this.columnRemark = columnRemark;
    }
}
