package ca.nait.dmit2504.activitystatedemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("MainActivity","onResume called");

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.i("MainActivity","onPostCreate called");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity","onStart called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity","onStop called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity","onDestroy called");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
