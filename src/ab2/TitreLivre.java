package ab2;

public class TitreLivre implements BookElement {
	private String name;
	public TitreLivre(String name) {
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
