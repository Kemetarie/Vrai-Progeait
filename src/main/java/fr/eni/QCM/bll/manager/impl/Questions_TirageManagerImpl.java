package bll.manager.impl;

import bll.manager.Questions_TirageManager;
import bo.Propositions;
import bo.Questions_Tirage;
import dal.dao.PropositionsDAO;
import dal.dao.Questions_TirageDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class Questions_TirageManagerImpl implements Questions_TirageManager {

    private Questions_TirageDAO questions_tirageDAO = DAOFactory.questions_tirageDAO();

    private static Questions_TirageManagerImpl instance;

    private Questions_TirageManagerImpl() {

    }

    public static Questions_TirageManagerImpl getInstance() {
        if(instance == null) {
            instance = new Questions_TirageManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Questions_Tirage> selectAll() throws ManagerException {

        List<Questions_Tirage> list = null;

        try {
            list = questions_tirageDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Questions_Tirage selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Questions_Tirage questions_tirage = null;

        try {

            ValidationUtil.checkNotNull(id);

            questions_tirage = questions_tirageDAO.selectById(id);

            if(questions_tirage == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return questions_tirage;
    }
}
