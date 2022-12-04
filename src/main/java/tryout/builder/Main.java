package tryout.builder;

public class Main {
    public static void main(String[] args) {
        Presentation presentation = new Presentation();
        presentation.addSlides("Slide 1");
        presentation.addSlides("Slide 2");
        presentation.addSlides("Slide 3");
        var builder = new MovieBuilder();
        presentation.export(builder);
        var movie = builder.getMovie();
        System.out.println(movie);

    }
}
