package ab2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class Livre implements BookElement {
	//BookElement[] elements;
	private ArrayList<BookElement> elements = new ArrayList<BookElement>();

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
		this.elements.add(new TitreLivre(sTitreLivre));
		Node auteur = wList.item(0);
		String sAuteur = auteur.getTextContent();
		this.elements.add(new Auteur(sAuteur));
		
		
		//create new Array of elements
//		this.elements = { new TitreLivre(sTitreLivre), 
//		new Auteur(sAuteur)/*, new Chapitre(nList)*/  };
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
