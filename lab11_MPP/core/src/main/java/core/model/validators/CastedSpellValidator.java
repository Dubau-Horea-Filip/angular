package core.model.validators;

import core.exceptions.ValidatorException;
import core.model.CastedSpell;
import core.model.Pair;
import org.springframework.stereotype.Component;
import java.util.stream.Stream;

@Component
public class CastedSpellValidator implements Validator<CastedSpell>{
    @Override
    public void validate(CastedSpell castedSpell) throws ValidatorException {
        Stream.of(new Pair<>(castedSpell.getWizardId() <= 0, "Wizard id should be positive."),
                        new Pair<>(castedSpell.getSpellId() <= 0, "Spell id should be positive."),
                        new Pair<>(castedSpell.getDetails().isEmpty(), "Details should not be empty."))
                .filter(Pair::getLeft)
                .forEach((b) -> {
                    throw new ValidatorException(b.getRight());
                });
    }
}
