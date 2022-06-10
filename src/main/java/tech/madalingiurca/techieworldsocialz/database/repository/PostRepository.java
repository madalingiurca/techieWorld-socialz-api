package tech.madalingiurca.techieworldsocialz.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.madalingiurca.techieworldsocialz.database.entity.Post;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
