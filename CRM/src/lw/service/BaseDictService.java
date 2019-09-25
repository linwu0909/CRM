package lw.service;

import java.util.List;

import lw.domain.BaseDict;

public interface BaseDictService {

	List<BaseDict> findByTypeCode(String dict_type_code);

}
