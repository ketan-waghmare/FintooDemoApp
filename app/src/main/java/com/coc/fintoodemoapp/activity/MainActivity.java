package com.coc.fintoodemoapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.coc.fintoodemoapp.R;
import com.coc.fintoodemoapp.adapter.FragmentAdapter;
import com.coc.fintoodemoapp.adapter.ViewPagerAdapter;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;


public class MainActivity extends AppCompatActivity {

    private Fragment fragmentOne;
    private Fragment fragmentTwo;
    private Fragment fragmentFour;
    private Fragment fragmentFive;
    private Fragment fragmentThree;

    private RelativeLayout rlCard1;
    private RelativeLayout rlCard2;
    private RelativeLayout rlCard3;
    private RelativeLayout rlCard4;

    private ImageView ivDots;
    private ImageView ivLeftArrow;
    private ImageView ivRightArrow;
    private FloatingActionButton fab;
    private SpaceNavigationView spaceNavigationView;

    private CardView cardView1;
    private CardView cardView2;
    private CardView cardView3;
    private CardView cardView4;

    private ViewPager2 viewPager;
    private ViewPagerAdapter adapter;
    private FragmentAdapter fragmentAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        setFabButton();
        setNavigation(savedInstanceState);

        setupEvents();
        setDotsNumber();
        setViewPagerAdapter();
    }

    private void setDotsNumber() {
        ivDots.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("UnsafeExperimentalUsageError")
            @Override
            public void onGlobalLayout() {
                try {
                    BadgeDrawable badgeDrawable = BadgeDrawable.create(MainActivity.this);
                    badgeDrawable.setNumber(4);
                    //Important to change the position of the Badge
                    badgeDrawable.setHorizontalOffset(10);
                    badgeDrawable.setVerticalOffset(0);
                    badgeDrawable.setBadgeGravity(BadgeDrawable.TOP_START);

                    BadgeUtils.attachBadgeDrawable(badgeDrawable, ivDots, null);

                    ivDots.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    private void setViewPagerAdapter() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fragmentManager,getLifecycle());
        viewPager.setAdapter(fragmentAdapter);
    }

    private void setupEvents() {
        ivLeftArrow.setOnClickListener(v -> {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1, true);
        });

        ivRightArrow.setOnClickListener(v -> {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
        });

        cardView1.setOnClickListener(v -> {
            rlCard2.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard3.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard4.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard1.setBackgroundColor(getResources().getColor(R.color.selected_tab));
            viewPager.setCurrentItem(1);
        });

        cardView2.setOnClickListener(v -> {
            rlCard1.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard3.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard4.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard2.setBackgroundColor(getResources().getColor(R.color.selected_tab));
            viewPager.setCurrentItem(2);
        });

        cardView3.setOnClickListener(v -> {
            rlCard1.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard2.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard4.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard3.setBackgroundColor(getResources().getColor(R.color.selected_tab));
            viewPager.setCurrentItem(3);
        });

        cardView4.setOnClickListener(v -> {
            rlCard1.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard3.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard2.setBackgroundColor(getResources().getColor(R.color.tab_color));
            rlCard4.setBackgroundColor(getResources().getColor(R.color.selected_tab));
            viewPager.setCurrentItem(4);
        });
    }

    private void setupUI() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        fab = findViewById(R.id.floating);
        ivDots = findViewById(R.id.iv_dots);

        cardView1 = findViewById(R.id.card_1);
        cardView2 = findViewById(R.id.card_2);
        cardView3 = findViewById(R.id.card_3);
        cardView4 = findViewById(R.id.card_4);

        rlCard1 = findViewById(R.id.rl_card1);
        rlCard2 = findViewById(R.id.rl_card2);
        rlCard3 = findViewById(R.id.rl_card3);
        rlCard4 = findViewById(R.id.rl_card4);

        viewPager = findViewById(R.id.view_pager);
        ivLeftArrow = findViewById(R.id.iv_left_arrow);
        ivRightArrow = findViewById(R.id.iv_right_arrow);
    }

    private void setNavigation(Bundle savedInstanceState) {
        spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);

        spaceNavigationView.showIconOnly(false);
        spaceNavigationView.getBaseline();
        spaceNavigationView.setCentreButtonIcon(R.drawable.ic_settings);
        spaceNavigationView.setActiveSpaceItemColor(ContextCompat.getColor(this, R.color.black));
        spaceNavigationView.setInActiveSpaceItemColor(ContextCompat.getColor(this, R.color.gray_1));
        spaceNavigationView.setSpaceBackgroundColor(ContextCompat.getColor(this, R.color.white));
        spaceNavigationView.addSpaceItem(new SpaceItem("Dashboard", R.drawable.ic_baseline_dashboard_24));
        spaceNavigationView.setCentreButtonColor(ContextCompat.getColor(this, R.color.center_button));
        spaceNavigationView.addSpaceItem(new SpaceItem("Profile", R.drawable.ic_baseline_person_outline_24));

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                Toast.makeText(MainActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
                if(itemName.equals("Profile")){
                    startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                }
            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {
                Toast.makeText(MainActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setFabButton() {
         fab.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @SuppressLint("UnsafeExperimentalUsageError")
            @Override
            public void onGlobalLayout() {
                try {
                    BadgeDrawable badgeDrawable = BadgeDrawable.create(MainActivity.this);
                    badgeDrawable.setNumber(2);
                    //Important to change the position of the Badge
                    badgeDrawable.setHorizontalOffset(20);
                    badgeDrawable.setVerticalOffset(30);
                    badgeDrawable.setBadgeGravity(BadgeDrawable.TOP_START);

                    BadgeUtils.attachBadgeDrawable(badgeDrawable, fab, null);

                    fab.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


         fab.setOnClickListener(v -> {
                startActivity(new Intent(this, ChatActivity.class));
         });
    }
}