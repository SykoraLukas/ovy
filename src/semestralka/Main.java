package semestralka;

import java.util.LinkedList;
import java.util.List;

/**
 *  Program k nalezeni optimalniho vozoveho parku interni posty
 *
 *  @author Lukas Sykora
 */
public class Main {

    public static void main(String[] args) {

        double countOfKm = 86;
        double priceFuel = 31.9;

        String[] cars = {"Polo", "Up", "Fabia", "Citigo", "Rapid", "Ibiza", "Mii", "Caddy", "Transporter", "Caravelle"};

        //definovani automobilu, ze kterych firma vybira
        List<Car> listOfCar = createCar();

        //nalezeni vsech pripustnych reseni
        List<Combination> allCombinations = createCombination();

        //vycisleni nakladu pro vsechny pripusne reseni
        Costs costs = new Costs(listOfCar, allCombinations, countOfKm, priceFuel);
        costs.setCosts(cars);

        //nalezeni optimalniho reseni (minimalni naklady)
        Combination comb = getMinimumCosts(allCombinations);

        System.out.println("Lowest combination is:" + comb.print(cars) + " and the value is: " + comb.getCosts() + ".");
        }

    private static Combination getMinimumCosts(List<Combination> allCombinations) {
        Combination lowestCombination = null;
        double lowestCombinationValue = 1000000000;
        for (Combination combination : allCombinations) {
            if (combination.getCosts() < lowestCombinationValue) {
                lowestCombination = combination;
                lowestCombinationValue = combination.getCosts();
            }
        }
        return lowestCombination;
    }

    private static List<Combination> createCombination() {
        List<Combination> allCombinations = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; i + j < 5; j++) {
                for (int k = 0; i + j + k < 5; k++) {
                    for (int l = 0; i + j + k + l < 5; l++) {
                        for (int m = 0; i + j + k + l + m < 5; m++) {
                            for (int n = 0; i + j + k + l + m + n < 5; n++) {
                                for (int o = 0; i + j + k + l + m + n + o < 5; o++) {
                                    for (int p = 0; p < 6; p++) {
                                        for (int q = 0; p + q < 6; q++) {
                                            for (int r = 0; p + q + r < 6; r++) {
                                                if (i +  j +  k + l + m + n + o + p + q + r == 5) {
                                                    allCombinations.add(new Combination(i, j, k, l, m, n, o, p, q, r));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return allCombinations;
    }

    private static List<Car> createCar() {
        List<Car> listOfCar = new LinkedList<>();
        listOfCar.add(new Car("Volkswagen", "Polo", CONSTANTS.VOLKSWAGEN_POLO_CENA, CONSTANTS.VOLKSWAGEN_POLO_NAKLADY, CONSTANTS.VOLKSWAGEN_POLO_SPOTREBA));
        listOfCar.add(new Car("Volkswagen", "Up", CONSTANTS.VOLKSWAGEN_UP_CENA, CONSTANTS.VOLKSWAGEN_UP_NAKLADY, CONSTANTS.VOLKSWAGEN_UP_SPOTREBA));
        listOfCar.add(new Car("Skoda", "Fabia", CONSTANTS.SKODA_FABIA_CENA, CONSTANTS.SKODA_FABIA_NAKLADY, CONSTANTS.SKODA_FABIA_SPOTREBA));
        listOfCar.add(new Car("Skoda", "Citigo", CONSTANTS.SKODA_CITIGO_CENA, CONSTANTS.SKODA_CITIGO_NAKLADY, CONSTANTS.SKODA_CITIGO_SPOTREBA));
        listOfCar.add(new Car("Skoda", "Rapid", CONSTANTS.SKODA_RAPID_CENA, CONSTANTS.SKODA_RAPID_NAKLADY, CONSTANTS.SKODA_RAPID_SPOTREBA));
        listOfCar.add(new Car("Seat", "Ibiza", CONSTANTS.SEAT_IBIZA_CENA, CONSTANTS.SEAT_IBIZA_NAKLADY, CONSTANTS.SEAT_IBIZA_SPOTREBA));
        listOfCar.add(new Car("Seat", "Mii", CONSTANTS.SEAT_MII_0CENA, CONSTANTS.SEAT_MII_NAKLADY, CONSTANTS.SEAT_MII_SPOTREBA));
        listOfCar.add(new Car("Volkswagen", "Caddy", CONSTANTS.VOLKSWAGEN_CADDY_CENA, CONSTANTS.VOLKSWAGEN_CADDY_NAKLADY, CONSTANTS.VOLKSWAGEN_CADDY_SPOTREBA));
        listOfCar.add(new Car("Volkswagen", "Transporter", CONSTANTS.VOLKSWAGEN_TRANSPORTER_CENA, CONSTANTS.VOLKSWAGEN_TRANSPORTER_NAKLADY, CONSTANTS.VOLKSWAGEN_TRANSPORTER_SPOTREBA));
        listOfCar.add(new Car("Volkswagen", "Caravelle", CONSTANTS.VOLKSWAGEN_CARAVELLE_CENA, CONSTANTS.VOLKSWAGEN_CARAVELLE_NAKLADY, CONSTANTS.VOLKSWAGEN_CARAVELLE_SPOTREBA));
        return listOfCar;
    }
}
