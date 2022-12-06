package com.example.onwelospring.voting.application.port.out;

import com.example.onwelospring.voting.application.port.in.GetCandidateVotesUseCase;

import java.util.List;

public interface GetCandidateVotesPort {
    List<GetCandidateVotesUseCase.CandidateVotes> getCandidateVotes();
}
