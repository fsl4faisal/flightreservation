package tryout.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Presentation {
    List<Slide> slides = new ArrayList<>();

    public void addSlides(String text) {
        slides.add(new Slide(text));
    }

    public void export(PresentationBuilder builder) {
        for (Slide slide : slides)
            builder.addSlide(slide.getContent());
    }


}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Slide {
    String content;
}
