package ab2;

public class BookElementPrintVisitor implements BookElementVisitor {
	private String htmlfile = "" ;
	private Boolean flag = false;
	
	public BookElementPrintVisitor(Boolean flag) {
		this.flag = flag;
	}
	@Override
	public void visit(TitreLivre titreLivre) {
		if(flag==true){
			htmlfile = htmlfile + "<H1>" + titreLivre.getName() + "</H1>" ;
			System.out.println("<H1>" + titreLivre.getName()   );
		}
	}

	@Override
	public void visit(Auteur auteur) {
		if(flag==true){
		htmlfile = htmlfile +  "<H2>" + auteur.getName() + "</H2>";
		System.out.println("Visiting " + auteur.getName() );
		}
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
		ChapiterElementPrintVisitor visitor = new ChapiterElementPrintVisitor(flag);
		chapitre.accept(visitor);
		this.htmlfile += visitor.htmlfile; 
		
	}
}
