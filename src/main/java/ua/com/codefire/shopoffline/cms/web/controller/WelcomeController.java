/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.web.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import ua.com.codefire.shopoffline.cms.db.entity.Brand;
import ua.com.codefire.shopoffline.cms.db.entity.Category;
import ua.com.codefire.shopoffline.cms.db.entity.Product;
import ua.com.codefire.shopoffline.cms.db.service.BrandService;
import ua.com.codefire.shopoffline.cms.db.service.CategoryService;
import ua.com.codefire.shopoffline.cms.db.service.ProductService;

/**
 *
 * @author user
 */
@Controller
public class WelcomeController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private BrandService brandService;
    private JSONParser jsonParser = new JSONParser();
    private double usd;

    @PostConstruct
    private void init() {
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11");
            String json = IOUtils.toString(url, "utf-8");
            JSONArray currencies = (JSONArray) jsonParser.parse(json);
//            System.out.println(currencies);

            for (int i = 0; i < currencies.size(); i++) {
                JSONObject curr = (JSONObject) currencies.get(i);

                if ("USD".equals(curr.get("ccy"))) {
                    usd = Double.valueOf(curr.get("sale").toString());
                }
            }
        } catch (MalformedURLException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(WelcomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @RequestMapping("/")
    public String getRoot(Model model) {
        List<Product> phoneList = productService.getProductList();
        model.addAttribute("products", phoneList);
        List<Brand> brandList = brandService.getBrandList();
        model.addAttribute("brands", brandList);
        model.addAttribute("usd", usd);
        List<Category> parentCategoryList = categoryService.parentCategoryList();
        model.addAttribute("categories", parentCategoryList);
        return "showcase";
    }

//    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @RequestMapping("/showcase")
    public String getIndex() {
        return "redirect:/";
    }

    @ResponseBody
    @RequestMapping(value = "/show/{brand}", produces = {"application/json"})
    public Object getANSWER(@PathVariable Integer brand) throws ParseException {
//        return (JSONObject) jsonParser.parse("{\"message\": \"Your advertisement can be here...\"}");
        List<Category> chaild = categoryService.getCategory(3).getCategoryList();
      //  categoryService.getCategoryChild(chaild);
        System.out.println((String) chaild.toString());
        for (Category category : categoryService.getCategoryChild(chaild)) {
                    System.out.println(category.getId().toString());
                }
        return brandService.getBrand(brand);
    }

//    @ResponseBody
//    @RequestMapping(value = "/shows/{brand}")
//    public String getANSWERs(@PathVariable Integer brand) {
////        return (JSONObject) jsonParser.parse("{\"message\": \"Your advertisement can be here...\"}");
//        List<Category> chaild = categoryService.getCategory(brand).getCategoryList();
//        return (String) categoryService.getCategoryChild(chaild).toString();
//
//    }
    @RequestMapping(value = "/categoryes/")
    public String getCategoryes(Model model) {

        List<Category> parentCategoryList = categoryService.parentCategoryList();
        model.addAttribute("categories", parentCategoryList);

        return "admin/category/index";
    }

    @ExceptionHandler
    public void errorHandler(Throwable exception) {
        exception.printStackTrace();
    }

}
