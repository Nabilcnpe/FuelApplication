package fuelapp.gorgoneyez.com.fuelapplication;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class StationInfo
{
	private static StationInfo stationInfo;				// singleton model
	private ArrayList<Station> stationList;

	private StationInfo(Context context)
	{
		this.stationList = new ArrayList<>();

		InputStream inputStream = null;

		try
		{
			inputStream = context.getResources().openRawResource(R.raw.file);

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(inputStream);

			Element root = document.getDocumentElement();
			root.normalize();

			NodeList nodeList = document.getElementsByTagName("pdv");

			for( int i = 0; i < 10000; ++i )
			{
				String lat = "";
				String lng = "";
				lat = ((Element)nodeList.item(i)).getAttribute("latitude");
				lng = ((Element)nodeList.item(i)).getAttribute("longitude");
				Element elem = (Element)nodeList.item(i);

				if( elem.getNodeType() == Node.ELEMENT_NODE )
				{
					NodeList prix_list = elem.getElementsByTagName("prix");
					NodeList service_list = elem.getElementsByTagName("service");
					String addresse;
					String ville;
					String prix = "", nom = "";		// prix et nom dans la meme balise
					String service = "";
					String debut = "";
					String fin = "";


//					debut = elem.getElementsByTagName("ouverture").item(0).getAttributes("debut");
					addresse = elem.getElementsByTagName("adresse").item(0).getTextContent();
					ville = elem.getElementsByTagName("ville").item(0).getTextContent();

					for( int j = 0; j < prix_list.getLength(); ++j )
					{
						nom += ((Element)prix_list.item(j)).getAttribute("nom");
						nom += "\n";
						prix += ((Element)prix_list.item(j)).getAttribute("valeur");
						prix += "\n";
					}

					for( int k = 0; k < service_list.getLength(); ++k )
					{
						service += ((Element)service_list.item(k)).getTextContent();;
						service += "\n";
					}

					this.stationList.add(new Station(ville, addresse, prix, nom, service, lat, lng));
				}
			}
		}
		catch( Exception e )
		{
			Log.d("stationinfo", "" + (inputStream == null));
			e.printStackTrace();
		}
	}

	public static StationInfo getStationsInfo(Context c)
	{
		if( stationInfo == null )
		{
			stationInfo = new StationInfo(c.getApplicationContext());
		}

		return stationInfo;
	}

	public ArrayList<Station> getStations()
	{
		return this.stationList;
	}
}
