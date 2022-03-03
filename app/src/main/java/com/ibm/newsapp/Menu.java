package com.ibm.newsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Menu extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_menu, container, true);
        Button buttonLastNews = view.findViewById(R.id.lastnewsButton);
        buttonLastNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity thisActivity = getActivity();
                if (thisActivity != null) {
                    startActivity(new Intent(thisActivity, UltimasNoticiasActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)); // if needed
                    thisActivity.finish();
                }
            }
        });

        Button buttonCategory = view.findViewById(R.id.categoriesButton);
        buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Activity thisActivity = getActivity();
                if (thisActivity != null) {
                    startActivity(new Intent(thisActivity, CategoriasNoticiasActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)); // if needed
                    thisActivity.finish();
                }
            }
        });
        return view;
    }

}