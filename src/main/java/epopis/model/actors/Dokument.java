package epopis.model.actors;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Dokument {
    protected Integer pk_idDokument;
    @NonNull protected String poziv;
    @NonNull protected Date datumIzdavanja;
    @NonNull protected String fk_KNJIGOVODJA_JMBG;
    @NonNull protected String fk_POTROSAC_PIB;

    public Dokument(Integer pk_idDokument) {
        this.pk_idDokument = pk_idDokument;
    }


}
