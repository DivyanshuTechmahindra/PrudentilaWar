package uk.prudential.businessunit2.email.onboarding.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import uk.prudential.R;
import uk.prudential.businessunit2.email.onboarding.OnBoardingActivity;


/**
 * Created by PK00339187 on 12-07-2016.
 */
public class OnBoardingFragmentOne extends Fragment {

    View mView;
    OnBoardingActivity context;
    String mParam1, mParam2;
    int mParam3;

    public OnBoardingFragmentOne() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(OnBoardingActivity.ARG_PARAM1);
            mParam2 = getArguments().getString(OnBoardingActivity.ARG_PARAM2);
            mParam3 = getArguments().getInt(OnBoardingActivity.ARG_PARAM3);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_onbording121, container, false);
        return mView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Customize SpeedometerGauge

       // TextView tXtTop = (TextView) mView.findViewById(R.id.onbordtext_top);
       // TextView tXtMsg = (TextView) mView.findViewById(R.id.onbordtext_bottom);
        ImageView iMgCenterIcon = (ImageView) mView.findViewById(R.id.onbordImage);
       // tXtTop.setText(mParam1);
        // To put property of Bold, used html feature while setting text string.
      //  tXtMsg.setText(Html.fromHtml(mParam2));
        iMgCenterIcon.setImageResource(mParam3);

    }
}