package ab2;

public class Engine implements CarElement {
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this);
		}

}
