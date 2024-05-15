package epopis.model.actors;

import epopis.model.reflection.Parser;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Elektricar implements Parser {
    private String pk_JMBG;
    @NonNull private String ime;
    @NonNull private String prezime;
    @NonNull private Integer fk_DISTRIBUTER_idDistributer;

    public Elektricar(String pk_JMBG) { this.pk_JMBG = pk_JMBG; }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_JMBG = rs.getString("JMBG");
        ime = rs.getString("ime");
        prezime = rs.getString("prezime");
        fk_DISTRIBUTER_idDistributer = rs.getInt("DISTRIBUTER_idDistributer");
    }
}
