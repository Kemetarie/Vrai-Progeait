package bll.manager.impl;

import bll.manager.CandidatsManager;
import bo.Candidats;
import bo.Profils;
import dal.dao.CandidatsDAO;
import dal.dao.ProfilsDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class CandidatsManagerImpl implements CandidatsManager {

    private CandidatsDAO candidatsDAO = DAOFactory.candidatsDAO();

    private static CandidatsManagerImpl instance;

    private CandidatsManagerImpl() {

    }

    public static CandidatsManagerImpl getInstance() {
        if(instance == null) {
            instance = new CandidatsManagerImpl();
        }
        return instance;
    }


    @Override
    public List<Candidats> selectAll() throws ManagerException {

        List<Candidats> list = null;

        try {
            list = candidatsDAO.selectAll();

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        }

        return list;
    }

    @Override
    public Candidats selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Candidats candidats = null;

        try {

            ValidationUtil.checkNotNull(id);

            candidats = candidatsDAO.selectById(id);

            if(candidats == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return candidats;
    }
}
