package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Iskljucenje extends Zahtjev {
    @NonNull private Integer fk_ZAHTJEV_idZahtjev;
}
