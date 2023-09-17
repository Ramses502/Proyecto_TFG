package com.dadm.repositories;

import com.dadm.model.Event;
import com.dadm.model.EventMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventMO, Long> {

    @Modifying
    @Query(value = "INSERT INTO event_user (user_name, event_id) VALUES (:userName, :eventId)", nativeQuery = true)
    void insertUserInEvent(@Param("userName") String userName, @Param("eventId") Long eventId);

    @Modifying
    @Query(value = "DELETE FROM event_user WHERE user_name = :userName AND event_id = :eventId", nativeQuery = true)
    void deleteUserInEvent(@Param("userName") String userName, @Param("eventId") Long eventId);

    @Modifying
    @Query(value = "DELETE FROM event_user WHERE event_id = :eventId", nativeQuery = true)
    void deleteEvent(@Param("eventId") Long eventId);

    @Query("SELECT ug.event FROM EventUserMO ug JOIN ug.user g WHERE g.name = :userName")
    List<EventMO> getAllEventsFromUser(@Param("userName") String userName);

    @Query("SELECT e FROM EventMO e WHERE e.name = :eventName")
    EventMO getEventFromName(String eventName);
}
