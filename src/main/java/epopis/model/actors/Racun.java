package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Racun extends Dokument {
    @NonNull private Double potroseno;
    @NonNull private Integer fk_DOKUMENT_idDokument;
}
