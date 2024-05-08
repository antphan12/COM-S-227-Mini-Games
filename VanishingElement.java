package hw4;

import api.AbstractElement;

/**
 * An element that does not move. Instead, it is intended to appear on the
 * screen for a fixed number of frames.
 * 
 * @author Anthony Phan
 */

public class VanishingElement extends SimpleElement{
    private int lifeRemaining;
    
	/**
	 * Constructs a new VanishingElement.
	 * @param x x-coordinate of upper left corner
	 * @param y y-coordinate of upper left corner
	 * @param width       element's width
	 * @param height      element's height
	 * @param initialLife the number of frames until this element marks itself for
	 *                    deletion
	 */
    
	public VanishingElement(double x, double y, int width, int height, int initialLife) {
        super(x, y, width, height); 
        this.lifeRemaining = initialLife; 
	}

    /**
     * Decreases the remaining life of this element by one frame.
     */
	
    @Override
    public void update() {
    	super.update();
        lifeRemaining--;
        if (lifeRemaining <= 0) {
            markForDeletion();
        }
    }

    /**
     * Returns the number of frames remaining for this element to disappear.
     * 
     * @return the remaining life of this element
     */
    
    protected int getLifeRemaining() {
        return lifeRemaining;
    }

    /**
     * Marks this element for deletion.
     */
    @Override
    public void markForDeletion() {
        super.markForDeletion(); //Calling the super class
    }


}
