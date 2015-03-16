package ab2;

public class BookElementPrintVisitor implements BookElementVisitor {
	private String htmlfile = "" ;
	@Override
	public void visit(TitreLivre titreLivre) {
		htmlfile = htmlfile + "<H1>" + titreLivre.getName() + "</H1>" ;
		System.out.println("<H1>" + titreLivre.getName()   );

	}

	@Override
	public void visit(Auteur auteur) {
		htmlfile = htmlfile +  "<H2>" + auteur.getName() + "</H2>";
		System.out.println("Visiting " + auteur.getName() );

	}

	@Override
	public void visit(Livre livre) {
		
		System.out.println("Visiting livre");

	}
	public  String get_html(){
		return htmlfile;
	}

	@Override
	public void visit(Chapitre chapitre) {
		this.htmlfile += "<H3>"+ chapitre.getName() + "</H3>"; 
		
	}
}
