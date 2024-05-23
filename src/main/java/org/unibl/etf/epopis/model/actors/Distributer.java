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
public class Distributer implements Parser {
    private Integer pk_idDistributer;
    @NonNull private String naziv;
    @NonNull private Double napon;
    @NonNull private String telefon;
    @NonNull private Integer fk_SNABDJEVAC_idSnabdjevac;
    @NonNull private String fk_MJESTO_posta;
    @NonNull private String lozinka;

    public Distributer(Integer pk_idDistributer) {
        this.pk_idDistributer = pk_idDistributer;
    }

    @Override
    public void parse(ResultSet rs) throws SQLException {
        if (rs.next()) {
            pk_idDistributer = rs.getInt("idDistributer");
            naziv = rs.getString("naziv");
            napon = rs.getDouble("napon");
            telefon = rs.getString("telefon");
            fk_SNABDJEVAC_idSnabdjevac = rs.getInt("SNABDJEVAC_idSnabdjevac");
            fk_MJESTO_posta = rs.getString("MJESTO_posta");
            lozinka = rs.getString("lozinka");
        }
    }
}
