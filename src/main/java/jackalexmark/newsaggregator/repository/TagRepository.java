package jackalexmark.newsaggregator.repository;

import jackalexmark.newsaggregator.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
