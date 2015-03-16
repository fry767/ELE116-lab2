package ab2;

public class main {

	  public static void main(String args[]) {
		  swingApplication swing = new swingApplication();
		  Livre livre = new Livre("C:/Users/michael/Desktop/allo.xml");
		  livre.accept(new BookElementPrintVisitor());

	  }
}
