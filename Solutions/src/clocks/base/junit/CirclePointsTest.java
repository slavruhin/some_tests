package clocks.base.junit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import clocks.base.*;

public class CirclePointsTest {

	@Test
	public void testGeometricBase() {

		int gradStart = 0, gradEnd = 360, gradStep = 60;
		assertEquals(6, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));

		gradEnd = 361;
		assertEquals(7, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));

	    gradStart = 360; gradEnd = 0; gradStep = 60;
		assertEquals(6, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));

	    gradStart = 361; gradEnd = 0; gradStep = 60;
		assertEquals(7, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));

	    gradStart = 360; gradEnd = 0; gradStep = 360;
		assertEquals(1, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));

	    gradStart = 360; gradEnd = 0; gradStep = 0;
		assertEquals(0, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));
	
	    gradStart = 360; gradEnd = 0; gradStep = 380;
		assertEquals(0, GeometricBase.getSegmentNumber(gradStart, gradEnd, gradStep));
	}

	@Test
	public void testCircle() {
		CirclePoints circle = new CirclePoints(200, 200,100, 360, 0, -30);
		System.out.println(circle);
		System.out.println();
		
		circle = new CirclePoints(200, 200,100, 360, 0, -50);
		System.out.println(circle);
		System.out.println();
		
		circle = new CirclePoints(200, 200,100, 0, 360, 90);
		System.out.println(circle);
		System.out.println();
	}

	@Test
	public void testCirclePoints() {
		CirclePoints circle = new CirclePoints(new Point(200, 200), 100, 0, 360, 90);
		System.out.println(circle);
		System.out.println();
	}

	@Test
	public void testRadials() {
		CirclePoints circle = new CirclePoints(200, 200,100, 0, 360, 10);
		System.out.println(circle);
		System.out.println();
		
		CircleRadials radials = new CircleRadials(new Point(200, 200), 80, 100, 0, 360, 10);
		System.out.println(radials);
		System.out.println();
	}
}
