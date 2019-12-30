package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author diego
 * @since 23/11/2019
 */
public class Vet extends Person {

    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
