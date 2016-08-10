package uk.prudential.businessunit1.splashscreen.customerlist.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import uk.prudential.R;
import uk.prudential.businessunit1.splashscreen.customerlist.activity.CustomerListActivityMain;
import uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.DataModel_CustomerList;
import uk.prudential.businessunit1.splashscreen.filter.FilterActivity;

/**
 * Created by user on 8/10/2016.
 */
public class CustomAdapter extends BaseAdapter{

    Context context;
    public static LayoutInflater inflater = null;
    DataModel_CustomerList mSchema;
    public CustomAdapter(CustomerListActivityMain mainActivity, DataModel_CustomerList mSchema){

        context = mainActivity;

        this.mSchema = mSchema;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mSchema.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder{
        TextView tv_customerName,txtGender,tv_customerAge,tv_plan, tv_planType, tv_percentage;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.adapter_customerlist, null);
        holder.tv_customerName = (TextView)rowView.findViewById(R.id.tv_customerName);
        holder.txtGender = (TextView)rowView.findViewById(R.id.txtGender);
        holder.tv_customerAge = (TextView)rowView.findViewById(R.id.tv_customerAge);
        holder.tv_plan = (TextView)rowView.findViewById(R.id.tv_plan);
        holder.tv_planType = (TextView)rowView.findViewById(R.id.tv_planType);
        holder.tv_percentage = (TextView)rowView.findViewById(R.id.tv_percentage);



        holder.tv_customerName.setText(mSchema.getList().get(position).getName().getFirst()+" "+mSchema.getList().get(position).getName().getLast());
        holder.txtGender.setText(mSchema.getList().get(position).getGender());
        holder.tv_customerAge.setText(mSchema.getList().get(position).getAge()+"");
        holder.tv_plan.setText(mSchema.getList().get(position).getProducts().get(0).getName());
        holder.tv_planType.setText(mSchema.getList().get(position).getProducts().get(0).getType());
        holder.tv_percentage.setText("100%");

//        rowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context,"You Click "+mSchema.getList().get(position).getName().getFirst(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(context,FilterActivity.class);
//                context.startActivity(intent);
//            }
//        });


        return rowView;
    }
}
