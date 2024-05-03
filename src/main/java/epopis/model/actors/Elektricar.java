package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Elektricar {
    @NonNull private String pk_JMBG;
    @NonNull private String ime;
    @NonNull private String prezime;
    @NonNull private Integer fk_DISTRIBUTER_idDistributer;
}
