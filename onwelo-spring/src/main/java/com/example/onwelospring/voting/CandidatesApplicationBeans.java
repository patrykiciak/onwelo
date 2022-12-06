package com.example.onwelospring.voting;

import com.example.onwelospring.voting.application.CreateCandidateService;
import com.example.onwelospring.voting.application.CreateVotersService;
import com.example.onwelospring.voting.application.GetCandidateVotesService;
import com.example.onwelospring.voting.application.GetVotersService;
import com.example.onwelospring.voting.application.SubmitVoteService;
import com.example.onwelospring.voting.application.port.out.CreateCandidatePort;
import com.example.onwelospring.voting.application.port.out.CreateVoterPort;
import com.example.onwelospring.voting.application.port.out.GetCandidateVotesPort;
import com.example.onwelospring.voting.application.port.out.GetVoterPort;
import com.example.onwelospring.voting.application.port.out.SubmitVotePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CandidatesApplicationBeans {

    @Bean
    CreateCandidateService createCandidateService(CreateCandidatePort createCandidatePort) {
        return new CreateCandidateService(createCandidatePort);
    }

    @Bean
    GetCandidateVotesService getCandidatesService(GetCandidateVotesPort getCandidateVotesPort) {
        return new GetCandidateVotesService(getCandidateVotesPort);
    }

    @Bean
    CreateVotersService createVotersService(CreateVoterPort createVoterPort) {
        return new CreateVotersService(createVoterPort);
    }

    @Bean
    GetVotersService getVotersService(GetVoterPort getVoterPort) {
        return new GetVotersService(getVoterPort);
    }

    @Bean
    SubmitVoteService submitVoteService(SubmitVotePort submitVotePort) {
        return new SubmitVoteService(submitVotePort);
    }
}
