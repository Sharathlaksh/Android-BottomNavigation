package com.example.bottomnavigation.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class Utils {

    public static Fragment getFragment(FragmentManager manager, Class fragmentclass) {
        Fragment fragment = manager.findFragmentByTag(fragmentclass.getSimpleName());
        if (fragment == null) {
            try {
                fragment = (Fragment) fragmentclass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fragment;
    }

}
