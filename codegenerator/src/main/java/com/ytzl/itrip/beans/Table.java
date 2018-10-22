package com.ytzl.itrip.beans;

import java.util.List;

/**
 * Created by sam on 2018/4/19.
 */
public class Table {
    //表名
    private String tableName;
    //类名
    private String className;
    //首字母小写类名
    private String firstLowerCaseClassName;
    //字段集合
    private List<Column> columnList;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getFirstLowerCaseClassName() {
        return firstLowerCaseClassName;
    }

    public void setFirstLowerCaseClassName(String firstLowerCaseClassName) {
        this.firstLowerCaseClassName = firstLowerCaseClassName;
    }

    public List<Column> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Column> columnList) {
        this.columnList = columnList;
    }
}
