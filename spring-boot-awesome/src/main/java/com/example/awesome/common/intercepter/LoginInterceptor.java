package com.example.awesome.common.intercepter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.awesome.common.constant.ResultEntity;
import com.example.awesome.common.emun.ErrorEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一日志处理
 */
public class LoginInterceptor implements HandlerInterceptor {

    public static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
    private long startTime;

    /** 在请求处理之前进行调用（Controller方法调用之前 */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object sessionObj = request.getSession().getAttribute("USER_KEY");
        if (sessionObj == null) {
            System.out.println("username=" + request.getParameter("username"));
            System.out.println("password=" + request.getParameter("password"));
            System.out.println("被拦截的url是：" + request.getRequestURI());
			// return doFalse(ifAjax(request), response, request);
        } else {
            startTime = System.currentTimeMillis();
            logger.info("调用开始[" + request.getServletPath() + "][" + Thread.currentThread().getName() + "]");
        }
        return true;
    }

    private boolean doFalse(boolean ifAjax, HttpServletResponse response, HttpServletRequest request) throws IOException {
        /** 600 对应前端vue session失效判断的数字 */
        String json = JSON.toJSONString(new ResultEntity(ErrorEnum.SESSION_VALID),
                new SerializerFeature[]{SerializerFeature.WriteDateUseDateFormat});
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(json);
        response.getWriter().flush();
        response.getWriter().close();

        return false;

    }

    private boolean ifAjax(HttpServletRequest request) throws IOException {
        String requestType = request.getHeader("X-Requested-With");
        if (!StringUtils.isEmpty(requestType)) {
            return true;
        }
        return false;
    }

    /** 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）*/
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle被调用");
    }

    /** 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）*/
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("调用结束[" + httpServletRequest.getServletPath() + "],本次请求用时：" + (System.currentTimeMillis() - startTime) / 1000.0000 + "秒["
            + Thread.currentThread().getName() + "]");
    }
}