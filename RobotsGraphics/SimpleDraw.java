import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** Displays a window and delegates drawing to DrawGraphics. */
public class SimpleDraw extends JPanel implements Runnable {
    private static final long serialVersionUID = -7469734580960165754L;
    private boolean animate = true;
    private final int FRAME_DELAY = 200; // 50 ms = 20 FPS
    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;
    private static int m_x = 0;
    private static int m_y = 0;
    
    private static Game game;
    private static DrawGraphics drawGraphics;
    private static int moveCode;
    private static final int topLeft = 7;
    private static final int top = 8;
    private static final int topRight = 9;
    private static final int left = 4;
    private static final int stay = 5;
    private static final int right = 6;
    private static final int bottomLeft = 1;
    private static final int bottom = 2;
    private static final int bottomRight = 3;
    
    private static Box clickedBox;
    private static int clickedBoxX;
    private static int clickedBoxY;
    private static int vertDistance;
    private static int horizDistance;
    
    private Font basic = new Font("TimesRoman", Font.PLAIN, 30);
    private static int win = -1;
    private static int wins = 0;
    private static int losses = 0;
    private DrawGraphics draw;
    public SimpleDraw(DrawGraphics drawer) {
        //mouse input
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                m_x = e.getX();
                m_y = e.getY();
            }
        });
        this.draw = drawer;
    }
    /** Paint callback from Swing. Draw graphics using g. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
// Enable anti-aliasing for better looking graphics
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(basic);
        
        if (win == 1) {
        	g2.drawString("You won!", WIDTH/2 - 60, 500);
        }
        else if (win == 0) {
        	g2.drawString("You lost!", WIDTH/2 - 60, 500);
        }
        //passing mouse coordinates to drawGraphics
        draw.draw(g2, m_x, m_y);
    }
    /** Enables periodic repaint calls. */
    public synchronized void start() {
        animate = true;
    }
    /** Pauses animation. */
    public synchronized void stop() {
        animate = false;
    }
    private synchronized boolean animationEnabled() {
        return animate;
    }
    public void run() {
        while (true) {
            if (animationEnabled()) {
                repaint();
            }
            try {
                Thread.sleep(FRAME_DELAY);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void main(String args[]) {
    	game = new Game();
    	game.newGame();
    	drawGraphics = new DrawGraphics(game);
        final SimpleDraw content = new SimpleDraw(drawGraphics);
        JFrame frame = new JFrame("Graphics!");
        Color bgColor = Color.white;
        frame.setBackground(bgColor);
        content.setBackground(bgColor);
// content.setSize(WIDTH, HEIGHT);
// content.setMinimumSize(new Dimension(WIDTH, HEIGHT));
        content.setPreferredSize(new Dimension(WIDTH, HEIGHT));
// frame.setSize(WIDTH, HEIGHT);
        frame.setContentPane(content);
        frame.setResizable(false);
        frame.pack();
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) { System.exit(0); }
            public void windowDeiconified(WindowEvent e) { content.start(); }
            public void windowIconified(WindowEvent e) { content.stop(); }
        });
        
        frame.addKeyListener(new KeyAdapter() {
    		public void keyPressed(KeyEvent e) {
    			if (moveCode >= 0) {
    				moveCode = 0;
    				if (drawGraphics.getClickedBox() != null) {
		    			clickedBox = drawGraphics.getClickedBox();
		    			clickedBoxX = clickedBox.getLoc().getCol();
		    			clickedBoxY = clickedBox.getLoc().getRow();
		    			
		    			horizDistance = (clickedBoxX - drawGraphics.playerLoc.getCol());
		    			vertDistance = -(clickedBoxY - drawGraphics.playerLoc.getRow());
		  
						if (horizDistance == -1 && vertDistance == -1) {
							moveCode = topLeft;
						}
						else if (horizDistance == 0 && vertDistance == -1) {
							moveCode = top;
						}
						else if (horizDistance == 1 && vertDistance == -1) {
							moveCode = topRight;
						}
						else if (horizDistance == -1 && vertDistance == 0) {
							moveCode = left;
						}
						else if (horizDistance == 0 && vertDistance == 0) {
							moveCode = stay;
						}
						else if (horizDistance == 1 && vertDistance == 0) {
							moveCode = right;
						}
						else if (horizDistance == -1 && vertDistance == 1) {
							moveCode = bottomLeft;
						}
						else if (horizDistance == 0 && vertDistance == 1) {
							moveCode = bottom;
						}
						else if (horizDistance == 1 && vertDistance == 1) {
							moveCode = bottomRight;
						}
    				}
					
	    			int keyCode = e.getKeyCode();
	    			if (keyCode == KeyEvent.VK_ENTER) {
	    				game.update(moveCode);
	    				m_x = 0;
	    				m_y = 0;
	    			}
	    			else if (keyCode == KeyEvent.VK_R) {
	    				game.newGame();
	    			}
	    			
	    			if (game.isWin()) {
	    				win = 1;
	    				wins += 1;
	    				game.newGame();  						//add "You win" onto the window
	    			}
	    			if (game.isLose()) {
	    				win = 0;
	    				losses += 1;
	    				game.newGame();							//add "You lose" onto the window
	    			}

    			}
    			
    		}
    	});
        
        new Thread(content).start();
        frame.setVisible(true);
    }
}