package com.keshe.luntan.interceptor;

import com.keshe.luntan.entity.UserState;
import com.keshe.luntan.utils.exception.ServiceException;
import com.keshe.luntan.utils.manager.UserStateManager;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManagerPermissionInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	}

	@Override
	public synchronized boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) {
        Integer userid = (Integer) request.getAttribute("userid");
		System.out.println(userid);
		System.out.println("拦截器3");
        if(userid != null) {
            //检查是否为管理员权限
//            UserState userState = UserStateManager.getUserStateflag(userid);
            UserState userState = new UserState(1);
            if(userState != null && userState.isManager()) {
                return true;
            }
        }
		try {
			request.getRequestDispatcher("/error/managerpermissionerror").forward(request,response);
		} catch (ServletException e) {
			throw new ServiceException(500,"页面跳转错误",e);
		} catch (IOException e) {
			throw new ServiceException(500,"页面跳转时IO错误",e);
		}
		return false;
	}

}
