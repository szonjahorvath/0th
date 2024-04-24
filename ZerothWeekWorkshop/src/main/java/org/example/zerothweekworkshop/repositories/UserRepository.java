package org.example.zerothweekworkshop.repositories;

import org.example.zerothweekworkshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
