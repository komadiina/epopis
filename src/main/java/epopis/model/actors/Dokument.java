package epopis.model.actors;

import epopis.model.reflection.Parser;
import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
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

    public Dokument(Integer pk_idDokument) {
        this.pk_idDokument = pk_idDokument;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_idDokument = rs.getInt("idDokument");
        poziv = rs.getString("poziv");
        datumIzdavanja = rs.getDate("datumIzdavanja");
        fk_KNJIGOVODJA_JMBG = rs.getString("KNJIGOVODJA_JMBG");
        fk_POTROSAC_PIB = rs.getString("POTROSAC_PIB");
    }
}
