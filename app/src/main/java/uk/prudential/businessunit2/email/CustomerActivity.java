package uk.prudential.businessunit2.email;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

import uk.prudential.R;
import uk.prudential.businessunit1.splashscreen.customerlist.activity.CustomerListActivity;
import uk.prudential.businessunit1.splashscreen.mpchart.DemoBase;

/**
 * Created by user on 8/10/2016.
 */
//Test commit
public class CustomerActivity extends DemoBase implements OnChartValueSelectedListener ,SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    public EditText tvMessage;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
private CustomerActivity mContext;
    private SeekBar mSeekBarX, mSeekBarY;
    private TextView tvX, tvY;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customerdetail);
         mContext = this;

       barchart(mContext);
        pichart(mContext);
        //ImageView mImage = (ImageView) findViewById(R.id.img_2);
        TextView txt2_d21 = (TextView) findViewById(R.id.txt2_d21);
        TextView txt2_d22 = (TextView) findViewById(R.id.txt2_d22);
        TextView txt2_d23 = (TextView) findViewById(R.id.txt2_d23);
        TextView txt2_d31 = (TextView) findViewById(R.id.txt2_d31);
        TextView txt2_d33 = (TextView) findViewById(R.id.txt2_d33);
        TextView mTetxt2_insurancext = (TextView) findViewById(R.id.txt2_insurance);
        TextView txt2_penson2 = (TextView) findViewById(R.id.txt2_penson2);
        TextView txt_Name = (TextView) findViewById(R.id.txt_Name);
        TextView txt_birth = (TextView) findViewById(R.id.txt_birth);
        TextView txt_phone = (TextView) findViewById(R.id.txt_phone);
        TextView txt_roll = (TextView) findViewById(R.id.txt_roll);
        TextView txt_acno = (TextView) findViewById(R.id.txt_acno);
      //  TextView txt_roll = (TextView) findViewById(R.id.txt_roll);

        ImageView mImagRecomArrow = (ImageView) findViewById(R.id.img_arrow);
        mImagRecomArrow.setOnClickListener(this);
        ImageView mImagThumb = (ImageView) findViewById(R.id.img_thumb);
        mImagThumb.setOnClickListener(this);

    }


    BarChart mChart;
    private PieChart mPieChart;
    private Typeface tf;

private void barchart(CustomerActivity mContext){

    tvX = (TextView) mContext.findViewById(R.id.tvXMax);
    tvY = (TextView) mContext.findViewById(R.id.tvYMax);

    mSeekBarX = (SeekBar) mContext.findViewById(R.id.seekBar11);
    mSeekBarX.setOnSeekBarChangeListener(this);

    mSeekBarY = (SeekBar) mContext.findViewById(R.id.seekBar21);
    mSeekBarY.setOnSeekBarChangeListener(this);

     mChart = (BarChart) mContext.findViewById(R.id.chart11);

    mChart.setDescription("");

    // if more than 60 entries are displayed in the chart, no values will be
    // drawn
    mChart.setMaxVisibleValueCount(60);

    // scaling can now only be done on x- and y-axis separately
    mChart.setPinchZoom(false);

    mChart.setDrawBarShadow(false);
    mChart.setDrawGridBackground(false);

    XAxis xAxis = mChart.getXAxis();
    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    xAxis.setDrawGridLines(false);

    mChart.getAxisLeft().setDrawGridLines(false);
    mSeekBarX.setProgress(10);
    mSeekBarY.setProgress(100);

    // add a nice and smooth animation
    mChart.animateY(2500);

    mChart.getLegend().setEnabled(false);

}
private void pichart(CustomerActivity mContext){
      mPieChart = (PieChart) mContext.findViewById(R.id.chart1);
    mPieChart.setUsePercentValues(true);
    mPieChart.setDescription("");
    mPieChart.setExtraOffsets(5, 10, 5, 5);
    mPieChart.setDragDecelerationFrictionCoef(0.95f);
    tf = Typeface.createFromAsset(getAssets(), "OpenSans-Regular.ttf");

    mPieChart.setCenterTextTypeface(Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf"));
    mPieChart.setCenterText(generateCenterSpannableText());

    mPieChart.setExtraOffsets(20.f, 0.f, 20.f, 0.f);

    mPieChart.setDrawHoleEnabled(true);
    mPieChart.setHoleColor(Color.WHITE);

    mPieChart.setTransparentCircleColor(Color.WHITE);
    mPieChart.setTransparentCircleAlpha(110);

    mPieChart.setHoleRadius(58f);
    mPieChart.setTransparentCircleRadius(61f);

    mPieChart.setDrawCenterText(true);

    mPieChart.setRotationAngle(0);
    // enable rotation of the chart by touch
    mPieChart.setRotationEnabled(true);
    mPieChart.setHighlightPerTapEnabled(true);

    // mChart.setUnit(" €");
    // mChart.setDrawUnitsInChart(true);

    // add a selection listener
    mPieChart.setOnChartValueSelectedListener(this);
    setData(4, 100);

    mPieChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);
    // mChart.spin(2000, 0, 360);

    Legend l = mPieChart.getLegend();
    l.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
    l.setEnabled(false);
}





    @Override
    public void onValueSelected(Entry e, Highlight h) {

        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getY() + ", xIndex: " + e.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }
//
//    @Override
//    public void onStartTrackingTouch(SeekBar seekBar) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onStopTrackingTouch(SeekBar seekBar) {
//        // TODO Auto-generated method stub
//
//    }

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < count; i++) {
            entries.add(new PieEntry((float) (Math.random() * mult) + mult / 5, mParties[i % mParties.length]));
        }

        PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<Integer>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);


        dataSet.setValueLinePart1OffsetPercentage(80.f);
        dataSet.setValueLinePart1Length(0.2f);
        dataSet.setValueLinePart2Length(0.4f);
        // dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(tf);
        mPieChart.setData(data);

        // undo all highlights
        mPieChart.highlightValues(null);

        mPieChart.invalidate();
    }

    private SpannableString generateCenterSpannableText() {

        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.65f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }



    /*BarChart===============================================================*/
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        tvX.setText("" + (mSeekBarX.getProgress() + 1));
        tvY.setText("" + (mSeekBarY.getProgress()));

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < mSeekBarX.getProgress() + 1; i++) {
            float mult = (mSeekBarY.getProgress() + 1);
            float val = (float) (Math.random() * mult) + mult / 3;
            yVals1.add(new BarEntry(i, val));
        }

        BarDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Data Set");
            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            set1.setDrawValues(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            mChart.setData(data);
            mChart.setFitBars(true);
        }

        mChart.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_arrow:
                Intent intent = new Intent(mContext, CustomerListActivity.class);
                mContext.startActivity(intent);

                break;
            case R.id.img_thumb:
                Intent intent1 = new Intent(mContext, CustomerActivity.class);
                mContext.startActivity(intent1);

                break;
        }

        }
}