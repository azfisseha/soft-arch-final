package edu.wctc;


public class Maze {
    private Room[][] maze;
    private RoomBuilder roomBuilder;

    private volatile static Maze uniqueInstance;

    private Maze (int rows, int cols){
        maze = new Room[rows][cols];
        roomBuilder = new RoomBuilder();
    }

    public static Maze getInstance(int rows, int cols)
    {
        if(uniqueInstance == null)
        {
            synchronized (Maze.class) {
                if(uniqueInstance == null)
                {
                    uniqueInstance = new Maze(rows,cols);
                }
            }
        }
        return uniqueInstance;
    }

    public Room constructMaze()
    {
        Room startingRoom = roomBuilder.buildStartingRoom();

        int rows = maze.length;
        int cols = maze[0].length;

        for(int x = 0; x < rows; x++)
        {
            for(int y = 0; y < cols; y++)
            {
                if(x == 0 && y == 0)
                {
                    maze[x][y] = startingRoom;
                }else {
                    maze[x][y] = roomBuilder.buildRandomRoom();
                }
            }
        }
        // Connect neighboring rooms
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                Room currentRoom = maze[x][y];
                Room neighbor;
                // Connect north
                if (x > 0) {
                    neighbor = maze[x - 1][y];
                    currentRoom.setAdjoiningRoom(Directions.NORTH, neighbor);
                }

                // Connect south
                if (x < rows - 1) {
                    neighbor = maze[x + 1][y];
                    currentRoom.setAdjoiningRoom(Directions.SOUTH, neighbor);
                }

                // Connect east
                if (y < cols - 1) {
                    neighbor = maze[x][y + 1];
                    currentRoom.setAdjoiningRoom(Directions.EAST, neighbor);
                }

                // Connect west
                if (y > 0) {
                    neighbor = maze[x][y - 1];
                    currentRoom.setAdjoiningRoom(Directions.WEST, neighbor);
                }
            }
        }
        return startingRoom;
    }
}
