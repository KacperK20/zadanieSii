package com.example.zadaniesi.controller;

import com.example.zadaniesi.Dto.EmailUpdateDto;
import com.example.zadaniesi.Repo.ReservationRepository;
import com.example.zadaniesi.Repo.UserRepository;
import com.example.zadaniesi.Service.ReservationService;
import com.example.zadaniesi.Service.UserService;
import com.example.zadaniesi.model.ConferencePlan;

import com.example.zadaniesi.model.Reservation;
import com.example.zadaniesi.model.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.zadaniesi.Service.ConferencePlanService;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/conference")

public class ConferenceController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ConferencePlanService conferencePlanService;
    private ReservationService reservationService;

    @Autowired
    public ConferenceController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }




    public ConferenceController(ConferencePlanService conferencePlanService) {
        this.conferencePlanService = conferencePlanService;
    }


    @GetMapping("/plan")
    public List<ConferencePlan> getConferencePlan() {
        return conferencePlanService.getAllConferencePlans();
    }


    @GetMapping("/reservations/{username}")
    public List<ConferencePlan> getReservations(@PathVariable String username) {

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new IllegalArgumentException("User not found");
        }


        List<Reservation> reservations = reservationRepository.findByUser(user);


        List<ConferencePlan> conferencePlans = new ArrayList<>();
        for (Reservation reservation : reservations) {
            conferencePlans.add(reservation.getLecture());
        }

        return conferencePlans;
    }

    @PostMapping("/bookLecture/{lectureId}")
    public String bookLecture(@PathVariable Long lectureId, @RequestBody User user) {
        return reservationService.bookLecture(lectureId, user.getUsername(), user.getEmail());
    }

    @DeleteMapping("/cancelReservation/{lectureId}/{userName}")
    public ResponseEntity<?> cancelReservation(@PathVariable Long lectureId, @PathVariable String userName) {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        Reservation reservation = reservationRepository.findByUserIdAndLectureId(user.getId(), lectureId);
        if (reservation == null) {
            throw new NotFoundException("Reservation not found");
        }

        reservationRepository.delete(reservation);
        return ResponseEntity.ok("Reservation cancelled successfully.");
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    @PutMapping("/{userName}/email")
    public ResponseEntity<?> updateUserEmail(@PathVariable String userName, @RequestBody EmailUpdateDto emailUpdateDto) {
        User user = userRepository.findByUsername(userName);

        if(user == null) {
            throw new EntityNotFoundException("User not found");
        }

        user.setEmail(emailUpdateDto.getEmail());
        userRepository.save(user);

        return ResponseEntity.ok().body("Email updated successfully");
    }
}
