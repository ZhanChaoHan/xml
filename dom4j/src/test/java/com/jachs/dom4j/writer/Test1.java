package com.jachs.dom4j.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

/***
 * 创建空白XML
 * @author zhanchaohan
 *
 */
public class Test1 {
	private static final String PATH=Test1.class.getResource("/").getPath()+File.separator+"T1.xml";
	
	@Test
	public void test1() throws Exception {
		Document doc=DocumentHelper.createDocument();
		// 自定义xml样式
		OutputFormat format = new OutputFormat();
		format.setIndentSize(2); // 行缩进
		format.setNewlines(true); // 一个结点为一行
		format.setTrimText(true); // 去重空格
		format.setPadText(true);
		format.setNewLineAfterDeclaration(false); // 放置xml文件中第二行为空白行

		// 输出xml文件
		XMLWriter writer = new XMLWriter(new FileOutputStream(PATH), format);
		writer.write(doc);
		System.out.println("dom4j CreateDom4j success!");
	}
}
