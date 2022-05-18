package ng.plan.nationalgalleryplanner.ADTs;

import javafx.scene.image.Image;

public class Room {
    public String name, roomNo, title, description;
    public Image image;

    public Room(String name, String roomNo, String title, String description, Image image){
        this.name = name;
        this.roomNo = roomNo;
        this.title = title;
        this.description = description;
        this.image = image;
    }
}
