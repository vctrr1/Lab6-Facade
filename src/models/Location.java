package models;

public class Location {
    private String block;
    private int floor;
    private String series;

    public Location (String block, int floor, String series){
        this.block = block;
        this.floor = floor;
        this.series = series;
    }

    public void setBlock(String block){
        this.block = block;
    }

    public void setFloor(int floor){
        this.floor = floor;
    }

    public void setSeries(String series){
        this.series = series;
    }

    public String getLocationName(){
        return block + "-" + String.valueOf(floor) + this.series;
    }
}
