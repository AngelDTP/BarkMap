package com.BarkMap.BarkMap.Repository;

import com.BarkMap.BarkMap.Models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    @Query("""
        select u from Compte u where trim(lower(u.credentials.email)) = :email
    """)
    Optional<Compte> findUserAppByEmail(@Param("email") String email);
}