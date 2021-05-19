package ru.runner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.runner.entity.Builder;

@Repository
public interface BuilderRepository extends JpaRepository<Builder, Long> {
}
