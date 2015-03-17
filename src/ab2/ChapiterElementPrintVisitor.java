package ab2;

public class ChapiterElementPrintVisitor implements ChapiterElementVisitor {
		public String htmlfile = "";
		private Boolean flag;
		
		public ChapiterElementPrintVisitor(Boolean flag) {
			this.flag = flag;
		}
	@Override
	public void visit(Paragraphe paragraphe) {
		if(flag==true){
		htmlfile = htmlfile +"<H4>"+ paragraphe.getName() +"</H4>";
		}
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
