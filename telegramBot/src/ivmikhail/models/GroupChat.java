package ivmikhail.models;

public class GroupChat {
    //    id	Integer	Unique identifier for this group chat
    private long id;
    //    title	String	Group name
    private String title;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
