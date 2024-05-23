package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Racun extends Dokument implements Parser {
    @NonNull private Double potroseno;
    @NonNull private Integer fk_DOKUMENT_idDokument;

    public Racun(Integer pk_idDokument) {
        super(pk_idDokument);
        this.fk_DOKUMENT_idDokument = pk_idDokument;
    }

    public Racun (Integer idDokument,
                  Double potroseno,
                  String poziv,
                  Date datumIzdavanja,
                  String KNJIGOVODJA_JMBG,
                  String POTROSAC_PIB,
                  Boolean placen) {
        super(idDokument, poziv, datumIzdavanja, KNJIGOVODJA_JMBG, POTROSAC_PIB, placen);
        this.potroseno = potroseno;
        this.fk_DOKUMENT_idDokument = idDokument;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            potroseno = rs.getDouble("potroseno");
            fk_DOKUMENT_idDokument = rs.getInt("DOKUMENT_idDokument");
        }
        super.parse(rs);
    }
}
