package cs.elon.edu.doodlecam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

/**
 * Main activity for the Doodle Portion.
 *
 * @author J. Hollingsworth
 * Modified by Philip Parvaneh
 * 12/10/15
 */
public class DoodleActivity extends MainActivity {
    public final static int WIDTH_DIALOG = 1;
    public final static int COLOR_DIALOG = 2;

    private Intent intent;
    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doodle);

        doodleView = (DoodleView) findViewById(R.id.doodleview);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_doodle, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_setwidth) {
            // start the Set Width dialog - pass the current pen width + current rgba values
            Intent intent = new Intent(this, SetWidthDialogActivity.class);
            intent.putExtra("width", doodleView.getPenWidth());
            intent.putExtra("rgb_alpha", doodleView.getRGBAlpha());
            intent.putExtra("rgb_red", doodleView.getRGBRed());
            intent.putExtra("rgb_green", doodleView.getRGBGreen());
            intent.putExtra("rgb_blue", doodleView.getRGBBlue());
            startActivityForResult(intent, WIDTH_DIALOG);
            return true;
        }

        else if (id == R.id.action_setcolor) {
            //start the set color dialog - pass the current rgba values
            Intent intent = new Intent(this, SetColorDialogActivity.class);
            intent.putExtra("rgb_alpha", doodleView.getRGBAlpha());
            intent.putExtra("rgb_red", doodleView.getRGBRed());
            intent.putExtra("rgb_green", doodleView.getRGBGreen());
            intent.putExtra("rgb_blue", doodleView.getRGBBlue());
            startActivityForResult(intent, COLOR_DIALOG);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WIDTH_DIALOG) {
            if (resultCode == RESULT_OK) {
                // get the new pen width and tell the DoodleView
                int width = data.getIntExtra("width", doodleView.getPenWidth());
                doodleView.setPenWidth(width);
            }
        }
        else if (requestCode == COLOR_DIALOG) {
            if (resultCode == RESULT_OK) {
                //get the new color and pass it to the DoodleView
                int red = data.getIntExtra("rgb_red", doodleView.getRGBRed());
                int green = data.getIntExtra("rgb_green", doodleView.getRGBBlue());
                int blue = data.getIntExtra("rgb_blue", doodleView.getRGBGreen());
                int alpha = data.getIntExtra("rgb_alpha", doodleView.getRGBAlpha());
                doodleView.setRGBAlpha(alpha);
                doodleView.setRGBRed(red);
                doodleView.setRGBGreen(green);
                doodleView.setRGBBlue(blue);
            }
        }
    }

    public void onSaveClick(View v) {
        doodleView.saveLines();
    }


    public void onClearClick(View view) {
        //When the user clicks the clear screen button, tells the DoodleView to call its
        //clearLines method
        doodleView.clearLines();

    }
}
