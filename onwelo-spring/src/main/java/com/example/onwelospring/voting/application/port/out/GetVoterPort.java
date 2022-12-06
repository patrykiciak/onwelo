package com.example.onwelospring.voting.application.port.out;

import com.example.onwelospring.voting.domain.Voter;

import java.util.List;

public interface GetVoterPort {
    List<Voter> getVoters();
}
