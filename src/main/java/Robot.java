import java.time.LocalDate;

public abstract class Robot {

    private String name;
    private String fabricante;
    private int anyo;
    private LocalDate fechaRegistro;

    public Robot(String name, String fabricante, int anyo) {
        this.name = name;
        this.fabricante = fabricante;
        this.anyo = anyo;
        this.fechaRegistro = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public String getFabricante() {
        return fabricante;
    }

    public int getAnyo() {
        return anyo;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public abstract String getTechnicalDescription();

}
