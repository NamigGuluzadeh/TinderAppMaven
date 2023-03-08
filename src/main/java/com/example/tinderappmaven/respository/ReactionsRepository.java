package com.example.tinderappmaven.respository;

import com.example.tinderappmaven.model.Reactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReactionsRepository extends JpaRepository<Reactions, Long> {
}
