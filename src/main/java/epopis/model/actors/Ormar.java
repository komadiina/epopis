package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Ormar {
    @NonNull private Boolean prikljucak;
    @NonNull private Double brojilo;
    @NonNull private Boolean iskljucen;
    @NonNull private String fk_POTROSAC_PIB;
}
