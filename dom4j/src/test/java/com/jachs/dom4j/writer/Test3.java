package com.jachs.dom4j.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author zhanchaohan
 *
 */
public class Test3 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T3.xml";
	Document doc;
	
	@Before
	public void init() {
		doc=DocumentHelper.createDocument();
	}
	@After
	public void afWriter() throws IOException {
		// 自定义xml样式
		OutputFormat format = new OutputFormat();
		format.setIndentSize(2); // 行缩进
		format.setNewlines(true); // 一个结点为一行
		format.setTrimText(true); // 去重空格
		format.setPadText(true);
		format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行
		
		
		XMLWriter writer = new XMLWriter(new FileWriter(PATH),format);
		writer.write(doc);
		writer.close();
		System.out.println("dom4j CreateDom4j success!");
	}
	@Test
	public void test1() {
		Element root=doc.addElement("library", "jachs space");
		
		Element bk1=root.addElement("book");
		bk1.addElement("bookName").setText("一本书");
		bk1.addElement("bookPrice").setText("1.2");
		
		Element bk2=root.addElement("book");
		bk2.addElement("bookName").setText("二本书");
		bk2.addElement("bookPrice").setText("0.5");
		
		Element bk3=root.addElement("book");
		bk3.addElement("bookName").setText("other book");
		bk3.addElement("bookPrice").setText("0.5");
		
		Element bk4=root.addElement("book");
		bk4.addElement("bookName").setText("another book");
		bk4.addElement("bookPrice").setText("0.5");
		
		Element bk5=root.addElement("book");
		bk5.addElement("bookName").setText("more book");
		bk5.addElement("bookPrice").setText("0.5");
		
		root.addComment("*********************************************");
		Element peo1=root.addElement("people");
		peo1.addElement("peoName").setText("皮皮虾");
		peo1.addElement("peoAge").setText("10");
		
		
		Element peo2=root.addElement("people");
		peo2.addElement("peoName").setText("jack.chi");
		peo2.addElement("peoAge").setText("8");
		
		bk1.setAttributeValue("auth", "jachs");
	}
}
