package com.example.turagentstvo.repositorys;

import com.example.turagentstvo.entities.Rout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutRepository extends JpaRepository<Rout, Long> {
}