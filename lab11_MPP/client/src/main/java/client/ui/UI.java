package client.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import web.dto.*;


import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

@Component
public class UI {
    @Autowired
    private RestTemplate restTemplate;
    private final Map<Integer, Runnable> menuTable = new HashMap<>();
    String wizardsUrl = "http://localhost:8080/api/wizards";
    String spellsUrl = "http://localhost:8080/api/spells";
    String castedSpellsUrl = "http://localhost:8080/api/casted_spells";


    String WandUrl = "http://localhost:8080/api/wands";

    static void printMenu(){
        System.out.println("1. Add a wizard");
        System.out.println("2. Show wizards");
        System.out.println("3. Delete wizard");
        System.out.println("4. Update wizard\n");

        System.out.println("5. Add spell");
        System.out.println("6. Show spells");
        System.out.println("7. Delete spell");
        System.out.println("8. Update spell\n");

        System.out.println("9. Add casted spell");
        System.out.println("10. Show casted spells");
        System.out.println("11. Delete casted spell");
        System.out.println("12. Update casted spell\n");

        System.out.println("13. Add Wand");
        System.out.println("14. Show Wands");
        System.out.println("15. Delete Wand");
        System.out.println("16. Update Wand\n");

        System.out.println("17. Filter wizards by name");
        System.out.println("18. Get wands  sorted by strength");
        System.out.println("19. Filter spells by name");

        System.out.println("0. Exit\n");
    }

    public void runProgram() {
        menuTable.put(1, this::addWizard);
        menuTable.put(2, this::showWizards);
        menuTable.put(3, this::deleteWizard);
        menuTable.put(4, this::updateWizard);
        menuTable.put(5, this::addSpell);
        menuTable.put(6, this::showSpells);
        menuTable.put(7, this::deleteSpell);
        menuTable.put(8, this::updateSpell);
        menuTable.put(9, this::addCastedSpell);
        menuTable.put(10, this::showCastedSpells);
        menuTable.put(11, this::deleteCastedSpell);
        menuTable.put(12, this::updateCastedSpell);
        menuTable.put(13, this::addWand);
        menuTable.put(14, this::showWands);
        menuTable.put(15, this::deleteWand);
        menuTable.put(16, this::updateWand);
        menuTable.put(17, this::filterWizardsByName);
        menuTable.put(18, this::getWandsSortedBystrength);
        menuTable.put(19, this::filterSpellsByName);


        while(true) {
            printMenu();
            try {
                int choice = readNumberFromConsole();
                if (choice == 0)
                    break;
                Runnable toRun = menuTable.get(choice);
                if (toRun == null) {
                    System.out.println("Bad choice");
                    continue;
                }
                toRun.run();
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("Invalid integer");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    int readNumberFromConsole() {
        Scanner stdin = new Scanner(System.in);
        return stdin.nextInt();
    }


    void addWizard() {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Name: ");
        String name = stdin.nextLine().strip();
        System.out.println("Age: ");
        Integer age = Integer.valueOf(stdin.nextLine().strip());
        System.out.println("Pet: ");
        String pet = stdin.nextLine().strip();
       try{
           WizardDTO wizardDTO = new WizardDTO(name, age, pet);
           restTemplate.postForObject(wizardsUrl, wizardDTO, WizardDTO.class);
           System.out.println("Wizard added successfully");
       } catch (HttpStatusCodeException ex) {
           System.out.println(ex.getMessage());
           System.out.println(ex.getStatusCode());
           System.out.println("Cannot add wizard!");
       }
    }

    void showWizards() {
        WizardsDTO wizardsDTO = restTemplate.getForObject(wizardsUrl, WizardsDTO.class);
        assert wizardsDTO != null;
        wizardsDTO.getWizards().forEach(System.out::println);
    }

    void deleteWizard(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Wizard id: ");
        Long id = stdin.nextLong();
        try{
            restTemplate.delete(wizardsUrl + "/{id}", id);
            System.out.println("Wizard deleted successfully");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot delete wizard!");
        }
    }

    void updateWizard(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Id: ");
        Long id = Long.parseLong(stdin.nextLine());
        System.out.println("Name: ");
        String name = stdin.nextLine().strip();
        System.out.println("Age: ");
        Integer age = Integer.valueOf(stdin.nextLine().strip());
        System.out.println("Pet: ");
        String pet = stdin.nextLine().strip();
       try{
           WizardDTO wizardDTO = new WizardDTO(name, age, pet);
           restTemplate.put(wizardsUrl + "/{id}", wizardDTO, id);
           System.out.println("Wizard updated successfully.");
       }catch (HttpStatusCodeException ex) {
           System.out.println("Cannot update wizard!");
       }
    }

    private void filterWizardsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        try {
            WizardsDTO wizardsDTO = restTemplate.getForObject(wizardsUrl + "/filter/{name}", WizardsDTO.class, name);
            if (wizardsDTO == null)
                System.out.println("No wizards with the given name!");
            else
                wizardsDTO.getWizards().forEach(System.out::println);
        } catch (HttpStatusCodeException ex) {
            System.out.println("Cannot get wizards!");
        }
    }

    void addSpell(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Name: ");
        String name = stdin.nextLine().strip();
        System.out.println("Description: ");
        String description = stdin.nextLine().strip();
        try{
            SpellDTO spellDTO = new SpellDTO(name, description);
            restTemplate.postForObject(spellsUrl, spellDTO, SpellDTO.class);
            System.out.println("Spell added successfully");
        } catch (HttpStatusCodeException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStatusCode());
            System.out.println("Cannot add spell!");
        }

    }

    void showSpells(){
        SpellsDTO spellsDTO = restTemplate.getForObject(spellsUrl, SpellsDTO.class);
        assert spellsDTO != null;
        spellsDTO.getSpells().forEach(System.out::println);
    }

    void deleteSpell(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Spell id: ");
        Long id = stdin.nextLong();
        try{
            restTemplate.delete(spellsUrl + "/{id}", id);
            System.out.println("Spell deleted successfully");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot delete spell!");
        }
    }

    void updateSpell(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Id: ");
        Long id = Long.parseLong(stdin.nextLine());
        System.out.println("Name: ");
        String name = stdin.nextLine().strip();
        System.out.println("Description: ");
        String description = stdin.nextLine().strip();
        try{
            SpellDTO spellDTO = new SpellDTO(name, description);
            restTemplate.put(spellsUrl + "/{id}", spellDTO, id);
            System.out.println("Spell updated successfully.");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot update spell!");
        }
    }

    private void filterSpellsByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name: ");
        String name = scanner.next();
        try {
            SpellsDTO spellsDTO = restTemplate.getForObject(spellsUrl + "/filter/{name}", SpellsDTO.class, name);
            if (spellsDTO == null)
                System.out.println("No spells with the given name!");
            else
                spellsDTO.getSpells().forEach(System.out::println);
        } catch (HttpStatusCodeException ex) {
            System.out.println("Cannot get spells!");
        }
    }



