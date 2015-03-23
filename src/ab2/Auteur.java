package ab2;
// élément concret
public class Auteur implements BookElement {
	private String name;

	public Auteur(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// on accepte le visiteur
	@Override
	public void accept(BookElementVisitor visitor) {
		visitor.visit(this);

	}

}
