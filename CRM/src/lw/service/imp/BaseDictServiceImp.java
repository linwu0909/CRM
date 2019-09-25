package lw.service.imp;

import java.util.List;

import lw.dao.BaseDictDao;
import lw.domain.BaseDict;
import lw.service.BaseDictService;

public class BaseDictServiceImp implements BaseDictService {
	private BaseDictDao baseDictDao;

	public void setBaseDictDao(BaseDictDao baseDictDao) {
		this.baseDictDao = baseDictDao;
	}

	@Override
	public List<BaseDict> findByTypeCode(String dict_type_code) {
		return baseDictDao.findByTypeCode(dict_type_code);
	}
	
}
