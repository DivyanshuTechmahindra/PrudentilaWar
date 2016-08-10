package uk.prudential.businessunit1.splashscreen.customerlist.adapter.models;

/**
 * Created by user on 8/10/2016.
 */

    import java.util.ArrayList;
    import java.util.List;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    public class DataModel_CustomerList {



            @SerializedName("list")
            @Expose
            private java.util.List<uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.List> list = new ArrayList<uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.List>();

            /**
             *
             * @return
             * The list
             */
            public java.util.List<uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.List> getList() {
                return list;
            }

            /**
             *
             * @param list
             * The list
             */
            public void setList(java.util.List<uk.prudential.businessunit1.splashscreen.customerlist.adapter.models.List> list) {
                this.list = list;
            }

        }