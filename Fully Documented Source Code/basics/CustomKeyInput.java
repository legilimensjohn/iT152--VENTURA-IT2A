/**
 * The CustomKeyInput class extends KeyAdapter and acts as an intermediary between 
 * the game's keyboard input handling and the main Game class.
 * It accepts the Game instance as a parameter and delegated key events such key presses and releases to the Game class's relevant methods.
 * This enables the Game class to respond to keyboard input events and apply specified actions or behaviors during gameplay based on user key inputs.
 */

package basics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CustomKeyInput extends KeyAdapter {
     Game customGame;
     
     /**
      * Constructor for CustomKeyInput that takes a Game instance as a parameter.
      * @param customGame The Game instance to associate with this CustomKeyInput.
      */
     public CustomKeyInput(Game customGame) {
          this.customGame = customGame;
     }

     /**
      * Overrides the keyPressed method in KeyAdapter and delegates the key event
      * to the corresponding method in the associated Game instance.
      * @param e The KeyEvent representing the key press event.
      */
     public void keyPressed(KeyEvent e) {
          customGame.keyPressed(e);
     }

     /**
      * Overrides the keyReleased method in KeyAdapter and delegates the key event
      * to the corresponding method in the associated Game instance.
      * @param e The KeyEvent representing the key release event.
      */
     public void keyReleased(KeyEvent e) {
          customGame.keyReleased(e);
     }
}