package ab2;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;

public class Chapitre implements BookElement, ChapiterElement {
	private ArrayList<ChapiterElement> elements = new ArrayList<ChapiterElement>();
	String sTitreChapitre;

	// Paragraphe[] paragraphe;
	// private String htmlfile = "";

	public Chapitre(Node nNode) {
		// Ici, on va séparer l'arbre créér par la librarie DOM pour avoir le titre 
		// du chapitre ainsi que le contenu de celui-ci
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
			Element eElement = (Element) nNode;
			
			//On va chercher l'élément correspondant au titre du chapitre
			sTitreChapitre = eElement.getElementsByTagName("titre_chapitre")
					.item(0).getTextContent();
			//Ajout du titre du chapitre dans la liste du visiteur de chapitre
			this.elements.add(new TitreChapitre(sTitreChapitre));
			
			//Ici, on regarde s'il y a plus qu'un paragraphe. 
			if (eElement.getElementsByTagName("paragraphe").getLength() > 0) {
				for (int temps = 0; temps < eElement.getElementsByTagName("paragraphe").getLength(); temps++) {
					// ajout de l'élément paragraphe dans la liste du visiteur de chapitre
					this.elements.add(new Paragraphe(eElement.getElementsByTagName("paragraphe").item(temps).getTextContent()));

				}
			} else {
				this.elements.add(new Paragraphe(eElement
						.getElementsByTagName("paragraphe").item(0)
						.getTextContent()));

			}

		}
	}
	// on accepte le visiteur de book
	@Override
	public void accept(BookElementVisitor visitor) {
		visitor.visit(this);

	}
	// on accepte le visiteur de chapitre
	@Override
	public void accept(ChapiterElementVisitor visitor) {
		for (ChapiterElement elem : elements) {
			elem.accept(visitor);

		}

	}

}
