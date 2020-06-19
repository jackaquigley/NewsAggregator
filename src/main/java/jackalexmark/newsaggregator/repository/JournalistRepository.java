package jackalexmark.newsaggregator.repository;

import jackalexmark.newsaggregator.models.Journalist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalistRepository extends JpaRepository<Journalist, Long> {

}
