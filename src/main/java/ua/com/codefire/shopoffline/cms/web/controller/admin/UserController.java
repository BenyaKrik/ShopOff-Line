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
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.codefire.shopoffline.cms.db.entity.User;
import ua.com.codefire.shopoffline.cms.db.service.UserService;

/**
 *
 * @author user
 */
@Controller
@RequestMapping(value = "/admin/user/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "")
    public String showUsers(Model model) {

        List<User> userList;
        userList = userService.getUserList();
        model.addAttribute("UserList", userList);
        return "admin/users";
    }

    @RequestMapping(value = "remove/{id}")
    public String removeUser(@PathVariable int id) {

        userService.removeUser(id);

        return "redirect:/admin/user/";
    }

    @RequestMapping(value = "edit/{id}")
    public String editUser(Model model, @PathVariable int id) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "admin/user.edit";
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.POST, params = {"name", "email", "status"})
    public String editUserpost(Model model, @PathVariable int id, @RequestParam String name, @RequestParam String email, @RequestParam String status) {

        User user = userService.getUser(id);
        user.setEmail(email);
        user.setName(name);
        user.setStatus(status);
        userService.save(user);
        return "redirect:/admin/user/edit/" + user.getId();

    }
}
