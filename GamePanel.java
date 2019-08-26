import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable {

    private Game game;
    
    private JFrame frame;

    public GamePanel (JFrame frame) {
        this.frame = frame;
        
        game = new Game();

        new Thread(this).start();
    }

    public void update () {
        game.update();
        repaint();
    }

    protected void paintComponent (Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.GREEN);

        try {
            for (Render r : game.getRenders()) {
                g.drawImage(r.image, r.x, r.y, null);
            }
        } catch(Exception e) {e.printStackTrace();}
    }
    
    public void run () {
        boolean startOfGame = true;
        try {
            while (true) {
                if(startOfGame)
                    game.initBricks();
                if(startOfGame)
                    startOfGame = false;
                update();
                frame.setTitle(game.point+"");
                Thread.sleep(25);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
