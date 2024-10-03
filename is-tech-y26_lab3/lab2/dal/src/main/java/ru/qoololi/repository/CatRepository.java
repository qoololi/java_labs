package ru.qoololi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qoololi.models.Cat;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
}
