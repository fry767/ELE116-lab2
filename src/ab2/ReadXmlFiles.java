package ab2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXmlFiles {
 
  public ReadXmlFiles(String pathfile) {
	  
//	swingApplication swing = new swingApplication();
	
    try {
 
	File fXmlFile = new File(pathfile);
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
	doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("chapitre");
	NodeList cList = doc.getElementsByTagName("titre_livre");
	NodeList wList = doc.getElementsByTagName("auteur");
	
 
	System.out.println("----------------------------");
	
	for(int temp = 0; temp< cList.getLength();temp++){
		Node nNode = cList.item(temp);
		System.out.println("\nCurrent Element : " + nNode.getNodeName());
		System.out.println("Titre de livre : " + nNode.getTextContent());
		
	}
	for(int temp = 0;temp<wList.getLength();temp++){
		Node nNode = wList.item(temp);
		System.out.println("\nCurrent Element : " + nNode.getNodeName());
		System.out.println("Auteur : " + nNode.getTextContent());
	}
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
			System.out.println("Titre chapitre : " + eElement.getElementsByTagName("titre_chapitre").item(0).getTextContent());
			if(eElement.getElementsByTagName("paragraphe)").getLength() > 0){
				for(int temps = 0;temps<eElement.getElementsByTagName("paragraphe").getLength();temps++){
					System.out.println("Paragraphe : " + eElement.getElementsByTagName("paragraphe").item(temp).getTextContent());
				}
			}else{
				System.out.println("Paragraphe : " + eElement.getElementsByTagName("paragraphe").item(0).getTextContent());
			}
			
	
 
		}
	}
	
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
}