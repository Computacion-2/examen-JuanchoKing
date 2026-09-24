package com.example.demo.controller;

import com.example.demo.model.PullRequest;
import com.example.demo.repository.IPullRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pull-requests")
@RequiredArgsConstructor
public class PullRequestController {

    private final IPullRequestRepository pullRequestRepository;

    @GetMapping
    public List<PullRequest> findAllPullRequests() {
        return pullRequestRepository.findAll();
    }

    @GetMapping("/point1")
    public List<PullRequest> point1(){
        return pullRequestRepository.findDistinctByAuthor_Classrooms_NameAndStatusOrderByCreatedAtDesc(
                "Computacion en Internet II - Grupo 1", "OPEN");
    }

    @GetMapping("/point3")
    public List<PullRequest> point3(){
        return pullRequestRepository.findDistinctByReviewer_RoleAndAuthor_UsernameAndAuthor_Classrooms_Semester("TA", "cjimenez", "2026-02");
    }
}
