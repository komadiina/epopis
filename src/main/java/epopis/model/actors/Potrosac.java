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
public class Potrosac implements Parser {
    @NonNull private String pk_PIB;
    @NonNull private String naziv;
    @NonNull private String telefon;
    @NonNull private String fk_MJESTO_posta;

    public Potrosac(@NonNull String pk_PIB) {
        this.pk_PIB = pk_PIB;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_PIB = rs.getString("PIB");
        naziv = rs.getString("naziv");
        telefon = rs.getString("telefon");
        fk_MJESTO_posta = rs.getString("MJESTO_posta");;
    }
}
