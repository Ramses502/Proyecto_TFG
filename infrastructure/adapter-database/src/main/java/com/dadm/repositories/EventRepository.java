package com.dadm.repositories;

import com.dadm.model.Event;
import com.dadm.model.EventMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventMO, Long> {

    @Query("SELECT e FROM EventMO e")
    List<EventMO> getEventsFromUser(String userName);
}
