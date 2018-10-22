package com.ytzl.itrip;

import com.ytzl.itrip.beans.Table;

import java.util.List;

/**
 * Created by sam on 2018/4/19.
 */
public class Test {
    public static void main(String[] args) {
        List<Table> tableList = TableHandler.getTables();
        for (Table table : tableList) {
            GeneratorHandler.executeModel(table);
            GeneratorHandler.executeMapper(table);
            GeneratorHandler.executeMapperXml(table);
            GeneratorHandler.executeService(table);
            GeneratorHandler.executeServiceImpl(table);
        }
    }
}
