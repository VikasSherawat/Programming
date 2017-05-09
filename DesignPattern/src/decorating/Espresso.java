package decorating;

public class Espresso extends Beverage{

	
	public Espresso() {
		super();
		description = "Espresso";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 1.99;
	}

}
