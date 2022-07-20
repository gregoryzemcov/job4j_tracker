package ru.job4j.poly;

public class StartVehicle {
    public static void main(String[] args) {
        Vehicle turkey = new Airplane();
        Vehicle rostov = new Train();
        Vehicle wolksvagen = new Minibus();
        Vehicle egypt = new Airplane();
        Vehicle kazan = new Train();
        Vehicle ford = new Minibus();
        Vehicle[] vehicles = new Vehicle[] {turkey, rostov, wolksvagen, egypt, kazan, ford};
        for (Vehicle v: vehicles) {
            v.move();
        }
    }
}
