package Objeto.Hotel;

public class Reserva {
    private String hospede;
    private String checkIn;
    private String checkOut;
    private String tipoQuarto;

    public Reserva(String hospede, String checkIn, String checkOut, String tipoQuarto) {
        this.hospede = hospede;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.tipoQuarto = tipoQuarto;
    }

    public String getHospede() {
        return hospede;
    }

    public void setHospede(String hospede) {
        this.hospede = hospede;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(String tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    @Override
    public String toString() {
        return String.format("Reserva [Hóspede=%s, Check-in=%s, Check-out=%s, Tipo de Quarto=%s]", hospede, checkIn, checkOut, tipoQuarto);
    }
}
