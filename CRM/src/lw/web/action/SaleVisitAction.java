package lw.web.action;

import java.util.Date;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import lw.domain.PageBean;
import lw.domain.SaleVisit;
import lw.service.SaleVisitService;

public class SaleVisitAction extends ActionSupport implements ModelDriven<SaleVisit> {
	private SaleVisit saleVisit=new SaleVisit();
	@Override
	public SaleVisit getModel() {
		return saleVisit;
	}
	
	//在Action中注入Service
	@Resource(name="saleVisitService")
	private SaleVisitService saleVisitService;
	
	//接收分页数据
	private Integer currPage=1;
	private Integer pageSize=3;
	
	public void setCurrPage(Integer currPage) {
		if(currPage==null){
			currPage=1;
		}
		this.currPage = currPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize==null){
			pageSize=3;
		}
		this.pageSize = pageSize;
	}

	public String findAll(){
		//创建离线查询对象
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(SaleVisit.class);
		//设置条件
		if(saleVisit.getVisit_time()!=null){
			detachedCriteria.add(Restrictions.ge("visit_time", saleVisit.getVisit_time()));
		}
		if(visit_end_time!=null){
			detachedCriteria.add(Restrictions.le("visit_time", visit_end_time));
		}
		//调用业务层
		PageBean<SaleVisit> pageBean=saleVisitService.findByPage(detachedCriteria,currPage,pageSize);
		//存入到值栈
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/**
	 * 拜访记录跳转到添加页面的方法
	 * @return
	 */
	public String saveUI(){
		return "saveUI";
	}
	/**
	 * 保存客户拜访记录的方法
	 */
	public String save(){
		//调用业务层
		saleVisitService.save(saleVisit);
		return "saveSuccess";
	}
	//接收数据
	private Date visit_end_time;
	public void setVisit_end_time(Date visit_end_time) {
		this.visit_end_time = visit_end_time;
	}

	public Date getVisit_end_time() {
		return visit_end_time;
	}
	
}
