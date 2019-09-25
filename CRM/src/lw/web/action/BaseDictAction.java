package lw.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import lw.domain.BaseDict;
import lw.service.BaseDictService;
import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;



public class BaseDictAction extends ActionSupport implements ModelDriven<BaseDict> {
	//模型驱动使用的对象
	private BaseDict baseDict=new BaseDict();
	@Override
	public BaseDict getModel() {
		return baseDict;
	}
	//注入service
	private BaseDictService baseDictService;
	public void setBaseDictService(BaseDictService baseDictService) {
		this.baseDictService = baseDictService;
	}
	/*
	 * 根据类型名称查询字典
	 * */
	public String findByTypeCode() throws IOException{
		//调用业务层查询
		List<BaseDict> list=baseDictService.findByTypeCode(baseDict.getDict_type_code());
		
		JsonConfig jsonConfig=new JsonConfig();
		jsonConfig.setExcludes(new String[]{"dict_sort","dict_enable","dict_memo"});
		JSONArray jsonArray=JSONArray.fromObject(list,jsonConfig);
		System.out.println(jsonArray.toString());
		//将json打印到页面
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
