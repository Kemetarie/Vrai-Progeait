package bll.manager.impl;

import bll.manager.ThemesManager;
import bo.Epreuves;
import bo.Themes;
import dal.dao.TestsDAO;
import dal.dao.ThemesDAO;
import dal.exception.DaoException;
import dal.factory.DAOFactory;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;
import fr.eni.tp.web.common.util.ValidationUtil;

import java.util.List;

public class ThemesManagerImpl implements ThemesManager {


    private ThemesDAO themesDAO = DAOFactory.themesDAO();

    private static ThemesManagerImpl instance;

    private ThemesManagerImpl() {

    }

    public static ThemesManagerImpl getInstance() {
        if(instance == null) {
            instance = new ThemesManagerImpl();
        }
        return instance;
    }

    @Override
    public List<Themes> selectAll() throws ManagerException {
        return null;
    }

    @Override
    public Themes selectById(Integer id) throws ManagerException, ElementNotFoundException {

        Themes themes = null;

        try {

            ValidationUtil.checkNotNull(id);

            themes = themesDAO.selectById(id);

            if(themes == null) {
                throw new ElementNotFoundException("The note does not exist", null);
            }

        } catch (DaoException e) {
            throw new ManagerException(e.getMessage(), e);
        } catch (IllegalArgumentException e) {
            throw new ManagerException("The id cannot be null", e);
        }

        return themes;
    }
}
