
package com.example.zadaniesi.Service;
import com.example.zadaniesi.model.ConferencePlan;
import com.example.zadaniesi.Repo.ConferencePlanRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ConferencePlanService {

    private final ConferencePlanRepository conferencePlanRepository;

    public ConferencePlanService(ConferencePlanRepository conferencePlanRepository) {
        this.conferencePlanRepository = conferencePlanRepository;
    }

    public List<ConferencePlan> getAllConferencePlans() {
        return conferencePlanRepository.findAll();
    }
}