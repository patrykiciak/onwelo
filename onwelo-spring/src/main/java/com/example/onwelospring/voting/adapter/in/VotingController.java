package com.example.onwelospring.voting.adapter.in;

import com.example.onwelospring.voting.application.port.in.CreateCandidateUseCase;
import com.example.onwelospring.voting.application.port.in.CreateVoterUseCase;
import com.example.onwelospring.voting.application.port.in.GetCandidatesUseCase;
import com.example.onwelospring.voting.application.port.in.GetVotersUseCase;
import com.example.onwelospring.voting.application.port.in.SubmitVoteUseCase;
import com.example.onwelospring.voting.domain.Candidate;
import com.example.onwelospring.voting.domain.Voter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    private final GetCandidatesUseCase getCandidatesUseCase;
    private final SubmitVoteUseCase submitVoteUseCase;
    private final CreateVoterUseCase createVoterUseCase;
    private final GetVotersUseCase getVotersUseCase;

    VotingController(
            CreateCandidateUseCase createCandidateUseCase,
            GetCandidatesUseCase getCandidatesUseCase,
            SubmitVoteUseCase submitVoteUseCase,
            CreateVoterUseCase createVoterUseCase,
            GetVotersUseCase getVotersUseCase
    ) {
        this.createCandidateUseCase = createCandidateUseCase;
        this.getCandidatesUseCase = getCandidatesUseCase;
        this.submitVoteUseCase = submitVoteUseCase;
        this.createVoterUseCase = createVoterUseCase;
        this.getVotersUseCase = getVotersUseCase;
    }

    @PostMapping("candidates")
    ResponseEntity<Void> postCandidate(@RequestBody PostCandidateRequest request) {
        createCandidateUseCase.createCandidate(request.name());
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("candidates")
    ResponseEntity<List<Candidate>> getCandidates() {
        return ResponseEntity.ok(getCandidatesUseCase.getCandidates());
    }

    @PostMapping("voters")
    ResponseEntity<Void> postVoter(@RequestBody PostVoterRequest request) {
        createVoterUseCase.createVoter(request.name());
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("voters")
    ResponseEntity<List<Voter>> getVoters() {
        return ResponseEntity.ok(getVotersUseCase.getVoters());
    }

    @PostMapping("votes")
    ResponseEntity<Void> postVote(@RequestBody PostVoteRequest request) {
        submitVoteUseCase.submitVote(request.voterId(), request.candidateId());
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
