package tryout.builder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class MovieBuilder implements PresentationBuilder {
    Movie movie = new Movie();

    @Override
    public void addSlide(String content) {
        movie.addFrame(content);
    }

    public Movie getMovie() {
        return movie;
    }
}

@ToString
class Movie {
    List<Frame> frame = new ArrayList<>();

    public void addFrame(String text) {
        frame.add(new Frame(text, 3));
    }
}

@AllArgsConstructor
@Getter
@Setter
@ToString
class Frame {
    String text;
    int time;
}