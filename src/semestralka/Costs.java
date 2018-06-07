package semestralka;

import java.util.List;

/**
 *  Trida, ktera pracuje s naklady
 *
 *  @author Lukas Sykora
 */
public class Costs {

    private List<Car> listOfCar;
    private List<Combination> allCombinations;
    private double km;
    private double priceFuel;

    Costs(List<Car> listOfCar, List<Combination> allCombinations, double km, double priceFuel) {
        this.listOfCar = listOfCar;
        this.allCombinations = allCombinations;
        this.km = km;
        this.priceFuel = priceFuel;
    }

    public void setCosts(String[] cars) {
        Car car;
        for (Combination comb : this.allCombinations) {
            double costs = 0;
            for (String car1 : cars) {
                for (Car aListOfCar : listOfCar) {
                    car = aListOfCar;
                    if (car1.equalsIgnoreCase(car.getType())) {
                        int cost = comb.getValue(car1);
                        costs += countCosts(km, priceFuel, cost, car);
                    }
                }
            }
            comb.setCosts(costs);
        }
    }

    private double countCosts(double km, double priceFuel, int count, Car car) {
        double costs = 0;
        if (count > 0) {
            costs += car.getAmortization();
            costs += count * 50 * (fuelCosts(km, car.getConsumption(), priceFuel) + getOtherCosts(km, car.getCosts()));
        }
        return  costs;
    }

    private double getOtherCosts(double km, double consumption) {
        return km * consumption;
    }

    private double fuelCosts(double km, double consumption, double priceFuel) {
        return km / 100 * consumption * priceFuel;
    }
}
