package darrellpayne.com.sunshine;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
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
        int RESULT_SETTINGS = 1;

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_refresh) {
            // return true;
            ForecastFragment.FetchWeatherTask weatherTask = new ForecastFragment.FetchWeatherTask();

           // FetchWeatherTask weatherTask = new ForecastFragment.FetchWeatherTask();
            weatherTask.execute("94043");
            return true;


        }else if (id == R.id.action_settings){

            // TODO: Call the settings activity
            Intent intent = new Intent(this,SettingsActivity.class);
            startActivityForResult(intent,RESULT_SETTINGS); // TODO: This is temp setting
            // Toast.makeText(this, "Settings clicked", Toast.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
