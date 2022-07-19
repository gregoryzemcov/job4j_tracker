package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public String driveStr() {
        return "Поехали";
    }

    @Override
    public int passInt(int pass) {
        int count = 0;
        while (count < 30) {
            count += pass;
        }
        return count;
    }

    @Override
    public int fuelInt(int fuel) {
        int coast = 55;
        return fuel * coast;
    }
}
