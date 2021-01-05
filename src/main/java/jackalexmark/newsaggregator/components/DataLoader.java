package jackalexmark.newsaggregator.components;

import jackalexmark.newsaggregator.models.Comment;
import jackalexmark.newsaggregator.models.Source;
import jackalexmark.newsaggregator.models.Story;
import jackalexmark.newsaggregator.models.Tag;
import jackalexmark.newsaggregator.repository.CommentRepository;
import jackalexmark.newsaggregator.repository.SourceRepository;
import jackalexmark.newsaggregator.repository.StoryRepository;
import jackalexmark.newsaggregator.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    StoryRepository storyRepository;

    @Autowired
    SourceRepository sourceRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    TagRepository tagRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        // Story 1

        Story story1  = new Story("Prime Minister responds to leaked report!");
        storyRepository.save(story1);

        Tag tag1 = new Tag("Politics", story1);
        Tag tag2 = new Tag("UK News", story1);

        tagRepository.save(tag1);
        tagRepository.save(tag2);

        Source source1 = new Source("Prime Minister holds press conference", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", "The Fun", story1, 98, "Jaime Pearson");

        Source source2 = new Source("Michael Gove - The Next Conservative Leader? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com","The Fun", story1, 76, "Franky Palmer");
        Source source3 = new Source("Prime Minister Announces Press Conference", "https://upload.wikimedia.org/wikipedia/commons/7/7a/Boris_Johnson_%28cropped%29.jpg", "https://www.google.com", "ANC", story1, 111, "April Walker");

        sourceRepository.save(source1);
        sourceRepository.save(source2);
        sourceRepository.save(source3);

        Comment comment1 = new Comment("So like the fun to make something out of nothing", "Starlight", source2);
        Comment comment2 = new Comment("Who doesn't?", "ANC_READER", source2);
        Comment comment3 = new Comment( "So the photograph on tweeter is real?", "StMirrenSupp", source3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

        // Story 2

        Story story2 = new Story("Gemma Collins suceeds Corbyn in shock by election");

        storyRepository.save(story2);

        Tag tag3 = new Tag("Politics", story2);
        Tag tag4 = new Tag("UK News", story2);
        Tag tag5 = new Tag("Reality TV", story2);

        tagRepository.save(tag3);
        tagRepository.save(tag4);
        tagRepository.save(tag5);

    }
}
