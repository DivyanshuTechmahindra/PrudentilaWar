package uk.prudential.businessunit2.email.onboarding;

import android.accounts.AccountManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import uk.prudential.R;
import uk.prudential.businessunit2.email.onboarding.fragment.OnBoardingFragmentFour;
import uk.prudential.businessunit2.email.onboarding.fragment.OnBoardingFragmentOne;
import uk.prudential.businessunit2.email.onboarding.fragment.OnBoardingFragmentThree;
import uk.prudential.businessunit2.email.onboarding.fragment.OnBordingFragmentTwo;

/**
 * Created by PK00339187 on 12-07-2016.
 */
public class OnBoardingActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = "OnBording";

    public static final String ARG_PARAM1 = "textTop";
    public static final String ARG_PARAM2 = "textBottom";
    public static final String ARG_PARAM3 = "textImage";
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int FOUR = 4;

    private ViewPager viewPager;
    private LinearLayout pager_indicator;
    private int dotsCount;
    private ImageView[] dots;
    private ViewPagerAdapter adapter;
    private Button btnNext;
    private String customerName;
    ImageView btn_Back, btn_Cross;
    private int[] mImageResources = {R.drawable.kudo_thumb_ico, R.drawable.banner_bg_02, R.drawable.banner_img};

    public static String [] prgmNameList={"Customer\nInformation","Manage\nLeads","   Quotes\n","Process \n Application","Product\nBrouchers","Status \n Tracker"};
    public static int [] prgmImages={R.drawable.customer_info_ico,
            R.drawable.leads_management_ico,
            R.drawable.generate_quote_ico,

            R.drawable.application_process_ico,
            R.drawable.brochure_ico,
            R.drawable.campaign_ico};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_onbording);

            //back button defined
           /* btn_Back = (ImageView) this.findViewById(R.id.btn_Back);
            btn_Back.setVisibility(View.INVISIBLE);
            btn_Back.setOnClickListener(this);
            //cross button defined.
            btn_Cross = (ImageView) this.findViewById(R.id.btn_cross);
            btn_Cross.setOnClickListener(this);
           */ // added ViewPager
            viewPager = (ViewPager) findViewById(R.id.view_pager);
            setupViewPager(viewPager);
            viewPager.setOnPageChangeListener(onPageListner);
            // added page indicatior
            pager_indicator = (LinearLayout) this.findViewById(R.id.viewPagerCountDots);
            pager_indicator = (LinearLayout) this.findViewById(R.id.viewPagerCountDots);
            // added MyButton next
          //  btnNext = (Button) this.findViewById(R.id.btn_next);
           // btnNext.setOnClickListener(this);

        GridView gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));

        setUiPageViewController();
        /*} catch (Exception e) {
            //AnalyticsHelper.logException(e, true);
        }*/
    }


    @SuppressLint("StringFormatMatches")
    private void setupViewPager(ViewPager viewPager) {
        // Text font handling of messages.
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        String value1 = "<b> FREE . </b>";
        String value2 = "<b> 23kg...</b>", value3 = "<b> 20kg</b>", value4 = "<b>3kg baggage credit</b>";
        adapter.addFragment(new OnBoardingFragmentOne(), getResources().getString(R.string.txtonbording_Top1), String.format(getResources().getString(R.string.txt_onbordingbottom1).toString(), value1), mImageResources[0]);
        adapter.addFragment(new OnBordingFragmentTwo(), getResources().getString(R.string.txtonbording_Top2), String.format(getResources().getString(R.string.txt_onbordingbottom2).toString(), customerName, value2), mImageResources[1]);
        adapter.addFragment(new OnBoardingFragmentThree(), getResources().getString(R.string.txtonbording_Top3), String.format(getResources().getString(R.string.txt_onbordingbottom3).toString(), customerName, value3), mImageResources[2]);
       // adapter.addFragment(new OnBoardingFragmentFour(), getResources().getString(R.string.txtonbording_Top4), String.format(getResources().getString(R.string.txt_onbordingbottom41).toString(), customerName, value4), mImageResources[3]);

        viewPager.setAdapter(adapter);
    }


    ViewPager.OnPageChangeListener onPageListner = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
           // btn_Back.setVisibility(View.VISIBLE);
            if (position == (dotsCount - ONE)) {
                //btnNext.setText(R.string.gotit);
            } else {
                //btnNext.setText(R.string.next);
                if (position == ZERO) {
                   // btn_Back.setVisibility(View.INVISIBLE);
                }
            }
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            }
            dots[position].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String param1, String param2, int param3) {
            Bundle args = new Bundle();
            args.putString(ARG_PARAM1, param1);
            args.putString(ARG_PARAM2, param2);
            args.putInt(ARG_PARAM3, param3);
            fragment.setArguments(args);

            mFragmentList.add(fragment);

        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }

    /*
     *  To handle dots icons w.r.t ViewPageer screen changes.
     */
    private void setUiPageViewController() {
        dotsCount = adapter.getCount();
        dots = new ImageView[dotsCount];
        for (int i = ZERO; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(getResources().getDrawable(R.drawable.nonselecteditem_dot));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(FOUR, ZERO, FOUR, ZERO);
            pager_indicator.addView(dots[i], params);
        }
        dots[ZERO].setImageDrawable(getResources().getDrawable(R.drawable.selecteditem_dot));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.btn_next:
               // To handle Next button of ViewPager to handle next visible page in OnBoarding Screen.
                if (viewPager.getCurrentItem() == (dotsCount - ONE)) {
                   // MyBaggageActivity.setOnBordingPreference(this, false);
                    this.finish();
                }
                viewPager.setCurrentItem((viewPager.getCurrentItem() < dotsCount)
                        ? viewPager.getCurrentItem() + ONE : ZERO);
                break;
           case R.id.btn_cross:
                // to close and switch back stake to Balance tab [ BMS-7 ]
                this.finish();
                break;
            case R.id.btn_Back:
                onBackBtnClik();
                break;
*/

        }
    }

    /*
     * To handle Back button of ViewPager to handle last visible page in OnBoarding Screen.
     */
    public void onBackBtnClik() {
        viewPager.setCurrentItem((viewPager.getCurrentItem() > ZERO)
                ? viewPager.getCurrentItem() - ONE : ZERO);
    }

}