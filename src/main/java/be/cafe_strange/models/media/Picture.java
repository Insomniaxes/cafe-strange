package be.cafe_strange.models.media;

import be.cafe_strange.enums.MediaType;
import be.cafe_strange.models.Category;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("0")
public class Picture extends Media {

    public Picture() {
    }

    public Picture(String title, String caption, String url, Category category, boolean aproved) {
        super(title, caption, url, MediaType.PICTURE, category, aproved);
    }

}
