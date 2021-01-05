package jackalexmark.newsaggregator.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stories")
public class Story  {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    @JsonIgnoreProperties({"story"})
    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
    private List<Source> sources;

    @JsonIgnoreProperties({"story"})
    @OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
    private List<Tag> tags;

    public Story(String title){
        this.title = title;
    }

    public Story(){

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

    public List<Source> getSources() {
        return sources;
    }

    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
