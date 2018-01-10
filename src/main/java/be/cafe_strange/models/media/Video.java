package be.cafe_strange.models.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.Category;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Video extends Media {

    public Video() {
    }

    public Video(String title, String caption, String url, Category category, boolean aproved) {
        super(title, caption, url, MediaType.VIDEO, category, aproved);
    }

}
