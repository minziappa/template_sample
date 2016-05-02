package io.sample.template.main;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.template.TemplateException;
import io.sample.template.service.SampleService;

public class TemplateMain {

	public static void main(String[] args) throws Exception {

        try {
             ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
             SampleService sampleService = (SampleService) context.getBean("sampleServiceImpl");
             sampleService.makeHtmlWithTmeplate();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
	}

}
