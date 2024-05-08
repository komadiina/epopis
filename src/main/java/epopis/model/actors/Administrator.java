package epopis.model.actors;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Administrator {
    @NonNull private String username;
    private String password;
}
