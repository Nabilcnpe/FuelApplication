package fuelapp.gorgoneyez.com.fuelapplication;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StationsInformations extends AppCompatActivity {

    TextView stationNom;
    TextView ouverture;
    private Context mContext;
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stations_informations);


        // Get the application context
        mContext = getApplicationContext();
        mActivity = StationsInformations.this;



        stationNom = (TextView) findViewById(R.id.stationNom);
        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            stationNom.setText(bundle.getString("fname"));
        }
    }

}
