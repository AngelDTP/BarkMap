package com.BarkMap.BarkMap.Service;

import com.BarkMap.BarkMap.Repository.CompteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {
    CompteRepository compteRepository;

    public AdminService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }
}
