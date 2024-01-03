package basics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

//Game class represents the main class for a simple 2D fighting game.
// Also it represents the main game engine, managing the game loop, states, player input, and rendering.
public class Game extends Canvas implements Runnable {
     /**
      *
      */
     private static final long serialVersionUID = 1L;
     
     // Game class represents the main class for a simple 2D fighting game.
     public static final int WIDTH = 790;
     public static final int HEIGHT = 590;
     public static final int SCALE = 1;
     // Title of the game window.
     public final String TITLE = "Platform 9¾";
     
     // Thread and game running status
     private boolean running = false; // Flag indicating whether the game loop is running.
     private Thread thread; // Thread responsible for running the game loop.

     // Images and game elements
     private BufferedImage img = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
     private BufferedImage menuImage = null;
     private BufferedImage CharacterSelectionImage = null;
     public BufferedImage Player1 = null; // test
     public BufferedImage Player2 = null; // test
     public BufferedImage GameBackground = null;
     // Instances of Menu and CustomCharacterSelection classes for handling menu and character selection screens.
     private Menu menu;
     private CustomCharacterSelection characterSelect;

     // Game states and character choices
     public static enum STATE { MENU, CHARSELECT1, CHARSELECT2, CHOOSE, GAME } ;
     public static enum CHOICEP1 { HERMIONEP1, HARRYP1, NOTHING } ;
     public static enum CHOICEP2 { HERMIONEP2, HARRYP2, NOTHING2 } ;

     // Current state and choices
     public static CHOICEP1 ChoiceP1 = CHOICEP1.NOTHING;
     public static CHOICEP2 ChoiceP2 = CHOICEP2.NOTHING2;
     public static STATE State = STATE.MENU;
     
     // Players and textures
     private Player p;
     private Player2 p2;
     static CharacterTexture tex;
     
     /**
      * Initializes the game, loading images and setting up input listeners.
      *
      * @param characterSelection The character selection instance.
      */
     public void init(CustomCharacterSelection characterSelection) {
          ImageLoader loaderMenu = new ImageLoader();
          ImageLoader loaderChar = new ImageLoader();
          ImageLoader loaderGBG = new ImageLoader();
          tex = new CharacterTexture();
          
          // Load menu, character selection, and game background images.
          try {
              menuImage = loaderMenu.loadImage("/assets/BGresizeS.jpg");
              GameBackground = loaderGBG.loadImage("/assets/resize_Hogwarts.jpg");
              CharacterSelectionImage = loaderChar.loadImage("/assets/reBG.jpg");
          } catch (IOException e) {
              e.printStackTrace();
          }
          
          // Set up input listeners
          this.addMouseListener(new MouseInput());
          addKeyListener(new CustomKeyInput(this));
          
          // Initialize game elements
          menu = new Menu();
          characterSelection = new CustomCharacterSelection();
     }
     
     // Main method to start the game loop.
     private synchronized void start() {
          if (running)
               return;
          running = true;
          thread = new Thread(this);
          thread.start();
     }
     
     // Method to stop the game loop.
     private synchronized void stop() {
          if (!running)
               return;
          running = false;
          try {
               thread.join();
          } catch (InterruptedException e) {
               e.printStackTrace();
          }
          System.exit(1);
     }
     
     // Main game loop.
     public void run() {
          init();
          
          // Timing variables for controlling game updates and rendering.
          long lastTime = System.nanoTime();
          final double amountOfTicks = 60.0;
          double ns = 1000000000 / amountOfTicks;
          double delta = 0;
          int updates = 0;
          int frames = 0;
          long timer = System.currentTimeMillis();

          while (running) {
               long now = System.nanoTime();
               delta += (now - lastTime) / ns;
               lastTime = now;
               if (delta >= 1) {
                    tick();	 // Update game logic.
                    updates++;
                    delta--;
               }
               render();   // Render game graphics.
               frames++;
               
               // Print updates and frames per second every second.
               if (System.currentTimeMillis() - timer > 1000) {
                    timer += 1000;
                    System.out.println(updates + " Ticks, FPS " + frames);
                    updates = 0;
                    frames = 0;
               }
          }
          stop();  // Stop the game loop.
     }
     
     // Initialize method (currently empty, can be extended).
     private void init() {
          // TODO Auto-generated method stub
     }
     
     // Update game logic.
     private void tick() {
          if (State == STATE.GAME) {
               p.tick();
               p2.tick();
          }
          if (State == STATE.GAME) {
               p.init();
               p2.init();
          }
          if (State == STATE.CHOOSE) {
               p = new Player(140.0, 340.0);
               p2 = new Player2(800.0 - 140.0, 340.0);
               State = STATE.GAME;
          }
     }
     
     // Render game graphics.
     private void render() {
          BufferStrategy bs = this.getBufferStrategy();
          if (bs == null) {
               createBufferStrategy(3);
               return;
          }

          Graphics g = bs.getDrawGraphics();

          g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
          if (State == STATE.GAME) {
               g.clearRect(0, 0, 800, 600);

               g.drawImage(GameBackground, 0, 0, null);
               p.render(g);
               p2.render(g);

          } else if (State == STATE.MENU) {
               g.clearRect(0, 0, 800, 600);
               g.drawImage(menuImage, 0, 0, null);
               menu.render(g);

          } else if (State == STATE.CHARSELECT1 || State == STATE.CHARSELECT2) {
               g.clearRect(0, 0, 800, 600);
               g.drawImage(CharacterSelectionImage, 0, 0, null);
               characterSelect.render(g);
          }
          g.dispose();
          bs.show();
     }
     
