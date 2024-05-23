package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Knjigovodja implements Parser {
    @NonNull private String pk_JMBG;
    @NonNull private String PIB;
    @NonNull private String ime;
    @NonNull private String prezime;

    @NonNull private String lozinka;

    public Knjigovodja(@NonNull String pk_JMBG) {
        this.pk_JMBG = pk_JMBG;
    }

    public Knjigovodja(String jmbg, String pib, String ime, String prezime) {
        this.pk_JMBG = jmbg;
        this.PIB = pib;
        this.ime = ime;
        this.prezime = prezime;
        this.lozinka = "********";
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            pk_JMBG = rs.getString("JMBG");
            PIB = rs.getString("PIB");
            ime = rs.getString("ime");
            prezime = rs.getString("prezime");
            lozinka = rs.getString("lozinka");
        }
    }
}
