package com.example.demo.repository;

import com.example.demo.model.Commit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICommitRepository extends JpaRepository<Commit, Long> {

    List<Commit> findDistinctByRepository_ParentIsNotNullAndMessageContainingIgnoreCaseAndLinesdAddedGreaterThan(String name, String text, Integer int);

}
