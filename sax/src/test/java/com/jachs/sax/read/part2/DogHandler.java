package com.jachs.sax.read.part2;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.jachs.sax.entity.Dog;


/***
 * 
 * @author zhanchaohan
 *
 */
public class DogHandler extends DefaultHandler{
	public List<Dog>dogList;
	
	private Dog dog;
	
	@Override
	public void startDocument(){
	    this.dogList=new ArrayList<Dog>();
	}
	 
	@Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("dog")) {
        	dog=new Dog();
        	dog.setType(attributes.getValue("type"));
        	dog.setAge(attributes.getValue("age"));
        }else {
        	return;
        }
    }
 
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
    	if(qName.equals("dog")) {
    		dogList.add(dog);
    	}
    }
 
    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        String str = new String(ch, start, length);
        if (!"\n".equals(str)) {
        	dog.setName(str);
        }
    }
}
