package com.example.onwelospring.voting.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {}
