package bo;

import java.io.Serializable;

public class Reponses_Tirage implements Serializable {

    private int idQuestion_Tirage;

    private int idProposition;

    public Reponses_Tirage() {
    }

    public Reponses_Tirage(int idQuestion_Tirage, int idProposition) {
        this.idQuestion_Tirage = idQuestion_Tirage;
        this.idProposition = idProposition;
    }

    public int getIdQuestion_Tirage() {
        return idQuestion_Tirage;
    }

    public void setIdQuestion_Tirage(int idQuestion_Tirage) {
        this.idQuestion_Tirage = idQuestion_Tirage;
    }

    public int getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(int idProposition) {
        this.idProposition = idProposition;
    }
}
