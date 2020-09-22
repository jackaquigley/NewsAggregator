package jackalexmark.newsaggregator.components;

import jackalexmark.newsaggregator.models.Comment;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.repository.CommentRepository;
import jackalexmark.newsaggregator.repository.SourceRepository;
import jackalexmark.newsaggregator.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

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

        Source source1 = new Source("Prime Minister Caught Doing Thing!", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", "The Fun", story1, 98, "Sam Smith");
        sourceRepository.save(source1);

        Source source2 = new Source("Prime Minister - Is He Doing The Thing? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com","The Fun", story1, 76, "Adele");
        sourceRepository.save(source2);

        Comment comment1 = new Comment("So like the fun to make something out of nothing", "Starlight", source2);
        commentRepository.save(comment1);

        Comment comment2 = new Comment("Who doesn't?", "ANC_READER", source2);
        commentRepository.save(comment2);

        Comment comment3 = new Comment( "So the photograph on tweeter is real?", "StMirrenSupp", source1);
        commentRepository.save(comment3);

    }
}
