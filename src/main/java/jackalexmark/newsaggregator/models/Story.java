package jackalexmark.newsaggregator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stories")
public class Story implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnoreProperties(value = "journalists_stories")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            joinColumns = {@JoinColumn(name = "story_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "journalist_id", nullable = false, updatable = false)}
    )
    private List<Journalist> journalists;

    public Story(String title){
        this.title = title;
        this.journalists = new ArrayList<Journalist>();
    }

    public Story(){

    }

    public List<Journalist> getJournalists() {
        return journalists;
    }

    public void setJournalists(List<Journalist> journalists) {
        this.journalists = journalists;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addJournalist(Journalist journalist){
        this.journalists.add(journalist);
    }

}
