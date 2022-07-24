package fr.eni.ecole.projetEnchere.modele.bll.managers;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Withdrawal;

public interface WithdrawalManager {

	Withdrawal addWithdrawal(Withdrawal withdrawal);

	Withdrawal updateWithdrawal(Withdrawal withdrawal);

	boolean deleteWithdrawal(Integer id);

	Withdrawal getWithdrawalById(Integer idArticle);
}
