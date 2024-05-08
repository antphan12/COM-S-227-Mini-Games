package hw4;

/**
 * Moving element in which the vertical velocity is adjusted each frame by a
 * gravitational constant to simulate gravity. The element can be set to
 * "grounded", meaning gravity will no longer influence its velocity.
 * 
 * @author Anthony Phan
 */
//TODO: This class must directly or indirectly extend AbstractElement
public class FlyingElement extends MovingElement {
	private boolean onGround;
	private double gravity;

	/**
	 * Constructs a new FlyingElement. By default it should be grounded, meaning
	 * gravity does not influence its velocity.
	 * 
	 * @param x; x-coordinate of upper left corner
	 * @param y;y-coordinate of upper left corner
	 * @param width  element's width
	 * @param height element's height
	 */
	
	public FlyingElement(double x, double y, int width, int height) {
		super(x, y, width, height); 
		this.gravity = 0.0;
		this.onGround = false;

	}

	/**
	 * Updates the position
	 */
	
	@Override
	public void update() {
		super.update();
		if (!onGround) {
			setVelocity(getDeltaX(), getDeltaY() + gravity);
		}
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

	public void setGrounded(boolean grounded) {
		this.onGround = grounded;
	}

	public boolean isGrounded() {
		return onGround;
	}


}