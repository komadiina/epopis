package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Elektricar {
    private String pk_JMBG;
    @NonNull private String ime;
    @NonNull private String prezime;
    @NonNull private Integer fk_DISTRIBUTER_idDistributer;

    public Elektricar(String pk_JMBG) { this.pk_JMBG = pk_JMBG; }
}
