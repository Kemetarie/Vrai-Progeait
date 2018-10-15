package bo;

import java.io.Serializable;

public class Candidats implements Serializable {

    private int idCandidat;
    private Promotions promotions;
    private Epreuves epreuves;

    public Candidats() {
    }

    public Candidats(int idCandidat, Promotions promotions, Epreuves epreuves) {
        this.idCandidat = idCandidat;
        this.promotions = promotions;
        this.epreuves = epreuves;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public Promotions getPromotions() {
        return promotions;
    }

    public void setPromotions(Promotions promotions) {
        this.promotions = promotions;
    }

    public Epreuves getEpreuves() {
        return epreuves;
    }

    public void setEpreuves(Epreuves epreuves) {
        this.epreuves = epreuves;
    }
}
