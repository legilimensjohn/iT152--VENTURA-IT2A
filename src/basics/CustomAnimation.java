/**
 * The `CustomAnimation` class facilitates the implementation of a simple custom animation
 * using a series of BufferedImage frames. It allows for easy creation and rendering of
 * animations with specified speed and frame images.
 */

package basics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class CustomAnimation {
	
	 // Fields to store animation parameters and state
     private int animationSpeed;
     private int totalFrames;
     private int currentIndex = 0;
     private int frameCount = 0;
     private BufferedImage[] animationFrames;
     private BufferedImage currentFrame;
     
     /**
      * Constructor for the `CustomAnimation` class.
      *
      * @param speed        The speed of the animation, controlling the frame transition rate.
      * @param frameImages  Variable number of BufferedImage frames for the animation.
      */

     public CustomAnimation(int speed, BufferedImage... frameImages) {
          this.animationSpeed = speed;
          animationFrames = new BufferedImage[frameImages.length];
          for (int i = 0; i < frameImages.length; i++) {
               animationFrames[i] = frameImages[i];
          }
          totalFrames = frameImages.length;
     }
     

     /**
      * Runs the animation, updating the current frame based on the animation speed.
      * This method is typically called in a game loop to advance the animation.
      */
     public void runAnimation() {
          currentIndex++;
          if (currentIndex > animationSpeed) {
               currentIndex = 0;
               nextFrame();
          }
     }
    
     //Updates the current frame to the next frame in the animation sequence.
     private void nextFrame() {
          currentFrame = animationFrames[frameCount % totalFrames];
          frameCount++;
     }
     
     /**
      * Draws the current frame of the animation at the specified coordinates.
      *
      * @param g  The Graphics object used for drawing.
      * @param x  The x-coordinate for rendering the animation.
      * @param y  The y-coordinate for rendering the animation.
      */
     public void drawAnimation(Graphics g, int x, int y) {
          g.drawImage(currentFrame, x, y, null);
     }
}
