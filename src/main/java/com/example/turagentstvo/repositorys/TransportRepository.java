package com.example.turagentstvo.repositorys;

import com.example.turagentstvo.entities.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
}
