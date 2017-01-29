package com.keskin.com.live;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.widget.TextView;

import java.util.Random;


public class wallactivity extends WallpaperService {
    public Engine onCreateEngine() {
        return new engine();
    }




    private class engine extends Engine {


        @Override
        public void onCreate(SurfaceHolder surfaceHolder) {
            super.onCreate(surfaceHolder);
            TextView t = new TextView(getApplicationContext());

            final SurfaceHolder holder = getSurfaceHolder();

            Canvas c = null;
            try
            {
                c = holder.lockCanvas();
                if (c != null)
                {
                    c.drawARGB(255, 100, 50, 200);
                }
            } finally
            {
                if (c != null) holder.unlockCanvasAndPost(c);
            }
        }
        public void onOffsetsChanged(float xOffset, float yOffset, float xStep, float yStep, int xPixels, int yPixels)
        {
            drawFrame();
        }

        void drawFrame()
        {
            final SurfaceHolder holder = getSurfaceHolder();
            Random rand = new Random();
            SharedPreferences edit = getSharedPreferences("renk",MODE_PRIVATE);
            final int alpha = rand.nextInt(edit.getInt("a",255));
            final int red = rand.nextInt(edit.getInt("r",255));
            final int green = rand.nextInt(edit.getInt("g",255));
            final int blue = rand.nextInt(edit.getInt("b",255));
            Canvas c = null;
            try
            {
                c = holder.lockCanvas();
                if (c != null)
                {
                    c.drawARGB(alpha,red,green,blue);
                }
            } finally
            {
                if (c != null) holder.unlockCanvasAndPost(c);
            }
        }
    }

}
