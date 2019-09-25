package lw.service;

import org.hibernate.criterion.DetachedCriteria;

import lw.domain.PageBean;
import lw.domain.SaleVisit;


public interface SaleVisitService {

	PageBean<SaleVisit> findByPage(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);

	void save(SaleVisit saleVisit);

	
	
}
