package com.jachs.dom4j.reader;

import java.io.File;
import java.util.List;

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
 * @see com.jachs.dom4j.writer.Test3
 */
public class Test3 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T3.xml";
	Document doc;
	
	
	@Before
	public void init() throws DocumentException {
		SAXReader reader = new SAXReader();
		doc=reader.read(PATH);
	}
	//获取全部book节点
	@Test
	public void test1() {
		Element root=doc.getRootElement();
		
		List<Element> bookList=root.elements("book");
		
		for (Element element : bookList) {
			System.out.println(element.elementText("bookName")+"\t"+element.elementText("bookPrice"));
		}
	}
}
