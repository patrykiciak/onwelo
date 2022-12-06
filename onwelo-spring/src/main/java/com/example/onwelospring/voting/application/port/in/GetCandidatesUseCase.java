package com.example.onwelospring.voting.application.port.in;

import com.example.onwelospring.voting.domain.Candidate;

import java.util.List;

public interface GetCandidatesUseCase {
    List<Candidate> getCandidates();
}
