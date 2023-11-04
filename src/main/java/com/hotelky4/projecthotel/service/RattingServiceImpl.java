package com.hotelky4.projecthotel.service;

import com.hotelky4.projecthotel.dao.RattingRepository; // Update the repository import
import com.hotelky4.projecthotel.entity.Ratting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RattingServiceImpl implements RattingService {
    private final RattingRepository rattingRepository; // Rename the repository to match your entity name

    @Autowired
    public RattingServiceImpl(RattingRepository rattingRepository) { // Rename the constructor parameter to match
        this.rattingRepository = rattingRepository;
    }

    @Override
    public Ratting saveRatting(Ratting ratting) {
        if (ratting.getId() != 0) {
            Optional<Ratting> existingRatting = rattingRepository.findById(ratting.getId());
            if (existingRatting.isPresent()) {
                Ratting updatedRatting = existingRatting.get();
                updatedRatting.setComment(ratting.getComment());
                updatedRatting.setEvaluationScore(ratting.getEvaluationScore());
                return rattingRepository.save(updatedRatting);
            }
        }
        return rattingRepository.save(ratting);
    }

    @Override
    public List<Ratting> getAllRattings() {
        return rattingRepository.findAll();
    }

    @Override
    public Ratting getRattingById(Long id) {
        return rattingRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    @Override
    public void deleteRattingById(Long id) {
        rattingRepository.deleteById(Math.toIntExact(id));
    }

    @Override
    public void deleteRatting(int rattingId) {
        rattingRepository.deleteById((int) rattingId);
    }


    @Override
    public Ratting findById(int commentId) {
        return rattingRepository.findById((int) commentId).orElse(null); // Correct repository name
    }

    @Override
    public Ratting findRattingById(Long id) {
        return rattingRepository.findById(Math.toIntExact(id)).orElse(null); // Correct repository name
    }

    @Override
    public List<Ratting> findRattingsByCreatedAtBetween(Date startDate, Date endDate) {
        List<Ratting> rattings = rattingRepository.findCommentsByCreatedAtBetween(startDate, endDate); // Correct repository name
        return rattings;
    }
}
