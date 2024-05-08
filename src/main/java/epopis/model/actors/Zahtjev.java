package epopis.model.actors;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Zahtjev {
    protected Integer pk_idZahtjev;
    @NonNull protected Date datum;
    protected Boolean odobren;
    @NonNull protected Integer fk_DISTRIBUTER_idDistributer;
    @NonNull protected String fk_POTROSAC_PIB;

    public Zahtjev(Integer pk_idZahtjev) {
        this.pk_idZahtjev = pk_idZahtjev;
    }
}
