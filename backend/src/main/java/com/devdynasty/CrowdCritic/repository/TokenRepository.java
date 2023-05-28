package com.devdynasty.CrowdCritic.repository;

import com.devdynasty.CrowdCritic.model.Token;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer> {


    List<Token> findAllByExpiredFalse();


    Optional<Token> findByToken(String token);


    Optional<Token> findByUserIdAndExpiredIsFalse(Integer id);


    @Modifying
    @Transactional
    @Query("update  Token t set t.expired=true where t.id = ?1 and t.expired = false")
    void updateTokensByIdSetExpiredTrue(Integer id);




}
