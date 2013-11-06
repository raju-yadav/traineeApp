package validators;

import model.CommonBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

@Component
public class TrainingInvitationValidator {
	public void validate(BindingResult errors,CommonBean commonBean,String trainingName, String venuName, String timeSlot) {
		ValidationUtils.rejectIfEmpty(errors, "selectedMails", "selectedMails.required");
		if(trainingName==""){
			errors.rejectValue("trainingName", "trainingName.required");
		}
		if(venuName==""){
			errors.rejectValue("venu", "venu.required");
		}
		if(timeSlot==""){
			errors.rejectValue("timeSlot", "timeSlot.required");
		}
		if(errors.getErrorCount()==0)
		{
			if(commonBean.getSelectedMails().length==0){
				errors.rejectValue("selectedMails", "selectedMails.required");
			}
		}
	}
}
