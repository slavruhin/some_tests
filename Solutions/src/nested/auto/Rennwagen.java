package nested.auto;

public class Rennwagen {

	String type;
	Fahrer fahrer;
	Motor motor;

	class Motor {
		String type;
		Motor(String type) {
			this.type = type;
		}
		
		@Override
		public String toString() {
			return String.format("Motor %s aus dem Rennwagen %s", type, Rennwagen.this.type);
		}
	}

	static class Fahrer {
		String Vorname, Nachname;
		
		public Fahrer(String Vorname, String Nachname) {
			this.Vorname  = Vorname;
			this.Nachname  = Nachname;
		}
	}
	
	public Rennwagen(String type) {
		this.type = type;
		motor = new Motor("type1");
		fahrer = new Fahrer("", "");
	}
	
	void setFahrer(Fahrer fahrer) {
		this.fahrer = fahrer;
	}
	
	Motor getMotor() {
		return motor;
	}
	
	@Override
	public String toString() {
		return String.format("Rennwagen %s. Fahrer: %s %s", type, fahrer.Vorname, fahrer.Nachname);
	}
}
