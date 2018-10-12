package bll.manager.impl;

import bll.manager.CollaborateursManager;
import bo.Collaborateurs;
import bo.Epreuves;
import dal.dao.CollaborateursDAO;
import dal.dao.EpreuvesDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class CollaborateursManagerImpl implements CollaborateursManager {

    private CollaborateursDAO collaborateursDAO = DAOFactory.collaborateursDAO();

    private static CollaborateursManagerImpl instance;

    private CollaborateursManagerImpl() {

    }

    public static CollaborateursManagerImpl getInstance() {
        if(instance == null) {
            instance = new CollaborateursManagerImpl();
        }
        return instance;
    }


    @Override
    public List<Collaborateurs> selectAll() throws ManagerException {

        List<Collaborateurs> list = null;

        try {
            list = collaborateursDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Collaborateurs selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Collaborateurs collaborateurs = null;

        try {

            ValidationUtil.checkNotNull(id);

            collaborateurs = collaborateursDAO.selectById(id);

            if(collaborateurs == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return collaborateurs;
    }
}
