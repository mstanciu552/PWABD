package pwabd.util;

import java.io.Serializable;

public class Eroare implements Serializable {
    private String mesaj;

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public String getMesaj() {
        return mesaj;
    }
    
}
