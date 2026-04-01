import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Publikacija implements Citabilno{

    private String doi;
    private String naslov;
    private int godinaIzdanja;
    private List<String> kljucneReci = new ArrayList<>();
    private List<Publikacija> citati = new ArrayList<>();
    private List<Recenzija> recenzije = new ArrayList<>();


    public Publikacija(String doi, String naslov, int godinaIzdanja) {
        this.doi = doi;
        this.naslov = naslov;
        this.godinaIzdanja = godinaIzdanja;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Publikacija that = (Publikacija) o;
        return Objects.equals(doi, that.doi);
    }


    public boolean dodajCitat(Publikacija p) {
            if (!citati.contains(p)) {
                citati.add(p);
                return true;
            }
        return false;
    }

    public boolean dodajRecenziju(Recenzija r){
        if(r.getOcena() < 1 || r.getOcena() > 5) return false;
        int brojReci = r.getTekst().trim().split("\\s+").length;
        if(brojReci < 50 || brojReci > 200) return false;

        recenzije.add(r);
        return true;
    }

    public abstract boolean validneRecenzije();

    public String vratiIspisCitata(){
            StringBuilder sb = new StringBuilder();

            for(Publikacija p : citati){
                sb.append(p.generisiCitat()).append("\n");
            }
            return sb.toString();
    }

    public double prosecnaOcena(){
        if (recenzije.isEmpty()) return 0;
        int suma = 0;
        for(Recenzija r : recenzije){
            suma += r.getOcena();
        }
        return  (double)suma / recenzije.size();
    }

    public String getDoi() {return doi;}
    public void setDoi(String doi) {this.doi = doi;}

    public String getNaslov() {return naslov;}
    public void setNaslov(String naslov) {this.naslov = naslov;}

    public int getGodinaIzdanja() {return godinaIzdanja;}
    public void setGodinaIzdanja(int godinaIzdanja) {this.godinaIzdanja = godinaIzdanja;}

    public List<String> getKljucneReci() {return kljucneReci;}
    public void setKljucneReci(List<String> kljucneReci) {this.kljucneReci = kljucneReci;}

    public List<Publikacija> getCitati() {return citati;}
    public void setCitati(List<Publikacija> citati) {this.citati = citati;}

    public List<Recenzija> getRecenzije() {return recenzije;}
    public void setRecenzije(List<Recenzija> recenzije) {this.recenzije = recenzije;}
}
