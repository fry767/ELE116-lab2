package ab2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Livre implements BookElement {
	BookElement[] elements;
	TitreLivre[] titreLivre ;
	
	
	public Livre(String pathfile ) {
		try{
		File fXmlFile = new File(pathfile);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		
		NodeList nList = doc.getElementsByTagName("chapitre");
		NodeList cList = doc.getElementsByTagName("titre_livre");
		NodeList wList = doc.getElementsByTagName("auteur");
		
		doc.getDocumentElement().normalize();
		
		Node titreLivre = cList.item(0);
		String sTitreLivre = titreLivre.getTextContent();
		
		Node auteur = wList.item(0);
		String sAuteur = auteur.getTextContent();
		
		//create new Array of elements
		this.elements = new BookElement[] { new TitreLivre(sTitreLivre), 
		new Auteur(sAuteur) };
		}catch (Exception e) {
			e.printStackTrace();
	    }
		
	}
	@Override
	public void accept(BookElementVisitor visitor) {
		for(BookElement elem : elements) {
			elem.accept(visitor);

	}
  }	
}
