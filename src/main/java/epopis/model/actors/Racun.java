package epopis.model.actors;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class Racun extends Dokument {
    @NonNull private Double potroseno;
    @NonNull private Integer fk_DOKUMENT_idDokument;

    public Racun(@NotNull Integer pk_idDokument) {
        super(pk_idDokument);
        this.fk_DOKUMENT_idDokument = pk_idDokument;
    }
}
