package pwabd.conversie;

import java.io.Serializable;

import pwabd.util.Unitati;

public class InfoConversie implements Serializable {
    private int valoareDeconvertit;
    private int valoareConvertita;
    private double constantaDeConversie;
    private Unitati unitateDin;
    private Unitati unitateCatre;

    public int getValoareDeconvertit() {
        return valoareDeconvertit;
    }
    public void setValoareDeconvertit(int valoareDeconvertit) {
        this.valoareDeconvertit = valoareDeconvertit;
    }
    public int getValoareConvertita() {
        return valoareConvertita;
    }
    public void setValoareConvertita(int valoareConvertita) {
        this.valoareConvertita = valoareConvertita;
    }
    public double getConstantaDeConversie() {
        return constantaDeConversie;
    }
    public void setConstantaDeConversie(double constantaDeConversie) {
        this.constantaDeConversie = constantaDeConversie;
    }
    public Unitati getUnitateDin() {
        return unitateDin;
    }
    public void setUnitateDin(Unitati unitateDin) {
        this.unitateDin = unitateDin;
    }
    public Unitati getUnitateCatre() {
        return unitateCatre;
    }
    public void setUnitateCatre(Unitati unitateCatre) {
        this.unitateCatre = unitateCatre;
    }
    

}