package ggteam.googleglassekg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "ggteam.googleglassekg.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Seems like onClickBtn on really works when you only have one of them in an activity?
    public void onClickBtn(View view)
    {
        String inpText;

        //This gives us the current contexts EditText so we can take the input from it.
        //and we need to say get the content and turn it into a string.
        EditText inputText = (EditText)findViewById(R.id.inputNumbers);
        inpText = inputText.getText().toString();

        //Checks if it's 12 characters long.
        if(inputText.getText().toString().trim().length() == 12)
        {
            //Intent, it's how me tells the button that we want to go to another activity.
            //We can send with a string, or some other data. But we need to send along a message
            //but it can be an empty string if we want.
            Intent intent = new Intent(this, HeartBeatActivity.class);
            intent.putExtra(EXTRA_MESSAGE, inpText);
            startActivity(intent);
        }
        //Here we just do some checking to make sure tell the user why he gets an error.
        else if(inputText.getText().toString().trim().length() < 12)
        {
            Toast.makeText(this, "The ID is too short!", Toast.LENGTH_LONG).show();
        }
        else if(inpText.matches(""))
        {
            Toast.makeText(this, "Please enter an ID!", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this, "The ID is too long!", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
