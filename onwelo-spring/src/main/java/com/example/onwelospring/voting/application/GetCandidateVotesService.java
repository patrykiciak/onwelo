package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.GetCandidateVotesUseCase;
import com.example.onwelospring.voting.application.port.out.GetCandidateVotesPort;

import java.util.List;

public class GetCandidateVotesService implements GetCandidateVotesUseCase {
    private final GetCandidateVotesPort getCandidateVotesPort;

    public GetCandidateVotesService(GetCandidateVotesPort getCandidateVotesPort) {
        this.getCandidateVotesPort = getCandidateVotesPort;
    }

    @Override
    public List<CandidateVotes> getCandidateVotes() {
        return getCandidateVotesPort.getCandidateVotes();
    }
}
