package validators;


import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

@Component
public class FeedBackFormValidator {

	public void validate(BindingResult errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjClearRadio", "trObjClearRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjAchievedRadio", "trObjAchievedRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjContentRadio", "trObjContentRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjRateRadio", "trObjRateRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjReadingRadio", "trObjReadingRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjTopiceRadio", "trObjTopiceRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjJobRadio", "trObjJobRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjPresentedRadio", "trObjPresentedRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjLevelRadio", "trObjLevelRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjTrainerRadio", "trObjTrainerRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjTrainrRadio", "trObjTrainrRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjUrsantRadio", "trObjUrsantRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjSessionRadio", "trObjSessionRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "trObjAnsRadio", "trObjAnsRadio.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feedbackSuggestion", "feedbackSuggestion.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "feedbackPerspective", "feedbackPerspective.required");
	}
}

