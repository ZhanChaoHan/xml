package com.jachs.sax.read.part2;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

import com.jachs.sax.create.Test1;
import com.jachs.sax.entity.Dog;

/***
 * 
 * @author zhanchaohan
 *
 */
public class DogTest {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"Dog.xml";

	@Test
	public void test1() throws Exception {
		 DogHandler	dh=new DogHandler();
		 
		 SAXParserFactory factory = SAXParserFactory.newInstance();
	     SAXParser saxParser = factory.newSAXParser();
	     saxParser.parse(new File(PATH), dh);
	     
	     for (Dog dog : dh.dogList) {
			System.out.println(dog.getName()+"\t"+dog.getType()+"\t"+dog.getAge());
		}
	}
}
