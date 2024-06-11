package lesson5.labs.prob1.rulesets;

import lesson5.labs.prob1.gui.BookWindow;

import java.awt.*;
import java.math.BigDecimal;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	private BookWindow bookWindow;

	@Override
	public void applyRules(Component ob) throws RuleException {
		bookWindow = (BookWindow) ob;
		nonemptyRule();
		idNumericRule();
		isPriceFloatingTwoDecimalPlacesRule();
		isANumberGreaterThan49();
	}

	private void nonemptyRule() throws RuleException {
		if(bookWindow.getIsbnValue().trim().isEmpty() ||
				bookWindow.getTitleValue().trim().isEmpty() ||
				bookWindow.getPriceValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}

	private void idNumericRule() throws RuleException {
		String val = bookWindow.getIsbnValue().trim();
		if(val.length() != 10 && val.length() != 13) {
			throw new RuleException("ISBN value must be 10 or 13 characters!");
		}
		if(val.length() == 10) {
			if(!val.startsWith("0") && !val.startsWith("1")) {
				throw new RuleException("ISBN value must be started with 0 or 1!");
			}
		}
		if(val.length() == 13) {
			if(!val.startsWith("978") && !val.startsWith("979")) {
				throw new RuleException("ISBN value must be started with 978 or 979!");
			}
		}
		try {
			Integer.parseInt(val);
			//val is numeric
		} catch(NumberFormatException e) {
			throw new RuleException("Isbn must be numeric");
		}
	}

	private void isPriceFloatingTwoDecimalPlacesRule() throws RuleException {
		try {
			Double.parseDouble(bookWindow.getPriceValue().trim());
		} catch(NumberFormatException e) {
			throw new RuleException("Isbn must be numeric");
		}
		double val = Double.parseDouble(bookWindow.getPriceValue().trim());
		if (BigDecimal.valueOf(val).scale() != 2) {
			throw new RuleException("Price must be floating two decimal places!");
		}
	}

	private void isANumberGreaterThan49() throws RuleException {
		double val = Double.parseDouble(bookWindow.getPriceValue().trim());
		if(val <= 0.49) {
			throw new RuleException("Price must be greater than or equal to 0.49!");
		}
	}

}
