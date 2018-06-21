package com.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author huangding
 * @create 2018/6/13 15:18
 * @desc
 **/
@Component
@Slf4j
public class MyFilter extends ZuulFilter{
    @Override
    public String filterType() {
        /**
         * pre：路由之前
         routing：路由之时
         post： 路由之后
         error：发送错误调用
         */

        return "pre";
    }

    /**
     *   filterOrder：过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *  过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info("来请求了-----"+request.getMethod() ,request.getRequestURL().toString());
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("nmd 居然没有token");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {

                requestContext.getResponse().getWriter().write("nmd 居然没有token");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("那小子安全");
        return null;
    }
}