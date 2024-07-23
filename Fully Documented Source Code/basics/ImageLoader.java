//The ImageLoader class is responsible for loading images from file paths.
package basics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

//The ImageLoader class is responsible for loading images from file paths.
public class ImageLoader {
     private BufferedImage loadedImage;
     
     /**
      * Loads an image from the specified file path.
      * @param path The file path of the image to be loaded.
      * @return The loaded BufferedImage.
      * @throws IOException If an error occurs during image loading.
      */
     public BufferedImage loadImage(String path) throws IOException {
          loadedImage = ImageIO.read(getClass().getResource(path));
          return loadedImage;
     }
}