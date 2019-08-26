import java.util.ArrayList;
import java.util.Random;

public class Game {

    public int point;
    
    Random random = new Random();
    
    public Keyboard keyboard;

    Background background;
        
    Bird bird;
    
    ArrayList<Brick> bricks;
    
    public Game() {
        bird = new Bird();
        background = new Background();
        bricks = new ArrayList<Brick>();
        keyboard = Keyboard.getInstance();
    }
    
    public void initBricks() {
        int fsda = 20;
        for(int x=0; x<fsda; x++) {
            Brick brick = new Brick();
            brick.x = random.nextInt(500);
            brick.y = -random.nextInt(100) + random.nextInt(600);
            bricks.add(brick);
        }
    }
    
    public void update() {
        this.point = bird.update(bricks);
        boolean g = false;
        for(Brick brick: bricks) {
            g = false;
            if(brick.y > 800)
                g = true;
        }
        if(g) {
            initBricks();
        }
        if (bird.y + bird.height > App.HEIGHT - 80) {


            bird.y = 588;

            // keep the bird above ground
            bird.y = App.HEIGHT - 80 - bird.height;
        }
    }
    
    public ArrayList<Render> getRenders() {
        try {
            ArrayList<Render> renders = new ArrayList<Render>();
            renders.add(background.getRender());
            for(Brick brick : bricks)
                renders.add(brick.getRender());
            renders.add(bird.getRender());
            return renders;
        } catch(Exception e) {
            return null;
        }
    }

}