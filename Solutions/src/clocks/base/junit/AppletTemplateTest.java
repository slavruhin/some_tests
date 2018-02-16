package clocks.base.junit;

import java.awt.*;
import clocks.base.*;

public class AppletTemplateTest extends AppletTemplate {

	CircleRadials radials;
	CirclePoints points;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void extendedInit() {
		super.extendedInit();
		
		points = new CirclePoints(new clocks.base.Point(center.x, center.y), center.x * 0.97, 0, 360, 12);
		for(java.awt.Point r : points.getAwtArray())
			System.out.println(r);
		System.out.println();

		radials = new CircleRadials(new clocks.base.Point(center.x, center.y), center.x * 0.9, center.x * 0.95, 0, 360, 30);
		for(AwtRadial r : radials.getAwtArray())
			System.out.println(r);
		System.out.println();
	}
	
	@Override
	public void drawImage() {
		super.drawImage();
		
		offscreen.setColor(java.awt.Color.BLUE);
		for(AwtRadial r : radials.getAwtArray()) {
			((Graphics2D)offscreen).setStroke(new BasicStroke(6.0f));
			offscreen.drawLine(Math.round(r.point1.x), Math.round(r.point1.y), Math.round(r.point2.x), Math.round(r.point2.y));
		}

		offscreen.setColor(java.awt.Color.RED);
		for(java.awt.Point p : points.getAwtArray()) {
			AwtSquare sq = new AwtSquare(p, 10);
			//offscreen.fillOval(sq.point1.x, sq.point1.x, 10, 10);
			offscreen.drawRect(sq.point1.x, sq.point1.x, 10, 10);
		}
	}

}
