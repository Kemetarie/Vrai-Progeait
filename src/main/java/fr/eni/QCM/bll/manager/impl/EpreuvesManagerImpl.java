package bll.manager.impl;

import bll.manager.EpreuvesManager;
import bo.Epreuves;
import dal.dao.EpreuvesDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class EpreuvesManagerImpl implements EpreuvesManager {

    private EpreuvesDAO epreuvesDAO = DAOFactory.epreuvesDAO();

    private static EpreuvesManagerImpl instance;

    private EpreuvesManagerImpl() {

    }

    public static EpreuvesManagerImpl getInstance() {
        if(instance == null) {
            instance = new EpreuvesManagerImpl();
        }
        return instance;
    }


    @Override
    public List<Epreuves> selectAll() throws ManagerException {

        List<Epreuves> list = null;

        try {
            list = epreuvesDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Epreuves selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Epreuves epreuves = null;

        try {

            ValidationUtil.checkNotNull(id);

            epreuves = epreuvesDAO.selectById(id);

            if(epreuves == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return epreuves;
    }
}
