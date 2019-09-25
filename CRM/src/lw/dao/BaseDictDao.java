package lw.dao;

import java.util.List;

import lw.domain.BaseDict;

public interface BaseDictDao extends BaseDao<BaseDict>{

	List<BaseDict> findByTypeCode(String dict_type_code);

}
