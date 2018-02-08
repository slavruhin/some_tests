package nested.auto;

public class Rennwagen {

	private String hersteller;
	private Fahrer fahrer;
	private Motor motor;

	class Motor {
		String type;
		
		Motor(String type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return String.format("Motor %s aus dem Rennwagen %s", type, hersteller);
		}
	}

	static class Fahrer {
		String Vorname = "", Nachname = "";
		
		public Fahrer() {}
		public Fahrer(String Vorname, String Nachname) {
			this.Vorname  = Vorname;
			this.Nachname  = Nachname;
		}
		@Override
		public String toString() {
			return String.format("%s %s", Vorname, Nachname);
		}
	}
	
	public Rennwagen(String hersteller) {
		this(hersteller, "Type1");
	}
	public Rennwagen(String hersteller, String motorType) {
		this.hersteller = hersteller;
		motor = new Motor(motorType);
		fahrer = new Fahrer();
	}
	
	void setFahrer(Fahrer fahrer) {
		this.fahrer = fahrer;
	}
	
	Motor getMotor() {
		return motor;
	}
	
	@Override
	public String toString() {
		return String.format("Rennwagen %s. Fahrer: %s", hersteller, fahrer);
	}
}
