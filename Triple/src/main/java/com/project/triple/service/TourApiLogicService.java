package com.project.triple.service;

import com.project.triple.model.entity.Tour;
import com.project.triple.model.network.Header;
import com.project.triple.model.network.request.TourApiRequest;
import com.project.triple.model.network.response.TourApiResponse;

import com.project.triple.repository.TourRepository;
import com.project.triple.service.BaseService.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TourApiLogicService extends BaseService<TourApiRequest, TourApiResponse, Tour> {

    @Autowired
    private TourRepository tourRepository;

    private TourApiResponse response(Tour tour){
        TourApiResponse tourApiResponse = TourApiResponse.builder()
                .idx(tour.getIdx())
                .type(tour.getType())
                .tourNum(tour.getTourNum())
                .country(tour.getCountry())
                .address(tour.getAddress())
                .managerName(tour.getManagerName())
                .contactNum(tour.getContactNum())
                .title(tour.getTitle())
                .info(tour.getInfo())
                .status(tour.getStatus())
                .price(tour.getPrice())
                .timeTaken(tour.getTimeTaken())
                .startDate(tour.getStartDate())
                .endDate(tour.getEndDate())
                .likeCount(tour.getLikeCount())
                .remaining(tour.getRemaining())
                .build();
        return tourApiResponse;
    }

    @Override
    public Header<TourApiResponse> create(Header<TourApiRequest> request) {
        return null;
    }

    @Override
    public Header<TourApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<TourApiResponse> update(Header<TourApiRequest> request) {
        return null;
    }

    @Override
    public Header<TourApiResponse> delete(Long id) {
        return null;
    }
}
