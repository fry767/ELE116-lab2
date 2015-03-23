package ab2;

// interface des visiteurs de book
public interface BookElementVisitor {
	void visit(TitreLivre titreLivre);

	void visit(Auteur auteur);

	void visit(Chapitre chapitre);

	void visit(Livre livre);

}
