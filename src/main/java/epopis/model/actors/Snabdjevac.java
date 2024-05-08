package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Snabdjevac {
    private Integer pk_idSnabdjevac;
    @NonNull private String naziv;
    @NonNull private Double napon;
    @NonNull private String telefon;
    @NonNull private String fk_MJESTO_posta;

    public Snabdjevac(Integer pk_idSnabdjevac) {
        this.pk_idSnabdjevac = pk_idSnabdjevac;
    }
}
