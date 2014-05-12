package fr.bb.android;

import javax.xml.bind.annotation.XmlElement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebServices {
	
	
	@RequestMapping("getApp.sd")
	@XmlElement
	public String getApp()
	{
		String retour = "";
		retour = "<root>"
					+ "<header title=\"Applications\">"
					+ "<item  name=\"Item 1\"/>"
					+ "<item  name=\"Item 2\"/>"
					+ "<item  name=\"Item 3\"/>"
					+ "<item  name=\"Item 4\"/>"
					+ "<item  name=\"Item 5\"/>"    	
					+ "</header>"
					+ "</root>";
		return "<root><header title=\"Applications\"><item  name=Item 1/>";
	}

}
