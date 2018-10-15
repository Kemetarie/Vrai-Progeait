package bo;

import java.io.Serializable;

public class Candidats implements Serializable {

    private int idCandidat;
    private int codePromotion;
    private Epreuves epreuves;

    public Candidats() {
    }

    public Candidats(int idCandidat, int codePromotion, Epreuves epreuves) {
        this.idCandidat = idCandidat;
        this.codePromotion = codePromotion;
        this.epreuves = epreuves;
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

    public Epreuves getEpreuves() {
        return epreuves;
    }

    public void setEpreuves(Epreuves epreuves) {
        this.epreuves = epreuves;
    }
}
