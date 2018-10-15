package bll.manager.impl;

import bll.manager.PromotionsManager;
import bo.Promotions;
import bo.Tests;
import dal.dao.PromotionsDAO;
import dal.dao.TestsDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class PromotionsManagerImpl implements PromotionsManager {

    private PromotionsDAO promotionsDAO = DAOFactory.promotionsDAO();

    private static PromotionsManagerImpl instance;

    private PromotionsManagerImpl() {

    }

    public static PromotionsManagerImpl getInstance() {
        if(instance == null) {
            instance = new PromotionsManagerImpl();
        }
        return instance;
    }


    @Override
    public List<Promotions> selectAll() throws ManagerException {

        List<Promotions> list = null;

        try {
            list = promotionsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Promotions selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Promotions promotions = null;

        try {

            ValidationUtil.checkNotNull(id);

            promotions = promotionsDAO.selectById(id);

            if(promotions == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return promotions;
    }

    @Override
    public Promotions selectByLibelle(String libelle) throws DaoException {

        Promotions promotions = null;

        try {

            ValidationUtil.checkNotNull(libelle);

            promotions = promotionsDAO.selectByLibelle(libelle);

            if(promotions == null) {
                throw new ManagerException("The note does not exist", null);
            }

        } catch (ManagerException e) {
            e.printStackTrace();
        }

        return promotions;
    }
}
