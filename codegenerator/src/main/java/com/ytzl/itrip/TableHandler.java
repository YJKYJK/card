package com.ytzl.itrip;


import com.ytzl.itrip.beans.Column;
import com.ytzl.itrip.beans.Table;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sam on 2018/4/10.
 */
public class TableHandler {

    //数据库连接信息
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String JDBCURL = "jdbc:mysql://localhost:3306/card";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static Connection conn;
    private static DatabaseMetaData dbmd;

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBCURL, USERNAME, PASSWORD);
            dbmd = conn
                    .getMetaData();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Table> getTables() {
        List<Table> tableList = new ArrayList<>();
        try {
            ResultSet rs = dbmd.getTables(null, null, null, new String[]{"TABLE"});
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");
                System.out.println("---" + tableName);
                Table table = new Table();
                table.setTableName(tableName);
                table.setColumnList(getColumns(tableName));
                String firstLowerCaseClassName = "";
                String className = "";
                //itrip_hotel_room
                //itripHotelRoom
                //ItripHotelRoom
                // itrip    hotel    room
                String[] split = tableName.split("_");
                for (String sp : split) {
                    //itrip    hotel    room  --> ItripHotelRoom
                    className += sp.substring(0, 1).toUpperCase()
                            + sp.substring(1);
                }
                firstLowerCaseClassName = className.substring(0, 1).toLowerCase()
                        + className.substring(1);
                table.setFirstLowerCaseClassName(firstLowerCaseClassName);
                table.setClassName(className);
                tableList.add(table);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
    }

    public static void main(String[] args) {
        TableHandler.getColumns("itrip_hotel");
    }

    public static List<Column> getColumns(String tableName) {
        List<Column> columnList = new ArrayList<>();
        try {
            ResultSet rs = dbmd.getColumns(null, null, tableName, null);
            while (rs.next()) {
                //获取字段名称
                String columnName = rs.getString("COLUMN_NAME");
                //获取字段类型
                String typeName = rs.getString("TYPE_NAME");
                //描述内容
                String remarks = rs.getString("REMARKS");
                System.out.println(columnName + "---" + swatchType(typeName) + "---" + remarks);
                Column column = new Column();
                column.setColumnName(columnName);
                column.setColumnRemark(remarks);
                column.setColumnType(swatchType(typeName));
                //hotelName  HotelName
                String firstUpperCaseColumnName = columnName.substring(0, 1).toUpperCase()
                        + columnName.substring(1);
                column.setFirstUpperCaseColumnName(firstUpperCaseColumnName);
                columnList.add(column);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columnList;
    }

    public static String swatchType(String type) {
        switch (type) {
            case "BIGINT":
                return "Long";
            case "DATETIME":
                return "Date";
            case "VARCHAR":
                return "String";
            case "INT":
                return "Integer";
            case "DECIMAL":
                return "BigDecimal";
            default:
                return "String";
        }
    }


}
