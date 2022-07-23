package fr.eni.ecole.projetEnchere.modele.dal.dao;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Withdrawal;

public interface WithdrawalDao {

	Withdrawal addWithdrawal(Withdrawal withdrawal);

	Withdrawal updateWithdrawal(Withdrawal withdrawal);

	boolean deleteWithdrawal(Integer id);

	Withdrawal getWithdrawalById(Integer idArticle);
}
