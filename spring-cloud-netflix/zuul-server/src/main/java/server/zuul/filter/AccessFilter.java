package server.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

//@Component
public class AccessFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {

        return FilterConstants.PRE_TYPE;
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
        // https://blog.csdn.net/yangstarss/article/details/80493334
//        RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        Object token = request.getParameter("token");
//
//        //校验token
//        if (token == null) {
//            log.info("token为空，禁止访问!");
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        } else {
//            //TODO 根据token获取相应的登录信息，进行校验（略）
//        }
//
//        //添加Basic Auth认证信息
//        ctx.addZuulRequestHeader("Authorization", "Basic " + getBase64Credentials("app01", "*****"));

        return null;
    }

}
