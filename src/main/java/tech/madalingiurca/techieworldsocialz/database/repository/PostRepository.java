package tech.madalingiurca.techieworldsocialz.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.madalingiurca.techieworldsocialz.database.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
