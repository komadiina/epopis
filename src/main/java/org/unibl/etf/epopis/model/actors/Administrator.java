package org.unibl.etf.epopis.model.actors;

import org.unibl.etf.epopis.model.reflection.Parser;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Administrator implements Parser {
    @NonNull private String pk_username;
    private String password;

    @Override
    public void parse(ResultSet rs) throws SQLException {
        pk_username = rs.getString("username");
        password = rs.getString("password");
    }
}
