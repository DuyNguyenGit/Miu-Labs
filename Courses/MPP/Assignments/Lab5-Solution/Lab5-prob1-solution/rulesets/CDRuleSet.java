package lesson5.labs.prob1.rulesets;

import lesson5.labs.prob1.gui.CDWindow;

import java.awt.*;
import java.math.BigDecimal;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Price must be a floating point number with two decimal places
 * 3. Price must be a number greater than 0.49.
 */

public class CDRuleSet implements RuleSet {
    private CDWindow cdWindow;

    @Override
    public void applyRules(Component ob) throws RuleException {
        cdWindow = (CDWindow) ob;
        nonemptyRule();
        isPriceFloatingTwoDecimalPlacesRule();
        isANumberGreaterThan49();
    }

    private void nonemptyRule() throws RuleException {
        if (cdWindow.getArtistValue().trim().isEmpty() ||
                cdWindow.getTitleValue().trim().isEmpty() ||
                cdWindow.getPriceValue().trim().isEmpty()) {
            throw new RuleException("All fields must be non-empty!");
        }
    }

    private void isPriceFloatingTwoDecimalPlacesRule() throws RuleException {
        try {
            Double.parseDouble(cdWindow.getPriceValue().trim());
        } catch (NumberFormatException e) {
            throw new RuleException("Isbn must be numeric");
        }
        double val = Double.parseDouble(cdWindow.getPriceValue().trim());
        if (BigDecimal.valueOf(val).scale() != 2) {
            throw new RuleException("Price must be floating two decimal places!");
        }
    }

    private void isANumberGreaterThan49() throws RuleException {
        double val = Double.parseDouble(cdWindow.getPriceValue().trim());
        if (val <= 0.49) {
            throw new RuleException("Price must be greater than or equal to 0.49!");
        }
    }

}
