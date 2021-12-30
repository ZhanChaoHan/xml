package com.jachs.sax.create;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.xml.sax.helpers.AttributesImpl;


/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Sax1.xml";
	
	@Test
	public void test1() throws Exception {
        SAXTransformerFactory factory = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
        TransformerHandler handler = factory.newTransformerHandler();
        Transformer transformer = handler.getTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        Result result = new StreamResult(new FileOutputStream(PATH));
        handler.setResult(result);
		
        // 创建一个属性实例, addAttribute(String uri, String localName, String qName, String type, String value)
        AttributesImpl attr = new AttributesImpl();
        // 打开doc对象
        handler.startDocument();
        // 创建元素: handler.startElement(uri, 命名空间, 元素名, 属性列表);//没有则填null
        handler.startElement("", "", "root", attr);
        attr.clear();
        attr.addAttribute("", "", "attr", "", "one");
        handler.startElement("", "", "person", attr);
        attr.clear();
        attr.addAttribute("", "", "attr", "", "one");
        handler.startElement("", "", "people", attr);
        handler.characters("one child people one".toCharArray(), 0, 14);
        handler.endElement("", "", "people");
        attr.clear();
        attr.addAttribute("", "", "attr", "", "two");
        handler.startElement("", "", "people", attr);
        handler.characters("one child people two".toCharArray(), 0, 14);
        handler.endElement("", "", "people");
        handler.endElement("", "", "person");
        attr.clear();
        attr.addAttribute("", "", "attr", "", "two");
        handler.startElement("", "", "person", attr);
        attr.clear();
        attr.addAttribute("", "", "attr", "", "one");
        handler.startElement("", "", "people", attr);
        handler.characters("two child people one".toCharArray(), 0, 14);
        handler.endElement("", "", "people");
        attr.clear();
        attr.addAttribute("", "", "attr", "", "two");
        handler.startElement("", "", "people", attr);
        handler.characters("two child people two".toCharArray(), 0, 14);
        handler.endElement("", "", "people");
        handler.endElement("", "", "person");
        // 结束hanlder.endElement("", "", 元素名)
        handler.endElement("", "", "root");
        // 关闭doc对象
        handler.endDocument();
        System.out.println("SAX CreateSAX success!");
	}
}
