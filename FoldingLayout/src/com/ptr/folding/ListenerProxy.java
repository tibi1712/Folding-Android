package com.ptr.folding;

import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.support.v4.widget.SlidingPaneLayout.PanelSlideListener;
import android.view.View;

class ListenerProxy implements DrawerListener, PanelSlideListener {

	private DrawerListener mDrawerListener;
	private PanelSlideListener mPanelSlideListener;

	public ListenerProxy(DrawerListener drawerListener,
			PanelSlideListener panelSlideListener) {
		mDrawerListener = drawerListener;
		mPanelSlideListener = panelSlideListener;
	}

	public DrawerListener getDrawerListener() {
		return mDrawerListener;
	}

	public void setDrawerListener(DrawerListener drawerListener) {
		this.mDrawerListener = drawerListener;
	}

	public PanelSlideListener getPanelSlideListener() {
		return mPanelSlideListener;
	}

	public void setPanelSlideListener(PanelSlideListener panelSlideListener) {
		this.mPanelSlideListener = panelSlideListener;
	}

	@Override
	public void onDrawerClosed(View drawerView) {
		if (null != mDrawerListener) {
			mDrawerListener.onDrawerClosed(drawerView);
		}
	}

	@Override
	public void onDrawerOpened(View drawerView) {
		if (null != mDrawerListener) {
			mDrawerListener.onDrawerOpened(drawerView);
		}
	}

	@Override
	public void onDrawerSlide(View drawerView, float slideOffset) {
		if (drawerView instanceof BaseFoldingLayout) {
			((BaseFoldingLayout) drawerView).setFoldFactor(1 - slideOffset);
		}

		if (null != mDrawerListener) {
			mDrawerListener.onDrawerSlide(drawerView, slideOffset);
		}
	}

	@Override
	public void onDrawerStateChanged(int state) {
		if (null != mDrawerListener) {
			mDrawerListener.onDrawerStateChanged(state);
		}
	}

	@Override
	public void onPanelSlide(View v, float slideOffset) {
		if (v instanceof BaseFoldingLayout) {
			((BaseFoldingLayout) v).setFoldFactor(1 - slideOffset);
		}

		if (null != mPanelSlideListener) {
			mPanelSlideListener.onPanelSlide(v, slideOffset);
		}
	}

	@Override
	public void onPanelOpened(View v) {
		if (null != mPanelSlideListener) {
			mPanelSlideListener.onPanelOpened(v);
		}
	}

	@Override
	public void onPanelClosed(View v) {
		if (null != mPanelSlideListener) {
			mPanelSlideListener.onPanelClosed(v);
		}
	}

}
