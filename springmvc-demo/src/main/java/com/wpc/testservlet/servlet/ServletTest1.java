package com.wpc.testservlet.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author wangpeican
 * @date 2023/2/3 1:17
 */
public class ServletTest1 extends DispatcherServlet {
    public ServletTest1() {
        super();
    }

    public ServletTest1(WebApplicationContext webApplicationContext) {
        super(webApplicationContext);
    }

    @Override
    public void setDetectAllHandlerMappings(boolean detectAllHandlerMappings) {
        super.setDetectAllHandlerMappings(detectAllHandlerMappings);
    }

    @Override
    public void setDetectAllHandlerAdapters(boolean detectAllHandlerAdapters) {
        super.setDetectAllHandlerAdapters(detectAllHandlerAdapters);
    }

    @Override
    public void setDetectAllHandlerExceptionResolvers(boolean detectAllHandlerExceptionResolvers) {
        super.setDetectAllHandlerExceptionResolvers(detectAllHandlerExceptionResolvers);
    }

    @Override
    public void setDetectAllViewResolvers(boolean detectAllViewResolvers) {
        super.setDetectAllViewResolvers(detectAllViewResolvers);
    }

    @Override
    public void setThrowExceptionIfNoHandlerFound(boolean throwExceptionIfNoHandlerFound) {
        super.setThrowExceptionIfNoHandlerFound(throwExceptionIfNoHandlerFound);
    }

    @Override
    public void setCleanupAfterInclude(boolean cleanupAfterInclude) {
        super.setCleanupAfterInclude(cleanupAfterInclude);
    }

    @Override
    protected void onRefresh(ApplicationContext context) {
        super.onRefresh(context);
    }

    @Override
    protected void initStrategies(ApplicationContext context) {
        super.initStrategies(context);
    }

    @Override
    protected <T> T getDefaultStrategy(ApplicationContext context, Class<T> strategyInterface) {
        return super.getDefaultStrategy(context, strategyInterface);
    }

    @Override
    protected <T> List<T> getDefaultStrategies(ApplicationContext context, Class<T> strategyInterface) {
        return super.getDefaultStrategies(context, strategyInterface);
    }

    @Override
    protected Object createDefaultStrategy(ApplicationContext context, Class<?> clazz) {
        return super.createDefaultStrategy(context, clazz);
    }

    @Override
    protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doService(request, response);
    }

    @Override
    protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.doDispatch(request, response);
        System.out.println("form servlet1");
    }

    @Override
    protected LocaleContext buildLocaleContext(HttpServletRequest request) {
        return super.buildLocaleContext(request);
    }

    @Override
    protected HttpServletRequest checkMultipart(HttpServletRequest request) throws MultipartException {
        return super.checkMultipart(request);
    }

    @Override
    protected void cleanupMultipart(HttpServletRequest request) {
        super.cleanupMultipart(request);
    }

    @Override
    protected HandlerExecutionChain getHandler(HttpServletRequest request) throws Exception {
        return super.getHandler(request);
    }

    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.noHandlerFound(request, response);
    }

    @Override
    protected HandlerAdapter getHandlerAdapter(Object handler) throws ServletException {
        return super.getHandlerAdapter(handler);
    }

    @Override
    protected ModelAndView processHandlerException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        return super.processHandlerException(request, response, handler, ex);
    }

    @Override
    protected void render(ModelAndView mv, HttpServletRequest request, HttpServletResponse response) throws Exception {
        super.render(mv, request, response);
    }

    @Override
    protected String getDefaultViewName(HttpServletRequest request) throws Exception {
        return super.getDefaultViewName(request);
    }

    @Override
    protected View resolveViewName(String viewName, Map<String, Object> model, Locale locale, HttpServletRequest request) throws Exception {
        return super.resolveViewName(viewName, model, locale, request);
    }
}
