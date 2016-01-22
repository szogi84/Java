package creational.factory;

/**
 * Created by sczerwinski on 2016-01-19.
 */
public class Blog extends Website{

    @Override
    protected void createWebsite() {
        pages.add(new PostPage());
        pages.add(new AboutPage());
        pages.add(new CommentPage());
        pages.add(new ContactPage());
    }
}
