package tech.madalingiurca.techieworldsocialz.database.repository;

import org.springframework.data.repository.CrudRepository;
import tech.madalingiurca.techieworldsocialz.database.entity.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
