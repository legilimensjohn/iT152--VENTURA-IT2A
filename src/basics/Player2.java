/*
 * The Player2 class is similar to the 'Player' class, except it represents the game's second player.
 * It contains the second player's properties and actions, such as their location, movement, and animations.
 * It provides boolean flags to regulate the player's status, similar to the 'Player' class, such as jumping or executing certain attacks.
 * Walking, leaping, and different attacks are assigned based on the character selected by the second player during setup.
 * The class offers methods for initialization, updating the player's state, generating their animations, and accessing and altering player
 * properties via getter and setter methods. 'Player2' contains the key functions and visual characteristics of the game's player-controlled 
 * characters, focused on the second player's character.
 */
package basics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player2 {
	 private double x2;  // X-coordinate of Player2
     private double y2;  // Y-coordinate of Player2
     public int facing2 = 0; // Direction Player2 is facing (0 for left, 1 for right)

     private boolean jumping2;  // Flag indicating if Player2 is jumping
     private boolean hasChosen = false;  // Flag indicating if Player2 has chosen a character

     private double velX2 = 0;  // Velocity of Player2 along the X-axis
     private double velY2 = 0;  // Velocity of Player2 along the Y-axis

     public boolean punch2 = false;  // Flag indicating if Player2 is punching
     public boolean kick2 = false;   // Flag indicating if Player2 is kicking
     public boolean special2 = false;  // Flag indicating if Player2 is performing a special move
     public boolean strafe2 = false;   // Flag indicating if Player2 is strafing
     public boolean inAction2 = false;  // Flag indicating if Player2 is in an action state

     CharacterTexture tex = Game.getInstance();  // Instance of CharacterTexture for accessing textures

     // Animations for various movements and attacks
     private CustomAnimation playerWalk, playerWalkLeft, playerJump, playerJumpLeft, playerStillLeft, playerStill;
     private CustomAnimation playerPunch, playerPunchLeft, playerKick, playerKickLeft, playerSpecial, playerSpecialLeft;

     // Constructor for Player2
     public Player2(double x2, double y2) {
          this.x2 = x2;
          this.y2 = y2;
     
          // Check if Player2 has chosen a character
          if (!hasChosen) {
        	  // Assign animations based on the character chosen by Player2 during setup
               if (Game.ChoiceP2 == Game.CHOICEP2.HARRYP2) {
                    System.out.println("Player 2 has chosen Harry");
                    // Initialize animations for Harry's movements and attacks
                    playerWalk = new CustomAnimation(5, tex.harry[0],
                        tex.harry[1], tex.harry[2], tex.harry[3], tex.harry[4],
                        tex.harry[5], tex.harry[6]);
                    playerWalkLeft = new CustomAnimation(5, tex.harry[7],
                        tex.harry[8], tex.harry[9], tex.harry[10],
                        tex.harry[11], tex.harry[12]);
                    playerJump = new CustomAnimation(15, tex.harry_jump[0],
                        tex.harry_jump[1], tex.harry_jump[2], tex.harry_jump[3],
                        tex.harry_jump[4], tex.harry_jump[4], tex.harry_jump[4],
                        tex.harry_jump[4], tex.harry_jump[5], tex.harry_jump[6],
                        tex.harry_jump[7], tex.harry_jump[8]);
                    playerJumpLeft = new CustomAnimation(15, tex.harry_jump[9],
                        tex.harry_jump[10], tex.harry_jump[11],
                        tex.harry_jump[12], tex.harry_jump[12],
                        tex.harry_jump[12], tex.harry_jump[12],
                        tex.harry_jump[13], tex.harry_jump[14],
                        tex.harry_jump[15], tex.harry_jump[16],
                        tex.harry_jump[17]);
                    playerStillLeft = new CustomAnimation(1, tex.harry[0]);
                    playerStill = new CustomAnimation(1, tex.harry[7]);

                    playerPunch = new CustomAnimation(3, tex.harry_punch[0],
                        tex.harry_punch[1], tex.harry_punch[2],
                        tex.harry_punch[3], tex.harry_punch[4],
                        tex.harry_punch[5], tex.harry_punch[6],
                        tex.harry_punch[7], tex.harry_punch[8]);
                    playerPunchLeft = new CustomAnimation(3, tex.harry_punch[9],
                        tex.harry_punch[10], tex.harry_punch[11],
                        tex.harry_punch[12], tex.harry_punch[13],
                        tex.harry_punch[14], tex.harry_punch[15],
                        tex.harry_punch[16], tex.harry_punch[17]);
                    playerKick = new CustomAnimation(3, tex.harry_kick[0],
                        tex.harry_kick[1], tex.harry_kick[2], tex.harry_kick[3],
                        tex.harry_kick[4], tex.harry_kick[5], tex.harry_kick[6],
                        tex.harry_kick[7], tex.harry_kick[8]);
                    playerKickLeft = new CustomAnimation(3, tex.harry_kick[9],
                        tex.harry_kick[10], tex.harry_kick[11],
                        tex.harry_kick[12], tex.harry_kick[13],
                        tex.harry_kick[14], tex.harry_kick[15],
                        tex.harry_kick[16], tex.harry_kick[17]);
                    playerSpecial = new CustomAnimation(7, tex.harry_special[0],
                        tex.harry_special[1], tex.harry_special[2],
                        tex.harry_special[3], tex.harry_special[4],
                        tex.harry_special[5], tex.harry_special[6],
                        tex.harry_special[7], tex.harry_special[8]);
                    playerSpecialLeft = new CustomAnimation(7, tex.harry_special[9],
                            tex.harry_special[10], tex.harry_special[11],
                            tex.harry_special[12], tex.harry_special[13],
                            tex.harry_special[14], tex.harry_special[15],
                            tex.harry_special[16], tex.harry_special[17]);
               }

               else if (Game.ChoiceP2 == Game.CHOICEP2.HERMIONEP2) {
            	   // Initialize animations for Hermione's movements and attacks
            	   System.out.println("Player 2 has chosen Hermione");
                    playerWalk = new CustomAnimation(5, tex.hermione[0], tex.hermione[1],
                            tex.hermione[2], tex.hermione[3], tex.hermione[4],
                            tex.hermione[5], tex.hermione[6], tex.hermione[7]);
                    playerWalkLeft = new CustomAnimation(5, tex.hermione[8],
                        tex.hermione[9], tex.hermione[10], tex.hermione[11],
                        tex.hermione[12], tex.hermione[13], tex.hermione[14],
                        tex.hermione[15]);
                    playerJump = new CustomAnimation(15, tex.hermione_jump[0],
                        tex.hermione_jump[1], tex.hermione_jump[2],
                        tex.hermione_jump[3], tex.hermione_jump[4],
                        tex.hermione_jump[4], tex.hermione_jump[4],
                        tex.hermione_jump[4], tex.hermione_jump[5],
                        tex.hermione_jump[6]);
                    playerJumpLeft = new CustomAnimation(15, tex.hermione_jump[7],
                            tex.hermione_jump[8], tex.hermione_jump[9],
                            tex.hermione_jump[10], tex.hermione_jump[11],
                            tex.hermione_jump[12], tex.hermione_jump[13]);
                    playerStillLeft = new CustomAnimation(1, tex.hermione[0]);
                    playerStill = new CustomAnimation(1, tex.hermione[8]);

                    playerPunch = new CustomAnimation(3, tex.hermione_punch[0],
                        tex.hermione_punch[1], tex.hermione_punch[2],
                        tex.hermione_punch[3], tex.hermione_punch[4],
                        tex.hermione_punch[5], tex.hermione_punch[6],
                        tex.hermione_punch[7]);
                    playerPunchLeft = new CustomAnimation(3,
                        tex.hermione_punch[8], tex.hermione_punch[9],
                        tex.hermione_punch[10], tex.hermione_punch[11],
                        tex.hermione_punch[12], tex.hermione_punch[13],
                        tex.hermione_punch[14], tex.hermione_punch[15]);
                    playerKick = new CustomAnimation(3, tex.hermione_kick[0],
                        tex.hermione_kick[1], tex.hermione_kick[2],
                        tex.hermione_kick[3], tex.hermione_kick[4],
                        tex.hermione_kick[5], tex.hermione_kick[6]);
                    playerKickLeft = new CustomAnimation(3,
                        tex.hermione_kick[7], tex.hermione_kick[8],
                        tex.hermione_kick[9], tex.hermione_kick[10],
                        tex.hermione_kick[11], tex.hermione_kick[12]);
                    playerSpecial = new CustomAnimation(7,
                        tex.hermione_special[0], tex.hermione_special[1],
                        tex.hermione_special[2], tex.hermione_special[3],
                        tex.hermione_special[4], tex.hermione_special[5],
                        tex.hermione_special[6], tex.hermione_special[7]);
                    playerSpecialLeft = new CustomAnimation(7,
                        tex.hermione_special[8], tex.hermione_special[9],
                        tex.hermione_special[10], tex.hermione_special[11],
                        tex.hermione_special[12], tex.hermione_special[13],
                        tex.hermione_special[14], tex.hermione_special[15]);
               }
               hasChosen = true;   // Set the hasChosen flag to true to avoid reinitialization
          }
     }

     public void init() {}	 // Initialization method

     public void tick() {	 // Initialization method
          x2 += velX2;
          y2 += velY2;
          
          // Handle jumping mechanics
          if (y2 <= 340) {
               velY2++;
               jumping2 = true;
          }
          if (x2 <= 0) {
               x2 = 0;
          }
          if (x2 >= 725) {
               x2 = 725;
          }
          if (y2 >= 400) {
               y2 = 400;
               jumping2 = false;
          }
          if (y2 <= 0) {
               y2 = 0;
          }
          
          // Determine the direction Player2 is facing based on velocity
          if (velX2 < 0) {
               facing2 = 0;
          } else if (velX2 > 0) {
               facing2 = 1;
          }

          // Run animations for various movements and attacks
          playerWalk.runAnimation();
          playerWalkLeft.runAnimation();
          playerJump.runAnimation();
          playerJumpLeft.runAnimation();
          playerStill.runAnimation();
          playerStillLeft.runAnimation();
          playerPunch.runAnimation();
          playerPunchLeft.runAnimation();
          playerKick.runAnimation();
          playerKickLeft.runAnimation();
          playerSpecial.runAnimation();
          playerSpecialLeft.runAnimation();
     }

     // Render method to display Player2's animations
     public void render(Graphics g) {
    	  // Check and render specific animations based on Player2's state
          if (jumping2 && facing2 == 1) {
               playerJump.drawAnimation(g, (int) x2, (int) y2);
          }

          else if (jumping2 && facing2 == 0) {
               playerJumpLeft.drawAnimation(g, (int) x2, (int) y2);
          } else if (jumping2 && facing2 == 1 && special2) {
               playerSpecial.drawAnimation(g, (int) x2, (int) y2);
          } else if (jumping2 && facing2 == 0 && special2) {
               playerSpecialLeft.drawAnimation(g, (int) x2, (int) y2);
          } else {
        	  // Render walking, idle, kicking, punching, and special animations based on Player2's state and facing direction
               if (!inAction2 && velX2 < 0) { // left
                    playerWalkLeft.drawAnimation(g, (int) x2, (int) y2);
               } else if (!inAction2 && velX2 > 0) {
                    playerWalk.drawAnimation(g, (int) x2, (int) y2);
               } else if (kick2 && facing2 == 1) {
                    playerKick.drawAnimation(g, (int) x2, (int) y2);
               } else if (kick2 && facing2 == 0) {
                    playerKickLeft.drawAnimation(g, (int) x2, (int) y2);
               } else if (punch2 && facing2 == 1) {
                    playerPunch.drawAnimation(g, (int) x2, (int) y2);
               } else if (punch2 && facing2 == 0) {
                    playerPunchLeft.drawAnimation(g, (int) x2, (int) y2);
               } else if (special2 && facing2 == 1) {
                    playerSpecial.drawAnimation(g, (int) x2, (int) y2);
               } else if (special2 && facing2 == 0) {
                    playerSpecialLeft.drawAnimation(g, (int) x2, (int) y2);
               } else {
                    if (facing2 == 0) {
                         playerStill.drawAnimation(g, (int) x2, (int) y2);
                    } else if (facing2 == 1) {
                         playerStillLeft.drawAnimation(g, (int) x2, (int) y2);
                    }
               }
          }
     }

     // Getter methods for Player2's coordinates and state
     public double getX2p2() {
          return x2;
     }
     public double getY2p2() {
          return y2;
     }
     public boolean isJumpingp2() {
          return jumping2;
     }
     
     // Setter methods for modifying Player2's attributes
     public void setXp2(double xp2) {
          this.x2 = xp2;
     }
     public void setYp2(double yp2) {
          this.y2 = yp2;
     }
     public void setVelXp2(double velXp2) {
          this.velX2 = velXp2;
     }
     public void setVelYp2(double velYp2) {
          this.velY2 = velYp2;
     }
}
