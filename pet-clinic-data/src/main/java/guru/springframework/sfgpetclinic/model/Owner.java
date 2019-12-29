package guru.springframework.sfgpetclinic.model;

import java.util.Set;

/**
 * @author diego
 * @since 23/11/2019
 */
public class Owner extends Person {
    private Set<Pet> pet;

    public Set<Pet> getPet() {
        return pet;
    }

    public void setPet(Set<Pet> pet) {
        this.pet = pet;
    }
}
