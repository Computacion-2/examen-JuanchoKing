package com.example.demo.repository;

import com.example.demo.model.PullRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPullRequestRepository extends JpaRepository<PullRequest, Long> {

    List<PullRequest> findDistinctByAuthor_Classrooms_NameAndStatusOrderByCreatedAtDesc(
            String classroomName, String status);

    List<PullRequest> findDistinctByReviewer_RoleAndAuthor_UsernameAndAuthor_Classrooms_Semester(String role, String username, String semester);
}
