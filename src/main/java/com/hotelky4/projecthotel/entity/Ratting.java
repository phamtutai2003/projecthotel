package com.hotelky4.projecthotel.entity;



import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "ratting")


public class Ratting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;


    @Column(columnDefinition = "TEXT")
    private String comment;
    @Column(name = "createdat")
    private LocalDateTime createdAt;
    @Column(name = "evaluationScore")
    private int evaluationScore;




    public Ratting() {
        this.createdAt = LocalDateTime.now();
    }



    public Ratting(User user , Room room, String comment ,int evaluationScore){
        this.room = room;
        this.user=user;
        this.comment = comment;
        this.evaluationScore = evaluationScore;
        this.createdAt=LocalDateTime.now();
    }
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    public int getId() {
        return Math.toIntExact(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getEvaluationScore() {
        return evaluationScore;
    }

    public void setEvaluationScore(int evaluationScore) {
        this.evaluationScore = evaluationScore;
    }



    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime now) {
    }


}
