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
public class DogTest {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Dog.xml";
	AttributesImpl attr = new AttributesImpl();
	
	@Test
	public void test1() throws Exception {
		 SAXTransformerFactory factory = (SAXTransformerFactory)SAXTransformerFactory.newInstance();
		 TransformerHandler handler = factory.newTransformerHandler();
		 Transformer transformer = handler.getTransformer();
		 transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		 transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
		 Result result = new StreamResult(new FileOutputStream(PATH));
		 handler.setResult(result);
		 
		 handler.startDocument();
		 handler.startElement("", "", "root", attr);
		 
		 attr.addAttribute("", "", "type", "", "金毛");
		 attr.addAttribute("", "", "age", "", "1");
		 handler.startElement("", "", "dog", attr);
		 String text="大金毛";
		 handler.characters(text.toCharArray(), 0, text.length());
		 handler.endElement("", "", "dog");
		 
		 attr.clear();
		 
		 attr.addAttribute("", "", "type", "", "哈士奇");
		 attr.addAttribute("", "", "age", "", "2");
		 handler.startElement("", "", "dog", attr);
		 String text1="二哈";
		 handler.characters(text1.toCharArray(), 0, text1.length());
		 handler.endElement("", "", "dog");
		 
		 handler.endElement("", "", "root");
		 handler.endDocument();
	}
}
