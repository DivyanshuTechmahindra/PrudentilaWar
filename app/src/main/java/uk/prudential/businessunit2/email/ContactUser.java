package uk.prudential.businessunit2.email;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import uk.prudential.R;

/**
 * Created by user on 8/10/2016.
 */
//Test commit
public class ContactUser extends AppCompatActivity {
    public EditText tvMessage;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_user);
        Context con = this;
        Button mFloatingActionButton2 = (Button) findViewById(R.id.floatingActionButtonPersonalInfo2);
        //mFloatingActionButton.setOnClickListener(this);
        mFloatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsDialog(ContactUser.this,"","");
            }
        });
        Button mFloatingActionButton3 = (Button) findViewById(R.id.floatingActionButtonPersonalInfo3);
        //mFloatingActionButton.setOnClickListener(this);
        mFloatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ContactUser.this, InboxEmailReplylFragment.class);
                ContactUser.this.startActivity(intent);

            }
        });

                Button mFloatingActionButton1 = (Button) findViewById(R.id.floatingActionButtonPersonalInfo1);
        //mFloatingActionButton.setOnClickListener(this);
        mFloatingActionButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + "8860611845"));
                if (ActivityCompat.checkSelfPermission(ContactUser.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                //ContactUser.this.startActivities(intent);

            }
        });

    }
    public  void SmsDialog(final Activity mActivity, String mtitle, String mMessage) {

        if (mActivity != null && mtitle != null && mtitle.length() > 0 && mMessage != null && mMessage.length() > 0) {
            final Dialog dialog = new Dialog(mActivity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.sms_dialog);
            //dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(false);
            TextView tvTitle = (TextView) dialog.findViewById(R.id.tvTitle);
            tvTitle.setText(mtitle.toString().trim());
            tvMessage = (EditText) dialog.findViewById(R.id.tvMessage);


            Button btOk = (Button) dialog.findViewById(R.id.bt_ok);

            btOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendSMS("8860611845",tvMessage.getText().toString());

                    dialog.dismiss();

                }
            });
            dialog.show();
        }
    }


    public void sendSMS(String phoneNo, String msg){
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNo, null, msg, null, null);
            Toast.makeText(getApplicationContext(), "Message Sent",
                    Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(),ex.getMessage().toString(),
                    Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }
    }

}
