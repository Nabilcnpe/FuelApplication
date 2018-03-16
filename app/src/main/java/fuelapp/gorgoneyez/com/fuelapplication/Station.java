package fuelapp.gorgoneyez.com.fuelapplication;

public class Station
{
	private String adresse;
	private String prix;
	private String nom;		// optionnel
	private String ville;
    private String service;
    private String lat;
    private String lng;
	
	public Station(String ville, String adresse, String prix, String service, String lat, String lng)
	{
		this.adresse = adresse;
		this.prix = prix;
		this.ville = ville;
        this.service = service;
        this.lat = lat;
        this.lng = lng;
	}

	public void setVille(String ville)
	{
		this.ville = ville;
	}

	public String getVille()
	{
		return this.ville;
	}

	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	
	public String getAdresse()
	{
		return this.adresse;
	}
	
	public void setPrix(String prix)
	{
		this.prix = prix;
	}
	
	public String getPrix()
	{
		return this.prix;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}

    public String getService()
    {
        return this.service;
    }

    public void setService(String service)
    {
        this.service = service;
    }

	public String getLat()
	{
		return this.lat;
	}

	public void setLat(String lat)
	{
		this.lat = lat;
	}

	public String getLng()
	{
		return this.lng;
	}

	public void setLng(String lng)
	{
		this.lng = lng;
	}



	@Override
	public String toString()
	{
		return this.ville + "\n" + this.adresse + "\n\n" + "SERVICES OFFERTES :" + "\n\n" + this.service;
	}
}
