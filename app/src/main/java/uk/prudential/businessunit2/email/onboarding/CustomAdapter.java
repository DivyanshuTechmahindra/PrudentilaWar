package uk.prudential.businessunit2.email.onboarding;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.prudential.MainActivity;
import uk.prudential.R;
import uk.prudential.businessunit1.splashscreen.customerlist.activity.CustomerListActivity;
import uk.prudential.businessunit1.splashscreen.customerlist.activity.CustomerListActivityMain;
import uk.prudential.businessunit2.email.ContactUser;
import uk.prudential.businessunit2.email.CustomerActivity;
import uk.prudential.businessunit2.email.InboxEmailReplylFragment;

/**
 * Created by user on 8/10/2016.
 */



    public class CustomAdapter extends BaseAdapter {

        String [] result;
    OnBoardingActivity context;
        int [] imageId;
        private static LayoutInflater inflater=null;
        public CustomAdapter(OnBoardingActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
            // TODO Auto-generated constructor stub
            result=prgmNameList;
            context=mainActivity;
            imageId=prgmImages;
            inflater = ( LayoutInflater )context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return result.length;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        public class Holder
        {
            TextView tv;
            ImageView img;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            Holder holder=new Holder();
            View rowView;

            rowView = inflater.inflate(R.layout.gridview_home, null);
            holder.tv=(TextView) rowView.findViewById(R.id.textView1);
            holder.img=(ImageView) rowView.findViewById(R.id.imageView1);

            holder.tv.setText(result[position]);
            holder.img.setImageResource(imageId[position]);

            rowView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                   // Intent intent = new Intent(context, CustomerListActivityMain.class);
                    Intent intent = new Intent(context, CustomerActivity.class);
                    context.startActivity(intent);


                    // TODO Auto-generated method stub
                    Toast.makeText(context, "You Clicked "+result[position], Toast.LENGTH_LONG).show();
                }
            });

            return rowView;
        }

    }
