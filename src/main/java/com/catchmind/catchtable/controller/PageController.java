package com.catchmind.catchtable.controller;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.dto.ProfileDto;
import com.catchmind.catchtable.service.ProfileLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.stream.Stream;

@Controller
@RequestMapping("")
public class PageController {

    @Autowired
    private ProfileLogicService profileLogicService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }

    @GetMapping("login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @PostMapping(path="/loginOk")   // http://localhost:8888/loginOk
    public String loginOk(HttpServletRequest request, String prHp, String prUserpw){
        if(profileLogicService.login(prHp, prUserpw) != null){
            HttpSession session = request.getSession();
            ProfileDto profile = profileLogicService.login(prHp, prUserpw);
            session.setAttribute("prIdx", profile.prIdx());
            session.setAttribute("prName", profile.prName());
            session.setAttribute("prHp", prHp);
            return "redirect:/";
        }else{
            return "redirect:/login";
        }
    }

    @GetMapping("join")
    public ModelAndView join() {
        return new ModelAndView("/join");
    }
}
