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
public class Ormar implements Parser {
    @NonNull private Boolean prikljucak;
    @NonNull private Double brojilo;
    @NonNull private Boolean iskljucen;
    @NonNull private String fk_POTROSAC_PIB;

    public Ormar(@NonNull String fk_POTROSAC_PIB) {
        this.fk_POTROSAC_PIB = fk_POTROSAC_PIB;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        prikljucak = rs.getBoolean("prikljucak");
        brojilo = rs.getDouble("brojilo");
        iskljucen = rs.getBoolean("iskljucen");
        fk_POTROSAC_PIB = rs.getString("POTROSAC_PIB");
    }
}
