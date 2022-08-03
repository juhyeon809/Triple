package com.project.triple.service.CouponService;

import com.project.triple.model.entity.Coupon.UserCoupon;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.CouponRequest.UserCouponApiRequest;
import com.project.triple.model.network.response.CouponResponse.UserCouponApiResponse;
import com.project.triple.model.network.response.QnAResponse.QuestionApiResponse;
import com.project.triple.repository.UserCouponRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCouponApiLogicService extends BaseService<UserCouponApiRequest, UserCouponApiResponse, UserCoupon> {

    @Autowired
    private UserCouponRepository userCouponRepository;

    private UserCouponApiResponse response(UserCoupon userCoupon){
        UserCouponApiResponse userCouponApiResponse = UserCouponApiResponse.builder()
                .idx(userCoupon.getIdx())
                .regDate(userCoupon.getRegDate())
                .userId(userCoupon.getUserId())
                .couponId(userCoupon.getCouponId())
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

    public Long findUserId(Long userId){
        Long couponId = userCouponRepository.findByUserId(userId).get().getCouponId();

        return couponId;
    }

}
