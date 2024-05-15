package epopis.model.actors;

import epopis.model.reflection.Parser;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Iskljucenje extends Zahtjev implements Parser {
    @NonNull private Integer fk_ZAHTJEV_idZahtjev;

    public Iskljucenje(@NonNull Integer idZahtjev) {
        super(idZahtjev);
        this.fk_ZAHTJEV_idZahtjev = idZahtjev;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        fk_ZAHTJEV_idZahtjev = rs.getInt("ZAHTJEV_idZahtjev");
        super.parse(rs);
    }
}
