package com.project.triple.controller.page;

import com.project.triple.model.entity.Guide.Guide;
import com.project.triple.model.enumclass.GuideType;
import com.project.triple.model.network.response.AirResponse.AirTicketApiResponse;
import com.project.triple.model.network.response.GuideResponse.GuideApiResponse;
import com.project.triple.model.network.response.MagazineApiResponse;
import com.project.triple.model.network.response.UserResponse.AdminUserApiResponse;
import com.project.triple.service.AirService.AirTicketApiLogicService;
import com.project.triple.service.GuideService.GuideApiLogicService;
import com.project.triple.service.MagazineApiLogicService;
import com.project.triple.service.UserService.AdminUserApiLogicService;
import com.project.triple.service.UserService.UsersApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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

    @Autowired
    private MagazineApiLogicService magazineApiLogicService;

    @Autowired
    private GuideApiLogicService guideApiLogicService;

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






//    항공

    @RequestMapping(path = "/inquiryWrite")
    public ModelAndView inquiryWrite(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("nickname");
        }
        model.addAttribute("email", (String)session.getAttribute("email"));
        model.addAttribute("nickname", (String)session.getAttribute("nickname"));

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_write").addObject("email", email)
                .addObject("nickname", name);
    }

    @RequestMapping(path = "/inquiryList")
    public ModelAndView inquiryList(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String name = null;
        if(session == null) {

        }else{
            email = (String) session.getAttribute("email");
            name = (String) session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/mypage/mypage_reserve/my_inquiry_list").addObject("email", email)
                .addObject("nickname", name);
    }

    @RequestMapping(path = "/couponMain")
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

    @RequestMapping(path = "/mypageMain")
    public ModelAndView  my_travel_main(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/mypage/my_travel/my_travel_main").addObject("email", email)
                .addObject("nickname", nickname);
    }



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
        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.list().getData();

        return new ModelAndView("/pages/magazine/magazine").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/recommend/view/{idx}")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_recommend_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/recommend_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/tip/view/{idx}")     //http://localhost:9090/Triple/magazine_tip
    public ModelAndView magazine_tip_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/tip_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/restaurant/view/{idx}")    //http://localhost:9090/Triple/magazine_eatplace
    public ModelAndView magazine_restaurant_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/eatplace_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/air/view/{idx}")     //http://localhost:9090/Triple/magazine_airport
    public ModelAndView magazine_air_view(@PathVariable Long idx,HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/airport_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/lodging/view/{idx}")      //http://localhost:9090/Triple/magazine_guesthouse
    public ModelAndView magazine_lodging_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/guesthouse_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/tourticket/view/{idx}")      //http://localhost:9090/Triple/magazine_tourticket
    public ModelAndView magazine_tourticket_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/tourticket_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/shopping/view/{idx}")        //http://localhost:9090/Triple/magazine_shop
    public ModelAndView magazine_shopping_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();

        return new ModelAndView("/pages/magazine/magazine_view/shop_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }
    @RequestMapping(path = "/magazine/travels/view/{idx}")     //http://localhost:9090/Triple/magazine_travels
    public ModelAndView magazine_travels_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }
        MagazineApiResponse magazineApiResponse = magazineApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/magazine/magazine_view/travels_view").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazine", magazineApiResponse);
    }

    @RequestMapping(path = "/magazine/recommend")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_recommend(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.recommend().getData();

        return new ModelAndView("/pages/magazine/magazine_recommend").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/travels")   //http://localhost:9090/Triple/magazine_recommend
    public ModelAndView magazine_travels(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.recommend().getData();

        return new ModelAndView("/pages/magazine/magazine_recommend").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }

    @RequestMapping(path = "/magazine/tip")     //http://localhost:9090/Triple/magazine_tip
    public ModelAndView magazine_tip(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.tip().getData();

        return new ModelAndView("/pages/magazine/magazine_tip").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/restaurant")    //http://localhost:9090/Triple/magazine_eatplace
    public ModelAndView magazine_restaurant(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.restaurant().getData();

        return new ModelAndView("/pages/magazine/magazine_eatplace").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/air")     //http://localhost:9090/Triple/magazine_airport
    public ModelAndView magazine_air(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.air().getData();

        return new ModelAndView("/pages/magazine/magazine_airport").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/lodging")      //http://localhost:9090/Triple/magazine_guesthouse
    public ModelAndView magazine_lodging(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.lodging().getData();

        return new ModelAndView("/pages/magazine/magazine_guesthouse").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/tourticket")      //http://localhost:9090/Triple/magazine_tourticket
    public ModelAndView magazine_tourticket(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.tourTicket().getData();

        return new ModelAndView("/pages/magazine/magazine_tourticket").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
    }
    @RequestMapping(path = "/magazine/shopping")        //http://localhost:9090/Triple/magazine_shop
    public ModelAndView magazine_shopping(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<MagazineApiResponse> magazineApiResponseList = magazineApiLogicService.shopping().getData();

        return new ModelAndView("/pages/magazine/magazine_shop").addObject("email", email)
                .addObject("nickname", nickname).addObject("magazineList",magazineApiResponseList);
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

    /* 관리자 등록 */
    @RequestMapping(path="/admin/admin_join")       //http://localhost:9090/Triple/admin/admin_join
    public ModelAndView admin_join() {
        return new ModelAndView("/pages/admin/manage/admin_manage_register");
    }

    /* 로그인 검증 */
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

    /* 관리자 로그아웃 */
    @RequestMapping("/admin/logout")
    public ModelAndView admin_logout(HttpServletResponse response, HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession();
        session.setAttribute("userid",null);
        session.setAttribute("name", null);
        ScriptUtils.alert(response, "로그아웃 되었습니다.");
        return new ModelAndView("/pages/admin/admin_login");
    }

    /*관리자 리스트*/
    @RequestMapping(path = "/adminList")   //http://localhost:9090/Triple/adminList
    public ModelAndView adminList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<AdminUserApiResponse> adminUserList = adminUserApiLogicService.search().getData();
        //        List<TimeCollector> timeTakenList = adminUserList.stream().map(adminUserApiResponse ->
        //                adminUserApiLogicService.timeSort(adminUserApiResponse)
        //        ).collect(Collectors.toList());

        return new ModelAndView("/pages/admin/manage/admin_manage_list").addObject("userid", userid)
                .addObject("name", name).addObject("adminUserList", adminUserList);
    }

    /* 관리자 상세보기 페이지 */
    @RequestMapping(path="/adminList/view/{idx}")       //http://localhost:9090/Triple/adminList/view/{idx}
    public ModelAndView adminList_view(@PathVariable Long idx, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }
        AdminUserApiResponse adminUserApiResponse = adminUserApiLogicService.read(idx).getData();
        return new ModelAndView("/pages/admin/manage/admin_manage_detail")
                .addObject("userid", userid)
                .addObject("name", name)
                .addObject("adminUser", adminUserApiResponse);
    }

    /* 공지사항 등록 */
    @RequestMapping(path = "/admin/notice/register")
    public ModelAndView notice_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/notice/notice-register")
                .addObject("userid", userid)
                .addObject("name", name);
    }

    /* 공지사항 리스트 */
    @RequestMapping(path = "/admin/noticeList")   //http://localhost:9090/Triple/admin/noticeList
    public ModelAndView noticeList(HttpServletRequest request) throws NullPointerException {
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null) {

        }else{
            userid = (String) session.getAttribute("userid");
            name = (String) session.getAttribute("name");
        }
        List<AdminUserApiResponse> noticeList = adminUserApiLogicService.search().getData();

        return new ModelAndView("/pages/admin/notice/notice-list").addObject("userid", userid)
                .addObject("name", name).addObject("noticeList", noticeList);
    }


    //투어 메인
    @RequestMapping(path = "/spot_tour")
    public ModelAndView spot_tour(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_tour").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_tour_info")
    public ModelAndView spot_tour_info(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_tour_info").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_review")
    public ModelAndView spot_review(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_review").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_restaurant")
    public ModelAndView spot_restaurant(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_restaurant").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_restaurant_list")
    public ModelAndView spot_restaurant_list(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_restaurant_list").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_restaurant_info")
    public ModelAndView spot_restaurant_info(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_restaurant_info").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_overseas")
    public ModelAndView spot_overseas(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_overseas").addObject("email", email)
                .addObject("nickname", nickname);
    }

    @RequestMapping(path = "/spot_location_info/{id}")
    public ModelAndView spot_location_info(HttpServletRequest request, @PathVariable Long id){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        GuideApiResponse guide = guideApiLogicService.read(id).getData();

        return new ModelAndView("/pages/travel_spot/spot_location_info").addObject("email", email)
                .addObject("nickname", nickname).addObject("guide", guide);
    }

    @RequestMapping(path = "/spot_location")
    public ModelAndView spot_location(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        List<GuideApiResponse> guideApiResponseList1 = guideApiLogicService.typeList(GuideType.AIRPORT).getData();
        List<GuideApiResponse> guideApiResponseList2 = guideApiLogicService.typeList(GuideType.CHECK).getData();
        List<GuideApiResponse> guideApiResponseList3 = guideApiLogicService.typeList(GuideType.DOMESTICAIR).getData();


        return new ModelAndView("/pages/travel_spot/spot_location").addObject("email", email)
                .addObject("nickname", nickname).addObject("AirportList", guideApiResponseList1)
                .addObject("CheckList", guideApiResponseList2).addObject("DomesticAirList", guideApiResponseList3);
    }

    @RequestMapping(path = "/spot_domestic")
    public ModelAndView spot_domestic(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String email = null;
        String nickname = null;
        if(session == null){

        }else{
            email = (String)session.getAttribute("email");
            nickname = (String)session.getAttribute("nickname");
        }

        return new ModelAndView("/pages/travel_spot/spot_domestic").addObject("email", email)
                .addObject("nickname", nickname);
    }

    // 마이페이지 메거진 등록
    @RequestMapping(path = "/magazine_register")
    public ModelAndView magazine_register(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        String userid = null;
        String name = null;
        if(session == null){

        }else{
            userid = (String)session.getAttribute("userid");
            name = (String)session.getAttribute("name");
        }

        return new ModelAndView("/pages/admin/magazine/magazine-register").addObject("userid", userid)
                .addObject("name", name);
    }
}
