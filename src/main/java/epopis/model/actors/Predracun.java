package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Predracun {
    private Integer pk_idPredracun;
    @NonNull private Double potroseno;
    @NonNull private String fk_ELEKTRICAR_JMBG;
    @NonNull private String fk_KNJIGOVODJA_JMBG;
    @NonNull private String fk_POTROSAC_PIB;
}
