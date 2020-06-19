package jackalexmark.newsaggregator.models;

import java.io.Serializable;

public class Story implements Serializable {

    private Long id;
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
