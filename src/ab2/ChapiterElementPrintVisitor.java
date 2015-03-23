package ab2;

// On collecte les donn�es � propos du chapitre
public class ChapiterElementPrintVisitor implements ChapiterElementVisitor {
	private String htmlfile = "";
	private Boolean flag;

	//constructeur pour recevoir le flag du livre ou de la table des mati�re
	public ChapiterElementPrintVisitor(Boolean flag) {
		this.flag = flag;
	}

	// m�thode de visite du paragraphe
	@Override
	public void visit(Paragraphe paragraphe) {
		if (flag == true) {
			htmlfile = htmlfile + "<H4>   " + paragraphe.getName() + "</H4>";
		}
	}

	// m�thode de visite du titre du chapitre
	@Override
	public void visit(TitreChapitre titreChapitre) {
		htmlfile = htmlfile + "<H2>   " + titreChapitre.getName() + "</H2>";

	}

	// m�thode de visite du chapitre
	@Override
	public void visit(Chapitre chapitre) {
		// TODO Auto-generated method stub

	}

	//m�thode pour retourner la string html format� avec toute les informations du chapitre
	public String get_html() {
		return htmlfile;
	}
}
