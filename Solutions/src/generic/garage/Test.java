package generic.garage;

public class Test {

	public static void main(String[] args) {

		Garage<PKW> pkwGarage = new Garage<PKW>();
		Garage<LKW> lkwGarage = new Garage<LKW>();
		
		PKW pkw = new PKW();
		LKW lkw = new LKW();
		
		pkwGarage.reinfahren(pkw);
		//pkwGarage.reinfahren(lkw);

		lkwGarage.reinfahren(lkw);
		//lkwGarage.reinfahren(pkw);

		//lkwGarage.reinfahren(new Object());
	}

}
