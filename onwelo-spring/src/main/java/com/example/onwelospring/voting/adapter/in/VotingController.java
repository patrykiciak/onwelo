package com.example.onwelospring.voting.adapter.in;

import com.example.onwelospring.voting.application.port.in.CreateCandidateUseCase;
import com.example.onwelospring.voting.application.port.in.CreateVoterUseCase;
import com.example.onwelospring.voting.application.port.in.GetCandidateVotesUseCase;
import com.example.onwelospring.voting.application.port.in.GetVotersUseCase;
import com.example.onwelospring.voting.application.port.in.SubmitVoteUseCase;
import com.example.onwelospring.voting.domain.Voter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
class VotingController {
    private final CreateCandidateUseCase createCandidateUseCase;
    private final GetCandidateVotesUseCase getCandidateVotesUseCase;
    private final SubmitVoteUseCase submitVoteUseCase;
    private final CreateVoterUseCase createVoterUseCase;
    private final GetVotersUseCase getVotersUseCase;

    VotingController(
            CreateCandidateUseCase createCandidateUseCase,
            GetCandidateVotesUseCase getCandidateVotesUseCase,
            SubmitVoteUseCase submitVoteUseCase,
            CreateVoterUseCase createVoterUseCase,
            GetVotersUseCase getVotersUseCase
    ) {
        this.createCandidateUseCase = createCandidateUseCase;
        this.getCandidateVotesUseCase = getCandidateVotesUseCase;
        this.submitVoteUseCase = submitVoteUseCase;
        this.createVoterUseCase = createVoterUseCase;
        this.getVotersUseCase = getVotersUseCase;
    }

    @PostMapping("candidates")
    void postCandidate(@RequestBody PostCandidateRequest request) {
        createCandidateUseCase.createCandidate(request.name());
    }

    @GetMapping("votes")
    List<GetCandidateVotesUseCase.CandidateVotes> getCandidatesVotes() {
        return getCandidateVotesUseCase.getCandidateVotes();
    }

    @PostMapping("voters")
    void postVoter(@RequestBody PostVoterRequest request) {
        createVoterUseCase.createVoter(request.name());
    }

    @GetMapping("voters")
    List<Voter> getVoters() {
        return getVotersUseCase.getVoters();
    }

    @PostMapping("votes")
    void postVote(@RequestBody PostVoteRequest request) {
        submitVoteUseCase.submitVote(request.voterId(), request.candidateId());
    }
}
