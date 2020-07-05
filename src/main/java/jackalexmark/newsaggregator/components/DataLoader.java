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

        Publisher publisher2 = new Publisher("The Rational Cautious Sceptic");
        publisherRepository.save(publisher2);

        Source source1 = new Source("Prime Minister Caught Doing Thing!", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", story1, 98, publisher1, "Mabel");
        sourceRepository.save(source1);

        Source source2 = new Source("Prime Minister - Is He Doing The Thing? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/a/a0/Yukiya_Amano_with_Boris_Johnson_in_London_-_2018_%2841099455635%29_%28cropped%29.jpg", "https://www.google.com", story1, 76, publisher1, "Stormzy");
        sourceRepository.save(source2);

        Source source3 = new Source("Prime Minister Did The Thing - What Next?", "https://upload.wikimedia.org/wikipedia/commons/e/e9/Boris_Johnson_on_13_August_2019.jpg", "https://www.google.com", story1, 95, publisher2, "La Roux");
        sourceRepository.save(source3);

        Comment comment1 = new Comment("So what if he did the thing - everyone does!", "MumsNetVegan", source2);
        commentRepository.save(comment1);

        Comment comment2 = new Comment("This is so embarrasing... in 2020 :(", "WeeSandra2k11", source2);
        commentRepository.save(comment2);

        Comment comment3 = new Comment("Bet they delete this comment! You can't hide that 5G causes the thing!", "RSC", source1);
        commentRepository.save(comment3);

        ;
    }
}
