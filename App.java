import java.awt.Color;
import javax.swing.*;

public class App {

    public static int WIDTH = 507;
    public static int HEIGHT = 800;

    public static void main (String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        Keyboard keyboard = Keyboard.getInstance();
        frame.addKeyListener(keyboard);

        GamePanel panel = new GamePanel(frame);
        panel.setBackground(new Color(0, 200, 0));
        frame.add(panel);
    }
}
