package bll.manager.impl;

import bll.manager.ProfilsManager;
import bo.Profils;
import dal.dao.ProfilsDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class ProfilsManagerImpl implements ProfilsManager {

    private ProfilsDAO profilsDAO = DAOFactory.profilsDAO();

    private static ProfilsManagerImpl instance;

    private ProfilsManagerImpl() {

    }

    public static ProfilsManagerImpl getInstance() {
        if(instance == null) {
            instance = new ProfilsManagerImpl();
        }
        return instance;
    }


    @Override
    public List<Profils> selectAll() throws ManagerException {

        List<Profils> list = null;

        try {
            list = profilsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Profils selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Profils profils = null;

        try {

            ValidationUtil.checkNotNull(id);

            profils = profilsDAO.selectById(id);

            if(profils == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return profils;
    }

    @Override
    public Profils selectByLibelle(String libelle) throws DaoException {

        Profils profils = null;

        try {

            ValidationUtil.checkNotNull(libelle);

            profils = profilsDAO.selectByLibelle(libelle);

            if(profils == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return profils;
    }
}
