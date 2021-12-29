package com.jachs.dom4j.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/***
 * 
 * @author zhanchaohan
 *
 */
public class Test2 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T2.xml";
	Document doc;
	
	@Before
	public void init() {
		doc=DocumentHelper.createDocument();
	}
	@After
	public void afWriter() throws IOException {
		XMLWriter writer = new XMLWriter(new FileWriter(PATH));
		writer.write(doc);
		writer.close();
		System.out.println("dom4j CreateDom4j success!");
	}
	@Test
	public void test1() {
		//创建节点
		Element el=doc.addElement("根节点");
		//注释
		el.addComment("注释");
		//设置内容
		el.setText("INFO");
		//设置属性
		el.addAttribute("属性", "属性值");
	}
}
