package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Mjesto {
    @NonNull private String pk_posta;
    @NonNull private String naziv;
}
