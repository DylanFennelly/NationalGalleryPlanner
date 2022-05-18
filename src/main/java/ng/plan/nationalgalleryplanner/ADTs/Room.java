package ng.plan.nationalgalleryplanner.ADTs;

import javafx.scene.image.Image;

public class Room {
    public String name, roomNo, description;
    public Image image;

    public Room(String name, String roomNo, String description, Image image){
        this.name = name;
        this.roomNo = roomNo;
        this.description = description;
        this.image = image;
    }
}
