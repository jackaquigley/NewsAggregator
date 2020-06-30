package jackalexmark.newsaggregator.components;

import jackalexmark.newsaggregator.models.Comment;
import jackalexmark.newsaggregator.models.Publisher;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.CommentRepository;
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

    @Autowired
    CommentRepository commentRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Story story1  = new Story("Prime Minister Does Thing!");
        storyRepository.save(story1);

        Publisher publisher1 = new Publisher("The Fun");
        publisherRepository.save(publisher1);

        Source source1 = new Source("Prime Minister Caught Doing Thing!", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", story1, 98, publisher1, "Sam Smith");
        sourceRepository.save(source1);

        Source source2 = new Source("Prime Minister - Is He Doing The Thing? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", story1, 76, publisher1, "Sam Smith");
        sourceRepository.save(source2);

        Comment comment1 = new Comment("So", "S", source2);
        commentRepository.save(comment1);

        ;
    }
}
