package com.project.triple.controller.page;

import com.project.triple.model.entity.Air.AirTicket;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import com.project.triple.service.UserService.AdminUserApiLogicService;
import com.project.triple.service.UserService.UsersApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/Triple")   // http://localhost:9090/Triple
public class PageController {

    @Autowired
    private UsersApiLogicService usersApiLogicService;

    @Autowired
    private AirTicketApiLogicService airTicketApiLogicService;

    @Autowired
    private AdminUserApiLogicService adminUserApiLogicService;

    // 메인페이지
    @RequestMapping(path={""})
    public ModelAndView index(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null) {

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/main").addObject("email", email)
                .addObject("nickname", nickname);

    }
    //회원가입 페이지
    @RequestMapping(path="/join")
    public ModelAndView user_regist() {
        return new ModelAndView("/pages/join");
    }

    //로그인페이지
    @RequestMapping(path="/login")
    public ModelAndView login() {
        return new ModelAndView("/pages/login");
    }

    //로그인검증
    @PostMapping("/loginok")
    public ModelAndView loginOk(HttpServletResponse response, HttpServletRequest request, String email, String userpw) throws IOException {
        if(usersApiLogicService.login(email, userpw).getData() != null){
            HttpSession session = request.getSession();
            String nickname = usersApiLogicService.login(email, userpw).getData().getNickname();
            session.setAttribute("email", email);
            session.setAttribute("nickname", nickname);

            ScriptUtils.alert(response, "로그인 성공" );
            return new ModelAndView("/pages/main").addObject("email", email)
                    .addObject("nickname", nickname);

        }else{
            ScriptUtils.alert(response, "로그인 실패, 아이디와 비밀번호를 다시 확인해주세요");
            return new ModelAndView("/pages/login");

        }
    }
    @RequestMapping("/logout")
    public ModelAndView logOut(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("email",null);
        session.setAttribute("nickname", null);
        ScriptUtils.alert(response, "로그아웃 되었습니다.");
        return new ModelAndView("/pages/main");
    }

    //마이페이지

    @RequestMapping(path = "/inquiryWrite")     //http://localhost:9090/Triple/inquiryWrite
    public ModelAndView inquiryWrite(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("name");
        }

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_write").addObject("email", email)
                .addObject("name", name);
    }

//    @RequestMapping(path = "/inquiryList")      //http://localhost:9090/Triple/inquiryList
//    public ModelAndView inquiryList(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String name = null;
//        if(session == null) {
//
//        }else{
//            email = (String) session.getAttribute("email");
//            name = (String) session.getAttribute("name");
//        }
//
//        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_list").addObject("email", email)
//                .addObject("name", name);
//    }



    //항공
//    @RequestMapping(path = "/flightMain")       //http://localhost:9090/Triple/flightMain
//    public ModelAndView flightMain(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String nickname = null;
//        if(session == null){
//
//        }else{
//            email = (String)session.getAttribute("email");
//            nickname = (String)session.getAttribute("nickname");
//        }
//
//        return new ModelAndView("/pages/flight_reservation/flight_main").addObject("email", email)
//                .addObject("nickname", nickname);
//    }

    @RequestMapping(path = "/flightList")   //http://localhost:9090/Triple/flightList
    public ModelAndView flightList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            nickname = (String) session.getAttribute("nickname");
        }
        List<AirTicketApiResponse> airTicketList = airTicketApiLogicService.search().getData();
        List<TimeCollector> timeTakenList = airTicketList.stream().map(airTicketApiResponse ->
           airTicketApiLogicService.timeSort(airTicketApiResponse)
        ).collect(Collectors.toList());

        return new ModelAndView("/pages/flight_reservation/flight_list").addObject("email", email)
                .addObject("name", nickname).addObject("airTicketList", airTicketList).addObject("timeTakenList", timeTakenList);
    }


