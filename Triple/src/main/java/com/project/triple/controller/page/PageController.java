package com.project.triple.controller.page;

import com.project.triple.service.UserService.UsersApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/Triple")   // http://localhost:9090/Triple
public class PageController {

    @Autowired
    private UsersApiLogicService usersApiLogicService;
    @RequestMapping(path={""})
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("name");
        }

        return new ModelAndView("/pages/main").addObject("email", email)
                .addObject("name", name);

    }

    @RequestMapping(path="/join")
    public ModelAndView user_regist() {
        return new ModelAndView("/pages/join");
    }

    @RequestMapping(path="/login")
    public ModelAndView login() {
        return new ModelAndView("/pages/login");
    }

    @PostMapping("/loginok")
    public String loginOk(HttpServletResponse response, HttpServletRequest request, String email, String userpw) throws IOException {
        if(usersApiLogicService.login(email, userpw).getData() != null){
            HttpSession session = request.getSession();
            String nickname = usersApiLogicService.login(email, userpw).getData().getNickname();
            session.setAttribute("email", email);
            session.setAttribute("nickname", nickname);
            ScriptUtils.alertAndMovePage(response, "로그인 성공", "/Triple" );
            return null;
        }else{
            ScriptUtils.alertAndMovePage(response, "로그인 실패, 아이디와 비밀번호를 다시 확인해주세요", "/Triple/login" );
            return null;
        }
    }

}
