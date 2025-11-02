package challenge;

public class Place {
    private String name;
    private int distanceFromSydney;

    public Place(String name, int distanceFromSydney) {
        this.name = name;
        this.distanceFromSydney = distanceFromSydney;
    }

    public String getName() {
        return name;
    }

    public int getDistanceFromSydney() {
        return distanceFromSydney;
    }

    @Override
    public String toString() {
        return name + " (" + distanceFromSydney + " km)";
    }
}
