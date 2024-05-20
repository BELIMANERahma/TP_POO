package Model;

import kotlin.text.UStringsKt;

import java.io.Serializable;
import java.util.Date;

public abstract class Rendez_vous implements Serializable {
    private String date;
    private String heure;
    private Type_rendez_vous type;
    private String Observation;

    public Rendez_vous(String date, String heure, Type_rendez_vous type, String observation) {
        this.date = date;
        this.heure = heure;
        this.type = type;
        Observation = observation;
    }

    public Rendez_vous() {

    }

    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public Type_rendez_vous getType() {
        return type;
    }

    public String getObservation() {
        return Observation;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setType(Type_rendez_vous type) {
        this.type = type;
    }

    public void setObservation(String observation) {
        Observation = observation;
    }
}
