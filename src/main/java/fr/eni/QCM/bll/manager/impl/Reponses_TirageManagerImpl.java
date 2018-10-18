package bll.manager.impl;

import bll.manager.Reponses_TirageManager;
import bo.Questions;
import bo.Reponses_Tirage;
import dal.dao.QuestionsDAO;
import dal.dao.Reponses_TirageDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.exception.FunctionalException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class Reponses_TirageManagerImpl implements Reponses_TirageManager {

    private Reponses_TirageDAO reponses_tirageDAO = DAOFactory.reponses_tirageDAO();

    private static Reponses_TirageManagerImpl instance;

    private Reponses_TirageManagerImpl() {

    }

    public static Reponses_TirageManagerImpl getInstance() {
        if(instance == null) {
            instance = new Reponses_TirageManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Reponses_Tirage> selectAll() throws ManagerException {
        return null;
    }

    @Override
    public Reponses_Tirage selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Reponses_Tirage reponses_tirage = null;

        try {

            ValidationUtil.checkNotNull(id);

            reponses_tirage = reponses_tirageDAO.selectById(id);

            if(reponses_tirage == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return reponses_tirage;
    }

    @Override
    public Reponses_Tirage insert(Reponses_Tirage reponses_Tirage) throws ManagerException {

        try {

            ValidationUtil.checkNotNull(reponses_Tirage);
            ValidationUtil.checkNotNull(reponses_Tirage.getIdQuestion_Tirage());
            ValidationUtil.checkNotNull(reponses_Tirage.getIdProposition());

            reponses_tirageDAO.insert(reponses_Tirage);

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return reponses_Tirage;
    }
}
