package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.CreateVoterUseCase;
import com.example.onwelospring.voting.application.port.out.CreateVoterPort;

public class CreateVotersService implements CreateVoterUseCase {
    private final CreateVoterPort createVoterPort;

    public CreateVotersService(CreateVoterPort createVoterPort) {
        this.createVoterPort = createVoterPort;
    }

    @Override
    public void createVoter(String name) {
        createVoterPort.createVoter(name);
    }
}
