package com.example.demo.repository;

import com.example.demo.model.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;

public interface IRepositoryRepository extends JpaRepository<Repository, Integer> {

    List<Repository> findDistinctByParentIsNotNullAndOwner_EmailAndAssignment_DeadlineAfter(String email, Timestamp deadline);

}
