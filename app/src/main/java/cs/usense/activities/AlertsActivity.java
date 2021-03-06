/*
 * COPYRIGHTS COPELABS/ULHT, LGPLv3.0, 2016/11/25.
 * Class is part of the NSense application.
 */

package cs.usense.activities;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;

import cs.usense.R;


/**
 * This class instantiates an activity that allows the user to set his alerts
 * @author Miguel Tavares (COPELABS/ULHT)
 * @version 1.0, 2016
 */
public class AlertsActivity extends ActionBarActivity {

    /** This variable is used to debug AlertsActivity class */
    private static final String TAG = "AlertsActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        setup();
    }

    /**
     *  This method initialize everything needed in this activity
     */
    private void setup() {
        Log.i(TAG, "setup");
        setActionBarTitle(getString(R.string.Alerts));
        getFragmentManager().beginTransaction().replace(R.id.content_frame, new AlertsPreferencesActivity()).commit();
    }

    @Override
    public void onBackPressed() {
        Log.i(TAG, "onBackPressed");
        startActivity(new Intent(this, SettingsActivity.class));
        finish();
    }

    public static class AlertsPreferencesActivity extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.activity_alerts_preferences);
        }
    }

}
