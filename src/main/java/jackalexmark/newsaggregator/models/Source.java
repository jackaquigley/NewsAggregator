package jackalexmark.newsaggregator.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="sources")
//this is our class declaration it tells us what our class is and what word we'd use to call this class
public class Source implements Serializable {

    @Id
    @GeneratedValue
//    this section declares that the source object has a property id which is of type Long, the annotations connect
//    the property to our database and mean that each time a source object is saved, it has a unique id
    private Long id;

    @Column(name ="sourceTitle")
    private String sourceTitle;

    @Column(name ="sourceImg")
    private String sourceImg;

    @Column(name ="sourceLink")
    private String sourceLink;

    // this is our constructor - it builds the object with the class Source
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
