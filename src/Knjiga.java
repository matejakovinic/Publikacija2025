public class Knjiga extends Publikacija{

    private String isbnBroj;
    private String izdavac;
    private Autor autor;

    public Knjiga(String doi, String naslov, int godinaIzdanja, String isbnBroj, String izdavac, Autor autor) {
        super(doi, naslov, godinaIzdanja);
        this.isbnBroj = isbnBroj;
        this.izdavac = izdavac;
        this.autor = autor;
    }

    @Override
    public String generisiCitat(){
      return  autor.getIme() + " " + autor.getPrezime() + "(" + getGodinaIzdanja() + "),"
              + getNaslov() + ", " + getIzdavac() + "," + getIsbnBroj();
    }

    @Override
    public boolean validneRecenzije() {
        return getRecenzije().size() >= 2;
    }

    public String getIsbnBroj() {return isbnBroj;}
    public void setIsbnBroj(String isbnBroj) {this.isbnBroj = isbnBroj;}

    public String getIzdavac() {return izdavac;}
    public void setIzdavac(String izdavac) {this.izdavac = izdavac;}

    public Autor getAutor() {return autor;}
    public void setAutor(Autor autor) {this.autor = autor;}

}
