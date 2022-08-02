package ru.bogdanov.SpringBootCrudAndJunit.testing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bogdanov.SpringBootCrudAndJunit.testing.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
