package pwabd.conversie;

import java.io.Serializable;
import java.util.Optional;

import pwabd.util.Eroare;
import pwabd.util.Unitati;

public class InfoConversie implements Serializable {
    private double valoareDeconvertit;
    private double valoareConvertita;
    private double constantaDeConversie;
    private Unitati unitateDin;
    private Unitati unitateCatre;

    public Optional<Eroare> converteste() {
        Eroare eroare = null;
        switch (unitateDin) {
            case METRI:
                if (unitateCatre == Unitati.INCH) {
                    valoareConvertita = 39.37 * valoareDeconvertit;
                } else if (unitateCatre == Unitati.FEET) {
                    valoareConvertita = 3.28 * valoareDeconvertit;
                } else
                    return Optional.of(eroare);
                break;

            case INCH:
                if (unitateCatre == Unitati.METRI) {
                    valoareConvertita = valoareDeconvertit / 39.37;
                } else if (unitateCatre == Unitati.FEET) {
                    valoareConvertita = 0.083 * valoareDeconvertit;
                } else
                    return Optional.of(eroare);
                break;

            case FEET:
                if (unitateCatre == Unitati.INCH) {
                    valoareConvertita = valoareDeconvertit * 12;
                } else if (unitateCatre == Unitati.METRI) {
                    valoareConvertita = 0.3048 * valoareDeconvertit;
                } else
                    return Optional.of(eroare);
                break;

        }
        return Optional.empty();
    }

    public double getValoareDeconvertit() {
        return valoareDeconvertit;
    }

    public void setValoareDeconvertit(double valoareDeconvertit) {
        this.valoareDeconvertit = valoareDeconvertit;
    }

    public double getValoareConvertita() {
        return valoareConvertita;
    }

    public void setValoareConvertita(double valoareConvertita) {
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