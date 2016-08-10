package uk.prudential.businessunit1.splashscreen.customerlist.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import uk.prudential.R;
import uk.prudential.businessunit1.splashscreen.customerlist.ParserCustomerList.ParserCustomerList;
import uk.prudential.businessunit1.splashscreen.customerlist.ProgressHUD;
import uk.prudential.businessunit1.splashscreen.customerlist.adapter.CustomAdapter;
import uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.DataModel_CustomerList;
import uk.prudential.businessunit2.email.ContactUser;

/**
 * Created by user on 8/10/2016.
 */
public class CustomerListActivityMain extends AppCompatActivity implements SearchView.OnQueryTextListener {
    MenuItem item;
        private static final String TAG = "SearchViewFilterMode";
    ProgressHUD mProgressHUD2;
        private SearchView mSearchView;
        private ListView mListView;
        private ArrayAdapter<String> mAdapter;
        DataModel_CustomerList mSchema;

        private final String[] mStrings = new String[9];//= Cheeses.sCheeseStrings;



    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

            setContentView(R.layout.activity_customerlist);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Customer List");



            new fetchCustomerDetailsAsyncTask("").execute();
          //  setupSearchView();
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_customerlist, menu);

        return super.onCreateOptionsMenu(menu);
    }
    private void setupSearchView() {
        mSearchView.setIconifiedByDefault(false);
        mSearchView.setOnQueryTextListener(this);
        mSearchView.setSubmitButtonEnabled(false);
//        mSearchView.setQueryHint(getString(R.string.cheese_hunt_hint));
        mSearchView.setQueryHint("Search customer");
    }

    public boolean onQueryTextChange(String newText) {
        if (TextUtils.isEmpty(newText)) {
            mListView.clearTextFilter();
        } else {
            mListView.setFilterText(newText.toString());
        }
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    class fetchCustomerDetailsAsyncTask extends AsyncTask<String, Void, String> {

        private Exception exception;
        String mID;

        public fetchCustomerDetailsAsyncTask(String id) {
            mID = id;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressHUD2 = ProgressHUD.show(CustomerListActivityMain.this,
                    "Fetching Customer Details List....", true, true, null);
        }

        protected String doInBackground(String... urls) {
            try {
                ParserCustomerList deleteTruckDetails = new ParserCustomerList(CustomerListActivityMain.this);
                return "";
            } catch (Exception e) {
                this.exception = e;
                return null;
            }
        }

        protected void onPostExecute(String feed) {

            mProgressHUD2.dismiss();
            try {

                mSchema = ParserCustomerList.schema;
                final List<DataModel_CustomerList> filteredModelList = new ArrayList<>();
                //mStrings = mSchema.getList().size();
                for(int i=0;i<mSchema.getList().size();i++) {
                    mStrings[i] = mSchema.getList().get(i).getName().getFirst();
                }

                mSearchView = (SearchView) findViewById(R.id.search_view);

                int id = mSearchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
                TextView textView = (TextView) mSearchView.findViewById(id);
                textView.setTextColor(Color.BLACK);

                //mSearchView.setLayoutParams(new ActionBar.LayoutParams(Gravity.RIGHT));
                mListView = (ListView) findViewById(R.id.list_view);
//                mListView.setAdapter(mAdapter = new ArrayAdapter<String>(CustomerListActivityMain.this,
//                        android.R.layout.simple_list_item_1,
//                        mStrings));

                mListView.setAdapter(new CustomAdapter(CustomerListActivityMain.this,mSchema));
                setupSearchView();
                mListView.setTextFilterEnabled(true);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        Intent intent = new Intent(CustomerListActivityMain.this,ContactUser.class);
                        startActivity(intent);
                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}


