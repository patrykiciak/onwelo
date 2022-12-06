package com.example.onwelospring.voting.application.port.out;

import com.example.onwelospring.voting.domain.Candidate;

import java.util.List;

public interface GetCandidatesPort {
    List<Candidate> getCandidates();
}
