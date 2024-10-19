@Entity
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String localisation;
    private Double prix;
    private Integer superficie;
    private Integer nombrePieces;
    private String photoUrl; // lien vers la photo

    // Getters et Setters
}

