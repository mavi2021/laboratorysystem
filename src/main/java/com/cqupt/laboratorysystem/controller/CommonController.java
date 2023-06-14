package com.cqupt.laboratorysystem.controller;

import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @create 2023/6/13 22:31
 */

@Controller
public class CommonController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response){
        System.out.println("hah");
        return "login";
    }

//    @RequestMapping("/loginPage")
//    public String loginPage(){
//        return "login";
//    }

    @GetMapping("/error/403")
    public ModelAndView error403(){
        return new ModelAndView("error/403");
    }

//    @GetMapping("/error/404")
//    public ModelAndView error404(){
//        return new ModelAndView("error/404");
//    }

    @GetMapping("/error/404")
    public String error404(){
        return "error/404";
    }


    @GetMapping("/error/500")
    public ModelAndView error500(){
        return new ModelAndView("error/500");
    }


    @GetMapping("/loginPage")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

//    @PostMapping("/login")
//    public String authenticate(HttpServletRequest request, HttpServletResponse response){
//
//        return "redirect:/index";
//    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @GetMapping("/index")
    public String index() {
//        ModelAndView modelAndView = new ModelAndView("index");
        return "index";
    }

    @GetMapping("/main")
    @ResponseBody
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView("main");
        return modelAndView;
    }

    @GetMapping("/main2")
    public String main2() {
//        ModelAndView modelAndView = new ModelAndView("index");
        return "main2";
    }

    @GetMapping("/welcome")
    public String welcome() {
//        ModelAndView modelAndView = new ModelAndView("index");
        return "welcome";
    }
}
