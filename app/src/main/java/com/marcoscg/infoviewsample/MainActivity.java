package com.marcoscg.infoviewsample;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.marcoscg.infoview.InfoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final InfoView infoView = (InfoView) findViewById(R.id.info_view);
        /*
        infoView.setTitle("Oops!");
        infoView.setMessage("That should not have happened.");
        infoView.setButtonText("Try again");
        infoView.setButtonTextColorRes(R.color.colorAccent);
        */
        infoView.setOnTryAgainClickListener(new InfoView.OnTryAgainClickListener() {
            @Override
            public void onTryAgainClick() {
                Toast.makeText(MainActivity.this, "Try again clicked!", Toast.LENGTH_SHORT).show();
                emulateLoading(infoView);
            }
        });

        // This will simulate a 3 seconds loading process
        emulateLoading(infoView);

    }

    private void emulateLoading(final InfoView infoView) {
        infoView.setProgress(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                infoView.setProgress(false);
            }
        }, 3000);
    }
}
