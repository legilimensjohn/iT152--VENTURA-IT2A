// The 'Player' class encompasses the fundamental functions and visual characteristics of player-controlled characters in the game.

package basics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player {
     private double x1;
     private double y1;

     private boolean hasChosen = false;

     private boolean jumping1;
     private boolean attacking1 = false;

     private double velX1 = 0;
     private double velY1 = 0;

     public int facing1 = 1; // right
     public boolean punch1 = false;
     public boolean kick1 = false;
     public boolean special1 = false;
     public boolean strafe1 = false;
     public boolean inAction1 = false;

     CharacterTexture tex = Game.getInstance();
     
     // Animations for various player movements and attacks
     private CustomAnimation playerWalk, playerWalkLeft, playerJump, playerJumpLeft, playerStillLeft, playerStill; // movements
     private CustomAnimation playerPunch, playerPunchLeft, playerKick, playerKickLeft, playerSpecial, playerSpecialLeft; // attacks

     public Player(double x1, double y1) {
          this.x1 = x1;
          this.y1 = y1;
          
          // Initialize animations based on the character choice
          if (!hasChosen) {
               if (Game.ChoiceP2 == Game.CHOICEP2.HARRYP2) {
            	    // Harry's animations
                    System.out.println("Player 2 has chosen Harry");
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
               } else if (Game.ChoiceP2 == Game.CHOICEP2.HERMIONEP2) {
            	    // Hermione's animations
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

               hasChosen = true;
          }
     }

     public void init() {}  // Initialization method

     public void tick() { // Update method for player's position and animations
         
    	  // Update player's position based on velocity
    	  x1 += velX1;
          y1 += velY1;
          
          // Handle jumping mechanics
          if (y1 <= 340) {
               velY1++;
               jumping1 = true;
          }
          if (x1 <= 0) {
               x1 = 0;
          }
          if (x1 >= 725) {
               x1 = 725;
          }
          if (y1 >= 400) {
               y1 = 400;
               jumping1 = false;
          }
          if (y1 <= 0) {
               y1 = 0;
          }

          // Update player's facing direction based on velocity
          if (velX1 < 0) {
               facing1 = 0;
          } else if (velX1 > 0) {
               facing1 = 1;
          }
          
          // Run animations
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

     // Render method for drawing the player on the screen
     public void render(Graphics g) {
    	  // Check various conditions to determine which animation to draw
          if (jumping1 && facing1 == 1) {
               playerJump.drawAnimation(g, (int) x1, (int) y1);
          }

          else if (jumping1 && facing1 == 0) {
               playerJumpLeft.drawAnimation(g, (int) x1, (int) y1);
          } else if (jumping1 && facing1 == 1 && special1) {
               playerSpecial.drawAnimation(g, (int) x1, (int) y1);
          } else if (jumping1 && facing1 == 0 && special1) {
               playerSpecialLeft.drawAnimation(g, (int) x1, (int) y1);
          } else {
        	   // Check various conditions to determine which animation to draw
               if (!inAction1 && velX1 < 0) { // left
                    playerWalkLeft.drawAnimation(g, (int) x1, (int) y1);
               } else if (!inAction1 && velX1 > 0) {
                    playerWalk.drawAnimation(g, (int) x1, (int) y1);
               } else if (kick1 && facing1 == 1) {
                    playerKick.drawAnimation(g, (int) x1, (int) y1);
               } else if (kick1 && facing1 == 0) {
                    playerKickLeft.drawAnimation(g, (int) x1, (int) y1);
               } else if (punch1 && facing1 == 1) {
                    playerPunch.drawAnimation(g, (int) x1, (int) y1);
               } else if (punch1 && facing1 == 0) {
                    playerPunchLeft.drawAnimation(g, (int) x1, (int) y1);
               } else if (special1 && facing1 == 1) {
                    playerSpecial.drawAnimation(g, (int) x1, (int) y1);
               } else if (special1 && facing1 == 0) {
                    playerSpecialLeft.drawAnimation(g, (int) x1, (int) y1);
               } else {
            	    // Draw still frame based on facing direction
                    if (facing1 == 0) {
                         playerStill.drawAnimation(g, (int) x1, (int) y1);
                    } else if (facing1 == 1) {
                         playerStillLeft.drawAnimation(g, (int) x1, (int) y1);
                    }
               }
          }
     }

     // Getter methods for player attributes
     public double getX() {
          return x1;
     }
     public double getY() {
          return y1;
     }
     public boolean isJumping() {
          return jumping1;
     }
     
     // Setter methods for player attributes
     public void setX(double x) {
          this.x1 = x;
     }
     public void setY(double y) {
          this.y1 = y;
     }
     public void setVelX(double velX) {
          this.velX1 = velX;
     }
     public void setVelY(double velY) {
          this.velY1 = velY;
     }
}
