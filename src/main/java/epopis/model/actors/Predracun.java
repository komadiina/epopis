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
public class Predracun implements Parser {
    private Integer pk_idPredracun;
    @NonNull private Double potroseno;
    @NonNull private String fk_ELEKTRICAR_JMBG;
    @NonNull private String fk_KNJIGOVODJA_JMBG;
    @NonNull private String fk_POTROSAC_PIB;

    public Predracun(Integer pk_idPredracun) {
        this.pk_idPredracun = pk_idPredracun;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_idPredracun = rs.getInt("idPredracun");
        potroseno = rs.getDouble("potroseno");
        fk_ELEKTRICAR_JMBG = rs.getString("ELEKTRICAR_JMBG");
        fk_KNJIGOVODJA_JMBG = rs.getString("KNJIGOVODJA_JMBG");
        fk_POTROSAC_PIB = rs.getString("POTROSAC_PIB");
    }
}
