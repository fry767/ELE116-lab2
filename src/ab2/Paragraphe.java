package ab2;

public class Paragraphe implements ChapiterElement {
	private String name;

	public Paragraphe(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	// on accepte le visiteur
	@Override
	public void accept(ChapiterElementVisitor visitor) {
		visitor.visit(this);

	}

}
