package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.SubmitVoteUseCase;
import com.example.onwelospring.voting.application.port.out.SubmitVotePort;

public class SubmitVoteService implements SubmitVoteUseCase {
    private final SubmitVotePort submitVotePort;

    public SubmitVoteService(SubmitVotePort submitVotePort) {
        this.submitVotePort = submitVotePort;
    }

    @Override
    public void submitVote(int voterId, int candidateId) {
        submitVotePort.submitVote(voterId, candidateId);
    }
}
