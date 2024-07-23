/*
 * The Menu class represents the game's main menu and is in charge of producing graphical components such as buttons on the screen. 
 */
package basics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu {
	
	 // Rectangle objects defining the play, options, and exit buttons
     public Rectangle customPlayButton = new Rectangle(70, 230, 135, 79);
     public Rectangle customOptionsButton = new Rectangle(70, 312, 131, 79);
     public Rectangle customExitButton = new Rectangle(70, 400, 131, 79);
     
     // Renders graphical elements on the screen
     public void render(Graphics g) {
    	 
    	  // Graphics2D object for advanced graphics rendering
          Graphics2D g2d = (Graphics2D) g;
          
          // Draw outlines of play, options, and exit buttons
          g2d.draw(customPlayButton);
          g2d.draw(customOptionsButton);
          g2d.draw(customExitButton);
     }
}