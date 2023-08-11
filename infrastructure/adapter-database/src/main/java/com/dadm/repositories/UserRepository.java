package com.dadm.repositories;

import com.dadm.model.UserMO;
//import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserMO,String> {

    @Query("SELECT u FROM UserMO u WHERE u.name = :name AND u.password = :pass")
    Optional<UserMO> login(String name, String pass);

}
