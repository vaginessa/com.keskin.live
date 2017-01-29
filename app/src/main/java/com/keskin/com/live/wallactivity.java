package com.keskin.com.live;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Handler;
import android.service.wallpaper.WallpaperService;
import android.view.SurfaceHolder;
import android.widget.TextView;

import java.util.Random;

import static com.keskin.com.live.R.id.regular;


public class wallactivity extends WallpaperService {
    public Engine onCreateEngine() {
        return new engine();
    }
    int[] red = {0};
    int[] green={0};
    int[] blue = {0};
    int[] status = {1};



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
            SharedPreferences edit = getSharedPreferences("renk",MODE_PRIVATE);
            int regular =edit.getInt("regular",0);
            Random ra = new Random();
            status[0] = ra.nextInt(14);
            //random start status
            if (status[0] ==1){
                red[0] = 0;
                green[0]=0;
                blue[0] = 0;
            }
            if (status[0] ==2){
                red[0] = 255;
                green[0]=0;
                blue[0] = 0;
            }
            if (status[0] ==3){
                red[0] = 0;
                green[0]=255;
                blue[0] = 0;
            }
            if (status[0] ==4){
                red[0] = 255;
                green[0]=255;
                blue[0] = 0;
            }
            if (status[0] ==5){
                red[0] = 0;
                green[0]=0;
                blue[0] = 255;
            }
            if (status[0] ==6){
                red[0] = 255;
                green[0]=0;
                blue[0] = 255;
            }
            if (status[0] ==7){
                red[0] = 0;
                green[0]=255;
                blue[0] = 255;
            }
            if (status[0] ==8){
                red[0] = 255;
                green[0]=255;
                blue[0] = 255;
            }
            if (status[0] ==9){
                red[0] = 0;
                green[0]=255;
                blue[0] = 255;
            }
            if (status[0] ==10){
                red[0] = 255;
                green[0]=0;
                blue[0] = 255;
            }
            if (status[0] ==11){
                red[0] = 0;
                green[0]=0;
                blue[0] = 255;
            }
            if (status[0] ==12){
                red[0] = 255;
                green[0]=255;
                blue[0] = 0;
            }
            if (status[0] ==13){
                red[0] = 0;
                green[0]=255;
                blue[0] = 0;
            }
            if (status[0] ==14){
                red[0] = 255;
                green[0]=0;
                blue[0] = 0;
        }
            //set mode
            if (regular == 0) {
                drawFrame();
            }
            if (regular == 1) {
                drawregular();
            }
        }

         void drawregular() {
             final SurfaceHolder holder = getSurfaceHolder();
             final Handler h = new Handler();
                          final Runnable r = new Runnable() {
                 @Override
                 public void run() {
                     //set varibles
                     if (status[0] == 1){
                         red[0] = red[0] +1;
                         if (red[0] == 255){
                             status[0] = 2;
                         }
                     }
                     if (status[0] == 2){
                         red[0]=red[0]-1;
                         green[0] = green[0] +1;
                         if (green[0] == 255){
                             status[0] = 3;
                         }
                     }
                     if (status[0] == 3){
                         red[0] = red[0] +1;
                         if (red[0] == 255){
                             status[0] = 4;
                         }
                     }
                     if (status[0] == 4){
                         red[0]=red[0]-1;
                         green[0] = green[0] -1;
                         blue[0]=blue[0]+1;
                         if (blue[0] == 255){
                             status[0] = 5;
                         }
                     }
                     if (status[0] == 5){
                         red[0]=red[0]+1;
                         if (red[0] == 255){
                             status[0] = 6;
                         }
                     }
                     if (status[0] == 6){
                         red[0]=red[0]-1;
                         green[0] = green[0] +1;
                         if (green[0] == 255){
                             status[0] = 7;
                         }
                     }

                     if (status[0] == 7){
                         red[0]=red[0]+1;
                         if (red[0] == 255){
                             status[0] = 8;
                         }
                     }
                     //reverse
                     if (status[0] == 8) {
                         red[0] = red[0] - 1;
                         if (red[0] == 0) {
                             status[0] = 9;
                         }
                     }
                     if (status[0] == 9) {
                         red[0] = red[0] +1;
                         green[0] = green[0] -1;
                         if (red[0] == 255) {
                             status[0] = 10;
                         }
                     }
                     if (status[0] == 10) {
                         red[0] = red[0] - 1;
                         if (red[0] == 0) {
                             status[0] = 11;
                         }
                     }

                     if (status[0] == 11) {
                         red[0]=red[0]+1;
                         green[0] = green[0] +1;
                         blue[0]=blue[0]-1;
                         if (red[0] == 255) {
                             status[0] = 12;
                         }
                     }
                     if (status[0] == 12) {
                         red[0]=red[0]-1;
                         if (red[0] == 0) {
                             status[0] = 13;
                         }
                     }
                     if (status[0] == 13) {
                         red[0]=red[0]+1;
                         green[0]=green[0]-1;
                         if (red[0] == 255) {
                             status[0] = 14;
                         }
                     }

                     if (status[0] == 14) {
                         red[0]=red[0]-1;
                         if (red[0] == 0) {
                             status[0] = 1;
                         }
                     }

                     //draw canvar
                     Canvas c = null;
                     try
                     {
                         c = holder.lockCanvas();
                         if (c != null)
                         {
                             c.drawARGB(255,red[0],green[0],blue[0]);
                         }
                     } finally
                     {
                         if (c != null) holder.unlockCanvasAndPost(c);
                     }
                     h.postDelayed(this,1);
                 }
             };

             h.post(r);
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
