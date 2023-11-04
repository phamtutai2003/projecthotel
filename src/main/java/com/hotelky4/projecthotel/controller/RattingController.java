package com.hotelky4.projecthotel.controller;

import com.hotelky4.projecthotel.entity.Ratting;
import com.hotelky4.projecthotel.entity.Room;

import com.hotelky4.projecthotel.service.RattingService;
import com.hotelky4.projecthotel.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.time.LocalDateTime;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/rattings")
public class RattingController {

    private final RoomService roomService;
    private final RattingService rattingService;

    @Autowired
    public RattingController(RoomService roomService, RattingService rattingService) {
        this.roomService = roomService;

        this.rattingService = rattingService;
    }
    @PostMapping("/add")
    public String addRating(@RequestParam("roomId") int roomId,
                            @RequestParam("comment") String commentText,
                            @RequestParam("evaluationScore") int evaluationScore) {

        // Retrieve the Room entity by its ID
        Room room = roomService.findById(roomId);

        // Create a Rating entity
        Ratting rating = new Ratting();
        rating.setComment(commentText);
        rating.setEvaluationScore(evaluationScore);
        rating.setCreatedAt(LocalDateTime.now());

        // Set the Room for the Rating entity
        rating.setRoom(room);

        // Save the Rating entity
        rattingService.saveRatting(rating); // You need to implement a save method in you   r service

        // Redirect to the room details page, passing the roomId as a parameter
        return "redirect:rooms/room?roomId=" + roomId;
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Ratting ratting = rattingService.findRattingById(id);
        model.addAttribute("ratting", ratting);
        return "edit-ratting";
    }

    @PostMapping("/edit/{id}")
    public String editRatting(@PathVariable Long id,
                              @ModelAttribute Ratting updatedRatting,
                              @RequestParam("roomId") Long roomId) {
        Ratting existingRatting = rattingService.findRattingById(id);
        existingRatting.setComment(updatedRatting.getComment());
        existingRatting.setEvaluationScore(updatedRatting.getEvaluationScore());


        // Update the comment in the database
        rattingService.saveRatting(existingRatting);

        // Redirect user to the blog details page after editing the comment
        return "redirect:/rooms/room/?roomId=" + roomId;
    }

    @PostMapping("/delete/{id}")
    public String deleteRatting(@PathVariable Long id, @RequestParam("rattingId") Long rattingId) {
        rattingService.deleteRattingById(id);
        // Chuyển hướng người dùng về trang chi tiết blog sau khi xóa comment
        return "redirect:/rattings/ratting/?rattingId=" + rattingId;
    }

}


