package ab2;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class Chapitre implements BookElement, ChapiterElement {
	private ArrayList<ChapiterElement> elements = new ArrayList<ChapiterElement>();
	String sTitreChapitre;
	int i =0;
	// Paragraphe[] paragraphe;
	// private String htmlfile = "";

	public Chapitre(ArrayList<String> para) {
		
		for (String elem : para) {
			i++;
			if(i == 1){
				sTitreChapitre = elem;
				this.elements.add(new TitreChapitre(sTitreChapitre));
			}else{
				this.elements.add(new Paragraphe(elem));
			}
			
		}
		i=0;
//		if (para.getNodeType() == Node.ELEMENT_NODE) {
//			Element eElement = (Element) para;
//			sTitreChapitre = eElement.getElementsByTagName("titre_chapitre")
//					.item(0).getTextContent();
//			this.elements.add(new TitreChapitre(sTitreChapitre));
//			if (eElement.getElementsByTagName("paragraphe").getLength() > 0) {
//				for (int temps = 0; temps < eElement.getElementsByTagName("paragraphe").getLength(); temps++) {
//					this.elements.add(new Paragraphe(eElement.getElementsByTagName("paragraphe").item(temps).getTextContent()));
//
//				}
//			} else {
//				this.elements.add(new Paragraphe(eElement
//						.getElementsByTagName("paragraphe").item(0)
//						.getTextContent()));
//
//			}
//
//		}
	}

	@Override
	public void accept(BookElementVisitor visitor) {
		visitor.visit(this);

	}

	@Override
	public void accept(ChapiterElementVisitor visitor) {
		for (ChapiterElement elem : elements) {
			elem.accept(visitor);

		}

	}

}
