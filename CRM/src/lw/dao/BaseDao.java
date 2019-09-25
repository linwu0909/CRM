package lw.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao<T> {
	public void save(T t);
	public void update(T t);
	public void delete(T t);
	public T findById(Serializable id);
	//查询所有
	public List<T> findAll();
	//统计个数的方法
	public Integer findCount(DetachedCriteria detachedCriteria);
	//分页查询的方法
	public List<T> findByPage(DetachedCriteria detachedCriteria,Integer begin,Integer pageSize);
}
