package decorating;

public class Decaf extends Beverage{

	public Decaf() {
		super();
		description = "Decaf";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.20;
	}
	
	

}
