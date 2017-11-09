package app.android.mmauri.laboratorio_07_toolbar_tabs.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.android.mmauri.laboratorio_07_toolbar_tabs.Fragments.FormFragment;
import app.android.mmauri.laboratorio_07_toolbar_tabs.Fragments.ListFragment;

import static app.android.mmauri.laboratorio_07_toolbar_tabs.Activities.MainActivity.FROM_FRAGMENT_POSITION;
import static app.android.mmauri.laboratorio_07_toolbar_tabs.Activities.MainActivity.LIST_FRAGMENT_POSITION;

/**
 * Created by marc on 11/8/17.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fm, int numberOfTabs) {
        super(fm);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case FROM_FRAGMENT_POSITION:
                return new FormFragment();
            case LIST_FRAGMENT_POSITION:
                return new ListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return this.numberOfTabs;
    }
}
