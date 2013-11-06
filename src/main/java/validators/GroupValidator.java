package validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.CommonBean;
import model.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;

import service.GroupService;
@Component
public class GroupValidator {
	@Autowired
	private GroupService groupService;
	private Pattern pattern;
	  private Matcher matcher;
	  private static final String name ="^[a-zA-Z][a-zA-Z\\s]+$";
public void validate(BindingResult errors,CommonBean commonBean) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "groupName", "groupName.required");
		if(errors.getErrorCount()==0){
			if(commonBean.getGroupName().length()>50)
				errors.rejectValue("groupName", "groupName.size");
		}
		if(errors.getErrorCount()==0){
			pattern = Pattern.compile(name);
			String groupName=commonBean.getGroupName();
			matcher=pattern.matcher(groupName);
			if(!matcher.matches()){
				errors.rejectValue("groupName", "groupName.notValid");
			}
		}
		if(errors.getErrorCount()==0){
			String groupName=commonBean.getGroupName();
			Group group=groupService.getGroup(groupName);
			 if(group!=null){
				 errors.rejectValue("groupName","groupName.exists");
			 }
		}
}

}
