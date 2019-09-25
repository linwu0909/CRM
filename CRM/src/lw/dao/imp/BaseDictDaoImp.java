package lw.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import lw.dao.BaseDictDao;
import lw.domain.BaseDict;

public class BaseDictDaoImp extends BaseDaoImp<BaseDict> implements BaseDictDao {

	//根据类型编码查询字典数据
	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return (List<BaseDict>) this.getHibernateTemplate().find("from BaseDict where dict_type_code = ?",dict_type_code);
	}
	
}
