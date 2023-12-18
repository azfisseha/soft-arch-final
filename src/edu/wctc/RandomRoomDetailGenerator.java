package edu.wctc;

import java.util.Random;

//could swap this out for a class that uses a csv or some other file, a DB, etc.
public class RandomRoomDetailGenerator implements RandomDetailGenerator {
    private Random rand = new Random();

    private String[][] roomLib = {
            {"LIBRARY","The walls of this room are lined with bookshelves holding dusty tomes.  There is a small desk in the corner, with nothing on it but a long spiderweb reaching up to the rafters."},
            {"MUSEUM","Small pedestals are scattered across the room, holding objects that appear to be utterly worthless. A museum of junk."},
            {"BEDROOM","There is a large bed in the center of this room, and a wardrobe that has been left open and clearly ransacked."},
            {"COURTYARD", "Sunlight streams into this open-air courtyard.  There is a small fountain in the center, and a path lined with well-kept greenery."},
            {"HALLWAY","A long and narrow hallway leading elsewhere."},
            {"LABORATORY","Several tables in this room are lined with vials and flasks. Their contents are unidentifiable, but many of them are bubbling."},
            {"KTICHEN","A simple kitchen with pots and pans hanging from the ceiling over a small island.  Someone left the sink running, but there are no handles to turn it off."},
            {"DINING HALL","A massive chamber of a room with a grand table that seats dozens.  This dining hall has already been set for dinner - the only thing left is the food."},
            {"OBSERVATORY","A grand telescope points straight up to a small window in the ceiling.  The eyepiece is broken, you observe, rendering this observatory useless."}
    };

    public String[] generate()
    {
        return roomLib[rand.nextInt(roomLib.length)];
    }
}
