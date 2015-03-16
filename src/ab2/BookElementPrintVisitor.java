package ab2;

public class BookElementPrintVisitor implements BookElementVisitor {

	@Override
	public void visit(TitreLivre titreLivre) {
		System.out.println("Visiting " + titreLivre.getName() );

	}

	@Override
	public void visit(Auteur auteur) {
		System.out.println("Visiting " + auteur.getName() );

	}

	@Override
	public void visit(Livre livre) {
		System.out.println("Visiting livre");

	}

}
