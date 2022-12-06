package com.example.onwelospring.voting;

import com.example.onwelospring.voting.application.CreateCandidateService;
import com.example.onwelospring.voting.application.CreateVotersService;
import com.example.onwelospring.voting.application.GetCandidatesService;
import com.example.onwelospring.voting.application.GetVotersService;
import com.example.onwelospring.voting.application.SubmitVoteService;
import com.example.onwelospring.voting.application.port.out.CreateCandidatePort;
import com.example.onwelospring.voting.application.port.out.CreateVoterPort;
import com.example.onwelospring.voting.application.port.out.GetCandidatesPort;
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
    GetCandidatesService getCandidatesService(GetCandidatesPort getCandidatesPort) {
        return new GetCandidatesService(getCandidatesPort);
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
