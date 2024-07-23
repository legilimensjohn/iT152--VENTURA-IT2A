package basics;

// Importing classes for image processing and audio playback
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

// Class representing character textures and animations
public class CharacterTexture {
	 // Declare variables for sprite sheets and character images
     SpriteSheet hg, hp;
     // Declaration of BufferedImage objects for character sheets
     private BufferedImage harry_sheet = null;
     private BufferedImage hermione_sheet = null;
     
     // Arrays to store individual frames for each character's actions
     public BufferedImage[] harry = new BufferedImage[14];
     public BufferedImage[] harry_jump = new BufferedImage[18];
     public BufferedImage[] harry_punch = new BufferedImage[18];
     public BufferedImage[] harry_kick = new BufferedImage[18];
     public BufferedImage[] harry_special = new BufferedImage[18];
     public BufferedImage[] hermione = new BufferedImage[16];
     public BufferedImage[] hermione_jump = new BufferedImage[14];
     public BufferedImage[] hermione_punch = new BufferedImage[16];
     public BufferedImage[] hermione_kick = new BufferedImage[13];
     public BufferedImage[] hermione_special = new BufferedImage[16];
     
     // Constructor to load character images and play theme song
     public CharacterTexture() {
    	  // Loading character sheets using ImageLoader class
          ImageLoader loaderHarry = new ImageLoader();
          ImageLoader loaderHermione = new ImageLoader();
          
          // Load sprite sheets for HERWI and Hermione
          try {
               harry_sheet = loaderHarry.loadImage("/assets/HERWI.png");
               hermione_sheet = loaderHermione.loadImage("/assets/GRANGER.png");
          } catch (IOException e) {
               e.printStackTrace();
          }

          // Play the Harry Potter theme song
          try {
               AudioInputStream audioInputStream =
                   AudioSystem.getAudioInputStream(this.getClass().getResource(
                       "/music/Harry-Potter-Theme.wav"));
               Clip clip = AudioSystem.getClip();
               clip.open(audioInputStream);
               clip.start();
          }

          catch (Exception ex) {
          }
          
          // Initialize sprite sheets for both characters
          hp = new SpriteSheet(harry_sheet);
          hg = new SpriteSheet(hermione_sheet);
          
          // Populate character image arrays with specific frames
          getTextures();
     }
     
