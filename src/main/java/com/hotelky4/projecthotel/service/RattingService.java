package com.hotelky4.projecthotel.service;

import com.hotelky4.projecthotel.entity.Ratting;

import java.util.Date;
import java.util.List;

public interface RattingService {


    Ratting saveRatting(Ratting ratting);

    List<Ratting> getAllRattings();
    Ratting getRattingById(Long id);
    void deleteRattingById(Long id);
    void deleteRatting(int commentId);

    Ratting findById(int commentId);

    Ratting findRattingById(Long id);

    List<Ratting> findRattingsByCreatedAtBetween(Date startDate, Date endDate);
}
