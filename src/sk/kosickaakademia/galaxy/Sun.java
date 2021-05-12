package sk.kosickaakademia.galaxy;

import java.util.*;

public class Sun {
    private static Sun instance;
    private Set<Planet> planets;

    private Sun() {
        planets = new HashSet<>();
    }

    public static Sun getInstance(){
        if (instance == null){
            instance = new Sun();
        }
        return instance;
    }

    public void addPlanet(Planet planet){
        planets.add(planet);
    }

    public Set<Planet> getPlanets(){
        return planets;
    }

    public void printPlanetNames(){
        System.out.println("List of all planets of sun:");
        /*for (Planet planet :
                planets) {
            System.out.println(planet.getName());
        }*/
        Iterator<Planet> iterator = planets.iterator();
        while (iterator.hasNext()){
            /*Planet planet = (Planet) iterator.next();
            System.out.println( planet.getName() );*/
            System.out.println(iterator.next().getName());
        }
        System.out.println("----------------------------");
    }

    public void printPlanetsWithStr(String str){
        System.out.println("List of planets with \"" + str + "\" in name:");

        for (Planet planet :
                planets) {
            if (planet.getName().toLowerCase().contains(str))
                System.out.println(planet.getName());
        }
        System.out.println("----------------------------");
    }

    public void findClosestToSun(){
        List<Planet> result = new ArrayList<>();
        for (Planet planet :
                planets) {
            if (result.isEmpty()){
                result.add(planet);
                continue;
            }
            if (planet.getDistanceFromSun() < result.get(0).getDistanceFromSun()){
                result.removeAll(new HashSet<>(result));
                result.add(planet);
            }
            if (planet.getDistanceFromSun() == result.get(0).getDistanceFromSun()){
                result.add(planet);
            }
        }

        // final result print
        for (Planet planet :
                result) {
            System.out.println(planet);
        }
    }
}
