package com.example.zadaniesi.Repo;

import com.example.zadaniesi.model.ConferencePlan;
import com.example.zadaniesi.model.Reservation;
import com.example.zadaniesi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByLecture(Optional<ConferencePlan> lecture);
    Reservation findByUserIdAndLectureId(Long id, Long lectureId);
}