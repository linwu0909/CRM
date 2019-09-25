package lw.service.imp;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import lw.dao.CustomerDao;
import lw.domain.Customer;
import lw.domain.PageBean;
import lw.service.CustomerService;
//客户管理service接口实现类
@Transactional
public class CustomerServiceImp implements CustomerService {
	//注入客户的dao
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//业务层保存客户
	@Override
	public void save(Customer customer) {
		customerDao.save(customer);
	}
	@Override
	public PageBean<Customer> findByPage(DetachedCriteria detachedCriteria, Integer currPage,Integer pageSize) {
		PageBean<Customer> pageBean=new PageBean<Customer>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页显示记录数
		pageBean.setPageSize(pageSize);
		//封装总记录数
		Integer totalCount =customerDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		//封装总页数
		Double tc=totalCount.doubleValue();
		Double num=Math.ceil(tc/pageSize);
		pageBean.setTotalPage(num.intValue());
		//封装每页显示数据的集合
		Integer begin=(currPage-1)*pageSize;
		List<Customer> list=customerDao.findByPage(detachedCriteria,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	@Override
	public Customer findById(Long cust_id) {
		return customerDao.findById(cust_id);
	}
	@Override
	public void delete(Customer customer) {
		customerDao.delete(customer);
	}
	@Override
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	//业务层查询所有客户的方法
	@Override
	public List<Customer> findAll() {
		return customerDao.findAll();
	}
	
}
