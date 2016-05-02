package io.sample.template.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import io.sample.template.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;
	
	@Override
	public void makeHtmlWithTmeplate() throws Exception {
		String rootPath = new File("./bin").getCanonicalPath();
		System.out.println("Current dir:"+rootPath);

		freemarkerConfig.getConfiguration().setDirectoryForTemplateLoading(new File(rootPath + "/template"));
		
        //Create Data Model
        Map<String, Object> map = new HashMap<>();
        map.put("blogTitle", "Freemarker Template Demo");
        map.put("message", "Getting started with Freemarker.<br/>Find a simple Freemarker demo.");
        List<String> references = new ArrayList<>();
        references.add("test1");
        references.add("test2");
        references.add("test3");
        map.put("references", references);
        //Instantiate template
        Template template = freemarkerConfig.getConfiguration().getTemplate("template01.ftl");
        //Console output
        Writer console = new OutputStreamWriter(System.out);
        template.process(map, console);
        console.flush();
        // File output
        Writer file = new FileWriter(new File(rootPath + "/template/blog-template-output.html"));
        template.process(map, file);
        file.flush();
        file.close();

	}

}