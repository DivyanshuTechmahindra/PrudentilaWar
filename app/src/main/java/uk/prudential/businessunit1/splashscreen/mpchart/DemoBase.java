package uk.prudential.businessunit1.splashscreen.mpchart;

/**
 * Created by user on 8/10/2016.
 */

import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import uk.prudential.R;


/**
 * Baseclass of all Activities of the Demo Application.
 *
 * @author
 */
public abstract class DemoBase extends FragmentActivity {

    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    protected String[] mParties = new String[] {
            "Client A", "Client B", "Client C", "Client D", "Client E", "Client F", "Client G", "Client H",
            "Client I", "Client J", "Client K", "Client L", "Client M", "Client N", "Client O", "Client P",
            "Client Q", "Client R", "Client S", "Client T", "Client U", "Client V", "Client W", "Client X",
            "Client Y", "Client Z"
    };

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTfRegular = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}
