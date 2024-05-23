package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dokument implements Parser {
    protected Integer pk_idDokument;
    @NonNull protected String poziv;
    @NonNull protected Date datumIzdavanja;
    @NonNull protected String fk_KNJIGOVODJA_JMBG;
    @NonNull protected String fk_POTROSAC_PIB;
    @NonNull protected Boolean placen;

    public Dokument(Integer pk_idDokument) {
        this.pk_idDokument = pk_idDokument;
    }


    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            pk_idDokument = rs.getInt("idDokument");
            poziv = rs.getString("poziv");
            datumIzdavanja = rs.getDate("datumIzdavanja");
            fk_KNJIGOVODJA_JMBG = rs.getString("KNJIGOVODJA_JMBG");
            fk_POTROSAC_PIB = rs.getString("POTROSAC_PIB");
            placen = rs.getBoolean("placen");
        }
    }
}
