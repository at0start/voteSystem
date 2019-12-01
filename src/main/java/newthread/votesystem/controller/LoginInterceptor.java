package newthread.votesystem.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/8/1-12:45
 */

//拦截
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    //预处理回调方法，true不拦截，false拦截
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response, Object o) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute("userName")!=null){
            //不拦截
            return true;
        }else {
            // 拦截后进入登录页面
            response.sendRedirect(request.getContextPath()+"/**/login.html");
            return  false;
        }
    }


    //后处理回调请求，实现处理器（modelAndView）的后处理，但在渲染前
    @Override
    public void postHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o
            , ModelAndView modelAndView) throws Exception {

    }

    //整个请求后处理完毕后、返回前回调
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o
            , Exception e) throws Exception {

    }
}
