package fuelapp.gorgoneyez.com.fuelapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import static java.lang.Double.parseDouble;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private final static int LOCATION_REQ_CODE = 456;
    private ArrayList<Station> stations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        rafraichirCarte();

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQ_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        int padding = 100;
        LatLngBounds.Builder latLngBounds = new LatLngBounds.Builder();

        // Add a marker in Sydney and move the camera
//        mMap.setOnInfoWindowClickListener(this);
//        mMap.setInfoWindowAdapter(this);
        LatLng syd = new LatLng(47.1924314, -1.5811633);
        latLngBounds.include(syd);
        mMap.addMarker(new MarkerOptions().position(syd).title("1 Impasse Ordronneau" + "\n" + "REZÉ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(syd));
        mMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds.build(), 100));

        LatLng A_44410006 = new LatLng(47.3953567, -2.3058147);
        mMap.addMarker(new MarkerOptions().position(A_44410006).title("8 RUE DE KERVILY" + "\n" + "Saint-Lyphard"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44410006));

        LatLng A_44580001 = new LatLng(47.0406744, -1.9586244);
        mMap.addMarker(new MarkerOptions().position(A_44580001).title("ROUTE DE BOUIN" + "\n" + "Bourgneuf-en-Retz"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44580001));

        LatLng A_44400006 = new LatLng(47.1792294, -1.5358373);
        mMap.addMarker(new MarkerOptions().position(A_44400006).title("29 Rue de la Blordière" + "\n" + "REZÉ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44400006));

        LatLng A_44120005 = new LatLng(47.17221, -1.4723118);
        mMap.addMarker(new MarkerOptions().position(A_44120005).title("BOULEVARD DE L'EUROPE" + "\n" + "VERTOU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44120005));

        LatLng A_44570001 = new LatLng(47.3028879, -2.2107994);
        mMap.addMarker(new MarkerOptions().position(A_44570001).title("ZAC DE LA FONTAINE AU BRUN" + "\n" + "Trignac"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44570001));

        LatLng A_44240001 = new LatLng(47.2821246, -1.543235);
        mMap.addMarker(new MarkerOptions().position(A_44240001).title("Rue de la Bérangerais" + "\n" + "LA CHAPELLE-SUR-ERDRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44240001));

        LatLng A_44450002 = new LatLng(47.2706308, -1.3347915);
        mMap.addMarker(new MarkerOptions().position(A_44450002).title("BD PASTEUR" + "\n" + "LA CHAPELLE-BASSE-MER"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44450002));

        LatLng A_44600001 = new LatLng(47.256146137, -2.26488);
        mMap.addMarker(new MarkerOptions().position(A_44600001).title("332 Route de la Côte d'Amour" + "\n" + "SAINT-NAZAIRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44600001));

        LatLng A_44750002 = new LatLng(47.41290, -1.97051);
        mMap.addMarker(new MarkerOptions().position(A_44750002).title("AVENUE DES SPORTS" + "\n" + "CAMPBON"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44750002));

        LatLng A_44190002 = new LatLng(47.0980, -1.29844944);
        mMap.addMarker(new MarkerOptions().position(A_44190002).title("Route de Clisson" + "\n" + "GORGES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44190002));

        LatLng A_44360004 = new LatLng(47.27040, -1.76060);
        mMap.addMarker(new MarkerOptions().position(A_44360004).title("Route de Couéron" + "\n" + "Saint-étienne-de-Montluc"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44360004));

        LatLng A_44220005 = new LatLng(47.21363, -1.72222);
        mMap.addMarker(new MarkerOptions().position(A_44220005).title("Boulevard Paul Langevin" + "\n" + "COUERON"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44220005));

        LatLng A_44210002 = new LatLng(47.11293, -2.08468);
        mMap.addMarker(new MarkerOptions().position(A_44210002).title("330 Rue du G�n�ral de Gaulle" + "\n" + "Varades"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44210002));

        LatLng A_44370006 = new LatLng(47.38652, -1.02574);
        mMap.addMarker(new MarkerOptions().position(A_44370006).title("Boulevard Paul Langevin" + "\n" + "COUERON"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44370006));

        LatLng A_44340005 = new LatLng(47.167, -1.575);
        mMap.addMarker(new MarkerOptions().position(A_44340005).title("ROCADE SUD" + "\n" + "BOUGUENAIS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44340005));

        LatLng A_44860002 = new LatLng(47.12892, -1.50760);
        mMap.addMarker(new MarkerOptions().position(A_44860002).title("Rue des Vignes" + "\n" + "PONT-SAINT-MARTIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44860002));

        LatLng A_44310001 = new LatLng(47.24139, -1.64039);
        mMap.addMarker(new MarkerOptions().position(A_44310001).title("ESPACE CIAL GRAND LAC" + "\n" + "SAINT-PHILBERT-DE-GRAND-LIEU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44310001));

        LatLng A_44300016 = new LatLng(47.167, -1.575);
        mMap.addMarker(new MarkerOptions().position(A_44300016).title("272, ROUTE DE SAINTE LUCE" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44300016));

        LatLng A_44730002 = new LatLng(47.17027, -2.14844);
        mMap.addMarker(new MarkerOptions().position(A_44730002).title("Route de la Plaine" + "\n" + "SAINT-MICHEL-CHEF-CHEF"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44730002));

        LatLng A_44330002 = new LatLng(47.16225, -1.26201);
        mMap.addMarker(new MarkerOptions().position(A_44330002).title("37 Rue d'Anjou" + "\n" + "VALLET"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44330002));

        LatLng A_44360007 = new LatLng(47.27772, -1.72111);
        mMap.addMarker(new MarkerOptions().position(A_44360007).title("LIEU DIT TOURNEBRIDE" + "\n" + "SAINT ETIENNE DE MONTLUC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44360007));

        LatLng A_44600002 = new LatLng(47.281, -2.226);
        mMap.addMarker(new MarkerOptions().position(A_44600002).title("54 Rue Léon Bourgeois" + "\n" + "SAINT-NAZAIRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44600002));

        LatLng A_44450003 = new LatLng(47.24729, -1.37000);
        mMap.addMarker(new MarkerOptions().position(A_44450003).title("Centre Commercial du Chêne - l'Aulnaie" + "\n" + "SAINT-JULIEN-DE-CONCELLES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44450003));

        LatLng A_44550001 = new LatLng(47.327, -2.152);
        mMap.addMarker(new MarkerOptions().position(A_44550001).title("C.C. DE LA BERNUAIS" + "\n" + "MONTOIR-DE-BRETAGNE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44550001));

        LatLng A_44380007 = new LatLng(47.26247, -2.33434);
        mMap.addMarker(new MarkerOptions().position(A_44380007).title("Avenue du Baulois" + "\n" + "PORNICHET"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44380007));

        LatLng A_44370005 = new LatLng(47.38927, -1.02030);
        mMap.addMarker(new MarkerOptions().position(A_44370005).title("ROUTE D'ANGERS" + "\n" + "Varades"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44370005));

        LatLng A_44119005 = new LatLng(47.33626, -1.65245);
        mMap.addMarker(new MarkerOptions().position(A_44119005).title("ROUTE NATIONALE 137 - AIRE DE TREILLIÉRES" + "\n" + "TREILLIERES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44119005));

        LatLng A_44230002 = new LatLng(4720922, -1.50998);
        mMap.addMarker(new MarkerOptions().position(A_44230002).title("80 Boulevard des Pas Enchantés" + "\n" + "Saint-Sébastien-sur-Loire"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44230002));

        LatLng A_44000010 = new LatLng(47.24721, -1.55528);
        mMap.addMarker(new MarkerOptions().position(A_44000010).title("BOULEVARD GUY MOLLET" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44000010));

        LatLng A_44260003 = new LatLng(47.35931, -1.86116);
        mMap.addMarker(new MarkerOptions().position(A_44260003).title("Rue des Musiciens" + "\n" + "Malville"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44260003));

        LatLng A_44260005 = new LatLng(47.36862, -1.96231);
        mMap.addMarker(new MarkerOptions().position(A_44260005).title("Parc comemrcial de la Colleraye" + "\n" + "SAVENAY"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44260005));

        LatLng A_44250004 = new LatLng(47.24259, -2.15731);
        mMap.addMarker(new MarkerOptions().position(A_44250004).title("Avenue Guy Lafontaine" + "\n" + "Saint-Brevin-les-Pins"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44250004));

        LatLng A_44800005 = new LatLng(47.21128, -1.61435);
        mMap.addMarker(new MarkerOptions().position(A_44800005).title("Rue de Saint-Nazaire" + "\n" + "SAINT-HERBLAIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44800005));

        LatLng A_44150001 = new LatLng(47.397, -1.19);
        mMap.addMarker(new MarkerOptions().position(A_44150001).title("L'Aubinière" + "\n" + "ANCENIS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44150001));

        LatLng A_44170001 = new LatLng(47.57532, -1.63017);
        mMap.addMarker(new MarkerOptions().position(A_44170001).title("boulevard du Petit Versailles" + "\n" + "NOZAY"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44170001));

        LatLng A_44350005 = new LatLng(47.39098, -2.42943);
        mMap.addMarker(new MarkerOptions().position(A_44350005).title("impasse du breniguen" + "\n" + "SAINT-MOLF"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44350005));

        LatLng A_44170003 = new LatLng(47.56424, -1.61789);
        mMap.addMarker(new MarkerOptions().position(A_44170003).title("Rue Marie Curie" + "\n" + "NOZAY"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44170003));

        LatLng A_44190007 = new LatLng(47.09503, -1.29174);
        mMap.addMarker(new MarkerOptions().position(A_44190007).title("Route de Gorges" + "\n" + "Clisson"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44190007));

        LatLng A_44630002 = new LatLng(47.54254, -1.88270);
        mMap.addMarker(new MarkerOptions().position(A_44630002).title("11 bis rue charles perron" + "\n" + "Plessé"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44630002));

        LatLng A_44850002 = new LatLng(47.361, -1.408);
        mMap.addMarker(new MarkerOptions().position(A_44850002).title("2 Rue Beau Soleil" + "\n" + "SAINT-MARS-DU-DÉSERT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44850002));

        LatLng A_44370003 = new LatLng(47.38630, -1.03342);
        mMap.addMarker(new MarkerOptions().position(A_44370003).title("306, Rue du Maréchal Foch" + "\n" + "Varades"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44370003));

        LatLng A_44220001 = new LatLng(47.19372, -1.53042);
        mMap.addMarker(new MarkerOptions().position(A_44220001).title("75 Boulevard Joliot Curie" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44220001));

        LatLng A_44800007 = new LatLng(47.24121, -1.59335);
        mMap.addMarker(new MarkerOptions().position(A_44800007).title("205 ROUTE DE VANNES" + "\n" + "SAINT HERBLAIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44800007));

        LatLng A_44115002 = new LatLng(47.18736, -1.47044);
        mMap.addMarker(new MarkerOptions().position(A_44115002).title("Route de Clisson" + "\n" + "Basse-Goulaine"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44115002));

        LatLng A_44430003 = new LatLng(47.23689, -1.35042);
        mMap.addMarker(new MarkerOptions().position(A_44430003).title("Place Bretagne" + "\n" + "Le Loroux-Bottereau"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44430003));

        LatLng A_44140002 = new LatLng(47.05482, -1.51109);
        mMap.addMarker(new MarkerOptions().position(A_44140002).title("1 Avenue de la Vendée" + "\n" + "Geneston"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44140002));

        LatLng A_44590002 = new LatLng(47.64843, -1.66863);
        mMap.addMarker(new MarkerOptions().position(A_44550001).title("Lieu-dit Le Mortier" + "\n" + "Derval"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44550001));


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }

    }

}
