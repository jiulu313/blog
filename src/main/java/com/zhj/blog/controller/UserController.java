package com.zhj.blog.controller;


import com.zhj.blog.domain.User;
import com.zhj.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询所有用户
     *
     * @param model
     * @return
     */
    @GetMapping
    public ModelAndView list(Model model) {
        model.addAttribute("userList", userRepository.listUsers());
        model.addAttribute("title", "用户管理");
        return new ModelAndView("users/list", "userModel", model);
    }

    /**
     * 根据id查询用户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("{id}")
    public ModelAndView view(@PathVariable("id") Long id, Model model) {
        User user = userRepository.getUserById(id);
        model.addAttribute("user",user);
        model.addAttribute("title","查看用户");
        return new ModelAndView("users/list", "userModel", model);
    }


    /**
     * 获取创建表单页面
     * @param model
     * @return
     */
    @GetMapping("/form")
    public ModelAndView createForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("title","创建用户");
        return new ModelAndView("users/form","userModel",model);
    }

    /**
     * 保存或者修改用户
     * @param user
     * @return
     */
    @PostMapping
    public ModelAndView savaOrUpdateUser(User user){
        userRepository.saveOrUpdateUser(user);
        return new ModelAndView("redirect:/users");//重定向到list页面
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        userRepository.deleteUser(id);
        return new ModelAndView("redirect/users");
    }


}

















