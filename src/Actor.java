import java.util.ArrayList;
import java.util.List;

class Actor {
    String name;
    List<String> lines;
    public Actor(String name, List<String> lines){
        this.name = name;
        this.lines = lines;
    }
    public void talk(int line){
        System.out.println(lines.get(line));
    }
    public void addLine(String line){
        this.lines.add(line);
    }
    public void addLines(List<String> lines){
        this.lines.addAll(lines);
    }

    public static void main(String[] args) {
        List <String> randomLines = new ArrayList<>();
        randomLines.add("stuff");
        randomLines.add("stuff44");
        randomLines.add("stuff88");
        Actor paul = new Actor("Paul",new ArrayList<>());
        paul.addLines(randomLines);
        paul.talk(0);
        paul.talk(1);
        paul.talk(2);
    }
}