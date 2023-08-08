package com.dadm.repositories;

import com.dadm.model.EventMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventMO, Long> {
}
