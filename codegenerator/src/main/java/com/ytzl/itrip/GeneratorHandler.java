package com.ytzl.itrip;

import com.ytzl.itrip.beans.Table;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sam on 2018/4/19.
 */
public class GeneratorHandler {
    //数据
//    private List<Table> tableList;
    //模板所在地址
    private static String templatePath = "codegenerator\\src\\main\\resources";
    //文件输出地址
    private static String outputPath = "codegenerator\\src\\main\\resources\\output";

    private static String packageName = "com.yanyan.card";

    public static void executeModel(Table table) {
        execute(table,"model.ftl",
                "model\\"+table.getClassName()+".java");
    }

    public static void executeMapper(Table table) {
        execute(table,"mapper-interface.ftl",
                "mapper-interface\\"+table.getClassName()+"Mapper.java");
    }
    public static void executeMapperXml(Table table) {
        execute(table,"mapper-xml.ftl",
                "mapper-xml\\"+
                        table.getFirstLowerCaseClassName()+"Mapper.xml");
    }
    public static void executeService(Table table) {
        execute(table,"service-interface.ftl",
                "service-interface\\"+table.getClassName()+"Service.java");
    }
    public static void executeServiceImpl(Table table) {
        execute(table,"service-impl.ftl",
                "service-impl\\"+table.getClassName()+"ServiceImpl.java");
    }





    private static void execute(Table table, String templateName, String outputName) {
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            //构建数据
            Map<String, Object> param = new HashMap();
            param.put("table", table);
            param.put("packageName", packageName);
            //获取模板
            Template template = configuration.getTemplate(templateName);
            template.process(param, new OutputStreamWriter(
                    new FileOutputStream(
                            outputPath + "\\" + outputName)));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
