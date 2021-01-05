package jackalexmark.newsaggregator.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnoreProperties({"tags"})
    @ManyToOne
    @JoinColumn(name = "story_id", nullable = false)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Story story;

    public Tag(String name, Story story){
        this.name = name;
        this.story = story;
    }

    public Tag(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return name;
    }

    public void setTagName(String name) {
        this.name = name;
    }

    public Story getStory(){
        return story;
    }

    public void setStory(Story story){
        this.story = story;
    }
}
