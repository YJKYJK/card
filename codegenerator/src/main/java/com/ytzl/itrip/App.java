package com.ytzl.itrip;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 */
public class App {
    /**主键Id*/
    private Long id;
    public static  final String templatePath = "codegenerator\\src\\main\\resources";
    public static void main(String[] args) {
        //准备数据
        Map<String, Object> param = new HashMap<>();
        param.put("title","freemarker Demo");
        param.put("name","freemarker");
        //编写合成机制
        Configuration configuration = new Configuration();
        try {
            //设置模板地址
            configuration.setDirectoryForTemplateLoading(new File(templatePath));
            //获取模板
            Template template = configuration.getTemplate("index.ftl");
            //输出模板与数据整合的内容
            template.process(param,new OutputStreamWriter(
                    new FileOutputStream("J:\\index.html")));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}
