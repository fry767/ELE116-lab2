package ab2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;



import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Livre implements BookElement {
	// BookElement[] elements;
	
	public static ArrayList<BookElement> elements = new ArrayList<BookElement>();
	


	public Livre(String pathfile) {
		try {
			File fXmlFile = new File(pathfile);
//			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
//					.newInstance();
//			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//			Document doc = dBuilder.parse(fXmlFile);

//			NodeList nList = doc.getElementsByTagName("chapitre");
//			NodeList cList = doc.getElementsByTagName("titre_livre");
//			NodeList wList = doc.getElementsByTagName("auteur");

			//doc.getDocumentElement().normalize();

//			Node titreLivre = cList.item(0);
//			String sTitreLivre = titreLivre.getTextContent();
//			this.elements.add(new TitreLivre(sTitreLivre));
//			Node auteur = wList.item(0);
//			String sAuteur = auteur.getTextContent();
//			this.elements.add(new Auteur(sAuteur));
//
//			for (int temp = 0; temp < nList.getLength(); temp++) {
//				Node nNode = nList.item(temp);
//				this.elements.add(new Chapitre(nNode));
//
//			}
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

		 
			DefaultHandler handler = new DefaultHandler() {
		 
			boolean titreLivre = false;
			boolean auteur = false;
			boolean chapitre = false;
			boolean titreChapitre = false;
			boolean paragraphe = false;

		 
			public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {
		 
				//System.out.println("Debut de " + qName);
		 
				if (qName.equalsIgnoreCase("TITRE_LIVRE")) {
					titreLivre = true;
				}
		 
				if (qName.equalsIgnoreCase("AUTEUR")) {
					auteur = true;
				}
				
				if (qName.equalsIgnoreCase("CHAPITRE")) {
					chapitre = true;
				}
		 
				if (qName.equalsIgnoreCase("TITRE_CHAPITRE")) {
					titreChapitre = true;
				}
				if (qName.equalsIgnoreCase("PARAGRAPHE")) {
					paragraphe = true;
				}
		 
			}
		 
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
		 
				//System.out.println("fin de " + qName);
		 
			}
		 
			public void characters(char ch[], int start, int length) throws SAXException {
		 
				if (titreLivre) {
					String sTitreLivre = new String(ch, start, length);
					Livre.elements.add(new TitreLivre(sTitreLivre));
					System.out.println("Titre Livre : " + new String(ch, start, length));
					titreLivre = false;
				}
		 
				if (auteur) {
					String sAuteur = new String(ch, start, length);
					Livre.elements.add(new Auteur(sAuteur));
					System.out.println("Auteur : " + new String(ch, start, length));
					auteur = false;
				}
		 
				if (chapitre) {
					
					//System.out.println("Nick Name : " + new String(ch, start, length));
					chapitre = false;
				}
//		 
//				if (titreChapitre) {
//					System.out.println("Titre Chapitre : " + new String(ch, start, length));
//					titreChapitre = false;
//				}
//				if (paragraphe) {
//					System.out.println("Paragraphe : " + new String(ch, start, length));
//					paragraphe = false;
//				}
		 
			}
		 
		     };
		 
		       saxParser.parse(fXmlFile, handler);
			
			
			
			// create new Array of elements
			// this.elements = { new TitreLivre(sTitreLivre),
			// new Auteur(sAuteur)/*, new Chapitre(nList)*/ };
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void accept(BookElementVisitor visitor) {
		for (BookElement elem : elements) {
			elem.accept(visitor);

		}
	}
}
