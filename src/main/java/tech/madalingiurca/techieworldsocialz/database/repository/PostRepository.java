package tech.madalingiurca.techieworldsocialz.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.madalingiurca.techieworldsocialz.database.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
