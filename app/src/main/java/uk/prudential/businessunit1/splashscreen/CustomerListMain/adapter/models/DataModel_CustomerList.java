package uk.prudential.businessunit1.splashscreen.CustomerListMain.adapter.models;

/**
 * Created by user on 8/10/2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class DataModel_CustomerList {



        @SerializedName("list")
        @Expose
        private List<uk.prudential.businessunit1.splashscreen.CustomerListMain.adapter.models.List> list = new ArrayList<uk.prudential.businessunit1.splashscreen.CustomerListMain.adapter.models.List>();

        /**
         *
         * @return
         * The list
         */
        public List<uk.prudential.businessunit1.splashscreen.CustomerListMain.adapter.models.List> getList() {
            return list;
        }

        /**
         *
         * @param list
         * The list
         */
        public void setList(List<uk.prudential.businessunit1.splashscreen.CustomerListMain.adapter.models.List> list) {
            this.list = list;
        }

    }