package ab2;

public interface BookElementVisitor {
	void visit(TitreLivre titreLivre);
	void visit(Auteur auteur);
	void visit(Chapitre chapitre);
	//void visit(Paragraphe paragraphe);
	//void visit(TitreChapitre titreChapitre);
	void visit(Livre livre);
	
}
