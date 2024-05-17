package Model;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Orthophoniste  implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private Compte compte;
    private Agenda agenda;
    private Map<Patient, Integer> Mes_patients;


    public Orthophoniste(Compte compte ) {
        this.compte = compte;
        this.Mes_patients = new HashMap<Patient, Integer>();
        String email = this.compte.getEmail().toLowerCase().replace(" ", "");
        serializeProfile("./src/main/Userinformation/" + email + ".ser");



    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Agenda getAgnenda() {
        return agenda;
    }

    public void setAgnenda(Agenda agnenda) {
        this.agenda = agnenda;
    }

    public Map<Patient, Integer> getMes_patients() {
        return Mes_patients;
    }

    public void setMes_patients(Map<Patient, Integer> mes_patients) {
        Mes_patients = mes_patients;
    }


    private void serializeProfile(String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Serialized profile object created for " + this.compte.getEmail() + ".");
        }

        catch
        (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

}
