package com.yanyan.card.exception;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.Writer;

/**
 * Created by Administrator on 2018/10/16 0016.
 */
public class FreemarkerExceptionHander implements TemplateExceptionHandler{

    @Override
    public void handleTemplateException(TemplateException e, Environment environment, Writer writer) throws TemplateException {
        try {
            throw new Exception("freemark",e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
