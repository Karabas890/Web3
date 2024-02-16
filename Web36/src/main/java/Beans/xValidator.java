package Beans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.FacesValidator;
import jakarta.faces.validator.Validator;
import jakarta.faces.validator.ValidatorException;

@FacesValidator("YValidator")
public class xValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        Double xValue = (Double) value;

        if (xValue == null) {
            FacesMessage message = new FacesMessage("X должен быть выбран");
            throw new ValidatorException(message);
        }

        if (xValue.isNaN()) {
            FacesMessage message = new FacesMessage("X должен быть цифрой");
            throw new ValidatorException(message);
        }

        if (xValue <= -3 || xValue >= 3) {
            FacesMessage message = new FacesMessage("X должен быть в промежутке (-5; 5)");
            throw new ValidatorException(message);
        }
    }
}