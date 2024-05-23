package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Zahtjev implements Parser {
    protected Integer pk_idZahtjev;
    @NonNull protected Boolean iskljucenje;
    @NonNull protected Date datum;
    protected Boolean odobren;
    @NonNull protected Integer fk_DISTRIBUTER_idDistributer;
    @NonNull protected String fk_POTROSAC_PIB;

    public Zahtjev(Integer pk_idZahtjev) {
        this.pk_idZahtjev = pk_idZahtjev;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            pk_idZahtjev = rs.getInt("idZahtjev");
            iskljucenje = rs.getBoolean("iskljucenje");
            datum = rs.getDate("datum");
            odobren = rs.getBoolean("odobren");
            fk_DISTRIBUTER_idDistributer = rs.getInt("DISTRIBUTER_idDistributer");
            fk_POTROSAC_PIB = rs.getString("POTROSAC_PIB");
        }
    }
}
