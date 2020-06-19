package jackalexmark.newsaggregator.components;

import jackalexmark.newsaggregator.models.Publisher;
import jackalexmark.newsaggregator.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PublisherRepository publisherRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Publisher publisher = new Publisher("Sample Publisher");
        publisherRepository.save(publisher);
    }
}
