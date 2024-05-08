package hw4;

import java.awt.Rectangle;
import api.AbstractElement;

/**
 * An element in which the <code>update</code> method updates the position each
 * frame according to a <em>velocity</em> vector (deltaX, deltaY). The units are
 * assumed to be "pixels per frame".
 * 
 * @author Anthony Phan
 */

public class MovingElement extends SimpleElement {

	private double velocityX;
	private double velocityY;

	/**
	 * Constructs a MovingElement with a default velocity of zero in both
	 * directions.
	 * 
	 * @param x      x-coordinate of upper left corner
	 * @param y      y-coordinate of upper left corner
	 * @param width  object's width
	 * @param height object's height
	 */
	
	public MovingElement(double x, double y, int width, int height) {
		super(x, y, width, height);
		this.velocityX = 0.0;
		this.velocityY = 0.0;
	}

	/**
	 * Returns the x-component 
	 * 
	 * @return
	 */
	
	public double getDeltaX() {
		return velocityX;
	}

	/**
	 * returns the y-component 
	 * 
	 * @return
	 */
	public double getDeltaY() {
		return velocityY;
	}

	/**
	 * Sets the velocity for this object
	 * 
	 * @param deltaX
	 * @param deltaY
	 */
	
	public void setVelocity(double deltaX, double deltaY) {
		this.velocityX = deltaX;
		this.velocityY = deltaY;
	}

	@Override
	public void update() {
		double newX = getXReal() + velocityX;
		double newY = getYReal() + velocityY;
		setPosition(newX, newY);
		super.update();
	}
}
