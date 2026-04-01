import java.time.LocalDate;
import java.util.*;

public class Test {

    public static void main(String[] args) {

        // 🔹 AUTORI
        Autor a1 = new Autor("Petar", "Petrovic", "dr");
        Autor a2 = new Autor("Marija", "Markovic", "prof");
        Autor a3 = new Autor("Milan", "Mitic", "mr");

        // 🔹 CASOPISI
        Casopis c1 = new Casopis("1233-4567", "Casopis za programiranje");
        Casopis c2 = new Casopis("9876-5432", "IT svet");

        // 🔹 KNJIGE
        Knjiga k1 = new Knjiga("doi1", "Java Osnove", 2020, "isbn1", "Prosveta", a1);
        Knjiga k2 = new Knjiga("doi2", "Napredna Java", 2022, "isbn2", "Laguna", a2);
        Knjiga k3 = new Knjiga("doi3", "OOP u Javi", 2021, "isbn3", "Vulkan", a3);

        // 🔹 NAUCNI RADOVI
        List<Autor> autori1 = Arrays.asList(a1, a2);
        List<Autor> autori2 = Arrays.asList(a1, a2, a3);

        NaucniRad r1 = new NaucniRad("doi4", "AI u Javi", 2023, c1, autori1);
        NaucniRad r2 = new NaucniRad("doi5", "Machine Learning", 2024, c2, autori2);
        NaucniRad r3 = new NaucniRad("doi6", "Data Science", 2022, c1, autori1);

        // 🔹 DODAJ PUBLIKACIJE AUTORIMA
        a1.dodajPublikaciju(k1);
        a1.dodajPublikaciju(r1);
        a1.dodajPublikaciju(r2);

        a2.dodajPublikaciju(k2);
        a2.dodajPublikaciju(r1);
        a2.dodajPublikaciju(r2);

        a3.dodajPublikaciju(k3);
        a3.dodajPublikaciju(r2);
        a3.dodajPublikaciju(r3);

        // 🔹 RECENZIJE (dummy tekst 50+ reci)
        String tekst = "Ovo je veoma duga recenzija koja sadrzi vise od pedeset reci kako bi prosla validaciju i bila prihvacena u sistemu bez ikakvih problema jer profesor zahteva minimalno pedeset reci kako bi recenzija bila validna i uzeta u obzir prilikom racunanja proseka ocena publikacije i svih ostalih funkcionalnosti sistema";

        Recenzija rec1 = new Recenzija(tekst, LocalDate.now(), 5);
        Recenzija rec2 = new Recenzija(tekst, LocalDate.now(), 4);
        Recenzija rec3 = new Recenzija(tekst, LocalDate.now(), 3);

        // knjiga mora imati ≥2
        k1.dodajRecenziju(rec1);
        k1.dodajRecenziju(rec2);

        // rad mora imati ≥3
        r1.dodajRecenziju(rec1);
        r1.dodajRecenziju(rec2);
        r1.dodajRecenziju(rec3);

        // 🔹 TEST generisiCitat
        System.out.println("=== CITATI ===");
        System.out.println(k1.generisiCitat());
        System.out.println(r1.generisiCitat());

        // 🔹 TEST citiranja
        k1.dodajCitat(r1);
        k1.dodajCitat(r2);

        System.out.println("\n=== CITATI PUBLIKACIJE ===");
        System.out.println(k1.vratiIspisCitata());

        // 🔹 TEST filtriranja
        List<String> kljucne = Arrays.asList("Java", "AI");

        System.out.println("=== FILTRIRANE PUBLIKACIJE ===");
        List<Publikacija> filtrirane = a1.vratiPublikacijeZaKjucneReci(kljucne);
        for (Publikacija p : filtrirane) {
            System.out.println(p.generisiCitat());
        }

        // 🔹 TEST broj citata
        System.out.println("\nUkupan broj citata autora a1: " + a1.vratiBrojCitata());

        // 🔹 TEST prosek
        System.out.println("Prosek ocena k1: " + k1.prosecnaOcena());
        System.out.println("Validne recenzije k1: " + k1.validneRecenzije());

        // 🔹 TEST najbolja publikacija
        Publikacija najbolja = a1.vratiNajboljuPublikaciju();
        System.out.println("\nNajbolja publikacija autora a1:");
        System.out.println(najbolja.generisiCitat());
    }
}
