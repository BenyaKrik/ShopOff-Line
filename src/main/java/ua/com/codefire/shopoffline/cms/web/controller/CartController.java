/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@RequestMapping("/cart/")
@Controller
public class CartController {
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("")
    public String getRoot(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        
        if (cart != null) {
            Map<Product, Integer> buys = new HashMap();
            for (Integer pid : cart.keySet()) {
                buys.put(productService.get(pid), cart.get(pid));
            }
            
            model.addAttribute("cart", buys);
        }
        
        return "cart";
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "add/ajax")
    public JSONObject postToCart(HttpServletRequest req, @RequestParam Integer productId) {
        HttpSession session = req.getSession();

        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
        
        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        if (!cart.containsKey(productId)) {
            cart.put(productId, 1);
        } else {
            cart.put(productId, cart.get(productId) + 1);
        }
        
        Map<Product, Integer> buys = new HashMap();
        for (Integer pid : cart.keySet()) {
            buys.put(productService.get(pid), cart.get(pid));
        }
        
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("response", "SUCCESS");
        jsonObj.put("data", buys);
        
        return jsonObj;
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public String addToCart(HttpServletRequest req, @RequestParam Integer productId) {
        HttpSession session = req.getSession();

        Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
            session.setAttribute("cart", cart);
        }

        if (!cart.containsKey(productId)) {
            cart.put(productId, 1);
        } else {
            cart.put(productId, cart.get(productId) + 1);
        }

        return "redirect:/";
    }

}
