package cs.elon.edu.doodlecam;

import android.graphics.Canvas;
import android.graphics.Paint;
/**
 * A single dot on the screen.
 *
 * @author J. Hollingsworth and CSC 303 - Fall 2015
 */
public class Dot {
    private float x, y;
    private int penWidth;
    private Paint paint;

    public Dot(float x, float y, int penWidth, int alpha, int red, int green, int blue) {
        this.x = x;
        this.y = y;

        this.penWidth = penWidth;
        paint = new Paint();
        paint.setARGB(alpha, red, green, blue);
    }

    public void draw(Canvas canvas) {

        canvas.drawCircle(x, y, penWidth, paint);
    }

}
