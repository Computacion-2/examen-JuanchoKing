package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "repositories")
public class Repository {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(name =  "is_template", nullable = false)
    private boolean isTemplate;

    @Column(name =  "is_private", nullable = false)
    private boolean isPrivate;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @OneToMany(mappedBy = "repository", cascade = CascadeType.ALL)
    List<PullRequest> pullRequests;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    private Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Repository> childrenRepositories;

    @ManyToOne
    @JoinColumn(name = "paren_repo_id")
    private Repository parent;
}
