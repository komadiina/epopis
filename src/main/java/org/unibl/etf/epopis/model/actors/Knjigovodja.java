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

    public Knjigovodja(@NonNull String pk_JMBG) {
        this.pk_JMBG = pk_JMBG;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_JMBG = rs.getString("JMBG");
        PIB = rs.getString("PIB");
        ime = rs.getString("ime");
        prezime = rs.getString("prezime");
    }
}
