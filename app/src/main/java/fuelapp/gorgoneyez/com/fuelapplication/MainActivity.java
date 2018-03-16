package fuelapp.gorgoneyez.com.fuelapplication;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	public Button btn;
	public Button map;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);


		Button btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent test = new Intent(MainActivity.this, Accueil.class);
				startActivity(test);
			}
		});

		Button map = (Button) findViewById(R.id.map);
		map.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent test = new Intent(MainActivity.this, MapsActivity.class);
				startActivity(test);
			}
		});
	}
}