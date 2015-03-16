package ab2;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;

public class Chapitre implements BookElement, ChapiterElement {
	ChapiterElement[] elements;
	String sTitreChapitre;

	private String htmlfile = "";
	
	public  Chapitre(NodeList nList){
		for (int temp = 0; temp < nList.getLength(); temp++) {
			 
			Node nNode = nList.item(temp);
	 
			//System.out.println("\nCurrent Element :" + nNode.getNodeName());
	 
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	 
				Element eElement = (Element) nNode;
				//System.out.println("Titre chapitre : " + eElement.getElementsByTagName("titre_chapitre").item(0).getTextContent());
				sTitreChapitre = eElement.getElementsByTagName("titre_chapitre").item(0).getTextContent();
//				if(eElement.getElementsByTagName("paragraphe").getLength() > 0){
//					for(int temps = 0;temps<eElement.getElementsByTagName("paragraphe").getLength();temps++){
//						//System.out.println("Paragraphe : " + eElement.getElementsByTagName("paragraphe").item(temps).getTextContent());
//						
//					}
//				}else{
//					//System.out.println("Paragraphe : " + eElement.getElementsByTagName("paragraphe").item(0).getTextContent());		
//				}
			}

		}
		this.elements = new ChapiterElement[] { new TitreChapitre(sTitreChapitre)
				 };
	}
	
	
	
	public String getName() {
		return this.htmlfile;
		}
	@Override
	public void accept(BookElementVisitor visitor) {
		visitor.visit(this);

	}

	@Override
	public void accept(ChapiterElementVisitor visitor) {
		visitor.visit(this);
		
	}
	

}
