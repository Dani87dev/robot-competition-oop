import java.time.LocalDate;

public class RobotAereo extends Robot implements ResistanceEvaluable {

    private int altitudMaxima;
    private int autonomia;

    public RobotAereo(String name, String fabricante, int anyo, int altitudMaxima, int autonomia) {
        super(name, fabricante, anyo);
        this.altitudMaxima = altitudMaxima;
        this.autonomia = autonomia;
    }

    @Override
    public String getTechnicalDescription() {
        return super.getName() + " vuela hasta " + this.altitudMaxima + " m durante" + this.autonomia + " minutos. Fabricado en " + super.getAnyo() + " por " + super.getFabricante() + ".";
    }

    public int getAutonomia() {
        return autonomia;
    }

    @Override
    public String getResistanceReport() {
        String apto = (this.getAutonomia() < 60)? "No es apto para la competición ":"Es apto para la competición ";

        return super.getName() + ": autonomía de " + this.getAutonomia() + " minutos." + apto;
    }
}
