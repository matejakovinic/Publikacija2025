import java.util.ArrayList;
import java.util.List;


public class Autor {

    private String ime;
    private String prezime;
    private String titula;
    private List<Knjiga> knjige = new ArrayList<>();
    private List<NaucniRad> radovi = new ArrayList<>();
    private List<Publikacija> publikacije = new ArrayList<>();

    public Autor(String ime, String prezime, String titula) {
        this.ime = ime;
        this.prezime = prezime;
        this.titula = titula;
    }

    public void dodajPublikaciju(Publikacija p ){
        publikacije.add(p);
    }

    public List<Publikacija> vratiPublikacijeZaKjucneReci (List<String> trazeneReci){

        List<Publikacija> rezultat = new ArrayList<>();

        for(Publikacija p : publikacije){
            boolean poklapanje = false;

            for(String kljucna : p.getKljucneReci()){
                if(trazeneReci.contains(kljucna))
                    poklapanje = true;
                    break;
            }
            if(!poklapanje){
                String[] reciNaslova = p.getNaslov().split(" ");

                for(String rec : reciNaslova){
                    if(trazeneReci.contains(rec))
                        poklapanje = true;
                        break;
                }
            }
            if(poklapanje){
                rezultat.add(p);
            }

        }
        rezultat.sort((p1,p2) -> p2.getGodinaIzdanja() - p1.getGodinaIzdanja());
        return rezultat;
    }

    public int vratiBrojCitata(){
        int ukupno = 0;
        for(Publikacija p : publikacije){
            ukupno += p.getCitati() .size();
        }
        return ukupno;
    }

    public Publikacija vratiNajboljuPublikaciju(){

        Publikacija najbolja = publikacije.get(0);

        for(Publikacija p : publikacije){
            if(p.prosecnaOcena() > najbolja.prosecnaOcena()){
                najbolja = p;
            }
        }
        return najbolja;
    }

    public String getIme() {return ime;}
    public void setIme(String ime) {this.ime = ime;}

    public String getPrezime() {return prezime;}
    public void setPrezime(String prezime) {this.prezime = prezime;}

    public String getTitula() {return titula;}
    public void setTitula(String titula) {this.titula = titula;}

    public List<Knjiga> getKnjige() {return knjige;}
    public void setKnjige(List<Knjiga> knjige) {this.knjige = knjige;}

    public List<NaucniRad> getRadovi() {return radovi;}
    public void setRadovi(List<NaucniRad> radovi) {this.radovi = radovi;}
}