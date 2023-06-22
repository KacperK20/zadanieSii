package com.example.zadaniesi.model;


import jakarta.persistence.*;

import java.util.Optional;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private ConferencePlan lecture;


    public Long getId() {
        return id;
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

    public ConferencePlan getLecture() {
        return lecture;
    }

    public void setLecture(ConferencePlan conferencePlan) {
        this.lecture = conferencePlan;
    }
}
