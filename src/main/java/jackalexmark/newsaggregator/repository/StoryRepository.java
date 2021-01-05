package jackalexmark.newsaggregator.repository;

import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

    public List<Story> findByTagsNameIgnoreCase(String name);


}
