package bll.manager.impl;

import bll.manager.Sections_TestManager;
import bo.Epreuves;
import bo.Sections_Test;
import dal.dao.Reponses_TirageDAO;
import dal.dao.Sections_TestDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class Sections_TestManagerImpl implements Sections_TestManager {

    private Sections_TestDAO sections_testDAO = DAOFactory.sections_testDAO();

    private static Sections_TestManagerImpl instance;

    private Sections_TestManagerImpl() {

    }

    public static Sections_TestManagerImpl getInstance() {
        if(instance == null) {
            instance = new Sections_TestManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Sections_Test> selectAll() throws ManagerException {
        return null;
    }

    @Override
    public Sections_Test selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Sections_Test sections_test = null;

        try {

            ValidationUtil.checkNotNull(id);

            sections_test = sections_testDAO.selectById(id);

            if(sections_test == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return sections_test;
    }
}
