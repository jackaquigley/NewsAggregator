package jackalexmark.newsaggregator.components;

import jackalexmark.newsaggregator.models.Publisher;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.PublisherRepository;
import jackalexmark.newsaggregator.repository.SourceRepository;
import jackalexmark.newsaggregator.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    SourceRepository sourceRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Publisher publisher = new Publisher("Sample Publisher");
        publisherRepository.save(publisher);

        Story story = new Story("Sample Title");
        storyRepository.save(story);

        Source source = new Source("Sample Source Title", "Sample Source Link", "Sample Source Link");
        sourceRepository.save(source);
    }
}
