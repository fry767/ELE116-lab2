package ab2;

public interface ChapiterElementVisitor {
	void visit(Paragraphe paragraphe);
	void visit(TitreChapitre titreChapitre);
	void visit(Chapitre chapitre);
}
