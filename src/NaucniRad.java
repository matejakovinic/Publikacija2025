import java.util.ArrayList;
import java.util.List;

public class NaucniRad extends Publikacija {

    private Casopis casopis;
    private List<Autor> autori = new ArrayList<>();

    public NaucniRad(String doi, String naslov, int godinaIzdanja, Casopis casopis) {
        super(doi, naslov, godinaIzdanja);
        this.casopis = casopis;
    }

    public NaucniRad(String doi, String naslov, int godinaIzdanja, Casopis casopis, List<Autor> autori) {
        super(doi, naslov, godinaIzdanja);
        this.casopis = casopis;
        this.autori = autori;
    }

    public String generisiCitat(){
        StringBuilder sb = new StringBuilder();

        if(autori.size()<3){
            for(int i = 0; i < autori.size();i++) {
                Autor a = autori.get(i);
                sb.append(a.getIme()).append(" ").append(a.getPrezime());
                if (i < autori.size() - 1) {
                    sb.append(", ");
                }
            }
        }else {
            Autor prvi = autori.get(0);
            sb.append(prvi.getIme()).append(" ").append(prvi.getPrezime()).append(" ").append(", et. al.");
        }

        sb.append(" (").append(getGodinaIzdanja()).append("), ").append(getNaslov()).append(", ").append(casopis.getNaziv()).append(", ISSN ").append(casopis.getIssn());
        return sb.toString();
    }

    @Override
    public boolean validneRecenzije() {
        return getRecenzije().size() >= 3;
    }

    public Casopis getCasopis() {return casopis;}
    public void setCasopis(Casopis casopis) {this.casopis = casopis;}

    public List<Autor> getAutori() {return autori;}
    public void setAutori(List<Autor> autori) {this.autori = autori;}

}