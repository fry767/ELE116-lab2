package ab2;

//On collecte les donn�es � propos du livre
public class BookElementPrintVisitor implements BookElementVisitor {
	private String htmlfile = "";
	private Boolean flag = false;

	public BookElementPrintVisitor(Boolean flag) {
		this.flag = flag;
	}

	//m�thode de visite du titre du livre
	@Override
	public void visit(TitreLivre titreLivre) {
		if (flag == true) {
			htmlfile = htmlfile + "<H1>" + titreLivre.getName() + "</H1>";
			System.out.println(titreLivre.getName());
		}
	}

	//m�thode de visite de l'auteur
	@Override
	public void visit(Auteur auteur) {
		if (flag == true) {
			htmlfile = htmlfile + "<H3>" + auteur.getName() + "</H3>";
			System.out.println("Visiting " + auteur.getName());
		}
	}

	//m�thode de visite du livre
	@Override
	public void visit(Livre livre) {

		System.out.println("Visiting livre");

	}

	// m�thode de visite du chapitre
	@Override
	public void visit(Chapitre chapitre) {
		ChapiterElementPrintVisitor visitor = new ChapiterElementPrintVisitor(
				flag);
		chapitre.accept(visitor);
		this.htmlfile += visitor.get_html();

	}
	
	//m�thode pour retourner la string html format� avec toute les informations du livre
	public String get_html() {
		return htmlfile;
	}
}
