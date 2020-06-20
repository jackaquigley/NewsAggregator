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
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 3);
		assertEquals("Pub chain has no choice but to open on 4th July", source.getSourceTitle());
	}

	@Test
	public void canGetSourceImg(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 12);
		assertEquals("https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", source.getSourceImg());
	}

	@Test
	public void canGetSourceLink(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 18);
		assertEquals("https://www.bbc.co.uk/news/business-53094134", source.getSourceLink());
	}

	@Test
	public void canGetSourceRating(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 18);
		assertEquals(18, source.getRating());
	}

	@Test
	public void canIncreaseSourceRating(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 18);
		assertEquals(19, source.increaseRating());
	}

	@Test
	public void canDecreaseSourceRating() {
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source("Pub chain has no choice but to open on 4th July", "https://ichef.bbci.co.uk/news/660/cpsprodpb/13A84/production/_112961508_oakmaninnsscreenshot.jpg", "https://www.bbc.co.uk/news/business-53094134", story, 18);
		assertEquals(17, source.decreaseRating());
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
		Story story = new Story("Title");
		Journalist journalist = new Journalist("Sam Smith", publisher);
		publisherRepository.save(publisher);
		journalistRepository.save(journalist);
	}

	@Test
	public void canCreateAndSaveSource(){
		Story story = new Story("Pub chain has no choice but to open on 4th July");
		Source source = new Source ("The Sun", "Image Link", "Source Link", story, 22);
		sourceRepository.save(source);
	}

	@Test
	public void canCreateAndSaveStory(){
		Story story = new Story("HeadLine");
		storyRepository.save(story);
	}

	@Test
	public void canAddJournalistToStory(){
		Publisher publisher = new Publisher("Financial Times");
		publisherRepository.save(publisher);
		Story story = new Story("Title");
		storyRepository.save(story);
		Journalist journalist = new Journalist("Sam Smith", publisher);
		journalistRepository.save(journalist);

		story.addJournalist(journalist);
		journalist.addStory(story);
		journalistRepository.save(journalist);
		storyRepository.save(story);
	}

}
