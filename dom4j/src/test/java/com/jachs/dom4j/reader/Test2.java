package com.jachs.dom4j.reader;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import com.jachs.dom4j.writer.Test1;

/***
 * 
 * @author zhanchaohan
 * @see com.jachs.dom4j.writer.Test2
 */
public class Test2 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T2.xml";
	Document doc;
	
	
	@Before
	public void init() throws DocumentException {
		SAXReader reader = new SAXReader();
		doc=reader.read(PATH);
	}
	@Test
	public void test1() {
		Element root=doc.getRootElement();
		
		System.out.println("节点名称:"+root.getName());
		System.out.println("节点内容:"+root.getText());
		System.out.println("节点属性:"+root.attributeValue("属性"));
	}
}
