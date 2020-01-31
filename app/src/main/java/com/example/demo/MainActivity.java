package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import static com.example.demo.R.id.imgview;
import static com.example.demo.R.id.imgview2;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    ImageView img2;
    int mode = 0;
    int drag = 1;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(imgview);
        img2 = findViewById(imgview2);
        LinearLayout.LayoutParams layoutParam = new LinearLayout.LayoutParams(250, 250);
        layoutParam.leftMargin = 50;
        layoutParam.topMargin = 50;
        img.setLayoutParams(layoutParam);
        img2.setLayoutParams(layoutParam);

        scaleGestureDetector = new ScaleGestureDetector(this,new MyGesture());

        img.setOnTouchListener(new View.OnTouchListener() {
            LinearLayout.LayoutParams params;
            float dx=0, dy=0, x=0, y=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pointerCount = event.getPointerCount();
                ImageView imageView = (ImageView) v;
                if(pointerCount == 1) {
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                            params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                            dx = event.getRawX() - params.leftMargin;
                            dy = event.getRawY() - params.topMargin;
                            mode = drag;
                            break;

                        case MotionEvent.ACTION_MOVE:
                            if (mode == drag) {
                                x = event.getRawX();
                                y = event.getRawY();

                                params.leftMargin = (int) (x - dx);
                                params.topMargin = (int) (y - dy);

                                params.rightMargin = 0;
                                params.bottomMargin = 0;
                                params.rightMargin = params.leftMargin + (5 * params.width);
                                params.bottomMargin = params.topMargin + (10 * params.height);

                                imageView.setLayoutParams(params);
                            }
                    }
                }else{
                    scaleGestureDetector.onTouchEvent(event);
                }
                return true;
            }
        });

        img2.setOnTouchListener(new View.OnTouchListener() {
            LinearLayout.LayoutParams params;
            float dx=0, dy=0, x=0, y=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pointerCount = event.getPointerCount();
                ImageView imageView = (ImageView) v;
                if(pointerCount == 1) {
                    switch (event.getAction() & MotionEvent.ACTION_MASK) {
                        case MotionEvent.ACTION_DOWN:
                            params = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                            dx = event.getRawX() - params.leftMargin;
                            dy = event.getRawY() - params.topMargin;
                            mode = drag;
                            break;

                        case MotionEvent.ACTION_MOVE:
                            if (mode == drag) {
                                x = event.getRawX();
                                y = event.getRawY();

                                params.leftMargin = (int) (x - dx);
                                params.topMargin = (int) (y - dy);

                                params.rightMargin = 0;
                                params.bottomMargin = 0;
                                params.rightMargin = params.leftMargin + (5 * params.width);
                                params.bottomMargin = params.topMargin + (10 * params.height);

                                imageView.setLayoutParams(params);
                            }
                    }
                }else{
                    scaleGestureDetector.onTouchEvent(event);
                }
                return true;
            }
        });
    }

    class MyGesture extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        float scale = 1.0F; //onScaleStart = 0, onScaleEnd = 0;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *= detector.getScaleFactor();
            img.setScaleX(scale);
            img.setScaleY(scale);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            super.onScaleEnd(detector);
        }
    }
}
