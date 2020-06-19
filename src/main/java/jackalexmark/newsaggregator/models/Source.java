package jackalexmark.newsaggregator.models;

import java.io.Serializable;

public class Source implements Serializable {

    private Long id;
    private String sourceTitle;
    private String sourceImg;
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
