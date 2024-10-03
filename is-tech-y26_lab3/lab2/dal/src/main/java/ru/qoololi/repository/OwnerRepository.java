package ru.qoololi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.qoololi.models.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
