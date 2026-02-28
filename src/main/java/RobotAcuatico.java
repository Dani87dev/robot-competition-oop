import java.time.LocalDate;

public class RobotAcuatico extends Robot {


    public enum Propulsion {HELICE, CHORRO}

    private int profundidadMaxima;
    private Propulsion propulsion;


    public RobotAcuatico(String name, String fabricante, int anyo, Propulsion propulsion, int profundidadMaxima) {
        super(name, fabricante, anyo);
        this.propulsion = propulsion;
        this.profundidadMaxima = profundidadMaxima;
    }

    @Override
    public String getTechnicalDescription() {
        return super.getName() + " alcanza una profundidad de" + this.profundidadMaxima + " m con propulsión tipo " + this.propulsion + " . Fabricado por " + super.getFabricante() + " en " + super.getAnyo() + ".";
    }
}
