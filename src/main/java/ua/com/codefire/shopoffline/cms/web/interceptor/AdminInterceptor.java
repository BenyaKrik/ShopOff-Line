/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.interceptor;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ProductService productService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         
        
        return true;
    }
  
}
