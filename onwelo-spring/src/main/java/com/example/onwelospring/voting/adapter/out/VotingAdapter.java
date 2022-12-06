package com.example.onwelospring.voting.adapter.out;

import com.example.onwelospring.voting.application.port.in.GetCandidateVotesUseCase;
import com.example.onwelospring.voting.application.port.out.CreateCandidatePort;
import com.example.onwelospring.voting.application.port.out.CreateVoterPort;
import com.example.onwelospring.voting.application.port.out.GetCandidateVotesPort;
import com.example.onwelospring.voting.application.port.out.GetVoterPort;
import com.example.onwelospring.voting.application.port.out.SubmitVotePort;
import com.example.onwelospring.voting.domain.Candidate;
import com.example.onwelospring.voting.domain.Voter;
import com.example.onwelospring.voting.exception.InvalidReferenceException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class VotingAdapter
        implements CreateVoterPort, GetVoterPort, SubmitVotePort, CreateCandidatePort, GetCandidateVotesPort {
    private final VoterRepository voterRepository;

    private final CandidateRepository candidateRepository;

    VotingAdapter(VoterRepository voterRepository, CandidateRepository candidateRepository) {
        this.voterRepository = voterRepository;
        this.candidateRepository = candidateRepository;
    }

    @Override
    public void createVoter(String name) {
        voterRepository.save(new VoterEntity(name));
    }

    @Override
    public List<Voter> getVoters() {
        return voterRepository.findAll().stream().map(voterEntity -> {
            Candidate votedFor = null;
            if (voterEntity.getVotedFor() != null && voterEntity.getVotedFor().toDomain() != null) {
                votedFor = voterEntity.getVotedFor().toDomain();
            }
            return new Voter(voterEntity.getId(), voterEntity.getName(), votedFor);
        }).toList();
    }

    @Override
    public void submitVote(int voterId, int candidateId) {
        final var voter = voterRepository.findById(voterId).orElseThrow(InvalidReferenceException::new);
        final var candidate = candidateRepository.findById(candidateId).orElseThrow(InvalidReferenceException::new);
        voter.setVotedFor(candidate);
        voterRepository.save(voter);
    }

    @Override
    public void createCandidate(String name) {
        candidateRepository.save(new CandidateEntity(name));
    }

    @Override
    public List<GetCandidateVotesUseCase.CandidateVotes> getCandidateVotes() {
        return candidateRepository.findAll().stream().map(candidate -> {
            final var votes = voterRepository.countByVotedFor(candidate);
            return new GetCandidateVotesUseCase.CandidateVotes(candidate.getId(), candidate.getName(), votes);
        }).toList();
    }
}
