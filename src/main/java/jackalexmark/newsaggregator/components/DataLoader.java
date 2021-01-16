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
        Source source2 = new Source("Michael Gove - The Next Conservative Leader? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/4/4a/Michael_Gove%2C_5_September_2013.jpeg", "https://www.google.com","The Fun", story1, 76, "Franky Palmer");
        Source source3 = new Source("Prime Minister Announces Press Conference", "https://upload.wikimedia.org/wikipedia/commons/7/7a/Boris_Johnson_%28cropped%29.jpg", "https://www.google.com", "ANC", story1, 111, "April Walker");

        sourceRepository.save(source1);
        sourceRepository.save(source2);
        sourceRepository.save(source3);

        Comment comment1 = new Comment("Comment Comment Comment", "Username", source1);
        Comment comment2 = new Comment("Comment Comment Comment", "Username", source2);
        Comment comment3 = new Comment("Comment Comment Comment", "Username", source2);
        Comment comment4 = new Comment( "Comment Comment Comment", "Username", source3);

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
        commentRepository.save(comment4);

        // Story 2

        Story story2 = new Story("Gemma Collins suceeds Corbyn in shock by election");

        storyRepository.save(story2);

        Source source4 = new Source("Shock Islington Surprise for Labour", "https://upload.wikimedia.org/wikipedia/commons/8/84/Gemma_Collins_book_signing.jpeg", "https://www.google.com", "The Fun", story2, 99, "Samuel Khan");
        Source source5 = new Source("Islington By-Election Result In!", "https://upload.wikimedia.org/wikipedia/commons/d/d1/Official_portrait_of_Jeremy_Corbyn_crop_2%2C_2020.jpg","https://www.google.com", "ANC News", story2, 122, "Kian Gallagher");

        sourceRepository.save(source4);
        sourceRepository.save(source5);

        Tag tag3 = new Tag("Politics", story2);
        Tag tag4 = new Tag("UK News", story2);
        Tag tag5 = new Tag("Reality TV", story2);

        tagRepository.save(tag3);
        tagRepository.save(tag4);
        tagRepository.save(tag5);

        Comment comment5 = new Comment( "Comment Comment Comment", "Username", source4);
        Comment comment6 = new Comment( "Comment Comment Comment", "Username", source4);
        Comment comment7 = new Comment( "Comment Comment Comment", "Username", source5);

        commentRepository.save(comment5);
        commentRepository.save(comment6);
        commentRepository.save(comment7);

        // Story 3

        Story story3 = new Story("iPhone XSLMax released without box");

        storyRepository.save(story3);

        Source source6 = new Source("iPhone XSLMax released without box", "https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg", "https://www.google.com", "ANC News", story3, 77, "Bob Samson");
        Source source7 = new Source("No box? What next - no phone? - Opinion", "https://upload.wikimedia.org/wikipedia/commons/1/1d/Apple_iPhone_Box_%2841330393110%29.jpg", "https://www.google.com", "The Fun", story3, 24, "David Wallace");
        Source source8 = new Source("Apple changes the entire packaging industry", "https://cdn.slashgear.com/wp-content/uploads/2012/08/iphone-5-render-based-on-leaked-parts-3-820x420.jpeg", "https://www.google.com", "I-News", story3, 5, "Ahmed Khan");

        sourceRepository.save(source6);
        sourceRepository.save(source7);
        sourceRepository.save(source8);

        Tag tag6 = new Tag("Technology", story3);
        Tag tag7 = new Tag("Lifestyle", story3);

        tagRepository.save(tag6);
        tagRepository.save(tag7);

        Comment comment8 = new Comment( "Comment Comment Comment", "Username", source6);
        Comment comment9 = new Comment( "Comment Comment Comment", "Username", source7);
        Comment comment10 = new Comment( "Comment Comment Comment", "Username", source8);

        commentRepository.save(comment8);
        commentRepository.save(comment9);
        commentRepository.save(comment10);

    }
}
