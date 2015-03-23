package ab2;

//interface des visiteurs de chapitre
public interface ChapiterElementVisitor {
	void visit(Paragraphe paragraphe);

	void visit(TitreChapitre titreChapitre);

	void visit(Chapitre chapitre);
}
