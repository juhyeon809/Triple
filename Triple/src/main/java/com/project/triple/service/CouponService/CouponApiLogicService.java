package com.project.triple.service.CouponService;

import com.project.triple.model.entity.Coupon.Coupon;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.CouponRequest.CouponApiRequest;
import com.project.triple.model.network.response.CouponResponse.CouponApiResponse;
import com.project.triple.repository.CouponRepository;
import com.project.triple.service.BaseService.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class CouponApiLogicService extends BaseService<CouponApiRequest, CouponApiResponse, Coupon> {

    @Autowired
    private CouponRepository couponRepository;

    private CouponApiResponse response(Coupon coupon){
        CouponApiResponse couponApiResponse = CouponApiResponse.builder()
                .idx(coupon.getIdx())
                .name(coupon.getName())
                .type(coupon.getType())
                .price(coupon.getPrice())
                .useCondition(coupon.getUseCondition())
                .useStatus(coupon.getUseStatus())
                .code(coupon.getCode())
                .startDate(coupon.getStartDate())
                .endDate(coupon.getEndDate())
                .couponUse(coupon.getCouponUse())
                .build();
        return couponApiResponse;
    }

    @Override
    public Header<CouponApiResponse> create(Header<CouponApiRequest> request) {
        return null;
    }

    @Override
    public Header<CouponApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<CouponApiResponse> update(Header<CouponApiRequest> request) {
        return null;
    }

    @Override
    public Header<CouponApiResponse> delete(Long id) {
        return null;
    }
}
