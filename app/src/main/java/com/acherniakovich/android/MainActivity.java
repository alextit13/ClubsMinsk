package com.acherniakovich.android;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.yalantis.guillotine.animation.GuillotineAnimation;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 250;

    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;
    private ListView main_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        root = (FrameLayout) findViewById(R.id.root);
        contentHamburger = (View) findViewById(R.id.content_hamburger);
        main_list_view = (ListView) findViewById(R.id.main_list_view);

        test();


        if (toolbar != null) {
            //setSupportActionBar(toolbar);
            //getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);
        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_hamburger), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }

    private void test() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i<100;i++){
            list.add("Item discount # " + i);
        }
        ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,list);

        main_list_view.setAdapter(adapter);
    }
}
