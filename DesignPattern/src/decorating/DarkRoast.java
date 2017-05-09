package decorating;

public class DarkRoast extends Beverage{

	
	public DarkRoast() {
		super();
		description = "Dark Roast";
	}

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 2.30;
	}

}