    void addCastedSpell() {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Wizard id: ");
        Long wizardId = Long.parseLong(stdin.nextLine());
        System.out.println("Spell id: ");
        Long spellId = Long.parseLong(stdin.nextLine());
        System.out.println("Details: ");
        String details = stdin.nextLine().strip();
        try{
            CastedSpellDTO castedSpellDTO = new CastedSpellDTO(wizardId, spellId, details);
            restTemplate.postForObject(castedSpellsUrl, castedSpellDTO, CastedSpellDTO.class);
            System.out.println("CastedSpell added successfully");
        } catch (HttpStatusCodeException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStatusCode());
            System.out.println("Cannot add casted spell!");
        }
    }

    void showCastedSpells() {
        CastedSpellsDTO castedSpellsDTO = restTemplate.getForObject(castedSpellsUrl, CastedSpellsDTO.class);
        assert castedSpellsDTO != null;
        castedSpellsDTO.getCastedSpells().forEach(System.out::println);
    }

    void deleteCastedSpell(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("CastedSpell id: ");
        Long id = stdin.nextLong();
        try{
            restTemplate.delete(castedSpellsUrl + "/{id}", id);
            System.out.println("CastedSpell deleted successfully");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot delete castedSpell!");
        }
    }

    void updateCastedSpell(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Id: ");
        Long id = Long.parseLong(stdin.nextLine());
        System.out.println("Wizard id: ");
        Long wizardId = Long.parseLong(stdin.nextLine());
        System.out.println("Spell id: ");
        Long spellId = Long.parseLong(stdin.nextLine());
        System.out.println("Details: ");
        String details = stdin.nextLine();
        try{
            CastedSpellDTO castedSpellDTO = new CastedSpellDTO(wizardId, spellId, details);
            restTemplate.put(castedSpellsUrl + "/{id}", castedSpellDTO, id);
            System.out.println("CastedSpell updated successfully.");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot update castedSpell!");
        }
    }



    void addWand() {
        Scanner stdin = new Scanner(System.in);
        System.out.println("Wizard id: ");
        Long wizardId = Long.parseLong(stdin.nextLine());
        System.out.println("Name: ");
        String name = stdin.nextLine();
        System.out.println("Strength: ");
        Integer strength = Integer.valueOf(stdin.nextLine());

        try{
            WandDTO wizardDTO = new WandDTO(wizardId, name, strength);
            restTemplate.postForObject(WandUrl, wizardDTO, WandsDTO.class);
            System.out.println("Wand added successfully");
        } catch (HttpStatusCodeException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getStatusCode());
            System.out.println("Cannot add Wand!");
        }
    }

    void showWands() {
        WandsDTO wandsDTO = restTemplate.getForObject(WandUrl, WandsDTO.class);
        assert wandsDTO != null;
        wandsDTO.getWands().forEach(System.out::println);
    }

    void deleteWand(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Wand id: ");
        Long id = stdin.nextLong();
        try{
            restTemplate.delete(WandUrl + "/{id}", id);
            System.out.println("Wand deleted successfully");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot delete  Wand!");
        }
    }

    void updateWand(){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Id: ");
        Long id = Long.parseLong(stdin.nextLine());
        System.out.println("Wizard id: ");
        Long wizardId = Long.parseLong(stdin.nextLine());
        System.out.println("Name: ");
        String name = stdin.nextLine();
        System.out.println("Srength: ");
        Integer strength = Integer.parseInt(stdin.nextLine());

        try{
            WandDTO wizardDTO = new WandDTO(wizardId, name, strength);
            restTemplate.put(WandUrl + "/{id}", wizardDTO, id);
            System.out.println("Wand updated successfully.");
        }catch (HttpStatusCodeException ex) {
            System.out.println("Cannot update Wand!");
        }
    }

    private void getWandsSortedBystrength(){
        try{
            WandsDTO wandsDTO = restTemplate.getForObject(WandUrl + "/sort/strength", WandsDTO.class);
            if(wandsDTO == null)
                System.out.println("No Wands!");
            else
                wandsDTO.getWands().forEach(System.out::println);
        }catch (HttpStatusCodeException ex){
            System.out.println("Cannot get Wands!");
        }
    }




}
