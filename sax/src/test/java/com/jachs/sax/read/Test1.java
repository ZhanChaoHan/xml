package com.jachs.sax.read;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.junit.Test;
import org.xml.sax.SAXException;


/***
 * 
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Sax1.xml";
	
	@Test
	public void test1() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        saxParser.parse(new File(PATH), new MyHandler());
        
	}
}
