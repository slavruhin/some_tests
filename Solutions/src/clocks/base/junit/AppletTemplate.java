package clocks.base.junit;

import java.applet.Applet;
import java.awt.*;

public class AppletTemplate extends Applet implements Runnable {
	final int DefaultCenterX = 300;
	final int DefaultCenterY = 300;
	final Color DefaultBackground = Color.LIGHT_GRAY;
	
	// default position of center
	java.awt.Point center = new java.awt.Point(DefaultCenterX, DefaultCenterY);
	// setz default background
	Color background = DefaultBackground;
	
	// double buffering
	Image offscreenImg;
	Graphics offscreen;

	Thread runner;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() {
		
		try {
			// Set window size:
			setSize(center.x * 2, center.x * 2);
			
			// TODO: additional initializing
			extendedInit();

			offscreenImg = createImage(getSize().width, getSize().height);
			offscreen = offscreenImg.getGraphics();
		}
		catch (Exception e) 
		{
			System.err.println("An exception occurred while initialize Circle-objects.");
		}
	}
	
	/**
	 * 
	 */
	public void extendedInit() {
	}


	@Override
	public void start() {
		if(runner == null) {
			runner = new Thread(this);
			runner.start();
		}
	}
	
	@Override
	public void stop() {
		if(runner != null)
			runner = null;
	}

	@Override
	public void run() {
		Thread curr = Thread.currentThread();
		
		while(runner == curr) {

			repaint();
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
			}
		}
	}
	
//	@Override
//	public void repaint() {
//		// TODO Auto-generated method stub
//		super.repaint();
//	}
	
//	@Override
//	public void repaint(int x, int y, int width, int height) {
//		// TODO Auto-generated method stub
//		super.repaint(x, y, width, height);
//	}
	
	@Override
	public void paint(Graphics g) {

		// Clear old array in buffer
		offscreen.clearRect(0, 0, getWidth(), getHeight());

		// Draw buffer 
		drawImage();
		
		// Draw buffer into window
		g.drawImage(offscreenImg,  0,  0,  this);
	}

	/**
	 * 
	 */
    public void drawImage() {
		offscreen.setColor(background);
		offscreen.fillRect(0, 0,getWidth(), getHeight());
    }
}
