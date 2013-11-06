package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import model.CommonBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import service.FeedBackFormService;
//import service.EmployeeService;
import service.TrainingService;
import validators.FeedBackFormValidator;

@Controller
@SessionAttributes("commonBean")
@Transactional
public class FeedBackFormController extends ManagementControllerSupport {
    @Autowired
    private FeedBackFormValidator feedBackFormValidator;
    @Autowired
    private TrainingService traservice;
//    @Autowired
//    private EmployeeService empservice;
    
    @Autowired
	private FeedBackFormService feedBackFormService;

    @RequestMapping("/CreateFeedBack/feedback.htm")
    public String showForm(HttpSession session, Map<String, Object> model) {
    	if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
    	loadCommonData(session, model);
        List<String> training=traservice.getTraining();
        model.put("training",training);
//        List<String> emp=empservice.getEmp();
//        model.put("emp", emp);
        return "/corefiles/feedbackform";
    }

    @RequestMapping(value = "/CreateFeedBack/save.htm", method = RequestMethod.POST)
    public String next(HttpSession session, @ModelAttribute("commonBean") CommonBean commonBean, BindingResult errors, Map<String, Object> model) {
    	if(session.getAttribute("user")==null){
			return "redirect:/login.htm";
		}
    	feedBackFormValidator.validate(errors);

        if (errors.hasErrors()) {
            return showForm(session, model);
        }
        loadCommonData(session, model);
      //  feedBackFormService.saveOrUpdate(commonBean);
        model.put("val","FeedBack is ");
        return "/corefiles/success";
    }
//
//    @RequestMapping("/feedbackform/details.htm")
//    public String showDetails(HttpSession session,@ModelAttribute("commonBean") CommonBean commonBean, SessionStatus status, Map<String, Object> model) {
//        loadCommonData(session, model);
//        model.put("commonBean", commonBean);
//        List<ExpectedArrivals> arrivalsList = feedBackFormService.getArrivalsList();
//        List<YogaBuildingRoom> availableRoomList = feedBackFormService.getAvailableRoom();
//        model.put("arrivalsList", arrivalsList);
//        model.put("availableRoomList",availableRoomList);
//        return "/management/arrivalsDetails";
//    }
//    @RequestMapping("/feedbackform/save.htm")
//    public String save(@ModelAttribute("commonBean") CommonBean commonBean,
//    		           SessionStatus status,Map<String, Object> model  ) {
//    	Long arrivalId = Long.parseLong(commonBean.getRadioArr());
//    	Long buildingRoomId = Long.parseLong(commonBean.getRadioRoom());
//    	feedBackFormService.updateBuildingRooms(arrivalId, buildingRoomId);
//		return "redirect:details.htm";
//    	
//    }
    
    @RequestMapping(value = "/feedbackform/save.htm", params = "more")
    public String cancel(SessionStatus status) {
        return "redirect:index.htm";
    }

    @InitBinder
    public void bindConverters(WebDataBinder binder) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
    }
}