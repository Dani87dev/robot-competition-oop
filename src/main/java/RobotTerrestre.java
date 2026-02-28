import java.time.LocalDate;

public class RobotTerrestre extends Robot implements ResistanceEvaluable {

    private int velocidadMaxima;
    private Traccion tipoDeTraccion;


    public enum Traccion {RUEDAS, ORUGA}


    public RobotTerrestre(String name, String fabricante, int anyo, int velocidadMaxima, Traccion tipoDeTraccion) {
        super(name, fabricante, anyo);
        this.velocidadMaxima = velocidadMaxima;
        this.tipoDeTraccion = tipoDeTraccion;

    }

    public int getVelocidadMaxima() {
        return this.velocidadMaxima;
    }

    public Traccion getTipoDeTraccion(){
        return this.tipoDeTraccion;
    }


    @Override
    public String getTechnicalDescription() {
        return super.getName() + " fabricado por " + super.getFabricante() + " en " + super.getAnyo() + ", usa tracción " + this.tipoDeTraccion + " y alcanza hasta " + this.velocidadMaxima + " km/h.";
    }

    @Override
    public String getResistanceReport() {
        String apto = (this.tipoDeTraccion == Traccion.RUEDAS)?"No es apto para la competición":"Es apto para la competición";

        return super.getName() + " traccion " + this.getTipoDeTraccion() + "confirmada." + apto;
    }
}
