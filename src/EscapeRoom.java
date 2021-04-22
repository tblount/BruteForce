

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class EscapeRoom implements EscapeRoomInterface {

    Map<String, Playable> escapeRooms = new HashMap<>();
    Map<String, Room> innerRooms = new HashMap<>();
    Map<String, List<Actor>> actors = new HashMap<>();
    Map<String, List<String>> descriptions = new HashMap<>();

    public EscapeRoom ()throws IOException {
        this.load();

    }
    public void load() throws IOException {

        String roomPath = "Brute/data/RoomData.csv";
        Path descriptionPath = Path.of("Brute/data/Descriptions.csv");
        Files.readAllLines(Paths.get(roomPath), StandardCharsets.UTF_8).forEach(roomData -> {
            String[] roomDataCells = roomData.split(" : ");
            String gameName = roomDataCells[0];
            String roomName = roomDataCells[1];
            List<String> roomItems = Arrays.stream(roomDataCells[2].split(" ~ ")).collect(Collectors.toList());
            List<String> roomUsefulItems = Arrays.stream(roomDataCells[3].split(" ~ ")).collect(Collectors.toList());
            List <String> actorNames = Arrays.stream(roomDataCells[4].split(" ~ ")).collect(Collectors.toList());
            System.out.println(actorNames);
            List<String> scripts = Arrays.stream(roomDataCells[5].split(" - ")).collect(Collectors.toList());

            List<Actor> listActors = new ArrayList<>();
            for(int i =0 ; i<actorNames.size()-1;i++){
                List<String> script = Arrays.stream(scripts.get(i).split(" ~ ")).collect(Collectors.toList());
                listActors.add(new Actor(actorNames.get(i),script));
            }
            Room currentRoom = new Room(roomName,roomItems,roomUsefulItems,listActors);
            this.innerRooms.put(gameName + " : " + roomName,currentRoom);
        });

        System.out.println(this.innerRooms);

    }

    void generateEscapeRooms() throws IOException {
        escapeRooms.put("Space Odyssey", new SpaceOdyssey().playable());
        escapeRooms.put("Crazy Stans", new CrazyStans().playable());
        escapeRooms.put("Jonin Exams", new JoninExams().playable());
    }

    Map<String, Playable> getEscapeRooms() {
        return escapeRooms;
    }

    EscapeRoom getEscapeRoom(String room) {
        Map<String, Playable> playables = getEscapeRooms();
        return playables.get(room).getEscapeRoom();
    }

    public static void main(String[] args) throws IOException {
        EscapeRoom yoo = new EscapeRoom();
        System.out.println(yoo.innerRooms.get("SpaceOdyssey : Kitchen").getItems());
        System.out.println(yoo.innerRooms.get("SpaceOdyssey : Kitchen").getUsefulItems());
        System.out.println(yoo.innerRooms.get("SpaceOdyssey : Kitchen").getActors());
        yoo.innerRooms.get("SpaceOdyssey : Kitchen").getActors();


    }
}