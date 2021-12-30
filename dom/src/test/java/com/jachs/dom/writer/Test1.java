package com.jachs.dom.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Dom1.xml";
	Document document;
	
	@Before
	public void init() throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.newDocument();
	}
	@After
	public void save() throws FileNotFoundException, TransformerException {
		TransformerFactory tff = TransformerFactory.newInstance();
		Transformer tf = tff.newTransformer();

		tf.setOutputProperty("encoding", "utf-8");
		tf.setOutputProperty("indent", "yes");
	      
		// 设置输出数据时换行
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		// 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
		document.setXmlStandalone(true);

		// 使用Transformer的transform()方法将DOM树转换成XML
		tf.transform(new DOMSource(document), new StreamResult(new FileOutputStream(PATH)));
	}
	
	@Test
	public void test1() {
		//创建根节点
		Element root=document.createElement("room");
		
		Element t1=document.createElement("table");
		t1.setTextContent("一号桌子");
		t1.setAttribute("price", "500");
		
		Element t2=document.createElement("table");
		t2.setTextContent("二号桌子");
		t2.setAttribute("price", "800");
		
		Element c1=document.createElement("cup");
		c1.setTextContent("杯子");
		c1.setAttribute("capacity", "1000ml");
		c1.setAttribute("width", "20cm");
		
		
		t1.appendChild(c1);
		root.appendChild(t1);
		root.appendChild(t2);
		
		document.appendChild(root);
	}
}
