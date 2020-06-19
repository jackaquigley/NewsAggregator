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
	JournalistRepository journalistRepository;

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
	public void canGetJournalistName(){
		Publisher publisher = new Publisher("BBC");
		Journalist journalist = new Journalist ("Bob Smith", publisher);
		assertEquals("Bob Smith", journalist.getName());
	}

	@Test
	public void canGetSourceTitle(){
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134");
		assertEquals("Pub chain has no choice but to open on 4th July", source.getSourceTitle());
	}

	@Test
	public void canGetSourceImg(){
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134");
		assertEquals("https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", source.getSourceImg());
	}

	@Test
	public void canGetSourceLink(){
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134");
		assertEquals("https://www.bbc.co.uk/news/business-53094134", source.getSourceLink());
	}

	@Test
	public void canGetStoryTitle(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		assertEquals("Pub chain has no choice but to open on 4th July", story.getTitle());
	}

	@Test
	public void canGetPublisherName(){
		Publisher publisher = new Publisher("The Guardian");
		assertEquals("The Guardian", publisher.getName());
	}

	@Test
	public void canCreateAndSavePublisher(){
		Publisher publisher = new Publisher("Daily Mail");
		publisherRepository.save(publisher);
	}

	@Test
	public void canCreateAndSaveJournalist(){
		Publisher publisher = new Publisher("Financial Times");
		Journalist journalist = new Journalist("Sam Smith", publisher);
		publisherRepository.save(publisher);
		journalistRepository.save(journalist);
	}

}
