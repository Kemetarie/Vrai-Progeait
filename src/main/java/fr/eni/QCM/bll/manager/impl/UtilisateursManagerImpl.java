package bll.manager.impl;

import bll.manager.UtilisateursManager;
import bo.Utilisateurs;
import dal.dao.UtilisateursDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class UtilisateursManagerImpl implements UtilisateursManager {

    private UtilisateursDAO utilisateursDAO = DAOFactory.utilisateursDAO();

    private static UtilisateursManagerImpl instance;

    private UtilisateursManagerImpl() {

    }

    public static UtilisateursManagerImpl getInstance() {
        if(instance == null) {
            instance = new UtilisateursManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Utilisateurs> selectAll() throws ManagerException {

        List<Utilisateurs> list = null;

        try {
            list = utilisateursDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Utilisateurs selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(id);

            utilisateurs = utilisateursDAO.selectById(id);

            if(utilisateurs == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByName(String name) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(name);

            utilisateurs = utilisateursDAO.selectByName(name);

            if(utilisateurs == null) {
                throw new ManagerException("The note does not exist", null);
            }

        } catch (ManagerException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectBySurname(String surname) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(surname);

            utilisateurs = utilisateursDAO.selectBySurname(surname);

            if(utilisateurs == null) {

            }

        } catch (DaoException e) {
            try {
                throw new ManagerException(e.getMessage(), e);
            } catch (ManagerException e1) {
                e1.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            try {
                throw new ManagerException("The id cannot be null", e);
            } catch (ManagerException e1) {
                e1.printStackTrace();
            }
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByNameAndSurname(String name, String surname) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(name);
            ValidationUtil.checkNotNull(surname);

            utilisateurs = utilisateursDAO.selectByNameAndSurname(name,surname);

            if(utilisateurs == null) {
                throw new ManagerException("The note does not exist", null);
            }


        } catch (ManagerException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByEmail(String email) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(email);

            utilisateurs = utilisateursDAO.selectByEmail(email);

            if(utilisateurs == null) {
                throw new ManagerException("The note does not exist", null);
            }

        } catch (ManagerException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByEmailAndPsw(String email, String psw) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(email);

            utilisateurs = utilisateursDAO.selectByEmailAndPsw(email,psw);

            if(utilisateurs == null) {
                throw new ManagerException("The note does not exist", null);
            }

        } catch (ManagerException e) {
            e.printStackTrace();
        }

        return utilisateurs;
    }

    @Override
    public Utilisateurs selectByEmailAndPsw(String email, String psw) throws DaoException {

        Utilisateurs utilisateurs = null;

        try {

            ValidationUtil.checkNotNull(email);

            utilisateurs = utilisateursDAO.selectByEmailAndPsw(email,psw);

            if(utilisateurs == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return utilisateurs;
    }
}
