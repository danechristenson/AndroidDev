package ca.dane.nait.dmit.lab2take2;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

/**
 * Created by super on 7/3/2017.
 */

public class MainPreferenceActivity extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: (dane) replace with a fragment
        addPreferencesFromResource(R.xml.preference_settings);
    }
}
