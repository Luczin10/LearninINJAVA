public class Tranporte {
    private String modal;
    private int capacidadeEmL;
    private String placa;
    private int capacidadeEmKg;

    public Tranporte(String modal, int capacidadeEmL, String placa, int capacidadeEmKg) {
        if (capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();

        this.modal = modal;
        this.capacidadeEmL = capacidadeEmL;
        this.placa = placa;
        this.capacidadeEmKg = capacidadeEmKg;
    }

    public String getModal() {
        return modal;
    }

    public void setModal(String modal) {
        this.modal = modal;
    }

    public int getCapacidadeEmL() {
        return capacidadeEmL;
    }

    public void setCapacidadeEmL(int capacidadeEmL) {
        if (capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();
        this.capacidadeEmL = capacidadeEmL;
    }

    public String getPlaca() {
        return placa + "-";
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidadeEmKg() {
        return capacidadeEmKg;
    }

    public void setCapacidadeEmKg(int capacidadeEmKg) {
        if (capacidadeEmKg < 0 || capacidadeEmL < 0)
            throw new IllegalArgumentException();
        this.capacidadeEmKg = capacidadeEmKg;
    }

    @Override
    public String toString() {
        return "Tranporte{" +
                "modal='" + modal + '\'' +
                ", capacidadeEmL=" + capacidadeEmL +
                ", placa='" + placa + '\'' +
                ", capacidadeEmKg=" + capacidadeEmKg +
                '}';
    }
}
