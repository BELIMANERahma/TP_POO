package Model;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


public class Orthophoniste  implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;

    private Compte compte;
    private Agenda agenda;
    private TreeMap<Integer,Dossier> Mes_dossiers;


    public Orthophoniste(Compte compte ) {
        this.compte = compte;
        this.Mes_dossiers = new TreeMap<Integer,Dossier >();
        String email = this.compte.getEmail().toLowerCase().replace(" ", "");
        serializeProfile("./src/main/Userinformation/" + email + ".ser");

    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agnenda) {
        this.agenda = agnenda;
    }

    public TreeMap< Integer,Dossier > getMes_patients()
    {
        return Mes_dossiers;
    }
    public TreeMap< Integer,Dossier > add_patient(Dossier dossier)
    {
        Mes_dossiers.put(dossier.getNumero(),dossier);
        return Mes_dossiers;
    }

    public void setMes_patients(TreeMap< Integer,Dossier > mes_patients)

    {
        Mes_dossiers = mes_patients;
    }


    private void serializeProfile(String filepath)
    {
        try
        {
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

      public Dossier rechercher_patient(int n)
    {

        if (Mes_dossiers!=null)
        {
        if(Mes_dossiers.containsKey(n))
        {
        return Mes_dossiers.get(n);}
         else
         {
            return null;
        }
        }
        return null;
    }
    public static Orthophoniste getcurrentuser() throws IOException, ClassNotFoundException
    {
        String filename = "./src/main/Userinformation/current.ser";
        File file = new File(filename);
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Orthophoniste  utilisateur = (Orthophoniste) objectInputStream.readObject();

        return utilisateur ;

    }
    private static void serialize(String filepath,Orthophoniste user)
    {
        try {
            if (user != null)
            {
                String filename = "./src/main/Userinformation/current.ser";
                FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(user);

            }
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



