package jackalexmark.newsaggregator.repository;

import jackalexmark.newsaggregator.models.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceRepository extends JpaRepository<Source, Long> {
    List<Source> findByPublisherName(String publisherName);
}
