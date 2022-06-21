package core.model.validators;

import core.exceptions.ValidatorException;
import core.model.Pair;
import core.model.Wand;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

@Component
public class WandValidator implements Validator<Wand> {

    @Override
    public void validate(Wand wand) throws ValidatorException {
        Stream.of(new Pair<>(wand.getName().isEmpty(), "Name must not be empty."),
                        new Pair<>(wand.getStrength() <= 0, "Wand srenght should be positive.")
                )

                .filter(Pair::getLeft)
                .forEach((b) -> {
                    throw new ValidatorException(b.getRight());
                });
    }
}
