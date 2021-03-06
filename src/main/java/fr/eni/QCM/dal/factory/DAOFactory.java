package dal.factory;

import dal.dao.*;
import dal.dao.impl.*;

public class DAOFactory {

    public static CandidatsDAO candidatsDAO() {
        return CandidatsDaoImpl.getInstance();
    }

    public static CollaborateursDAO collaborateursDAO() {
        return CollaborateursDaoImpl.getInstance();
    }

    public static EpreuvesDAO epreuvesDAO() {
        return EpreuvesDaoImpl.getInstance();
    }

    public static ProfilsDAO profilsDAO() {
        return ProfilsDaoImpl.getInstance();
    }

    public static PromotionsDAO promotionsDAO() {
        return PromotionsDaoImpl.getInstance();
    }

    public static PropositionsDAO propositionsDAO() {
        return PropositionsDaoImpl.getInstance();
    }

    public static Questions_TirageDAO questions_tirageDAO() {
        return Questions_TirageDaoImpl.getInstance();
    }

    public static QuestionsDAO questionsDAO() {
        return QuestionsDaoImpl.getInstance();
    }

    public static Reponses_TirageDAO reponses_tirageDAO() {
        return Reponses_TirageDaoImpl.getInstance();
    }

    public static Sections_TestDAO sections_testDAO() {
        return Sections_TestDaoImpl.getInstance();
    }

    public static TestsDAO testsDAO() {
        return TestsDaoImpl.getInstance();
    }

    public static ThemesDAO themesDAO() {
        return ThemesDaoImpl.getInstance();
    }

    public static UtilisateursDAO utilisateursDAO() {
        return UtilisateursDaoImpl.getInstance();
    }
}
