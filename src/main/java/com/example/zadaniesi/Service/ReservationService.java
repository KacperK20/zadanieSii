package com.example.zadaniesi.Service;

import com.example.zadaniesi.Repo.ConferencePlanRepository;
import com.example.zadaniesi.Repo.ReservationRepository;
import com.example.zadaniesi.Repo.UserRepository;
import com.example.zadaniesi.Service.EmailService;
import com.example.zadaniesi.model.ConferencePlan;
import com.example.zadaniesi.model.Reservation;
import com.example.zadaniesi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConferencePlanRepository conferencePlanRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private EmailService emailService;

    public String bookLecture(Long lectureId, String login, String email) {
        User user = userRepository.findByUsername(login);
        if(user != null && !user.getEmail().equals(email)) {
            return "Podany login jest już zajęty.";
        }

        if(user == null) {
            user = new User();
            user.setUsername(login);
            user.setEmail(email);
            userRepository.save(user);
        }

        Optional<ConferencePlan> lectureOptional = conferencePlanRepository.findById(lectureId);
        if(!lectureOptional.isPresent()) {
            return "Lecture not found.";
        }


        ConferencePlan lecture = lectureOptional.get();
        List<Reservation> userReservations = reservationRepository.findByUser(user);
        for(Reservation res : userReservations) {
            if(res.getLecture().getStart().equals(lecture.getStart())) {
                return "You already have a reservation at this time.";
            }
        }


         List<Reservation> reservations = reservationRepository.findByLecture(Optional.of(lecture));
        if(reservations.size() >= 5) {
            return "No seats available for this lecture.";
        }

        Reservation newReservation = new Reservation();
        newReservation.setUser(user);
        newReservation.setLecture(lecture);
        reservationRepository.save(newReservation);


        emailService.sendEmail(user.getEmail(), "Your reservation for lecture  is confirmed.");

        return "Reservation successful.";
    }


}