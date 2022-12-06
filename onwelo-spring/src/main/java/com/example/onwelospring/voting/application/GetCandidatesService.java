package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.GetCandidatesUseCase;
import com.example.onwelospring.voting.application.port.out.GetCandidatesPort;
import com.example.onwelospring.voting.domain.Candidate;

import java.util.List;

public class GetCandidatesService implements GetCandidatesUseCase {
    private final GetCandidatesPort getCandidatesPort;

    public GetCandidatesService(GetCandidatesPort getCandidatesPort) {
        this.getCandidatesPort = getCandidatesPort;
    }

    @Override
    public List<Candidate> getCandidates() {
        return getCandidatesPort.getCandidates();
    }
}