     // Handle key press events.
     public void keyPressed(KeyEvent e) {
          int key = e.getKeyCode();
          
          // Player 1 controls
          if (key == KeyEvent.VK_D) {
               p.setVelX(5);
          } else if (key == KeyEvent.VK_A) {
               p.setVelX(-5);
          } else if (key == KeyEvent.VK_S) {
               p.setVelY(1);
          } else if (key == KeyEvent.VK_W && !p.isJumping()) {
               p.setVelY(-17);
               try {
            	    // Play jump sound
                    AudioInputStream audioInputStream =
                        AudioSystem.getAudioInputStream(
                            this.getClass().getResource("/music/jump.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }

          } else if (key == KeyEvent.VK_J) {
        	   // Player 1 punch
               p.punch1 = true;
               p.inAction1 = true;

               // Play punch sound
               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/punch.au"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               }

               catch (Exception ex) {
               }

               if (p.facing1 == 1 && p.getX() != 0) {
                    p.setVelX(0);
               } else if (p.facing1 == 0 && p.getX() != 0) {
                    p.setVelX(0);
               }
          } else if (key == KeyEvent.VK_K) {
        	   // Player 1 kick
               p.kick1 = true;
               p.inAction1 = true;

               try {
            	    // Play kick sound
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/kick.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }
               p.setVelX(0);
          } else if (key == KeyEvent.VK_L) {
        	   // Player 1 special move
               p.special1 = true;
               p.inAction1 = true;

               // Play special move sound
               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/select.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }
               p.setVelX(0);
          } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
        	   // Player 1 strafe right
        	   p.setX(p.getX() + 140);
               p.strafe1 = true;
               p.inAction1 = true;
          } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
        	   // Player 1 strafe left
        	   p.setX(p.getX() - 140);
               p.strafe1 = true;
               p.inAction1 = true;
          }
          
          // Player 2 controls (Similar logic as Player 1)
          if (key == KeyEvent.VK_RIGHT) {
               p2.setVelXp2(5);
          } else if (key == KeyEvent.VK_LEFT) {
               p2.setVelXp2(-5);
          } else if (key == KeyEvent.VK_DOWN) {
               p2.setVelYp2(1);
          } else if (key == KeyEvent.VK_UP && !p2.isJumpingp2()) {
               p2.setVelYp2(-17);

               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/jump.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }
          } else if (key == KeyEvent.VK_NUMPAD1) {
               p2.punch2 = true;
               p2.inAction2 = true;

               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/punch2.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }

               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_NUMPAD2) {
               p2.kick2 = true;
               p2.inAction2 = true;
               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/kick2.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_NUMPAD3) {
               p2.special2 = true;
               p2.inAction2 = true;

               try {
                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("/music/special2.wav"));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    clip.start();
               } catch (Exception ex) {
               }

               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_LEFT) {
               p2.strafe2 = true;
               p2.inAction2 = true;
          } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_RIGHT) {
               p2.strafe2 = true;
               p2.inAction2 = true;
          }
     }
     public void keyReleased(KeyEvent e) {
          int key = e.getKeyCode();
          
          // Player 1 key releases
          if (key == KeyEvent.VK_D) {
               p.setVelX(0);
          } else if (key == KeyEvent.VK_A) {
               p.setVelX(0);
          } else if (key == KeyEvent.VK_S) {
               // p.setVelY(0);
          } else if (key == KeyEvent.VK_W) {
               // p.setVelY(0);
          } else if (key == KeyEvent.VK_J) {
               p.punch1 = false;
               p.inAction1 = false;

          } else if (key == KeyEvent.VK_K) {
               p.kick1 = false;
               p.inAction1 = false;
               p.setVelX(0);
          } else if (key == KeyEvent.VK_L) {
               p.special1 = false;
               p.inAction1 = false;
               p.setVelX(0);
          } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_D) {
               p.setX(p.getX() + 140);
               p.strafe1 = false;
               p.inAction1 = false;
          } else if (key == KeyEvent.VK_S && key == KeyEvent.VK_A) {
               p.setX(p.getX() - 140);
               p.strafe1 = false;
               p.inAction1 = false;
          }
          
          // Player 2 key releases
          if (key == KeyEvent.VK_RIGHT) {
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_LEFT) {
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_DOWN) {
               // p2.setVelYp2(0);
          } else if (key == KeyEvent.VK_UP) {
               // p2.setVelYp2(0);
          } else if (key == KeyEvent.VK_NUMPAD1) {
               p2.punch2 = false;
               p2.inAction2 = false;
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_NUMPAD2) {
               p2.kick2 = false;
               p2.inAction2 = false;
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_NUMPAD3) {
               p2.special2 = false;
               p2.inAction2 = false;
               p2.setVelXp2(0);
          } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_LEFT) {
               p2.strafe2 = false;
               p2.inAction2 = false;
          } else if (key == KeyEvent.VK_DOWN && key == KeyEvent.VK_RIGHT) {
               p2.strafe2 = false;
               p2.inAction2 = false;
          }
     }

     public static CharacterTexture getInstance() {
          return tex;
     }
     
     // Main method to launch the game
     public static void main(String[] args) {
          Game game = new Game();

          game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
          game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
          game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

          JFrame frame = new JFrame(game.TITLE);
          frame.add(game);
          frame.pack();
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setResizable(false);
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
          game.start();
     }
}
