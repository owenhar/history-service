package edu.iu.harriowe.historyservice.controllers;

import edu.iu.harriowe.historyservice.model.PrimesRecord;
import edu.iu.harriowe.historyservice.repository.PrimesHistoryRepository;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesHistoryController {
    private final PrimesHistoryRepository primesHistoryRepository;
    public PrimesHistoryController(PrimesHistoryRepository primesHistoryRepository) {
        this.primesHistoryRepository = primesHistoryRepository;
    }

    @GetMapping("/{customer}")
    public List<PrimesRecord> findALl(@PathVariable String customer) {
        return primesHistoryRepository.findAllByCustomer(customer);
    }
}
