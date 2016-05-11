package entity;

/**
 * Created by ליברמן on 18/04/2016.
 */
public class Fact {
    private int id;
    private String title;
    private String contentText;

    public Fact(int id, String title, String contentText) {
        this.id = id;
        this.title = title;
        this.contentText = contentText;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContentText() {
        return contentText;
    }

    public void setContentText(String contentText) {
        this.contentText = contentText;
    }
}
