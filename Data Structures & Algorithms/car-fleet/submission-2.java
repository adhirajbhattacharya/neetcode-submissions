class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        return carFleetBySort(target, position, speed);
        // return carFleetByStack(target, position, speed);
    }

    int carFleetBySort(int target, int[] position, int[] speed) {
        int n = position.length;

        Car[] cars = new Car[n];
        for (int i = 0; i < n; i++) {
            cars[i] = new Car(position[i], speed[i]);
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = 1D * (target - cars[i].position) / cars[i].speed;
        }

        int fleet = 1;
        double curr = time[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (Double.compare(curr, time[i]) >= 0) continue;
            fleet++;
            curr = time[i];
        }

        return fleet;
    }
}

class Car {
    int position;
    int speed;

    Car(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }
}