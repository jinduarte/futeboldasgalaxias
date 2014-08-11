package com.universo.futeboldasgalaxias;

import java.util.Locale;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Classe responsavel pelas configuracoes
 * das tabs (pages) com quantidade e instancias
 */

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    /**
     *
     */
    private final MainActivity mainActivity;
    private static final int NUM_TABS = 3;

    public SectionsPagerAdapter(MainActivity mainActivity, FragmentManager fm) {
        super(fm);
        this.mainActivity = mainActivity;
    }

	/*@Override
    public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class
		// below).
		return PlaceholderFragment.newInstance(position + 1);
	}*/

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return PlacarMainFragment.newInstance(position + 1);
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return LancesFragment.newInstance(position + 1);
            case 2: // Fragment # 0 - This will show FirstFragment different title
                return CartolaFragment.newInstance(position + 1);
        /*case 3: // Fragment # 0 - This will show FirstFragment different title
            return LancesFragment.newInstance(position + 1);
        case 4: // Fragment # 0 - This will show FirstFragment different title
            return CartolaFragment.newInstance(position + 1);*/
            default: // Fragment # 1 - This will show SecondFragment
                return PlacarMainFragment.newInstance(position + 1);
        }
    }

    @Override
    public int getCount() {
        // Show total pages.
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return this.mainActivity.getString(R.string.title_section1).toUpperCase(l);
            case 1:
                return this.mainActivity.getString(R.string.title_section2).toUpperCase(l);
            case 2:
                return this.mainActivity.getString(R.string.title_section3).toUpperCase(l);
            default: // Fragment # 1 - This will show SecondFragment
                return "ABA DE TESTE";
        }
        //return null;
    }
}