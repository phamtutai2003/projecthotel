package com.hotelky4.projecthotel.dao;

import com.hotelky4.projecthotel.entity.Ratting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Date;
@Repository
public interface RattingRepository extends JpaRepository<Ratting, Integer> {

    List<Ratting> findCommentsByCreatedAtBetween(Date startDate, Date endDate);

    //Thêm các phương thức truy xuất tùy chỉnh dựa trên nhu cầu của bạn
}
