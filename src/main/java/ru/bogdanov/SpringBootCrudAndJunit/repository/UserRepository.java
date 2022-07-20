package ru.bogdanov.SpringBootCrudAndJunit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogdanov.SpringBootCrudAndJunit.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
