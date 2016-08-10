package uk.prudential.businessunit1.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;

import uk.prudential.R;

/**
 * Created by user on 8/10/2016.
 */
public class SplashScreen extends Activity {
    Shimmer shimmer;
    ShimmerTextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        Thread timerThread = new Thread() {
            public void run() {
                try {
                    shimmer = new Shimmer();
                    tv = (ShimmerTextView) findViewById(R.id.shimmer_tv);
                    shimmer.start(tv);
                    sleep(5000);
                    // Test for commit

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

//                    if(CASE) {
//                        Intent i = new Intent(SplashScreen.this, MAIN screen.class);
//                        startActivity(i);
//                        finish();
//                    }
//                    else{
//
////                        Intent intent = new Intent(SplashScreen.this, XYZ.class);
////                        startActivity(intent);
////                        finish();
//                    }


                }
            }
        };
        timerThread.start();

    }

//    public void toggleAnimation(View target) {
//        if (shimmer != null && shimmer.isAnimating()) {
//            shimmer.cancel();
//        } else {
//            shimmer = new Shimmer();
//            shimmer.start(tv);
//        }
//    }
}
