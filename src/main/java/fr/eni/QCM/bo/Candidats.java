package bo;

import java.io.Serializable;

public class Candidats implements Serializable {

    private int idCandidat;
    private int codePromotion;
    private int idEpreuve;

    public Candidats() {
    }

    public Candidats(int idCandidat, int codePromotion, int idEpreuve) {
        this.idCandidat = idCandidat;
        this.codePromotion = codePromotion;
        this.idEpreuve = idEpreuve;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getCodePromotion() {
        return codePromotion;
    }

    public void setCodePromotion(int codePromotion) {
        this.codePromotion = codePromotion;
    }

    public int getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(int idEpreuve) {
        this.idEpreuve = idEpreuve;
    }
}
