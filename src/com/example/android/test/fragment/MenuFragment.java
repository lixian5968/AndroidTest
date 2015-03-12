package com.example.android.test.fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.android.test.MainActivity;
import com.example.androidtest.R;

import android.app.Fragment;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuFragment extends Fragment implements OnItemClickListener {

	private View view;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		ListView listview = (ListView) view.findViewById(R.id.menuList);

		listview.setAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, android.R.id.text1,
				getList()));

		listview.setOnItemClickListener(this);
		// new BaseAdapter();
	}

	private List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("Fragment1");
		list.add("Fragment2");
		list.add("Fragment3");
		list.add("Fragment4");
		list.add("Fragment5");
		return list;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.menulistview, null);
		return view;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		Fragment f =null;
		switch (position) {
		case 0:
			f= new Fragment1();
			break;
		case 1:
			f= new Fragment2();
			break;
		case 2:
			f= new Fragment3();
			break;
		case 3:
			f= new Fragment4();
			break;
		case 4:
			f= new Fragment5();
			break;
		
		}
		switchFragment(f);
			
	}

	private void switchFragment(Fragment f) {
		if(f != null){
			if(getActivity() instanceof MainActivity) {
				((MainActivity)getActivity()).switchFragment(f);
			}
		}
		
	}

}
