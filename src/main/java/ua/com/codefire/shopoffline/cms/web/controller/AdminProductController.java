/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;
/**
 *
 * @author user
 */
public class AdminProductController {
     @Autowired
    private ProductService productService;

}
