package spring.tuto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.tuto.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
