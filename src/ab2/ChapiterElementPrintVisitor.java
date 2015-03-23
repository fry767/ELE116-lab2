package ab2;

// On collecte les données à propos du chapitre
public class ChapiterElementPrintVisitor implements ChapiterElementVisitor {
	private String htmlfile = "";
	private Boolean flag;

	//constructeur pour recevoir le flag du livre ou de la table des matière
	public ChapiterElementPrintVisitor(Boolean flag) {
		this.flag = flag;
	}

	// méthode de visite du paragraphe
	@Override
	public void visit(Paragraphe paragraphe) {
		if (flag == true) {
			htmlfile = htmlfile + "<H4>   " + paragraphe.getName() + "</H4>";
		}
	}

	// méthode de visite du titre du chapitre
	@Override
	public void visit(TitreChapitre titreChapitre) {
		htmlfile = htmlfile + "<H2>   " + titreChapitre.getName() + "</H2>";

	}

	// méthode de visite du chapitre
	@Override
	public void visit(Chapitre chapitre) {
		// TODO Auto-generated method stub

	}

	//méthode pour retourner la string html formaté avec toute les informations du chapitre
	public String get_html() {
		return htmlfile;
	}
}
