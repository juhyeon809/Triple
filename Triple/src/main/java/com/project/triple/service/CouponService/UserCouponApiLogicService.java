package com.project.triple.service.CouponService;

import com.project.triple.model.entity.Coupon.UserCoupon;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.CouponRequest.UserCouponApiRequest;
import com.project.triple.model.network.response.CouponResponse.UserCouponApiResponse;
import com.project.triple.repository.UserCouponRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserCouponApiLogicService extends BaseService<UserCouponApiRequest, UserCouponApiResponse, UserCoupon> {

    @Autowired
    private UserCouponRepository userCouponRepository;

    private UserCouponApiResponse response(UserCoupon userCoupon){
        UserCouponApiResponse userCouponApiResponse = UserCouponApiResponse.builder()
                .idx(userCoupon.getIdx())
                .regDate(userCoupon.getRegDate())
                .build();
        return userCouponApiResponse;
    }

    @Override
    public Header<UserCouponApiResponse> create(Header<UserCouponApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserCouponApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserCouponApiResponse> update(Header<UserCouponApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserCouponApiResponse> delete(Long id) {
        return null;
    }
}
