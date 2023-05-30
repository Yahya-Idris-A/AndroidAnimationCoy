package com.example.androidanimationcoy;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ObjectAnimator mAnimatorLeft;
    ObjectAnimator mAnimatorKeeperMove;
    ObjectAnimator mAnimatorDown;
    ObjectAnimator mAnimatorXBack;
    ObjectAnimator mAnimatorStraight;
    ObjectAnimator mAnimatorYBack;
    ObjectAnimator mAnimatorKeeperBack;
    ObjectAnimator mAnimatorFade;
    ObjectAnimator mAnimatorZoomOutY;
    ObjectAnimator mAnimatorZoomInY;
    ObjectAnimator mAnimatorZoomOutX;
    ObjectAnimator mAnimatorZoomInX;
    ObjectAnimator mAnimatorRotate;
    private AnimatorSet mAnimatorSetGoal = new AnimatorSet();
    private AnimatorSet mAnimatorSetOut = new AnimatorSet();
    int side=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        ImageView imgView = findViewById(R.id.img);
        ImageView imgKeeper = findViewById(R.id.img_keeper);
        ImageView imgText = findViewById(R.id.text_img);
        imgText.setVisibility(View.INVISIBLE);
        Button midBtn = findViewById(R.id.mid_btn);

        mAnimatorStraight = ObjectAnimator.ofFloat(imgView,"y", 650);
        mAnimatorLeft = ObjectAnimator.ofFloat(imgView,"x", 130);
        mAnimatorDown = ObjectAnimator.ofFloat(imgView, "y", 800);
        mAnimatorXBack = ObjectAnimator.ofFloat(imgView,"x", 380);
        mAnimatorYBack = ObjectAnimator.ofFloat(imgView,"y", 1430);
        mAnimatorRotate = ObjectAnimator.ofFloat(imgView,"rotation", 400);
        mAnimatorZoomOutX = ObjectAnimator.ofFloat(imgView, "scaleX", 0.5f);
        mAnimatorZoomInX = ObjectAnimator.ofFloat(imgView, "scaleX", 1);
        mAnimatorZoomOutY = ObjectAnimator.ofFloat(imgView, "scaleY", 0.5f);
        mAnimatorZoomInY = ObjectAnimator.ofFloat(imgView, "scaleY", 1);

        mAnimatorKeeperBack = ObjectAnimator.ofFloat(imgKeeper, "x", 380);
        mAnimatorKeeperMove = ObjectAnimator.ofFloat(imgKeeper, "x", 130);

        mAnimatorFade = ObjectAnimator.ofFloat(imgText, "alpha", 0);

        midBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                side = random.nextInt(2);
                if (side == 0) {
                    mAnimatorRotate.setDuration(1000);
                    mAnimatorStraight.setDuration(1000);
                    mAnimatorLeft.setDuration(1000);
                    mAnimatorZoomOutX.setDuration(1000);
                    mAnimatorZoomOutY.setDuration(1000);
                    mAnimatorFade.setDuration(500);
                    mAnimatorSetGoal.play(mAnimatorRotate).with(mAnimatorStraight).
                            with(mAnimatorLeft).with(mAnimatorZoomOutY).
                            before(mAnimatorFade).with(mAnimatorZoomOutX).
                            before(mAnimatorXBack).before(mAnimatorYBack).
                            before(mAnimatorZoomInY).before(mAnimatorZoomInX);
                    mAnimatorSetGoal.start();
                    imgText.setImageResource(R.drawable.goal);
                    imgText.setVisibility(View.VISIBLE);
                    String str = String.valueOf(side);
                    Log.i("side", str);

                }else {
                    mAnimatorRotate.setDuration(1000);
                    mAnimatorStraight.setDuration(1000);
                    mAnimatorLeft.setDuration(1000);
                    mAnimatorZoomOutX.setDuration(1000);
                    mAnimatorZoomOutY.setDuration(1000);
                    mAnimatorKeeperMove.setDuration(1000);
                    mAnimatorFade.setDuration(500);
                    mAnimatorSetOut.play(mAnimatorRotate).with(mAnimatorStraight).
                            with(mAnimatorLeft).with(mAnimatorKeeperMove).
                            with(mAnimatorZoomOutX).with(mAnimatorZoomOutY).
                            before(mAnimatorFade).before(mAnimatorXBack).
                            before(mAnimatorYBack).before(mAnimatorKeeperBack).
                            before(mAnimatorZoomInX).before(mAnimatorZoomInY);
                    mAnimatorSetOut.start();
                    imgText.setImageResource(R.drawable.save);
                    imgText.setVisibility(View.VISIBLE);
                    String str = String.valueOf(side);
                    Log.i("side", str);
                }
            }
        });
    }
}