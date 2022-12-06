package com.example.onwelospring.voting.application;

import com.example.onwelospring.voting.application.port.in.GetVotersUseCase;
import com.example.onwelospring.voting.application.port.out.GetVoterPort;
import com.example.onwelospring.voting.domain.Voter;

import java.util.List;

public class GetVotersService implements GetVotersUseCase {
    private final GetVoterPort getVoterPort;

    public GetVotersService(GetVoterPort getVoterPort) {
        this.getVoterPort = getVoterPort;
    }

    @Override
    public List<Voter> getVoters() {
        return getVoterPort.getVoters();
    }
}
