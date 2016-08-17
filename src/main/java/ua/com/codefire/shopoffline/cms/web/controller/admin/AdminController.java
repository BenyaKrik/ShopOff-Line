/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("")
    public String getRoot(Model model) {
        List<Product> productList = productService.getProductList();
        model.addAttribute("products", productList);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);

        return "admin/dashboard";
    }

    @RequestMapping("products")
    public String getIndex() {
        return "redirect:/admin/";
    }

    @RequestMapping(method = RequestMethod.GET, value = "brands")
    // @RequestMapping("/admin/brands") 
    public String showBrands(Model model) {

        List<Brand> bandAll = brandService.getBrandList();

        model.addAttribute("brandList", bandAll);

        return "admin/brands";

    }
}
