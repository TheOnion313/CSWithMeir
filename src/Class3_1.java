package Classes;
import canvasML.*;

public class Class3_1 {
    public static void main(String[] args) {
        Circle c;
        int velx = 1;
        int vely = 1;
        int x = 0;
        int y = 0;
        while(true) {
            c = new Circle(x, y, 20, "red");
            x += velx;
            y += vely;
            if(x >= Canvas.WIDTH - c.getDiameter() || x <= 0) {
                velx *= -1;
            }
            if(y >= Canvas.HEIGHT - c.getDiameter() || y <= 0) {
                vely *= -1;
            }
        }
    }
}
