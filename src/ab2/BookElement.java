package ab2;

// interface de book
public interface BookElement {
	void accept(BookElementVisitor visitor);
}
