package indi.wyx0k.demo.servicezuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulTestFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(ZuulTestFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        log.info(String.format("%s >>> %s",req.getMethod(),req.getRequestURI().toString()));
        Object accessToken = req.getParameter("token");
        if(accessToken == null){
            log.warn("没有token");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("fuck you");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("test ok");
        return null;
    }

}
