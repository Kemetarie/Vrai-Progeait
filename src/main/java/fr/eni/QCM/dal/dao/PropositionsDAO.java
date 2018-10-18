package dal.dao;

import bo.Propositions;
import dal.exception.DaoException;

import java.util.List;

public interface PropositionsDAO extends GenericDAO<Propositions,Integer> {

    List<Propositions> selectByIdQuestion(Integer integer) throws DaoException;

}
