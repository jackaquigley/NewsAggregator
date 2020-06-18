package jackalexmark.newsaggregator;

import jackalexmark.newsaggregator.models.Journalist;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NewsaggregatorApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetJournalistName(){
		Journalist journalist = new Journalist ("Bob Smith");
		assertEquals("Bob Smith", journalist.getName());
	}

}
