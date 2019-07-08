package com.keshe.luntan.interceptor;

import com.keshe.luntan.utils.MdzwUtils;
import com.keshe.luntan.utils.TokenUtils;
import com.keshe.luntan.utils.checker.MyNumberChecker;
import com.keshe.luntan.utils.manager.LoginManager;
import com.nimbusds.jose.JOSEException;
import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.Map;

public class TokenAnalysisInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o) {
        String token = request.getHeader("token");
        //验证token
        if(token != null && !"".equals(token)) {
            Map<String,Object> map = null;
            try {
                System.out.println(token);
                map = TokenUtils.valid(token);
            } catch (ParseException e) {
                System.out.println("TOKEN解析错误" + " token: " + token);
                //throw new ServiceException(500,"TOKEN解析错误",e);
            } catch (JOSEException e) {
                System.out.println("荷载解密错误" + " token: " + token);
                //throw new ServiceException(500,"荷载解密错误",e);
            }
            if(map != null) {
                JSONObject data = JSONObject.fromObject(map.get("data"));
                int userid = (int)data.get("userid");
                //检验userid
                if(MyNumberChecker.<Integer>numberExtChecker(userid, MyNumberChecker.NumberExtRule.ID_CHECKER)) {
                    if((int)map.get("Result") == 0) {
                        if(useridCheck(userid,token)) {
                            request.setAttribute("userid", userid);
                        }
                    }
                    else {
                        //token过期，下线用户
                        MdzwUtils.quitUser(userid);
                    }
                }
            }
        }
        return true;
    }

    private boolean useridCheck(int userid, String token) {
        if(userid == 0) {
            return false;
        }
//        if(!token.equals(LoginManager.getLoginflag(userid))) {
//            return false;
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
