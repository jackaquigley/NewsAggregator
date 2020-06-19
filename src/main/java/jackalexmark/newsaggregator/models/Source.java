package jackalexmark.newsaggregator.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="sources")
public class Source implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name ="sourceTitle")
    private String sourceTitle;

    @Column(name ="sourceImg")
    private String sourceImg;

    @Column(name ="sourceLink")
    private String sourceLink;

    public Source(String sourceTitle, String sourceImg, String sourceLink){
        this.sourceTitle = sourceTitle;
        this.sourceImg = sourceImg;
        this.sourceLink = sourceLink;
    }

    public String getSourceTitle() {
        return sourceTitle;
    }

    public void setSourceTitle(String sourceTitle) {
        this.sourceTitle = sourceTitle;
    }

    public String getSourceImg() {
        return sourceImg;
    }

    public void setSourceImg(String sourceImg) {
        this.sourceImg = sourceImg;
    }

    public String getSourceLink() {
        return sourceLink;
    }

    public void setSourceLink(String sourceLink) {
        this.sourceLink = sourceLink;
    }
}
