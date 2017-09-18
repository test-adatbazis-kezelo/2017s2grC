package ro.msg.edu.client.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneNumberValidator")
public class PhoneNumberValidator implements Validator {
	private final static String REGEX = "^(\\+)" + "[0-9]$";
	private final static String MATCHER_PHONE_GERMANY = "+49";
	private final static String MATCHER_PHONE_ROMANIA = "+40";

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String stringValue = value.toString();
		if (stringValue.length() < 10 && stringValue.length() > 15 && !(stringValue.startsWith(MATCHER_PHONE_GERMANY))
				&& !(stringValue.startsWith(MATCHER_PHONE_ROMANIA)) && !(stringValue.matches(REGEX))) {
			String phoneValidationMessage = context.getApplication().evaluateExpressionGet(context,
					"#{msg['validator.phone']}", String.class);
			FacesMessage message = new FacesMessage(phoneValidationMessage);
			throw new ValidatorException(message);
		}

	}

}
