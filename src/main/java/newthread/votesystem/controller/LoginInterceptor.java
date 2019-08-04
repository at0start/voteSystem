package newthread.votesystem.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/8/1-12:45
 */
public class LoginInterceptor implements HandlerInterceptor {

    //用来存储不用拦截的请求
    private List<String> unCheckUrls;
    @Override
    public boolean preHandle(HttpServletRequest request
            , HttpServletResponse response, Object o) throws Exception {
        String requestUrl = request.getRequestURI();
        requestUrl = requestUrl.replaceAll(request.getContextPath(),"");
        //判断是否针对匿名路径需要拦截，如果包含，则表示匿名路径，需要拦截，否则提供拦截
        if (unCheckUrls.contains(requestUrl)){

            //包含公开路径，直接跳转
            return true;
        }
        if (null ==request.getSession().getAttribute("sessionUser")) {
            response.sendRedirect(request.getContextPath() + "/users/login.action");
            return false;
        }

        //放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o
            , ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse, Object o
            , Exception e) throws Exception {

    }
}
