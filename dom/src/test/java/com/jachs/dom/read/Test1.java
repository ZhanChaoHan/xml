package com.jachs.dom.read;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/***
 * 
 * @author zhanchaohan
 * @see com.jachs.dom.writer.Test1
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Dom1.xml";
	Document doc;
	
	@Before
	public void init() throws Exception {
		DocumentBuilder domBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		doc = domBuilder.parse(new FileInputStream(PATH));
	}
	@Test
	public void test1() {
		 Element root = doc.getDocumentElement();
		 //全部子节点
//		 NodeList allList= root.getChildNodes();
		 NodeList tList=root.getElementsByTagName("table");
		 for (int kk = 0; kk < tList.getLength(); kk++) {
			 Node node=tList.item(kk);
			 System.out.println(node.getTextContent());
		}
		 
		 for (int kk = 0; kk < tList.getLength(); kk++) {
			 Element node=(Element) tList.item(kk);
			 System.out.println(node.getNodeName()+"\t"+node.getTextContent()+"\t"+node.getAttribute("price"));
		}
	}
}
