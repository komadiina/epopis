package epopis.model.actors;

import lombok.*;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Mjesto  {
    @NonNull private String pk_posta;
    @NonNull private String naziv;

    public Mjesto(@NonNull String pk_posta) {
        this.pk_posta = pk_posta;
    }
}
