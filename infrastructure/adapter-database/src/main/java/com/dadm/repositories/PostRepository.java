package com.dadm.repositories;

import com.dadm.model.PostMO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostMO, Long> {
}
