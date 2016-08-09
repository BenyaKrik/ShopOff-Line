/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author user
 */
@Controller
public class AuthorizationController {

    @RequestMapping(path = "/auth", method = RequestMethod.GET)
    public String Authorization() {
//if (req.getParameter("logout") != null) {
//            req.getSession().invalidate();
//        }
        return "authorization";

    }

}
