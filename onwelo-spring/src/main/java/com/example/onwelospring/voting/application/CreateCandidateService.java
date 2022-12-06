package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.CreateCandidateUseCase;
import com.example.onwelospring.voting.application.port.out.CreateCandidatePort;

public class CreateCandidateService implements CreateCandidateUseCase {
    private final CreateCandidatePort createCandidatePort;

    public CreateCandidateService(CreateCandidatePort createCandidatePort) {
        this.createCandidatePort = createCandidatePort;
    }

    @Override
    public void createCandidate(String name) {
        createCandidatePort.createCandidate(name);
    }
}
