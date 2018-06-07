package semestralka;

/**
 *  Definice automobilu
 *
 *  @author Lukas Sykora
 */
public class Car {
    private String name;
    private String type;
    private int price;
    private double costs;
    private double consumption;
    private double amortization;

    Car(String name, String type, int price, double costs, double consumption) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.costs = costs;
        this.consumption = consumption;
        this.amortization = price*(1-0.15)/5;
    }

    public double getAmortization() {
        return amortization;
    }

    public String getType() {
        return type;
    }

    public double getCosts() {
        return costs;
    }

    public double getConsumption() {
        return consumption;
    }
}
