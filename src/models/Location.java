package models;

import java.util.UUID;

public class Location {
    private String block;
    private int floor;
    private String series;
    private UUID id;

    public Location (String block, int floor, String series){
        this.block = block;
        this.floor = floor;
        this.series = series;
        this.id = UUID.randomUUID();
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

    public String getId(){
        return this.id.toString();
    }

    public String getLocationName(){
        return block + "-" + String.valueOf(floor) + this.series;
    }

    public Object getLocation() {
        return null;
    }

	public String getBlock() {
		return this.block.toString();
	}
}
