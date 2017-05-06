package ca.nait.dmit.imagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageButton oilersImageButton;
    private ImageButton ducksImageButton;
    private ImageView headerImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oilersImageButton = (ImageButton) findViewById(R.id.oilersImageButton);
        ducksImageButton = (ImageButton) findViewById(R.id.ducksImageButton);
        headerImageView = (ImageView) findViewById(R.id.headerImageView);

        ducksImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headerImageView.setImageResource(R.drawable.ducks);
            }
        });
    }

    public void pickOilers(View view){
        headerImageView.setImageResource(R.drawable.oilers);
    }

    public void reset(View view){
        headerImageView.setImageResource(R.drawable.header);
    }
}
