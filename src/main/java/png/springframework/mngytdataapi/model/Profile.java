package png.springframework.mngytdataapi.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String emailId;

    @Column(name = "urlThumbnail")
    private String urlThumbnail;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();
}
