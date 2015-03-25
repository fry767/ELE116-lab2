package ab2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;


import java.io.File;
import java.util.ArrayList;


public class Livre implements BookElement {
	// BookElement[] elements;
	private ArrayList<BookElement> elements = new ArrayList<BookElement>();

	public Livre(String pathfile) {
		try {
			File fXmlFile = new File(pathfile);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			//Séparation du livre en 3 liste comportant les éléments principaux du livre
			NodeList nList = doc.getElementsByTagName("chapitre");
			NodeList cList = doc.getElementsByTagName("titre_livre");
			NodeList wList = doc.getElementsByTagName("auteur");

			doc.getDocumentElement().normalize();
			//Traitement du titre du livre dans la liste du visiteur
			Node titreLivre = cList.item(0);
			String sTitreLivre = titreLivre.getTextContent();
			this.elements.add(new TitreLivre(sTitreLivre));
			//Traitement de l'auteur dans la liste du visitor
			Node auteur = wList.item(0);
			String sAuteur = auteur.getTextContent();
			this.elements.add(new Auteur(sAuteur));
			//Traitement des chapitres dans la liste du visiteur
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				this.elements.add(new Chapitre(nNode));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// on accepte le visiteur et on créer la liste d'éléments du visiteur pour le livre
	@Override
	public void accept(BookElementVisitor visitor) {
		for (BookElement elem : elements) {
			elem.accept(visitor);

		}
	}
}
