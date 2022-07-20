package com.project.triple.service;

import com.project.triple.model.entity.Airline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AirlineLogicService extends BaseService<AirlineApiRequest, AirlineApiResponse, Airline>{
}
