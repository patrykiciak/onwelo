package com.example.onwelospring.voting.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaVoterRepository extends JpaRepository<VoterEntity, Integer> {}
