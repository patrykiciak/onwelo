package com.example.onwelospring.voting.adapter.out;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VoterRepository extends JpaRepository<VoterEntity, Integer> {
    int countByVotedFor(CandidateEntity candidate);
}
