package bll.factory;

import bll.manager.*;
import bll.manager.impl.*;

public class ManagerFactory {

    public static EpreuvesManager epreuvesManager() {
        return EpreuvesManagerImpl.getInstance();
    }

    public static PropositionsManager propositionsManager() {
        return PropositionsManagerImpl.getInstance();
    }

    public static Questions_TirageManager questions_tirageManager() {
        return Questions_TirageManagerImpl.getInstance();
    }

    public static QuestionsManager questionsManager() {
        return QuestionsManagerImpl.getInstance();
    }

    public static Reponses_TirageManager reponses_tirageManager() {
        return Reponses_TirageManagerImpl.getInstance();
    }

    public static Sections_TestManager sections_testManager() {
        return Sections_TestManagerImpl.getInstance();
    }

    public static TestsManager testsManager() {
        return TestsManagerImpl.getInstance();
    }

    public static ThemesManager themesManager() {
        return ThemesManagerImpl.getInstance();
    }
}
