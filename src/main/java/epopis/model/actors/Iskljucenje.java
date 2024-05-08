package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Iskljucenje extends Zahtjev {
    @NonNull private Integer fk_ZAHTJEV_idZahtjev;

    public Iskljucenje(@NonNull Integer idZahtjev) {
        super(idZahtjev);
        this.fk_ZAHTJEV_idZahtjev = idZahtjev;
    }
}
