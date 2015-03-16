package ab2;

public class ChapiterElementPrintVisitor implements ChapiterElementVisitor {
		public String htmlfile = "";
	@Override
	public void visit(Paragraphe paragraphe) {
		htmlfile = htmlfile +"<H4>"+ paragraphe.getName() +"</H4>";
		
	}

	@Override
	public void visit(TitreChapitre titreChapitre) {
		htmlfile = htmlfile +"<H3>"+ titreChapitre.getName() +"</H3>";
		
	}

	@Override
	public void visit(Chapitre chapitre) {
		// TODO Auto-generated method stub
		
	}

}
