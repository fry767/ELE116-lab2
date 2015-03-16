package ab2;

public class Auteur implements BookElement {
	private String name;
	public Auteur (String name) {
		this.name = name;
		}
	public String getName() {
		return this.name;
		}
	@Override
	public void accept(BookElementVisitor visitor) {
		visitor.visit(this);

	}


}
