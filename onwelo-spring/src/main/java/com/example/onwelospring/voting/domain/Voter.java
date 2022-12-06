package com.example.onwelospring.voting.domain;

public record Voter(int id, String name, Candidate votedFor) {}
