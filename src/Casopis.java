import java.util.ArrayList;
import java.util.List;

public class Casopis {

    private String issn;
    private String naziv;
    private List<NaucniRad> radovi = new ArrayList<>();

    public Casopis(String issn, String naziv) {
        this.issn = issn;
        this.naziv = naziv;
    }

    public boolean dodajRad(NaucniRad a){
        if(!radovi.contains(a)) {
            radovi.add(a);
            return true;
        }
        return false;
    }


    public String getIssn() {return issn;}
    public void setIssn(String issn) {this.issn = issn;}

    public String getNaziv() {return naziv;}
    public void setNaziv(String naziv) {this.naziv = naziv;}

    public List<NaucniRad> getRadovi() {return radovi;}
    public void setRadovi(List<NaucniRad> radovi) {this.radovi = radovi;}
}
