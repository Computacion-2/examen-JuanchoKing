package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Repository> ownedRepositories;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<PullRequest> authoredPullRequests;

    @OneToMany(mappedBy = "reviewer", cascade = CascadeType.ALL)
    private List<PullRequest> reviewedPullRequests;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Commit> authoredCommits;
}
