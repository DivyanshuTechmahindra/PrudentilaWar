package uk.prudential.businessunit2.email;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONObject;

import uk.prudential.R;

/**
 * Created by PK00339187 on 17-12-2015.
 */
public class InboxEmailReplylFragment extends Activity implements View.OnClickListener {
    public final static String TAG = "InboxEmailReplylFragment";
    EditText mEdtSubject, mEdtMsg;
    TextView replyFrom, replyDate;
    private Button mbtnEmailSend, mbtnEmailCancel;
    private ImageView imgSend, imgBack;


   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.email_reply);
        initView(this);
    }




    public void initView(InboxEmailReplylFragment getView) {
        TextView lTxtViewTitle = (TextView) getView.findViewById(R.id.view_title);
        lTxtViewTitle.setVisibility(View.VISIBLE);
        lTxtViewTitle.setText("Reply");
        replyDate = (TextView) getView.findViewById(R.id.replyDate);
        replyFrom = (TextView) getView.findViewById(R.id.replyFrom);
        imgSend = (ImageView) getView.findViewById(R.id.imgArrowRight);
        imgBack = (ImageView) getView.findViewById(R.id.imgBack);
        Button btnEmailSend = (Button) getView.findViewById(R.id.btnEmailSend);

        mEdtSubject = (EditText) getView.findViewById(R.id.emEdtSubject);
        mEdtMsg = (EditText) getView.findViewById(R.id.emEdtMessage);
        mEdtMsg.requestFocus();
        btnEmailSend.setOnClickListener(this);

        /*if (getArguments() != null) {
            // lTxtViewTitle.setText("Re:"+getArguments().getString("messageTitle")+"");
            replyDate.setText(getArguments().getString("sendDate"));
            replyFrom.setText("Frome: Me");
            mEdtSubject.setText(getArguments().getString("senderName") + "");
        }*/
       /* Getting data : bundle.putString("senderName", data.getSenderName());
        bundle.putString("messageTitle", data.getMessageTitle());
        bundle.putInt("receiverId", data.getReceiverId());
        bundle.putInt("parentMessageId", data.getParentMessageId());*/


       /* mbtnEmailCancel = (Button) getView().findViewById(R.id.btnEmailCancel);
        mbtnEmailSend = (Button) getView().findViewById(R.id.btnEmailSend);

        mbtnEmailCancel.setOnClickListener(this);
        mbtnEmailSend.setOnClickListener(this);*/
        imgBack.setOnClickListener(this);
        imgSend.setOnClickListener(this);
    }


    public static boolean isValidateField(Activity activity, EditText mEditTextUserPassword) {
        if (mEditTextUserPassword.getText().toString().trim().length() > 0) {
            return true;
        } else {
            mEditTextUserPassword.setError(activity.getString(R.string.field_name_error));
        }
        return false;
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            // case R.id.btnEmailSend:
            case R.id.imgArrowRight:
            case R.id.btnEmailSend:
                if (isValidateField(this, mEdtMsg) && isValidateField(this, mEdtSubject)) {
                    ReplyMessage();
                }
                break;
            case R.id.imgBack:
                //   case R.id.btnEmailCancel:
                finish();
                break;
        }
    }
private void ReplyMessage(){
    final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
    emailIntent.setType("text/plain");
    emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{  "prashant@2728@gmail.com"});
    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Hello There");
    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Add Message here");

    emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, mEdtSubject.getText().toString().trim());
    emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, mEdtMsg.getText().toString().trim());


    emailIntent.setType("message/rfc822");

    try {
        startActivity(Intent.createChooser(emailIntent,
                "Send email using..."));
    } catch (android.content.ActivityNotFoundException ex) {
        Toast.makeText(this,"No email clients installed.",
                Toast.LENGTH_SHORT).show();
    }

}
});
        Android will automatically choose clients avilable in your device and user will be free to choose any Email client he want
}
   /* private void ReplyMessage() {
        try {
               "receiverId": 2, { user id of the receiver}
        "parentMessageId": 3, { Message id of message on which user replied }
        "messageTitle": "Hi",
                "message": "Hi, how are you?",
                "attachmentFlag": 1, { 0 - No attachment, 1 - attachment(s) }
        "attachmentsName": "abc.jpg,de.jpgf" { attachment(s) name }*/

           /* JSONObject lObjParam = new JSONObject();
            lObjParam.put(Constants.TAG_RECEIVERID, getArguments().getInt("receiverId"));
            lObjParam.put(Constants.TAG_PARENTMESSAGEID, getArguments().getInt("parentMessageId"));
            lObjParam.put(Constants.TAG_MESSAGETITLE, mEdtSubject.getText().toString().trim());
            lObjParam.put(Constants.TAG_MESSAGE, mEdtMsg.getText().toString().trim());
            lObjParam.put(Constants.TAG_ATTACHMENTFLAG, 0);
            lObjParam.put(Constants.TAG_ATTACHMENTNAME, "");
            WSRequestController.getInstance().requestToServer(getActivity(), WSConstants.URL_FOR_REPLY_MESSAGE, lObjParam.toString(), true, new ResponseListener() {
                @Override
                public void onResponseSuccess(String response) {
                    AppLog.log("replyMessage onResponseSuccess  " + response);
                    Toast.makeText(getActivity(), "" + response.toString(), Toast.LENGTH_SHORT).show();
                    Fragment squadFragment = new DashBoardFragment();
                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container_body, squadFragment, null);
                    fragmentTransaction.commit();
                }

                @Override
                public void onResponseError(String errorCode) {
                    AppLog.log("doLogin onResponseError " + errorCode);
                    Toast.makeText(getActivity(), "" + errorCode, Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            AppLog.logError("Exception from doRegistration in " + TAG + " " + e.getMessage());
        }
        // need to write a code to send email.
    }*/

    }