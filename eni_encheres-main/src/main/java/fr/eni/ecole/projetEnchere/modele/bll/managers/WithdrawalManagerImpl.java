package fr.eni.ecole.projetEnchere.modele.bll.managers;

import fr.eni.ecole.projetEnchere.modele.bll.bo.Withdrawal;
import fr.eni.ecole.projetEnchere.modele.dal.dao.DaoFactory;
import fr.eni.ecole.projetEnchere.modele.dal.dao.WithdrawalDao;
import fr.eni.ecole.projetEnchere.modele.dal.dao.WithdrawalDaoImpl;

public class WithdrawalManagerImpl implements WithdrawalManager {
	private WithdrawalDao withdrawalDao = DaoFactory.getWithdrawalDao();

	@Override
	public Withdrawal addWithdrawal(Withdrawal withdrawal) {
		return withdrawalDao.addWithdrawal(withdrawal);
	}

	@Override
	public Withdrawal updateWithdrawal(Withdrawal withdrawal) {
		return withdrawalDao.updateWithdrawal(withdrawal);
	}

	@Override
	public boolean deleteWithdrawal(Integer id) {
		return withdrawalDao.deleteWithdrawal(id);
	}

	@Override
	public Withdrawal getWithdrawalById(Integer idArticle) {
		return withdrawalDao.getWithdrawalById(idArticle);
	}

}
