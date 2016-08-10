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
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/admin/product")
public class AdminProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("/add")
    public String addProduct(Model model) {
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brandList", brandList);
        return "admin/product.edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", params = {"brand_id", "model", "body", "cost"})
    public String addProduct(
            @RequestParam Integer brand_id,
            @RequestParam String model,
            @RequestParam String body,
            @RequestParam Integer cost) {
        Product product = new Product(model, body, cost);
        Brand brand = brandService.findById(brand_id);
        product.setBrand(brand);
        product = productService.save(product);

        return "redirect:/admin/product/edit/" + product.getId();
    }

    @RequestMapping("edit/{id}")
    public String editProduct(Model model, @PathVariable("id") Integer id) {
      Product  product = productService.get(id);
         model.addAttribute("foundProduct", product);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brandList", brandList);
        return "admin/product.edit";
    }
//     @RequestMapping("edit/{id}")
//    public String editProduct(method = RequestMethod.POST, @PathVariable("id") Integer id, params = {"brand_id", "model", "body", "cost"}) {
//    
//    Product  product = productService.get(id);
//         model.addAttribute("foundProduct", product);
//        List<Brand> brandList = brandService.getBrandList();
//        model.addAttribute("brandList", brandList);
//        return "admin/product.edit";
//    }
    
    @RequestMapping("remove/{id}")
    public String removeProduct( @PathVariable("id") Integer id) {
       productService.removeProduct(id);
      
        return "redirect:/admin/";
    }
     
}
