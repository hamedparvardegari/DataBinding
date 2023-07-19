package com.parvardegari.mvvmnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.parvardegari.mvvmnew.databinding.ActivityMainBinding;
import com.parvardegari.mvvmnew.viewModel.PurchaseRoleViewModel;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        PurchaseRoleViewModel roleViewModel = new PurchaseRoleViewModel(this);
        binding.setViewModel(roleViewModel);
        binding.executePendingBindings();





    }
    @BindingAdapter({"toast"})
    public static void runMe(View view, String sku){
        if (sku!=null){
            Toast.makeText(view.getContext(), sku, Toast.LENGTH_SHORT).show();
        }

    }
}