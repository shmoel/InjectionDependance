package injectionDependance;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.jdom2.*;
import org.jdom2.input.*;
import org.jdom2.filter.*;

import java.util.LinkedList;
import java.util.List;

public class Main {
	static Document document;
	static Element racine;
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub
		SAXBuilder sxb = new SAXBuilder();
		
		try
		{
			document = sxb.build(new File("injection.xml"));
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		racine = document.getRootElement();
	

		Constructor ct = getClasse().getConstructor(new Class[]{List.class});
		
		Pile<Integer> p = (Pile<Integer>) ct.newInstance(getInjection().newInstance());
		
		p.empiler(5);
		p.empiler(6);
		p.empiler(15);
		p.empiler(12);
		
		p.depiler();
		p.depiler();
		
	}
	
	static Class getClasse() throws ClassNotFoundException
	{
		Element injection = racine.getChild("injection");
		
		return  Class.forName(System.getProperty("user.dir").substring(System.getProperty("user.dir").lastIndexOf("\\")+1) +"."+ injection.getAttributeValue("classe"));
	}
	
	static Class getInjection() throws ClassNotFoundException
	{
		Element injection = racine.getChild("injection");
		return  Class.forName(injection.getAttributeValue("injection"));
	}

}
