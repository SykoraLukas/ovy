package semestralka;

/**
 *  Trida zpracovavajici vsechny mozna reseni
 *
 *  @author Lukas Sykora
 */
public class Combination {
    private int Polo;
    private int Up;
    private int Fabia;
    private int Rapid;
    private int Citigo;
    private int Ibiza;
    private int Mii;
    private int Caddy;
    private int Transporter;
    private int Caravelle;
    private double costs;

    Combination(int polo, int up, int fabia, int rapid, int citigo, int ibiza, int mii, int caddy, int transporter, int caravelle) {
        Polo = polo;
        Up = up;
        Fabia = fabia;
        Rapid = rapid;
        Citigo = citigo;
        Ibiza = ibiza;
        Mii = mii;
        Caddy = caddy;
        Transporter = transporter;
        Caravelle = caravelle;
    }

    public void setCosts(double conts) {
        this.costs = conts;
    }

    private int getPolo() {
        return Polo;
    }

    private int getUp() {
        return Up;
    }

    private int getFabia() {
        return Fabia;
    }

    private int getRapid() {
        return Rapid;
    }

    private int getCitigo() {
        return Citigo;
    }

    private int getIbiza() {
        return Ibiza;
    }

    private int getMii() {
        return Mii;
    }

    private int getCaddy() {
        return Caddy;
    }

    private int getTransporter() {
        return Transporter;
    }

    private int getCaravelle() {
        return Caravelle;
    }

    public double getCosts() {
        return costs;
    }

    @Override
    public String toString() {
        return "{" + Polo + Up + Fabia + Rapid + Citigo + Ibiza + Mii + Caddy + Transporter + Caravelle + "}";
    }

    public String print(String[] cars) {
        StringBuilder retval = new StringBuilder();
        for (String car : cars) {
            if (getValue(car) > 0) {
                retval.append(" ").append(getValue(car)).append("x ").append(car);
            }
        }
        return retval.toString();
    }

    public int getValue(String name){
        switch(name) {
            case "Polo":
                return getPolo();
            case "Up":
                return getUp();
            case "Fabia":
                return getFabia();
            case "Citigo":
                return  getCitigo();
            case "Rapid":
                return getRapid();
            case "Ibiza":
                return getIbiza();
            case "Mii":
                return  getMii();
            case "Transporter":
                return getTransporter();
            case "Caddy":
                return getCaddy();
            case "Caravelle":
                return getCaravelle();
            default:
                return 0;
        }
    }
}