//    @RequestMapping(path = "/inquiryWrite")
//    public ModelAndView inquiryWrite(HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        String email = null;
//        String name = null;
//        if(session == null) {
//
//        }else{
//            email = (String) session.getAttribute("email");
//            name = (String) session.getAttribute("name");
//        }
//
//        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_write").addObject("email", email)
//                .addObject("name", name);
//    }

    @RequestMapping(path = "/inquiryList")
    public ModelAndView inquiryList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("name");
        }

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_list").addObject("email", email)
                .addObject("name", name);
    }

    @RequestMapping(path = "/mypage_main")
    public ModelAndView mypage_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("name");
        }

        return new ModelAndView("/pages/mypage/my_travel/my_travel_main").addObject("email", email)
                .addObject("name", name);
    }

    @RequestMapping(path = "/flightMain")
    public ModelAndView flightMain(HttpServletRequest request) {
        List<AirTicketApiResponse> airTicketList = airTicketApiLogicService.specialFlight().getData();
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/flight_reservation/flight_main").addObject("email", email)
                .addObject("nickname", nickname).addObject("airTicketList", airTicketList);
    }


    @RequestMapping(path = "/flightReservation")
    public ModelAndView flightReservation(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/flight_reservation/flight_reservation").addObject("email",email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/flightView")
    public ModelAndView flightView(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/flight_reservation/flight_view").addObject("email",email)
                .addObject("nickname", nickname);
    }



    //magazine
    @RequestMapping(path = "/magazine")     //http://localhost:9090/Triple/magazine
    public ModelAndView magazine(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine_recommend")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_recommend(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_recommend").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_tip")     //http://localhost:9090/Triple/magazine_tip
    public ModelAndView magazine_tip(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_tip").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_eatplace")    //http://localhost:9090/Triple/magazine_eatplace
    public ModelAndView magazine_eatplace(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_eatplace").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_airport")     //http://localhost:9090/Triple/magazine_airport
    public ModelAndView magazine_airport(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_airport").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_guesthouse")      //http://localhost:9090/Triple/magazine_guesthouse
    public ModelAndView magazine_guesthouse(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_guesthouse").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_tourticket")      //http://localhost:9090/Triple/magazine_tourticket
    public ModelAndView magazine_tourticket(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_tourticket").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_shop")        //http://localhost:9090/Triple/magazine_shop
    public ModelAndView magazine_shop(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_shop").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine_travels")     //http://localhost:9090/Triple/magazine_travels
    public ModelAndView magazine_travels(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_travels").addObject("email", email)
                .addObject("nickname", nickname);
    }


    //magazine_view
    @RequestMapping(path = "/magazine/recommend_view")
    public ModelAndView recommend_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/recommend_view").addObject("email", email)
                .addObject("nickname", nickname);
    }
    @RequestMapping(path = "/magazine/airport_view")
    public ModelAndView airport_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/airport_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/tip_view")
    public ModelAndView tip_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/tip_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/eatplace_view")
    public ModelAndView eatplace_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/eatplace_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/guesthouse_view")
    public ModelAndView guesthouse_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/guesthouse_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/tourticket_view")
    public ModelAndView tourticket_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/tourticket_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/shop_view")
    public ModelAndView shop_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/shop_view").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/magazine/travels_view")
    public ModelAndView travels_view(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/magazine/magazine_view/travels_view").addObject("email", email)
                .addObject("nickname", nickname);
    }





    @RequestMapping(path = "/coupon_main")
    public ModelAndView coupon_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/mypage/mypage_coupon/coupon_main").addObject("email", email)
                .addObject("nickname", nickname);
    }



    /* 관리자 페이지 */
    /* 관리자 페이지 로그인*/
    @RequestMapping(path={"/adminUser"})        //http://localhost:9090/Triple/adminUser
    public ModelAndView admin_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/admin_main").addObject("userid", userid)
                .addObject("name", name);

    }
    @RequestMapping(path="/admin/admin_login")      //http://localhost:9090/Triple/admin/admin_login
    public ModelAndView admin_login() {
        return new ModelAndView("/pages/admin/admin_login");
    }
    @RequestMapping(path="/admin/admin_join")
    public ModelAndView admin_join() {
        return new ModelAndView("/pages/admin/admin_join");
    }

    //로그인검증
    @PostMapping("/admin_loginOk")      //http://localhost:9090/Triple/admin/admin_loginOk
    public ModelAndView admin_loginOk(HttpServletResponse response, HttpServletRequest request, String userid, String userpw) throws IOException {
        if(adminUserApiLogicService.admin_login(userid, userpw).getData() != null){
            HttpSession session = request.getSession();
            String name = adminUserApiLogicService.admin_login(userid, userpw).getData().getName();
            session.setAttribute("userid", userid);
            session.setAttribute("userpw", userpw);

            ScriptUtils.alert(response, "로그인 성공" );
            return new ModelAndView("/pages/admin/admin_main").addObject("userid", userid)
                    .addObject("name", name);

        }else{
            ScriptUtils.alert(response, "로그인 실패, 아이디와 비밀번호를 다시 확인해주세요");
            return new ModelAndView("/pages/admin/admin_login");

        }
    }

}
