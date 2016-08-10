/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/admin/brand/")
public class AdminBrandController {

    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;

    @RequestMapping("remove")
    public String removeBrands(@RequestParam("id") int id) {
        System.out.println("   :::::::" + id);

        brandService.removeBrand(id);

        return "redirect:/admin/brands";
    }

    @RequestMapping("add")
    public String addBrands() {

        return "admin/brand.edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "add", params = {"name", "country"})
    public String addBrands(Model model, @RequestParam String name,
            @RequestParam String country) {

        Brand brand = new Brand(name, country);
        brand = brandService.save(brand);

        return "redirect:/admin/brand/edit?id=" + brand.getId();
    }

    @RequestMapping("edit")
    public String editBrands(Model model, @RequestParam Integer id) {
        Brand brand = brandService.getBrand(id);
        model.addAttribute("foundBrand", brand);
        return "admin/brand.edit";

    }

}
