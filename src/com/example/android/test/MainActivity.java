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
		// �˵�����߳���
		sm.setMode(SlidingMenu.LEFT);
		// ����ҳ��ʾ�Ŀ��
		sm.setBehindOffset(100);
		sm.setShadowDrawable(R.layout.showdow);
		// ������Ӱ���
		sm.setShadowWidth(50);

		// ������ʱ��ȫ��Ļ
		// ��һ������ SlidingMenu.TOUCHMODE_FULLSCREEN ����ȫ������
		// �ڶ������� SlidingMenu.TOUCHMODE_MARGIN ֻ���ڱ��ػ���
		// ���������� SlidingMenu.TOUCHMODE_NONE ���ܻ���
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		// ����Ϊ���û�����Ч��
		MenuFragment meueFrag = new MenuFragment();
		getFragmentManager().beginTransaction()
				.replace(R.id.menu_frame, meueFrag).commit();

//		// �����ұ߲˵�
//		sm.setSecondaryMenu(R.layout.right_menu);
//		sm.setSecondaryShadowDrawable(R.layout.showdow);
//		// ���涨����һ��MenuFragment ���������ֱ�������
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
