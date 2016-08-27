/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("/")
    public String getRoot(Model model) {
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);

        return "showcase";
    }

//    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @RequestMapping("/{id}")
    public String getbyid(Model model, @PathVariable("id") Integer id) {
        System.out.println(":::: ::: :: :" + id);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);

        Brand brand = brandService.getBrand(id);
        model.addAttribute("products", brand.getPhoneList());
        System.out.println(brand.getPhoneList());

        return "showcase";
    }
    
    @ExceptionHandler
    public void errorHandler(Throwable exception) {
        exception.printStackTrace();
    }
}
