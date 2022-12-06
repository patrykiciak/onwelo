package com.example.onwelospring.voting.application.port.in;

import java.util.List;

public interface GetCandidateVotesUseCase {
    record CandidateVotes(int id, String name, int votes) {}

    List<CandidateVotes> getCandidateVotes();
}
