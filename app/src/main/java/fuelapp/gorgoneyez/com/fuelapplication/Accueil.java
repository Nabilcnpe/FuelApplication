package fuelapp.gorgoneyez.com.fuelapplication;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Accueil extends Activity
{
    private ArrayList<Station> stations;
    private StationAdapter stationAdapter;
    private ListView listView;
    private EditText inputSearchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        this.listView = (ListView)findViewById(android.R.id.list);

        initList();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                // enleve ligne suivante pour ne rien afficher
//				Station s = ((StationAdapter)getListAdapter()).getItem(position);
//				Toast.makeText(this, "Clicked " + s.toString(), Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(getApplicationContext(), StationsInformations.class);
                myIntent.putExtra("fname", listView.getItemAtPosition(position).toString());
                startActivity(myIntent);
            }
        });

        this.inputSearchBar = (EditText)findViewById(R.id.input_search_bar);
        this.inputSearchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                stationAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable)
            {

            }
        });
    }

    private void initList()
    {
        this.stations = StationInfo.getStationsInfo(this).getStations();
        this.stationAdapter = new StationAdapter(getApplicationContext(), stations);

        this.listView.setAdapter(stationAdapter);
    }

    public class StationAdapter extends ArrayAdapter<Station>
    {
        // unused - mais peut etre utile en cas d'ajouter plus de fonctionnalites
        private Context context;

        public StationAdapter(Context context, ArrayList<Station> stations)
        {
            super(context, 0, stations);
            this.context = context;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if( convertView == null )
            {
                convertView = getLayoutInflater().inflate(R.layout.layout_stations, null);
            }

            Station s = getItem(position);

            TextView stationAdresse = convertView.findViewById(R.id.station_adresse);
            stationAdresse.setText(s.getAdresse());

            TextView gasPrice = convertView.findViewById(R.id.prices);
            gasPrice.setText(s.getPrix());

            TextView stationVille = convertView.findViewById(R.id.station_ville);
            stationVille.setText(s.getVille());

            TextView stationService = convertView.findViewById(R.id.station_service);
            stationService.setText(s.getNom());

            return convertView;
        }
    }

}
