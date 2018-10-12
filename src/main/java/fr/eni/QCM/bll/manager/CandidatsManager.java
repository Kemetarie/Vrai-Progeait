package bll.manager;

import bo.Candidats;
import fr.eni.tp.web.common.bll.exception.ElementNotFoundException;
import fr.eni.tp.web.common.bll.exception.ManagerException;

import java.util.List;

public interface CandidatsManager {

    List<Candidats> selectAll() throws ManagerException;

    Candidats selectById(Integer id) throws ManagerException, ElementNotFoundException;
}
