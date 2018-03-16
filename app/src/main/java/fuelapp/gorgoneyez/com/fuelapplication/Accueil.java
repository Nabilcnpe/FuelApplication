package fuelapp.gorgoneyez.com.fuelapplication;

        import android.app.ListActivity;
        import android.content.Context;
        import android.content.Intent;
        import android.support.v4.view.MenuItemCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;
        import android.widget.SearchView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class Accueil extends ListActivity
{
    private ArrayList<Station> stations;
    EditText inputSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        this.stations = StationInfo.getStationsInfo(this).getStations();

        StationAdapter stationAdapter = new StationAdapter(getApplicationContext(), stations);

        setListAdapter(stationAdapter);
    }


    public void onListItemClick(ListView listview, View view, int position, long id)
    {
        // enleve ligne suivante pour ne rien afficher
//		Station s = ((StationAdapter)getListAdapter()).getItem(position);
//		Toast.makeText(this, "Clicked " + s.toString(), Toast.LENGTH_SHORT).show();
        Intent myIntent = new Intent(getApplicationContext(), StationsInformations.class);
        myIntent.putExtra("fname", listview.getItemAtPosition(position).toString());
        startActivity(myIntent);
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

            return convertView;
        }
    }


//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		MenuInflater inflater = getMenuInflater();
//		inflater.inflate(R.menu.serach_menu, menu);
//
//		MenuItem searchItem  = menu.findItem(R.id.search);
//		SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//
//		searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//			@Override
//			public boolean onQueryTextSubmit(String s) {
//				return false;
//			}
//
//			@Override
//			public boolean onQueryTextChange(String s) {
//				return false;
//			}
//		});
//
//		return super.onCreateOptionsMenu(menu);
//	}
}
