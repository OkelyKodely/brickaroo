
import java.awt.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhcho
 */
public class Brick {
    
    public int x;
    public int y;
    public int point;
    public boolean step;

    private Image image;
    
    public Render getRender() {

        Render r = new Render();
        r.x = x;
        r.y = y;

        if (image == null) {
            image = Util.loadImage("lib/img.jpg");
        }
        r.image = image;

        return r;
    }
}
