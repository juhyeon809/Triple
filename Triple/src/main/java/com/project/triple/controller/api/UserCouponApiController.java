package com.project.triple.controller.api;

import com.project.triple.controller.CrudController;
import com.project.triple.model.entity.Coupon.UserCoupon;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.CouponRequest.UserCouponApiRequest;
import com.project.triple.model.network.response.CouponResponse.UserCouponApiResponse;
import com.project.triple.service.CouponService.UserCouponApiLogicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/userCoupon")
@RequiredArgsConstructor
public class UserCouponApiController extends CrudController<UserCouponApiRequest, UserCouponApiResponse, UserCoupon> {

    private final UserCouponApiLogicService userCouponApiLogicService;

    @Override
    public Header<UserCouponApiResponse> create(Header<UserCouponApiRequest> request) {
        return super.create(request);
    }

    @Override
    public Header<UserCouponApiResponse> read(Long id) {
        return super.read(id);
    }

    @Override
    public Header<UserCouponApiResponse> update(Header<UserCouponApiRequest> request) {
        return super.update(request);
    }

    @Override
    public Header<UserCouponApiResponse> delete(Long id) {
        return super.delete(id);
    }
}
