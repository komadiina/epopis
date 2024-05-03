package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Potrosac {
    @NonNull private String pk_PIB;
    @NonNull private String naziv;
    @NonNull private String telefon;
    @NonNull private String fk_MJESTO_posta;
}
