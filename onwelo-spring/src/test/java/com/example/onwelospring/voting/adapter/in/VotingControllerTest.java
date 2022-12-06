package com.example.onwelospring.voting.adapter.in;

import com.example.onwelospring.voting.application.port.in.CreateCandidateUseCase;
import com.example.onwelospring.voting.application.port.in.CreateVoterUseCase;
import com.example.onwelospring.voting.application.port.in.GetCandidateVotesUseCase;
import com.example.onwelospring.voting.application.port.in.GetVotersUseCase;
import com.example.onwelospring.voting.application.port.in.SubmitVoteUseCase;
import com.example.onwelospring.voting.domain.Candidate;
import com.example.onwelospring.voting.domain.Voter;
import com.example.onwelospring.voting.exception.InvalidReferenceException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(VotingController.class)
class VotingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateCandidateUseCase createCandidateUseCase;

    @MockBean
    private GetCandidateVotesUseCase getCandidateVotesUseCase;

    @MockBean
    private SubmitVoteUseCase submitVoteUseCase;

    @MockBean
    private CreateVoterUseCase createVoterUseCase;

    @MockBean
    private GetVotersUseCase getVotersUseCase;

    private static <T> T getResponseBody(MvcResult mvcResult, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(mvcResult.getResponse().getContentAsByteArray(), clazz);
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getVoters_successfully() throws Exception {
        // given
        final var voters =
                new Voter[]{new Voter(1, "Voter 1", null), new Voter(2, "Voter 2", new Candidate(1, "Hyzio"))};
        when(getVotersUseCase.getVoters()).thenReturn(Arrays.stream(voters).toList());

        // when
        final var mvcResult = mockMvc.perform(get("/voters")).andReturn();

        // then
        final var response = getResponseBody(mvcResult, Voter[].class);
        assertEquals(200, mvcResult.getResponse().getStatus());
        assertArrayEquals(voters, response);
    }

    @Test
    void postVote_noRequestBody() throws Exception {
        // given (nothing)

        // when
        final var mvcResult = mockMvc.perform(post("/votes")).andReturn();

        // then
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    void postVote_missingFieldsInRequestBody() throws Exception {
        // given (nothing)

        // when
        final var mvcResult = mockMvc.perform(post("/votes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andReturn();

        // then
        assertEquals(400, mvcResult.getResponse().getStatus());
    }

    @Test
    void postVote_invalidReference() throws Exception {
        // given
        doThrow(InvalidReferenceException.class).when(submitVoteUseCase).submitVote(3, 4);

        // when
        final var mvcResult = mockMvc.perform(post("/votes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new PostVoteRequest(3, 4))))
                .andReturn();

        // then
        assertEquals(422, mvcResult.getResponse().getStatus());
    }
}
