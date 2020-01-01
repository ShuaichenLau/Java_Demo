package com.alice.filter;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    private HttpServletRequest request;

    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public String getParameter(String name) {
        String oldValue = super.getParameter(name);
        System.out.println("原来参数==>" + oldValue);
        if (!StringUtils.isEmpty(oldValue)){
            oldValue = StringEscapeUtils.escapeHtml(oldValue);
            System.out.println("修改参数==>" + oldValue);
        }
        return oldValue;
    }
}
