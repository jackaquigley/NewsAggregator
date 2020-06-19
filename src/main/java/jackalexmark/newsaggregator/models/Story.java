package jackalexmark.newsaggregator.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stories")
public class Story implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "title")
    private String title;

    public Story(String title){
        this.title = title;
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
}
