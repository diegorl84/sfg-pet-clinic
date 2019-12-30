package guru.springframework.sfgpetclinic.model;

/**
 * @author diego
 * @since 29/12/2019
 */
public class Speciality extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