     // Method to assign specific frames to character image arrays
     public void getTextures() {
          // HARRY STUFF
          // harry looking right
          harry[0] = hp.grabImage(1, 1, 100, 150);
          harry[1] = hp.grabImage(2, 1, 100, 150);
          harry[2] = hp.grabImage(3, 1, 100, 150);
          harry[3] = hp.grabImage(4, 1, 100, 150);
          harry[4] = hp.grabImage(5, 1, 100, 150);
          harry[5] = hp.grabImage(6, 1, 100, 150);
          harry[6] = hp.grabImage(7, 1, 100, 150);

          // harry looking left
          harry[7] = hp.grabImage(1, 7, 100, 150);
          harry[8] = hp.grabImage(2, 7, 100, 150);
          harry[9] = hp.grabImage(3, 7, 100, 150);
          harry[10] = hp.grabImage(4, 7, 100, 150);
          harry[11] = hp.grabImage(5, 7, 100, 150);
          harry[12] = hp.grabImage(6, 7, 100, 150);

          // harry jump
          harry_jump[0] = hp.grabImage(1, 3, 100, 150);
          harry_jump[1] = hp.grabImage(2, 3, 100, 150);
          harry_jump[2] = hp.grabImage(3, 3, 100, 150);
          harry_jump[3] = hp.grabImage(4, 3, 100, 150);
          harry_jump[4] = hp.grabImage(5, 3, 100, 150);
          harry_jump[5] = hp.grabImage(6, 3, 100, 150);
          harry_jump[6] = hp.grabImage(7, 3, 100, 150);
          harry_jump[7] = hp.grabImage(8, 3, 100, 150);
          harry_jump[8] = hp.grabImage(9, 3, 100, 150);

          // harry jump left
          harry_jump[9] = hp.grabImage(1, 9, 100, 150);
          harry_jump[10] = hp.grabImage(2, 9, 100, 150);
          harry_jump[11] = hp.grabImage(3, 9, 100, 150);
          harry_jump[12] = hp.grabImage(4, 9, 100, 150);
          harry_jump[13] = hp.grabImage(5, 9, 100, 150);
          harry_jump[14] = hp.grabImage(6, 9, 100, 150);
          harry_jump[15] = hp.grabImage(7, 9, 100, 150);
          harry_jump[16] = hp.grabImage(8, 9, 100, 150);
          harry_jump[17] = hp.grabImage(9, 9, 100, 150);

          // harry punch right
          harry_punch[0] = hp.grabImage(1, 2, 100, 150);
          harry_punch[1] = hp.grabImage(2, 2, 100, 150);
          harry_punch[2] = hp.grabImage(3, 2, 100, 150);
          harry_punch[3] = hp.grabImage(4, 2, 100, 150);
          harry_punch[4] = hp.grabImage(5, 2, 100, 150);
          harry_punch[5] = hp.grabImage(6, 2, 100, 150);
          harry_punch[6] = hp.grabImage(7, 2, 100, 150);
          harry_punch[7] = hp.grabImage(8, 2, 100, 150);
          harry_punch[8] = hp.grabImage(9, 2, 100, 150);

          // harry punch left
          harry_punch[9] = hp.grabImage(1, 8, 100, 150);
          harry_punch[10] = hp.grabImage(2, 8, 100, 150);
          harry_punch[11] = hp.grabImage(3, 8, 100, 150);
          harry_punch[12] = hp.grabImage(4, 8, 100, 150);
          harry_punch[13] = hp.grabImage(5, 8, 100, 150);
          harry_punch[14] = hp.grabImage(6, 8, 100, 150);
          harry_punch[15] = hp.grabImage(7, 8, 100, 150);
          harry_punch[16] = hp.grabImage(8, 8, 100, 150);
          harry_punch[17] = hp.grabImage(9, 8, 100, 150);

          // harry kick right
          harry_kick[0] = hp.grabImage(1, 4, 100, 150);
          harry_kick[1] = hp.grabImage(2, 4, 100, 150);
          harry_kick[2] = hp.grabImage(3, 4, 100, 150);
          harry_kick[3] = hp.grabImage(4, 4, 100, 150);
          harry_kick[4] = hp.grabImage(5, 4, 100, 150);
          harry_kick[5] = hp.grabImage(6, 4, 100, 150);
          harry_kick[6] = hp.grabImage(7, 4, 100, 150);
          harry_kick[7] = hp.grabImage(8, 4, 100, 150);
          harry_kick[8] = hp.grabImage(9, 4, 100, 150);

          // harry kick left
          harry_kick[9] = hp.grabImage(1, 10, 100, 150);
          harry_kick[10] = hp.grabImage(2, 10, 100, 150);
          harry_kick[11] = hp.grabImage(3, 10, 100, 150);
          harry_kick[12] = hp.grabImage(4, 10, 100, 150);
          harry_kick[13] = hp.grabImage(5, 10, 100, 150);
          harry_kick[14] = hp.grabImage(6, 10, 100, 150);
          harry_kick[15] = hp.grabImage(7, 10, 100, 150);
          harry_kick[16] = hp.grabImage(8, 10, 100, 150);
          harry_kick[17] = hp.grabImage(9, 10, 100, 150);

          // harry special right
          harry_special[0] = hp.grabImage(1, 6, 100, 150);
          harry_special[1] = hp.grabImage(2, 6, 100, 150);
          harry_special[2] = hp.grabImage(3, 6, 100, 150);
          harry_special[3] = hp.grabImage(4, 6, 100, 150);
          harry_special[4] = hp.grabImage(5, 6, 100, 150);
          harry_special[5] = hp.grabImage(6, 6, 100, 150);
          harry_special[6] = hp.grabImage(7, 6, 100, 150);
          harry_special[7] = hp.grabImage(8, 6, 100, 150);
          harry_special[8] = hp.grabImage(9, 6, 100, 150);

          // harry special left
          harry_special[9] = hp.grabImage(1, 12, 100, 150);
          harry_special[10] = hp.grabImage(2, 12, 100, 150);
          harry_special[11] = hp.grabImage(3, 12, 100, 150);
          harry_special[12] = hp.grabImage(4, 12, 100, 150);
          harry_special[13] = hp.grabImage(5, 12, 100, 150);
          harry_special[14] = hp.grabImage(6, 12, 100, 150);
          harry_special[15] = hp.grabImage(7, 12, 100, 150);
          harry_special[16] = hp.grabImage(8, 12, 100, 150);
          harry_special[17] = hp.grabImage(9, 12, 100, 150);

          // HERMIONE STUFF
          // hermione looking right
          hermione[0] = hp.grabImage(1, 1, 100, 150);
          hermione[1] = hp.grabImage(2, 1, 100, 150);
          hermione[2] = hp.grabImage(3, 1, 100, 150);
          hermione[3] = hp.grabImage(4, 1, 100, 150);
          hermione[4] = hp.grabImage(5, 1, 100, 150);
          hermione[5] = hp.grabImage(6, 1, 100, 150);
          hermione[6] = hp.grabImage(7, 1, 100, 150);
          hermione[7] = hp.grabImage(8, 1, 100, 150);

          // hermione looking left
          hermione[8] = hp.grabImage(1, 7, 100, 150);
          hermione[9] = hp.grabImage(2, 7, 100, 150);
          hermione[10] = hp.grabImage(3, 7, 100, 150);
          hermione[11] = hp.grabImage(4, 7, 100, 150);
          hermione[12] = hp.grabImage(5, 7, 100, 150);
          hermione[13] = hp.grabImage(6, 7, 100, 150);
          hermione[14] = hp.grabImage(7, 7, 100, 150);
          hermione[15] = hp.grabImage(8, 7, 100, 150);

          // hermione jump
          hermione_jump[0] = hp.grabImage(1, 3, 100, 150);
          hermione_jump[1] = hp.grabImage(2, 3, 100, 150);
          hermione_jump[2] = hp.grabImage(3, 3, 100, 150);
          hermione_jump[3] = hp.grabImage(4, 3, 100, 150);
          hermione_jump[4] = hp.grabImage(5, 3, 100, 150);
          hermione_jump[5] = hp.grabImage(6, 3, 100, 150);
          hermione_jump[6] = hp.grabImage(7, 3, 100, 150);

          // hermione jump left
          hermione_jump[7] = hp.grabImage(1, 9, 100, 150);
          hermione_jump[8] = hp.grabImage(2, 9, 100, 150);
          hermione_jump[9] = hp.grabImage(3, 9, 100, 150);
          hermione_jump[10] = hp.grabImage(4, 9, 100, 150);
          hermione_jump[11] = hp.grabImage(5, 9, 100, 150);
          hermione_jump[12] = hp.grabImage(6, 9, 100, 150);
          hermione_jump[13] = hp.grabImage(7, 9, 100, 150);

          // hermione punch right
          hermione_punch[0] = hp.grabImage(1, 2, 100, 150);
          hermione_punch[1] = hp.grabImage(2, 2, 100, 150);
          hermione_punch[2] = hp.grabImage(3, 2, 100, 150);
          hermione_punch[3] = hp.grabImage(4, 2, 100, 150);
          hermione_punch[4] = hp.grabImage(5, 2, 100, 150);
          hermione_punch[5] = hp.grabImage(6, 2, 100, 150);
          hermione_punch[6] = hp.grabImage(7, 2, 100, 150);
          hermione_punch[7] = hp.grabImage(1, 2, 100, 150);

          // hermione punch left
          hermione_punch[8] = hp.grabImage(1, 8, 100, 150);
          hermione_punch[9] = hp.grabImage(2, 8, 100, 150);
          hermione_punch[10] = hp.grabImage(3, 8, 100, 150);
          hermione_punch[11] = hp.grabImage(4, 8, 100, 150);
          hermione_punch[12] = hp.grabImage(5, 8, 100, 150);
          hermione_punch[13] = hp.grabImage(6, 8, 100, 150);
          hermione_punch[14] = hp.grabImage(7, 8, 100, 150);
          hermione_punch[15] = hp.grabImage(8, 8, 100, 150);

          // hermione kick right
          hermione_kick[0] = hp.grabImage(1, 4, 100, 150);
          hermione_kick[1] = hp.grabImage(2, 4, 100, 150);
          hermione_kick[2] = hp.grabImage(3, 4, 100, 150);
          hermione_kick[3] = hp.grabImage(4, 4, 100, 150);
          hermione_kick[4] = hp.grabImage(5, 4, 100, 150);
          hermione_kick[5] = hp.grabImage(6, 4, 100, 150);
          hermione_kick[6] = hp.grabImage(7, 4, 100, 150);

          // hermione kick left
          hermione_kick[7] = hp.grabImage(1, 10, 100, 150);
          hermione_kick[8] = hp.grabImage(2, 10, 100, 150);
          hermione_kick[9] = hp.grabImage(3, 10, 100, 150);
          hermione_kick[10] = hp.grabImage(4, 10, 100, 150);
          hermione_kick[11] = hp.grabImage(5, 10, 100, 150);
          hermione_kick[12] = hp.grabImage(6, 10, 100, 150);

          // hermione special right
          hermione_special[0] = hp.grabImage(1, 6, 100, 150);
          hermione_special[1] = hp.grabImage(2, 6, 100, 150);
          hermione_special[2] = hp.grabImage(3, 6, 100, 150);
          hermione_special[3] = hp.grabImage(4, 6, 100, 150);
          hermione_special[4] = hp.grabImage(5, 6, 100, 150);
          hermione_special[5] = hp.grabImage(6, 6, 100, 150);
          hermione_special[6] = hp.grabImage(7, 6, 100, 150);
          hermione_special[7] = hp.grabImage(8, 6, 100, 150);

          // hermione special left
          hermione_special[8] = hp.grabImage(1, 12, 100, 150);
          hermione_special[9] = hp.grabImage(2, 12, 100, 150);
          hermione_special[10] = hp.grabImage(3, 12, 100, 150);
          hermione_special[11] = hp.grabImage(4, 12, 100, 150);
          hermione_special[12] = hp.grabImage(5, 12, 100, 150);
          hermione_special[13] = hp.grabImage(6, 12, 100, 150);
          hermione_special[14] = hp.grabImage(7, 12, 100, 150);
          hermione_special[15] = hp.grabImage(8, 12, 100, 150);

          // looking right
          hermione[0] = hp.grabImage(1, 1, 100, 150);
          hermione[1] = hp.grabImage(2, 1, 100, 150);
          hermione[2] = hp.grabImage(3, 1, 100, 150);
          hermione[3] = hp.grabImage(4, 1, 100, 150);
          hermione[4] = hp.grabImage(5, 1, 100, 150);
          hermione[5] = hp.grabImage(6, 1, 100, 150);
          hermione[6] = hp.grabImage(7, 1, 100, 150);
          hermione[7] = hp.grabImage(8, 1, 100, 150);

          // looking left
          hermione[8] = hp.grabImage(1, 7, 100, 150);
          hermione[9] = hp.grabImage(2, 7, 100, 150);
          hermione[10] = hp.grabImage(3, 7, 100, 150);
          hermione[11] = hp.grabImage(4, 7, 100, 150);
          hermione[12] = hp.grabImage(5, 7, 100, 150);
          hermione[13] = hp.grabImage(6, 7, 100, 150);
          hermione[14] = hp.grabImage(7, 7, 100, 150);
          hermione[15] = hp.grabImage(8, 7, 100, 150);

          // hermione jump
          hermione_jump[0] = hp.grabImage(1, 3, 100, 150);
          hermione_jump[1] = hp.grabImage(2, 3, 100, 150);
          hermione_jump[2] = hp.grabImage(3, 3, 100, 150);
          hermione_jump[3] = hp.grabImage(4, 3, 100, 150);
          hermione_jump[4] = hp.grabImage(5, 3, 100, 150);
          hermione_jump[5] = hp.grabImage(6, 3, 100, 150);
          hermione_jump[6] = hp.grabImage(7, 3, 100, 150);

          // hermione jump left
          hermione_jump[7] = hp.grabImage(1, 9, 100, 150);
          hermione_jump[8] = hp.grabImage(2, 9, 100, 150);
          hermione_jump[9] = hp.grabImage(3, 9, 100, 150);
          hermione_jump[10] = hp.grabImage(4, 9, 100, 150);
          hermione_jump[11] = hp.grabImage(5, 9, 100, 150);
          hermione_jump[12] = hp.grabImage(6, 9, 100, 150);
          hermione_jump[13] = hp.grabImage(7, 9, 100, 150);

          // hermione punch right
          hermione_punch[0] = hp.grabImage(1, 2, 100, 150);
          hermione_punch[1] = hp.grabImage(2, 2, 100, 150);
          hermione_punch[2] = hp.grabImage(3, 2, 100, 150);
          hermione_punch[3] = hp.grabImage(4, 2, 100, 150);
          hermione_punch[4] = hp.grabImage(5, 2, 100, 150);
          hermione_punch[5] = hp.grabImage(6, 2, 100, 150);
          hermione_punch[6] = hp.grabImage(7, 2, 100, 150);
          hermione_punch[7] = hp.grabImage(8, 2, 100, 150);

          // hermione punch left
          hermione_punch[8] = hp.grabImage(1, 8, 100, 150);
          hermione_punch[9] = hp.grabImage(2, 8, 100, 150);
          hermione_punch[10] = hp.grabImage(3, 8, 100, 150);
          hermione_punch[11] = hp.grabImage(4, 8, 100, 150);
          hermione_punch[12] = hp.grabImage(5, 8, 100, 150);
          hermione_punch[13] = hp.grabImage(6, 8, 100, 150);
          hermione_punch[14] = hp.grabImage(7, 8, 100, 150);
          hermione_punch[15] = hp.grabImage(8, 8, 100, 150);

          // hermione kick right
          hermione_kick[0] = hp.grabImage(1, 4, 100, 150);
          hermione_kick[1] = hp.grabImage(2, 4, 100, 150);
          hermione_kick[2] = hp.grabImage(3, 4, 100, 150);
          hermione_kick[3] = hp.grabImage(4, 4, 100, 150);
          hermione_kick[4] = hp.grabImage(5, 4, 100, 150);
          hermione_kick[5] = hp.grabImage(6, 4, 100, 150);
          hermione_kick[6] = hp.grabImage(7, 4, 100, 150);

          // hermione kick left
          hermione_kick[7] = hp.grabImage(1, 10, 100, 150);
          hermione_kick[8] = hp.grabImage(2, 10, 100, 150);
          hermione_kick[9] = hp.grabImage(3, 10, 100, 150);
          hermione_kick[10] = hp.grabImage(4, 10, 100, 150);
          hermione_kick[11] = hp.grabImage(5, 10, 100, 150);
          hermione_kick[12] = hp.grabImage(6, 10, 100, 150);

          // hermione special right
          hermione_special[0] = hp.grabImage(1, 6, 100, 150);
          hermione_special[1] = hp.grabImage(2, 6, 100, 150);
          hermione_special[2] = hp.grabImage(2, 6, 100, 150);
          hermione_special[3] = hp.grabImage(3, 6, 100, 150);
          hermione_special[4] = hp.grabImage(4, 6, 100, 150);
          hermione_special[5] = hp.grabImage(5, 6, 100, 150);
          hermione_special[6] = hp.grabImage(6, 6, 100, 150);
          hermione_special[7] = hp.grabImage(7, 6, 100, 150);
          hermione_special[8] = hp.grabImage(8, 6, 100, 150);

          // hermione special left
          hermione_special[9] = hp.grabImage(1, 12, 100, 150);
          hermione_special[10] = hp.grabImage(2, 12, 100, 150);
          hermione_special[11] = hp.grabImage(3, 12, 100, 150);
          hermione_special[12] = hp.grabImage(4, 12, 100, 150);
          hermione_special[13] = hp.grabImage(5, 12, 100, 150);
          hermione_special[14] = hp.grabImage(6, 12, 100, 150);
          hermione_special[15] = hp.grabImage(7, 12, 100, 150);
          hermione_special[16] = hp.grabImage(8, 12, 100, 150);
     }
}
