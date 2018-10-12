package bll.manager.impl;

import bll.manager.QuestionsManager;
import bo.Epreuves;
import bo.Questions;
import dal.dao.QuestionsDAO;
import dal.dao.Questions_TirageDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class QuestionsManagerImpl implements QuestionsManager {

    private QuestionsDAO questionsDAO = DAOFactory.questionsDAO();

    private static QuestionsManagerImpl instance;

    private QuestionsManagerImpl() {

    }

    public static QuestionsManagerImpl getInstance() {
        if(instance == null) {
            instance = new QuestionsManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Questions> selectAll() throws ManagerException {

        List<Questions> list = null;

        try {
            list = questionsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Questions selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Questions questions = null;

        try {

            ValidationUtil.checkNotNull(id);

            questions = questionsDAO.selectById(id);

            if(questions == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return questions;
    }
}
