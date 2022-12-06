package com.example.onwelospring.voting.application.port.in;

import com.example.onwelospring.voting.domain.Voter;

import java.util.List;

public interface GetVotersUseCase {
    List<Voter> getVoters();
}
