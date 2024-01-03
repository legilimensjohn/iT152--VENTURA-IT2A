/**
 * The `CustomCharacterSelection` class facilitates character selection in the game by defining
 * clickable rectangles for different characters and rendering character-specific text.
 */

package basics;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CustomCharacterSelection {
	
	 // Define public rectangles for character buttons
     public Rectangle backButton = new Rectangle(22, 535, 67, 42);
     public Rectangle harryButton = new Rectangle(244, 24, 379 - 244, 270 - 24);
     public Rectangle hermioneButton = new Rectangle(410, 24, 379 - 244, 270 - 24);
     
     /**
      * Renders character selection buttons and displays character-specific text
      * based on the current game state.
      *
      * @param g The graphics context used for rendering.
      */
     public void render(Graphics g) {
          Graphics2D g2d = (Graphics2D) g;
          
          // Draw rectangles for character buttons
          g2d.draw(backButton);
          g2d.draw(harryButton);
          g2d.draw(hermioneButton);
          
          // Display character-specific text based on the game state
          if (Game.State == Game.STATE.CHARSELECT1) {
               g.setFont(new Font("Verdana", Font.BOLD, 20));
               g.setColor(Color.white);
               g.drawString("HERWI POTAH select.", 320, 340);
          } else if (Game.State == Game.STATE.CHARSELECT2) {
               g.setFont(new Font("Verdana", Font.BOLD, 20));
               g.setColor(Color.white);
               g.drawString("HR MAI UHNEE GRAYNJR select.", 320, 340);
          }
     }
}
