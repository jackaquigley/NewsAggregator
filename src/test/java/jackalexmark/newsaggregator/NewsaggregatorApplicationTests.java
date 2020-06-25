package jackalexmark.newsaggregator;

import jackalexmark.newsaggregator.models.*;
import jackalexmark.newsaggregator.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NewsaggregatorApplicationTests {

	@Autowired
	PublisherRepository publisherRepository;

	@Autowired
	SourceRepository sourceRepository;

	@Autowired
	StoryRepository storyRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreatePublisherStoryAndSourceAndSave(){
		Story story1  = new Story("Prime Minister Does Thing!");
		storyRepository.save(story1);

		Publisher publisher1 = new Publisher("The Fun");
		publisherRepository.save(publisher1);

		Source source1 = new Source("Prime Minister Caught Doing Thing!", "https://upload.wikimedia.org/wikipedia/commons/e/eb/Boris_Johnson_in_2018.jpg", "https://www.google.com", story1, 98, publisher1);
		sourceRepository.save(source1);
	}

}
