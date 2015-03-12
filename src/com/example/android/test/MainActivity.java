package com.example.android.test;

import android.app.Fragment;
import android.os.Bundle;
import android.view.Window;

import com.example.android.test.fragment.Fragment1;
import com.example.android.test.fragment.HomeFragment;
import com.example.android.test.fragment.MenuFragment;
import com.example.androidtest.R;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity extends SlidingFragmentActivity {

	private SlidingMenu sm;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setBehindContentView(R.layout.menu);
		setContentView(R.layout.activity_main);

		Fragment f = new Fragment1();
		getFragmentManager().beginTransaction().replace(R.id.content_frame, f)
				.commit();

		sm = getSlidingMenu();
		// 菜单从左边出来
		sm.setMode(SlidingMenu.LEFT);
		// 内容页显示的宽度
		sm.setBehindOffset(100);
		sm.setShadowDrawable(R.layout.showdow);
		// 设置阴影面积
		sm.setShadowWidth(50);

		// 出来的时候全屏幕
		// 第一个参数 SlidingMenu.TOUCHMODE_FULLSCREEN 可以全屏滑动
		// 第二个参数 SlidingMenu.TOUCHMODE_MARGIN 只能在边沿滑动
		// 第三个参数 SlidingMenu.TOUCHMODE_NONE 不能滑动
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// 上面为设置滑动的效果
		MenuFragment meueFrag = new MenuFragment();
		getFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, meueFrag).commit();

//		// 设置右边菜单
//		sm.setSecondaryMenu(R.layout.right_menu);
//		sm.setSecondaryShadowDrawable(R.layout.showdow);
//		// 上面定义了一个MenuFragment 来替代可以直接用这个
//		MenuFragment meueFrag1 = new MenuFragment();
//		getFragmentManager().beginTransaction()
//				.replace(R.id.right_menu_frame, meueFrag1).commit();

		HomeFragment homeFragment = new HomeFragment();
		getSupportFragmentManager().beginTransaction()
				.replace(R.id.content_frame, homeFragment, "Home").commit();

	}

	public void switchFragment(Fragment f) {
		getFragmentManager().beginTransaction().replace(R.id.content_frame, f)
				.commit();
		sm.toggle();
	}
}
