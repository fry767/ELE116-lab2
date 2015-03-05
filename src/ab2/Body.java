package ab2;

public class Body implements CarElement{
	public void accept(CarElementVisitor visitor) {
		visitor.visit(this); 
		}

}
