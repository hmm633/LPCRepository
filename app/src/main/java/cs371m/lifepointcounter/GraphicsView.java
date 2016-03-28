package cs371m.lifepointcounter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Monolith on 3/27/2016.
 */
public class GraphicsView extends View {

    private static final String TAG = "Graphic View";

    public GraphicsView(Context context, AttributeSet attrs){
        super(context, attrs);
        Log.d(TAG, "in 2 param constructor");
    }

    public GraphicsView(Context context) {
        super(context);
        Log.d(TAG, "in 1 param constructor");
    }

    @Override
    protected void onDraw(Canvas canvas){
        Log.d(TAG, "in onDraw");
        Paint p = new Paint();
        p.setColor(Color.BLACK);

        final RectF rect = new RectF(); // set to "final" for some reason
        rect.set(0, 0, 223, 223);

        canvas.drawRoundRect(rect, 30, 30, p);
//                ();Rect(0, 0, 300, 300, p);

    }
}
