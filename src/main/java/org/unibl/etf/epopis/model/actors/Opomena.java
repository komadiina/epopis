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
public class Opomena extends Dokument implements Parser {
    @NonNull private Double potroseno;
    @NonNull private Date rok;
    @NonNull private Integer fk_DOKUMENT_idDokument;

    public Opomena(Integer pk_idDokument) {
        super(pk_idDokument);
        this.fk_DOKUMENT_idDokument = pk_idDokument;
    }

    public Opomena(@NonNull String poziv,
                   @NonNull Date datumIzdavanja,
                   @NonNull String fk_KNJIGOVODJA_JMBG,
                   @NonNull String fk_POTROSAC_PIB,
                   @NonNull Boolean placen,
                   @NonNull Double potroseno,
                   @NonNull Date rok) {
        super(poziv, datumIzdavanja, fk_KNJIGOVODJA_JMBG, fk_POTROSAC_PIB, placen);
        this.potroseno = potroseno;
        this.rok = rok;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            potroseno = rs.getDouble("potroseno");
            rok = rs.getDate("rok");
            fk_DOKUMENT_idDokument = rs.getInt("DOKUMENT_idDokument");
        }

        super.parse(rs);
    }
}
