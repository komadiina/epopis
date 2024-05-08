package epopis.model.actors;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Prikljucenje extends Zahtjev {
    @NonNull private Integer fk_ZAHTJEV_idZahtjev;

    public Prikljucenje(@NotNull Integer idZahtjev) {
        super(idZahtjev);
        this.fk_ZAHTJEV_idZahtjev = idZahtjev;
    }
}
