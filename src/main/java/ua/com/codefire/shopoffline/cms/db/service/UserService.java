/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.codefire.shopoffline.cms.db.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.codefire.shopoffline.cms.db.entity.User;
import ua.com.codefire.shopoffline.cms.db.repo.UserRepo;

/**
 *
 * @author user
 */
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public List<User> getUserList() {

        return (List<User>) userRepo.findAll();
    }
    public void removeUser(int  id){
    userRepo.delete(id); 
    }
public User getUser(int  id){
return  userRepo.findOne(id);
}
public User save(User user){
return userRepo.save(user);
}


}
