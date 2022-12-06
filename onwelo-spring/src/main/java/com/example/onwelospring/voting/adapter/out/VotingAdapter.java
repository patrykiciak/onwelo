package com.example.onwelospring.voting.adapter.out;

import com.example.onwelospring.voting.application.port.out.CreateCandidatePort;
import com.example.onwelospring.voting.application.port.out.CreateVoterPort;
import com.example.onwelospring.voting.application.port.out.GetCandidatesPort;
import com.example.onwelospring.voting.application.port.out.GetVoterPort;
import com.example.onwelospring.voting.application.port.out.SubmitVotePort;
import com.example.onwelospring.voting.domain.Candidate;
import com.example.onwelospring.voting.domain.Voter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class VotingAdapter implements CreateVoterPort, GetVoterPort, SubmitVotePort, CreateCandidatePort, GetCandidatesPort {
    private final JpaVoterRepository voterRepository;
    private final JpaCandidateRepository candidateRepository;

    VotingAdapter(JpaVoterRepository voterRepository, JpaCandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void createVoter(String name) {
        voterRepository.save(new VoterEntity(name));
    }

    @Override
    public List<Voter> getVoters() {
        return voterRepository.findAll().stream().map(
                VoterEntity::toDomain).toList();
    }

    @Override
    public void submitVote(int voterId, int candidateId) {
        final var voter = voterRepository.findById(voterId).orElseThrow();
        final var candidate = candidateRepository.findById(candidateId).orElseThrow();
        voter.setVotedFor(candidate);
        voterRepository.save(voter);
    }

    @Override
    public void createCandidate(String name) {
        candidateRepository.save(new CandidateEntity(name));
    }

    @Override
    public List<Candidate> getCandidates() {
        return candidateRepository.findAll().stream().map(CandidateEntity::toDomain).toList();
    }
}
