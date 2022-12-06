package com.example.onwelospring.voting.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCandidateRepository extends JpaRepository<CandidateEntity, Integer> {}
