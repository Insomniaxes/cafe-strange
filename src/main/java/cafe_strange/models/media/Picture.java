package cafe_strange.models.media;

import cafe_strange.enums.MediaType;
import cafe_strange.models.extra.Category;

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
