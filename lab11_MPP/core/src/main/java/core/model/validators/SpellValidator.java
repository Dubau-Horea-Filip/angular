package core.model.validators;

import core.exceptions.ValidatorException;
import core.model.Pair;
import core.model.Spell;
import org.springframework.stereotype.Component;


import java.util.stream.Stream;

@Component
public class SpellValidator implements Validator<Spell>{
    @Override
    public void validate(Spell spell) throws ValidatorException {
        Stream.of(new Pair<>(spell.getName().isEmpty(), "Spell name must not be empty"),
                        new Pair<>(spell.getDescription().isEmpty(), "Description must not pe empty"))
                .filter(Pair::getLeft)
                .forEach((b) -> {
                    throw new ValidatorException(b.getRight());
                });
    }
}
