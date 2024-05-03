package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Knjigovodja {
    @NonNull private String pk_JMBG;
    @NonNull private String PIB;
    @NonNull private String ime;
    @NonNull private String prezime;
}
