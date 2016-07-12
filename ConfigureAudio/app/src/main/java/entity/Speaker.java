package entity;

/**
 * Created by user on 07/07/2016.
 */
public class Speaker {
    private int id;
    private String name;
    private String line;
    private String quality;
    private String installation;
    private int coverage;
    private int sensitivity;
    private String stereo;
    private String plenum;
    private int qty;
    private double inches;
    private boolean powered;

    public Speaker(int id, String name, String stereo, String plenum) {
        this.id = id;
        this.name = name;
        this.stereo = stereo;
        this.plenum = plenum;
    }

    public int Id() {
        return id;
    }

    public void Id(int id) {
        this.id = id;
    }

    public String Name() {
        return name;
    }

    public void Name(String name) {
        this.name = name;
    }

    public String Stereo() {
        return stereo;
    }

    public void Stereo(String stereo) {
        this.stereo = stereo;
    }

    public String Plenum() {
        return plenum;
    }

    public void Plenum(String plenum) {
        this.plenum = plenum;
    }
}
