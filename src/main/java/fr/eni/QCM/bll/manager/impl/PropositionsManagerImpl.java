package bll.manager.impl;

import bll.manager.PropositionsManager;
import bo.Propositions;
import bo.Propositions;
import dal.dao.EpreuvesDAO;
import dal.dao.PropositionsDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class PropositionsManagerImpl implements PropositionsManager {

    private PropositionsDAO propositionsDAO = DAOFactory.propositionsDAO();

    private static PropositionsManagerImpl instance;

    private PropositionsManagerImpl() {

    }

    public static PropositionsManagerImpl getInstance() {
        if(instance == null) {
            instance = new PropositionsManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Propositions> selectAll() throws ManagerException {

        List<Propositions> list = null;

        try {
            list = propositionsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Propositions selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Propositions propositions = null;

        try {

            ValidationUtil.checkNotNull(id);

            propositions = propositionsDAO.selectById(id);

            if(propositions == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return propositions;
    }
}
