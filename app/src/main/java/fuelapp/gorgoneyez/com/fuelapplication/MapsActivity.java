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

        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMinZoomPreference(5);

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
        mMap.addMarker(new MarkerOptions().position(A_44590002).title("Lieu-dit Le Mortier" + "\n" + "Derval"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44590002));

        LatLng A_44400005 = new LatLng(47.15479, -1.53707);
        mMap.addMarker(new MarkerOptions().position(A_44400005).title("140 Route des Sorinières" + "\n" + "Rezé"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44400005));

        LatLng A_44590001 = new LatLng(47.6680921449, -1.66311548938);
        mMap.addMarker(new MarkerOptions().position(A_44590001).title("48 Rue Châteaubriant" + "\n" + "Derval"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44590001));

        LatLng A_44740002 = new LatLng(47.27800, -2.45800);
        mMap.addMarker(new MarkerOptions().position(A_44740002).title("ROUTE DU POULIGUEN" + "\n" + "Batz-sur-Mer"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44740002));

        LatLng A_44700003 = new LatLng(47.24624, -1.58938);
        mMap.addMarker(new MarkerOptions().position(A_44700003).title("54, avenue de la Ferrière" + "\n" + "Orvault"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44700003));

        LatLng A_44521001 = new LatLng(47.39123, -1.29207);
        mMap.addMarker(new MarkerOptions().position(A_44521001).title("RN 23 - LES HAUTES LANDES" + "\n" + "COUFFÉ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44521001));

        LatLng A_44420002 = new LatLng(47.353, -2.513);
        mMap.addMarker(new MarkerOptions().position(A_44420002).title("2 rue des Pins" + "\n" + "LA TURBALLE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44420002));

        LatLng A_44220003 = new LatLng(47.21344, -1.71900);
        mMap.addMarker(new MarkerOptions().position(A_44220003).title("6 Rue des Ardillets" + "\n" + "COUÉRON"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44220003));

        LatLng A_44118003 = new LatLng(47.09, -1.611);
        mMap.addMarker(new MarkerOptions().position(A_44118003).title("78 Grand'Rue" + "\n" + "La Chevrolière"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44118003));

        LatLng A_44350001 = new LatLng(47.291, -2.398);
        mMap.addMarker(new MarkerOptions().position(A_44350001).title("ROUTE DE LA BAULE" + "\n" + "GUERANDE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44350001));

        LatLng A_44190006 = new LatLng(47.09679, -1.28172);
        mMap.addMarker(new MarkerOptions().position(A_44190006).title("ROUTE DE NANTES" + "\n" + "Clisson"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44190006));

        LatLng A_44510001 = new LatLng(47.27503, -2.44083);
        mMap.addMarker(new MarkerOptions().position(A_44510001).title("Rue de Cornen" + "\n" + "LE POULIGUEN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44510001));

        LatLng A_44570004 = new LatLng(47.312222784, -2.20011680566);
        mMap.addMarker(new MarkerOptions().position(A_44570004).title("RN 171" + "\n" + "TRIGNAC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44570004));

        LatLng A_44300018 = new LatLng(47.24781, -1.51216);
        mMap.addMarker(new MarkerOptions().position(A_44300018).title("95 rue du Perray" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44300018));

        LatLng A_44160003 = new LatLng(47.43200, -2.08300);
        mMap.addMarker(new MarkerOptions().position(A_44160003).title("Route de Nantes-CS 20077" + "\n" + "Pontchâteau"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44160003));

        LatLng A_44160005 = new LatLng(47.43600, -2.07700);
        mMap.addMarker(new MarkerOptions().position(A_44160005).title("LA HIRTAIS" + "\n" + "SAINTE ANNE SUR BRIVET"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44160005));

        LatLng A_44800004 = new LatLng(47.22600, -1.63500);
        mMap.addMarker(new MarkerOptions().position(A_44800004).title("Zone Atlantis" + "\n" + "Saint-Herblain"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44800004));

        LatLng A_44600006 = new LatLng(47.263, -2.239);
        mMap.addMarker(new MarkerOptions().position(A_44600006).title("310 Rue de Pornichet" + "\n" + "SAINT-NAZAIRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44600006));

        LatLng A_44800001 = new LatLng(47.24714, -1.60587);
        mMap.addMarker(new MarkerOptions().position(A_44800001).title("325 Route de Vannes" + "\n" + "SAINT-HERBLAIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44800001));

        LatLng A_44110005 = new LatLng(47.71919, -1.36395);
        mMap.addMarker(new MarkerOptions().position(A_44110005).title("Rue des 27 Otages" + "\n" + "CHÂTEAUBRIANT"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44110005));

        LatLng A_44119003 = new LatLng(47.33140, -1.62326);
        mMap.addMarker(new MarkerOptions().position(A_44119003).title("RN 137 - Aire de Treillières Ouest" + "\n" + "Treillières"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44119003));

        LatLng A_44116001 = new LatLng(46.97125, -1.43372);
        mMap.addMarker(new MarkerOptions().position(A_44116001).title("6, rue de Carteron" + "\n" + "VIEILLEVIGNE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44116001));

        LatLng A_44300017 = new LatLng(47.25053, -1.51839);
        mMap.addMarker(new MarkerOptions().position(A_44300017).title("14 route de Paris" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44300017));

        LatLng A_44710002 = new LatLng(47.131, -1.753);
        mMap.addMarker(new MarkerOptions().position(A_44710002).title("RUE DES EPINETTES" + "\n" + "PORT SAINT-PERE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44710002));

        LatLng A_44830002 = new LatLng(47.14363, -1.67927);
        mMap.addMarker(new MarkerOptions().position(A_44830002).title("Rue de Nantes" + "\n" + "BOUAYE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44830002));

        LatLng A_44540001 = new LatLng(47.5297748799, -1.18620212627);
        mMap.addMarker(new MarkerOptions().position(A_44540001).title("RTE DE CHATEAUBRIANT" + "\n" + "SAINT-MARS-LA-JAILLE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44540001));

        LatLng A_44770001 = new LatLng(47.14145, -2.18897);
        mMap.addMarker(new MarkerOptions().position(A_44770001).title("1 Rue des Filets" + "\n" + "LA PLAINE-SUR-MER"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44770001));

        LatLng A_44390003 = new LatLng(47.43704, -1.51709);
        mMap.addMarker(new MarkerOptions().position(A_44390003).title("ZI DE LA SANGLE" + "\n" + "NORT SUR ERDRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44390003));

        LatLng A_44412001 = new LatLng(47.15955, -1.54517);
        mMap.addMarker(new MarkerOptions().position(A_44412001).title("10 Rond Point de la Corbinerie" + "\n" + "REZÉ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44412001));

        LatLng A_44802001 = new LatLng(47.222, -1.606);
        mMap.addMarker(new MarkerOptions().position(A_44802001).title("Boulevard de la Baule" + "\n" + "SAINT-HERBLAIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44802001));

        LatLng A_44350004 = new LatLng(47.32944, -2.41115);
        mMap.addMarker(new MarkerOptions().position(A_44350004).title("Rue de Villejames" + "\n" + "Guérande"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44350004));

        LatLng A_44000005 = new LatLng(47.23769, -1.53264);
        mMap.addMarker(new MarkerOptions().position(A_44000005).title("55 Boulevard Jules Verne" + "\n" + "Nantes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44000005));

        LatLng A_44350006 = new LatLng(47.30616, -2.40835);
        mMap.addMarker(new MarkerOptions().position(A_44350006).title("Route de la Baule" + "\n" + "Guérande"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44350006));

        LatLng A_44380008 = new LatLng(47.2594609, -2.342279);
        mMap.addMarker(new MarkerOptions().position(A_44380008).title("1, BOULEVARD DE LA REPUBLIQUE" + "\n" + "PORNICHET"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44380008));

        LatLng A_44100005 = new LatLng(47.2241746, -1.5319617);
        mMap.addMarker(new MarkerOptions().position(A_44100005).title("49-61 BLD DALBY" + "\n" + "NANTES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44100005));


        LatLng A_44580002 = new LatLng(47.0493551, -1.9634058);
        mMap.addMarker(new MarkerOptions().position(A_44580002).title("Chemin de la Culee" + "\n" + "BOURGNEUF-EN-RETZ"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44580002));

        LatLng A_44480002 = new LatLng(47.3244155, -2.0860493);
        mMap.addMarker(new MarkerOptions().position(A_44480002).title("Rue du Stade" + "\n" + "MDONGES"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44480002));

        LatLng A_44150004 = new LatLng(47.370918, -1.1814103);
        mMap.addMarker(new MarkerOptions().position(A_44150004).title("Rue Audigane" + "\n" + "ANCENIS"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44150004));

        LatLng A_44720004 = new LatLng(47.3854824, -2.2055697);
        mMap.addMarker(new MarkerOptions().position(A_44720004).title("Place de la Commune de Paris - D50" + "\n" + "Saint-Joachim"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44720004));

        LatLng A_44500002 = new LatLng(47.2791829, -2.4244468);
        mMap.addMarker(new MarkerOptions().position(A_44500002).title("14 Avenue du Maréchal de Lattre de Tassigny" + "\n" + "La Baule-Escoublac"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44500002));

        LatLng A_44600009 = new LatLng(47.2707397, -2.257991);
        mMap.addMarker(new MarkerOptions().position(A_44600009).title("LIEU DIT RETON" + "\n" + "SAINT NAZAIRE"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44600009));

        LatLng A_44230003 = new LatLng(47.1917216, -1.496474);
        mMap.addMarker(new MarkerOptions().position(A_44230003).title("2 Rue Pierre Mendès France" + "\n" + "Saint-Sébastien-sur-Loire"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44230003));

        LatLng A_44120004 = new LatLng(47.1603993, -1.514568);
        mMap.addMarker(new MarkerOptions().position(A_44120004).title("2102 La Grassinière, 44120 Vertou" + "\n" + "VERTOU"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44120004));

        LatLng A_44300004 = new LatLng(47.2583805, -1.581989);
        mMap.addMarker(new MarkerOptions().position(A_44300004).title("162 Route de Rennes" + "\n" + "Nantes"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44300004));

        LatLng A_44190001 = new LatLng(47.0849012, -1.2652629);
        mMap.addMarker(new MarkerOptions().position(A_44190001).title("LE BARILLET" + "\n" + "GéTIGNé"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44190001));

        LatLng A_44170002 = new LatLng(47.5631075, -1.6178248);
        mMap.addMarker(new MarkerOptions().position(A_44170002).title("ROUTE D'ABBARETZ" + "\n" + "NOZAY"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44170002));
///
        LatLng A_44640002 = new LatLng(47.198417, -1.759914);
        mMap.addMarker(new MarkerOptions().position(A_44640002).title("28 Rue de la Jouardais" + "\n" + "LE PELLERIN"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44640002));

        LatLng A_44620002 = new LatLng(47.1765082, -1.6813656);
        mMap.addMarker(new MarkerOptions().position(A_44620002).title("Avenue de la Libération" + "\n" + "La Montagne"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44620002));

        LatLng A_44220002 = new LatLng(47.2154785, -1.687093);
        mMap.addMarker(new MarkerOptions().position(A_44220002).title("48 Boulevard de la Libération" + "\n" + "Couëron"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44220002));

        LatLng A_44340004 = new LatLng(47.15795, -1.608438);
        mMap.addMarker(new MarkerOptions().position(A_44340004).title("ZONE NANTES ATLANTIQUE" + "\n" + "Bouguenais"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44340004));

        LatLng A_44210004 = new LatLng(47.15795, -1.6084389);
        mMap.addMarker(new MarkerOptions().position(A_44210004).title("Route Bleue" + "\n" + "Pornic"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(A_44210004));



        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            mMap.setMyLocationEnabled(true);
        }

    }

}
