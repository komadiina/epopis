package epopis.model.actors;

import epopis.model.reflection.Parser;
import lombok.*;
import org.jetbrains.annotations.NotNull;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Opomena extends Dokument implements Parser {
    @NonNull private Double potroseno;
    @NonNull private Integer fk_DOKUMENT_idDokument;

    public Opomena(@NotNull Integer pk_idDokument) {
        super(pk_idDokument);
        this.fk_DOKUMENT_idDokument = pk_idDokument;
    }

    public Opomena(@NonNull String poziv,
                   @NonNull Date datumIzdavanja,
                   @NonNull String fk_KNJIGOVODJA_JMBG,
                   @NonNull String fk_POTROSAC_PIB,
                   @NonNull Double potroseno) {
        super(poziv, datumIzdavanja, fk_KNJIGOVODJA_JMBG, fk_POTROSAC_PIB);
        this.potroseno = potroseno;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        potroseno = rs.getDouble("potroseno");
        fk_DOKUMENT_idDokument = rs.getInt("DOKUMENT_idDokument");
        super.parse(rs);
    }
}
