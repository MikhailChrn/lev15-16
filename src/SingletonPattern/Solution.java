package SingletonPattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//lev15: Закрепляем паттерн Singleton

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;
    //add static block here - добавьте статический блок тут
    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException exIO) {}
    }

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        thePlanet = null;
        if (str.equals(Planet.SUN)) thePlanet = Sun.getInstance();
        if (str.equals(Planet.MOON)) thePlanet = Moon.getInstance();
        if (str.equals(Planet.EARTH)) thePlanet = Earth.getInstance();
    }
}
