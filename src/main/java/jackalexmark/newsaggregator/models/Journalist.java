package jackalexmark.newsaggregator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="journalists")
public class Journalist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties(value="journalists")
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Publisher publisher;

    @JsonIgnoreProperties(value = "journalist")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "journalists_stories",
            joinColumns = {@JoinColumn(name = "journalist_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name="story_id", nullable = false, updatable = false)}
    )
    private List<Story> stories;

    public Journalist(String name, Publisher publisher) {
        this.name = name;
        this.publisher = publisher;
        this.stories = new ArrayList<Story>();
    }

    public Journalist() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Story> getStories() {
        return stories;
    }

    public void setStories(List<Story> stories) {
        this.stories = stories;
    }

    public void addStory(Story story){
        this.stories.add(story);
    }
}
