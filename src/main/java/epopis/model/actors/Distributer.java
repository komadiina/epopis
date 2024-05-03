package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Distributer {
    private Integer pk_idDistributer;
    @NonNull private String naziv;
    @NonNull private Double napon;
    @NonNull private String telefon;
    @NonNull private Integer fk_SNABDJEVAC_idSnabdjevac;
    @NonNull private String fk_MJESTO_posta;

    public Distributer(Integer pk_idDistributer) {
        this.pk_idDistributer = pk_idDistributer;
    }
}
