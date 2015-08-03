package com.python.trainning.nextgsolutions.tapswipe;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabPagerAdapter extends FragmentPagerAdapter {

	public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		Fragment fragment = null;
		switch (index) {
		case 0:
			fragment = new Home();
			break;
		case 1:
			fragment = new ReadMost();
			break;
		case 2:
			fragment = new New();
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		return 3;
	}
}