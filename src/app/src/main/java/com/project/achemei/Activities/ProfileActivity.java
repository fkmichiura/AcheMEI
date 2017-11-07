package com.project.achemei.Activities;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.achemei.Fragments.PicturesFragment;
import com.project.achemei.Fragments.ProfileFragment;
import com.project.achemei.Fragments.TeamFragment;
import com.project.achemei.R;
import com.project.achemei.Adapters.ViewPagerAdapter;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        ViewPager viewPager = (ViewPager) findViewById(R.id.tab_viewpager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new ProfileFragment(), "Sobre");
        viewPagerAdapter.addFragment(new TeamFragment(), "Equipe");
        viewPagerAdapter.addFragment(new PicturesFragment(), "Galeria");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
