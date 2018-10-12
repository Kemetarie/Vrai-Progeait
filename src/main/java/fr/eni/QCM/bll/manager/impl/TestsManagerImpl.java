package bll.manager.impl;

import bll.manager.TestsManager;
import bo.Epreuves;
import bo.Tests;
import dal.dao.Sections_TestDAO;
import dal.dao.TestsDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class TestsManagerImpl implements TestsManager {

    private TestsDAO testsDAO = DAOFactory.testsDAO();

    private static TestsManagerImpl instance;

    private TestsManagerImpl() {

    }

    public static TestsManagerImpl getInstance() {
        if(instance == null) {
            instance = new TestsManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Tests> selectAll() throws ManagerException {

        List<Tests> list = null;

        try {
            list = testsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Tests selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Tests tests = null;

        try {

            ValidationUtil.checkNotNull(id);

            tests = testsDAO.selectById(id);

            if(tests == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return tests;
    }
}
