package cs.elon.edu.doodlecam;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Initial Screen
 *
 * @author Philip Parvaneh
 * 12/1/15
 */
public class StartActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        intent = getIntent();
    }

    public void onContinueClick(View view){
        intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}


