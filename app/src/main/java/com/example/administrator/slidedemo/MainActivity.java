package com.example.administrator.slidedemo;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	private Toolbar toolbar;
	private DrawerLayout drawerlayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main3);
		toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		
		drawerlayout = (DrawerLayout)findViewById(R.id.drawerlayout);
		
		ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.drawer_open, R.string.drawer_close);
		drawerToggle.syncState();

     	drawerlayout.addDrawerListener(drawerToggle);
		
		drawerlayout.addDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int newState) {

			}
			@Override
			public void onDrawerSlide(View drawerView, float slideOffset) {
				View content = drawerlayout.getChildAt(0);
				View menu = drawerView;
				float scale = 1-slideOffset;//1~0
				float leftScale = (float) (1-0.3*scale);
				float rightScale = (float) (0.7f+0.3*scale);//0.7~1
				menu.setScaleX(leftScale);//1~0.7
				menu.setScaleY(leftScale);//1~0.7

				content.setScaleX(rightScale);
				content.setScaleY(rightScale);
				content.setTranslationX(menu.getMeasuredWidth()*(1-scale));//0~width

			}

			@Override
			public void onDrawerOpened(View drawerView) {

			}

			@Override
			public void onDrawerClosed(View drawerView) {

			}
		});

		
		
		
	}
}
