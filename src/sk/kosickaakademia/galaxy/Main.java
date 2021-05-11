package sk.kosickaakademia.galaxy;

public class Main {
    public static void main(String[] args) {
        Sun sun = Sun.getInstance();

        Planet earth = new Planet("Earth",1);
        Planet saturn = new Planet("Saturn",9.5);
        Planet mars = new Planet("Mars",1.5);

        sun.addPlanet(earth);
        sun.addPlanet(saturn);
        sun.addPlanet(mars);
    }
}
