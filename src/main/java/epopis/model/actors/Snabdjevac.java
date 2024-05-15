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
public class Snabdjevac implements Parser {
    private Integer pk_idSnabdjevac;
    @NonNull private String naziv;
    @NonNull private Double napon;
    @NonNull private String telefon;
    @NonNull private String fk_MJESTO_posta;

    public Snabdjevac(Integer pk_idSnabdjevac) {
        this.pk_idSnabdjevac = pk_idSnabdjevac;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_idSnabdjevac = rs.getInt("idSnabdjevac");
        naziv = rs.getString("naziv");
        napon = rs.getDouble("napon");
        telefon = rs.getString("telefon");
        fk_MJESTO_posta = rs.getString("MJESTO_posta");
    }
}
