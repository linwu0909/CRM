package lw.web.action;

import lw.domain.User;
import lw.service.UserService;
import net.sf.json.JSONArray;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * @author 林
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	//模型驱动使用的对象
	private User user=new User();
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	//注入service	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//用户注册的方法
	public String regist(){
		userService.regist(user);
		return LOGIN;
	}
	//用户登陆的方法:login
	public String login(){
		//调用业务层查询用户
		User existUser=userService.login(user);
		if(existUser==null){
			//登陆失败
			//添加错误信息
			this.addActionError("用户名或密码错误");
			return LOGIN;
		}else{
			ActionContext.getContext().getSession().put("existUser", existUser);
			return SUCCESS;
		}
	}
	public String findAllUser() throws IOException{
		List<User> list=userService.findAll();
		JSONArray jsonArray=JSONArray.fromObject(list);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonArray.toString());
		return NONE;
	}
}
