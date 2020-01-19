package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @author diegorl84@gmail.com
 * @since 12/12/2019
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality spe1 = new Speciality();
        spe1.setDescription("Radiology");

        Speciality spe2 = new Speciality();
        spe2.setDescription("Surgery");

        Speciality spe3 = new Speciality();
        spe3.setDescription("Dentristy");

        Speciality spe1saved = specialityService.save(spe1);
        Speciality spe2saved = specialityService.save(spe2);
        Speciality spe3saved = specialityService.save(spe3);


        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("25 hillstreet");
        owner1.setCity("Sidney");
        owner1.setTelephone("0452645737");

        Pet chispa  = new Pet();
        chispa.setPetType(dog);
        chispa.setName("Chispa");
        chispa.setBirthDate(LocalDate.now());
        chispa.setOwner(owner1);
        owner1.getPets().add(chispa);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("25 hillstreet");
        owner2.setCity("Sidney");
        owner2.setTelephone("0452645737");

        Pet suertudo  = new Pet();
        suertudo.setPetType(cat);
        suertudo.setName("Suertudo");
        suertudo.setBirthDate(LocalDate.now());
        suertudo.setOwner(owner2);
        owner2.getPets().add(suertudo);

        ownerService.save(owner2);

        Visit catVisit= new Visit();
        catVisit.setPet(suertudo);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("First session");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(spe1saved);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(spe3saved);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
