package structural.bridge.movie;


public class MovieBridgeDemo {

    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setClassification("Action");
        movie.setTitle("John Woick");
        movie.setRuntime("2:15");
        movie.setYear("2014");

        Formatter printFormatter = new PrintFormatter();
        Printer moviePrinter = new MoviePrinter(movie);

        String printedMaterial = moviePrinter.print(printFormatter);
        System.out.println(printedMaterial);

//        Formatter htmlFormatter = new HtmlFormatter();
//        String htmlMaterial = moviePrinter.print(htmlFormatter);
//        System.out.println(htmlMaterial);

    }






}
