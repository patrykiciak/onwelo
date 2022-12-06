package com.example.onwelospring.voting.application.port.in;

public interface SubmitVoteUseCase {
    void submitVote(int voterId, int candidateId);
}
