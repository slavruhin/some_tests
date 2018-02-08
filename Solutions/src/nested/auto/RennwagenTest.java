package nested.auto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RennwagenTest {

	@Test
	void test() {
		String expectedA = "Rennwagen Mercedes. Fahrer: M. Schuhmacher";
	    
		Rennwagen rw = new Rennwagen("Mercedes");
		Rennwagen .Fahrer f = new Rennwagen.Fahrer("M.", "Schuhmacher");
	    rw.setFahrer(f);
	    assertEquals(expectedA, rw.toString());
	    System.out.println(rw);		//Zeile A
	
		String expectedB = "Motor Type1 aus dem Rennwagen Mercedes";
	    Rennwagen.Motor m = rw.getMotor();
	    assertEquals(expectedB, m.toString());
	    System.out.println(m);		//Zeile B
	}
}
