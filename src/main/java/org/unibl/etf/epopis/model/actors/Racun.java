package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Racun extends Dokument implements Parser {
    @NonNull private Double potroseno;
    @NonNull private Integer fk_DOKUMENT_idDokument;

    public Racun(Integer pk_idDokument) {
        super(pk_idDokument);
        this.fk_DOKUMENT_idDokument = pk_idDokument;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        potroseno = rs.getDouble("potroseno");
        fk_DOKUMENT_idDokument = rs.getInt("DOKUMENT_idDokument");
        super.parse(rs);
    }
}
