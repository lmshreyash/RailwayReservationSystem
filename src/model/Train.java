package model;

public class Train {
    private String id;
    private String name;
    private String source;
    private String destination;

    public Train(String id, String name, String source, String destination) {
        this.id = id;
        this.name = name;
        this.source = source;
        this.destination = destination;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }

    public void setName(String name) { this.name = name; }
    public void setSource(String source) { this.source = source; }
    public void setDestination(String destination) { this.destination = destination; }

    @Override
    public String toString() {
        return id + "," + name + "," + source + "," + destination;
    }

    public static Train fromString(String data) {
        String[] parts = data.split(",");
        if (parts.length == 4) {
            return new Train(parts[0], parts[1], parts[2], parts[3]);
        }
        return null;
    }
}