package service;
import java.util.Date;
import java.util.List;

import model.CommonBean;
public interface MailManagerService {
 void sendMail(CommonBean commonBean, List<String> aray, List<Date> dateDet);
}
