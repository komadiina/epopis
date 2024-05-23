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
public class Mjesto implements Parser {
    @NonNull private String pk_posta;
    @NonNull private String naziv;

    public Mjesto(@NonNull String pk_posta) {
        this.pk_posta = pk_posta;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            pk_posta = rs.getString("posta");
            naziv = rs.getString("naziv");
        }
    }
}
