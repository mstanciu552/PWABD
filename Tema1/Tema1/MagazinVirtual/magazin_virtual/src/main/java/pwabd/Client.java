package pwabd;

public class Client {
    private String nume;
    private String prenume;
    private String oras;
    private String adresa;
    private String metoda_plata;

    public Client(String nume, String prenume, String oras, String adresa, String metoda_plata) {
        this.nume = nume;
        this.prenume = prenume;
        this.oras = oras;
        this.adresa = adresa;
        this.metoda_plata = metoda_plata;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMetoda_plata() {
        return metoda_plata;
    }

    public void setMetoda_plata(String metoda_plata) {
        this.metoda_plata = metoda_plata;
    }

    
}
