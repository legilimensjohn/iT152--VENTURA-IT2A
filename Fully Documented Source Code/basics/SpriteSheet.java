/*
 * The 'SpriteSheet' class has functionality for interacting with sprite sheets and extracting individual sprites from them.
 */
package basics;
import java.awt.image.BufferedImage;

public class SpriteSheet {
	 // The source image from which to extract sprites
     private BufferedImage customImage;

     // Constructor to initialize the SpriteSheet with a BufferedImage
     public SpriteSheet(BufferedImage customImage) {
          this.customImage = customImage;
     }

     // Method to extract a specific image region from the sprite sheet
     public BufferedImage extractImage(
         int col, int row, int width, int height) {
    	  // Get the subimage based on the specified column, row, width, and height
          BufferedImage img = customImage.getSubimage(
              (col * width) - width, (row * height) - height, width, height);
          return img;
     }

     // Placeholder method (TODO: Implement) for grabbing an image using specific parameters
     public BufferedImage grabImage(int i, int j, int k, int l) {
          // TODO Auto-generated method stub
    	  // This method is not implemented yet, and returns null
          // It can be completed with the logic to grab a specific image based on parameters
          // such as coordinates (i, j) and dimensions (k, l)
          return null;
     }
}