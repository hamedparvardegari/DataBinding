package com.parvardegari.mvvmnew.viewModel;


import android.annotation.SuppressLint;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.google.android.material.internal.TextWatcherAdapter;
import com.parvardegari.mvvmnew.BR;
import com.parvardegari.mvvmnew.BaseRequest;
import com.parvardegari.mvvmnew.model.PurchaseRole;

import java.util.ArrayList;
import java.util.Objects;

public class PurchaseRoleViewModel extends BaseObservable {

    private final Context context;

    @Bindable
    public String phone="";



    public PurchaseRoleViewModel(Context context) {
        this.context = context;
    }



    private ArrayList<PurchaseRole> purchaseRoles;


    public void getRoles() {
        if (phone != null) {
            BaseRequest<PurchaseRole> baseRequest = new BaseRequest.Builder<PurchaseRole>()
                    .arrayType(PurchaseRole[].class)
                    .method(BaseRequest.POST)
                    .body("phone", phone)
                    .subUrl("getroles")
                    .build();

            baseRequest.getResults(context, new BaseRequest.MultipleResultListener<>() {
                @Override
                public void onResult(@NonNull ArrayList<PurchaseRole> results) {
                    purchaseRoles = results;
                    notifyPropertyChanged(BR.sKU);
                }

                @Override
                public void onError(int code, @NonNull String response) {

                }

                @Override
                public void onException(@NonNull String message) {

                }
            });
        }

    }


    @Bindable
    public String getSKU() {
        if (purchaseRoles != null)
            return purchaseRoles.get(0).getSKU();
        return null;
    }
}
