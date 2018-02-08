package enums.s01;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class EnumAccessTest {

	@Test
	void testHunderasseV01() {
		assertEquals(3, Hunderasse_v01.values().length);
		for(Hunderasse_v01 h : Hunderasse_v01.values())
			System.out.println(h);
		System.out.println();
	}

	@Test
	void testHunderasseV02() {
		assertEquals(3, Hunderasse_v02.values().length);
		for(Hunderasse_v02 h : Hunderasse_v02.values())
			System.out.println(h);
		System.out.println();
	}

	@Test
	void testHunderasseV03() {
		assertEquals(3, Hunderasse_v03.values().length);
		for(Hunderasse_v03 h : Hunderasse_v03.values())
			System.out.println(h);
		System.out.println();
	}
}

