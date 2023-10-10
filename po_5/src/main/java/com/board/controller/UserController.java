package com.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.board.domain.UserDTO;
import com.board.service.UserService;
import com.board.util.UiUtils;

@Controller
public class UserController extends UiUtils {

    @Autowired
    private UserService userService;

    @GetMapping("/signUp")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "/project/공통/회원가입";
    }
    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user") UserDTO user, RedirectAttributes redirectAttributes, Model model) {
        boolean isRegistered = userService.insertUser(user);
        if (isRegistered) {
            model.addAttribute("successMessage", "회원가입이 완료되었습니다. 로그인해주세요.");
            return "redirect:/login"; // 회원가입 성공 시 로그인 페이지로 리다이렉션
        } else {
            model.addAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
            return "redirect:/signUp"; // 회원가입 실패 시 다시 회원가입 페이지로 리다이렉션
        }
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
    	model.addAttribute("user", new UserDTO());
        return "project/공통/로그인";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") UserDTO user, Model model, HttpSession session) {
        boolean loginUser = userService.loginUser(user);
        if (loginUser) {
            session.setAttribute("loggedInUser", user);
            System.out.println("로그인 성공: " + user.getNickname());
            System.out.println("로그인 성공: " + user.getPw());
            return "redirect:/main"; 
        } else {
            System.out.println("로그인 실패: " + user.getNickname());
            System.out.println("로그인 실패: " + user.getPw());
            model.addAttribute("errorMessage", "로그인에 실패했습니다. 다시 시도해주세요.");
            return "project/공통/로그인"; 
    }
}
    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/login";
    }
}