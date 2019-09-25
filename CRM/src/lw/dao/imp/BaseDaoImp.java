package lw.dao.imp;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import lw.dao.BaseDao;

public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T>{
	private Class clazz;
	public BaseDaoImp(){
		//反射:第一步获得class
		Class clazz=this.getClass();
		//查看jdk的api
		Type type=clazz.getGenericSuperclass();
		//得到这个type就是一个参数化类型，将type强转参数化的类型
		ParameterizedType pType=(ParameterizedType) type;
		//通过参数化类型获得实际类型参数:得到一个实际类型参数的数组
		Type[] types =pType.getActualTypeArguments();
		//只获得第一个实际类型参数即可
		this.clazz=(Class) types[0];
	}
	@Override
	public void save(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findById(Serializable id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	@Override
	public List<T> findAll() {
		return (List<T>) this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}
	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		//设置统计个数的条件
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list=(List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}
	@Override
	public List<T> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
		detachedCriteria.setProjection(null);
		return (List<T>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
	}
	
	
}
