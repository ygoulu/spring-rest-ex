package com.example.restex.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.restex.entities.History;

@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {

  Page<History> findAll(Pageable pageable);

  @Query("SELECT h FROM History h WHERE h.id = (SELECT MAX(id) FROM History)")
  History findLastHistory();
}