/**
 * The CustomMouseInput class implements the MouseListener interface to handle mouse events
 * for the game's menu and character selection screens.
 */

package basics;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MouseInput implements MouseListener {
     private int customChoicePlayer1, customChoicePlayer2;

     /**
      * Invoked when the mouse button is released.
      * @param e The MouseEvent representing the mouse event.
      */
     public void mouseReleased(MouseEvent e) {}

     /**
      * Invoked when the mouse button is clicked.
      * @param e The MouseEvent representing the mouse event.
      */
     public void mouseClicked(MouseEvent e) {}

     /**
      * Invoked when the mouse enters a component.
      * @param e The MouseEvent representing the mouse event.
      */
     public void mouseEntered(MouseEvent e) {}

     /**
      * Invoked when the mouse exits a component.
      * @param e The MouseEvent representing the mouse event.
      */
     public void mouseExited(MouseEvent e) {}

     /**
      * Invoked when a mouse button is pressed.
      * Handles mouse clicks based on the game state.
      * @param e The MouseEvent representing the mouse event.
      */
     public void mousePressed(MouseEvent e) {
          int mouseX = e.getX();
          int mouseY = e.getY();

          if (Game.State == Game.STATE.MENU) {
               if (mouseX >= 41 && mouseX <= 172) {
                    if (mouseY >= 225 && mouseY <= 294) {
                         // play button
                         Game.State = Game.STATE.CHARSELECT1;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                            		  (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
               if (mouseX >= 41 && mouseX <= 172) {
                    if (mouseY >= 312 && mouseY <= 381) {
                         // options
                    }
               }
               if (mouseX >= 41 && mouseX <= 172) {
                    if (mouseY >= 400 && mouseY <= 469) {
                         System.exit(1);
                         // exit
                    }
               }
          } else if (Game.State == Game.STATE.CHARSELECT1) {
               if (mouseY >= 535 && mouseY <= 577) {
                    if (mouseX >= 22 && mouseX <= 89) {
                         // back button
                         Game.State = Game.STATE.MENU;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                            		  (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
               if (mouseY >= 24 && mouseY <= 270) {
                    if (mouseX >= 244 && mouseX <= 379) {
                         // back button
                         Game.State = Game.STATE.CHARSELECT2;
                         Game.ChoiceP1 = Game.CHOICEP1.HARRYP1;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                            		  (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
               if (mouseY >= 24 && mouseY <= 270) {
                    if (mouseX >= 410 && mouseX <= 545) {
                         // back button
                         Game.State = Game.STATE.CHARSELECT2;
                         Game.ChoiceP1 = Game.CHOICEP1.HERMIONEP1;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                                  (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
          } else if (Game.State == Game.STATE.CHARSELECT2) {
               if (mouseY >= 535 && mouseY <= 577) {
                    if (mouseX >= 22 && mouseX <= 89) {
                         // back button
                         Game.State = Game.STATE.MENU;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                                      (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
               if (mouseY >= 24 && mouseY <= 270) {
                    if (mouseX >= 244 && mouseX <= 379) {
                         Game.State = Game.STATE.CHOOSE;
                         Game.ChoiceP2 = Game.CHOICEP2.HARRYP2;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                                      (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
               if (mouseY >= 24 && mouseY <= 270) {
                    if (mouseX >= 410 && mouseX <= 545) {
                         Game.State = Game.STATE.CHOOSE;
                         Game.ChoiceP2 = Game.CHOICEP2.HERMIONEP2;
                         try {
                              AudioInputStream audioInputStream = AudioSystem.getAudioInputStream
                                      (this.getClass().getResource("/music/select.wav"));
                              Clip clip = AudioSystem.getClip();
                              clip.open(audioInputStream);
                              clip.start();
                         } catch (Exception ex) {
                         }
                    }
               }
          }
     }
}