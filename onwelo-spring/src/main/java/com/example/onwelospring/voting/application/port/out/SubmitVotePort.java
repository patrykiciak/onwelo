package com.example.onwelospring.voting.application.port.out;

public interface SubmitVotePort {
    void submitVote(int voterId, int candidateId);
}
