package entity;

/**
 * Created by user on 10/07/2016.
 */
public class ParamsData {
    private int noiseFloor;
    private int roomPropose;
    private int length;
    private int width;
    private int high;
    private String installation;
    private String speaker;
    private String amplifier;

    public ParamsData()
    {}

    public int NoiseFloor() {
        return noiseFloor;
    }

    public void NoiseFloor(int noiseFloor) {
        this.noiseFloor = noiseFloor;
    }

    public int RoomPropose() {
        return roomPropose;
    }

    public void RoomPropose(int roomPropose) {
        this.roomPropose = roomPropose;
    }

    public int Length() {
        return length;
    }

    public void Length(int length) {
        this.length = length;
    }

    public int Width() {
        return width;
    }

    public void Width(int width) {
        this.width = width;
    }

    public int High() {
        return high;
    }

    public void High(int high) {
        this.high = high;
    }

    public String Installation() {
        return installation;
    }

    public void Installation(String installation) {
        this.installation = installation;
    }

    public String Speaker() {
        return speaker;
    }

    public void Speaker(String speakerName) {
        this.speaker = speakerName;
    }

//    public int Speaker() {
//        return speaker;
//    }
//
//    public void Speaker(int id) {
//        this.speaker = id;
//    }

    public String Amplifier() {
        return amplifier;
    }

    public void Amplifier(String amplifier) {
        this.amplifier = amplifier;
    }
}
