package structural.proxy;


public class TwitterSeviceStub implements TwitterService{

    public String getTimeline(String screenName) {
        return "My neato timeline";
    }

    public void postToTimeline(String screenName, String message) {

    }
}
