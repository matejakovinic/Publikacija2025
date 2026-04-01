import java.time.LocalDate;

public class Recenzija {

    private String tekst;
    private LocalDate datum;
    private int ocena;

    public Recenzija(String tekst, LocalDate datum, int ocena) {
        this.tekst = tekst;
        this.datum = datum;
        this.ocena = ocena;
    }

    public String getTekst() {return tekst;}
    public void setTekst(String teskt) {
        this.tekst = teskt;}

    public LocalDate getDatum() {return datum;}
    public void setDatum(LocalDate datum) {this.datum = datum;}

    public int getOcena() {return ocena;}
    public void setOcena(int ocena) {this.ocena = ocena;}
}
