import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Displays a window and delegates drawing to DrawGraphics. */
public class SimpleDraw extends JPanel implements Runnable {
    private static final long serialVersionUID = -7469734580960165754L;
    private boolean animate = true;
    private final int FRAME_DELAY = 200; // 50 ms = 20 FPS
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    private static int m_x = 0;
    private static int m_y = 0;
    private DrawGraphics draw;
    public SimpleDraw(DrawGraphics drawer) {
        //mouse input
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                m_x = e.getX();
                m_y = e.getY();
                System.out.println(m_x + " " + m_y);
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

    public static int getMouseX() {
        return m_x;
    }

    public static int getMouseY() {
        return m_y;
    }

    public static void main(String args[]) {
        final SimpleDraw content = new SimpleDraw(new DrawGraphics());
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
        new Thread(content).start();
        frame.setVisible(true);
    }
}