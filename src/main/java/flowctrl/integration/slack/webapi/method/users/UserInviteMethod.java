package flowctrl.integration.slack.webapi.method.users;

import flowctrl.integration.slack.validation.Problem;
import flowctrl.integration.slack.validation.ValidationError;
import flowctrl.integration.slack.webapi.SlackWebApiConstants;
import flowctrl.integration.slack.webapi.method.AbstractMethod;

import java.util.List;
import java.util.Map;

/**
 * @author Furze
 */
public class UserInviteMethod extends AbstractMethod {

    public UserInviteMethod(String email) {
        this.email = email;
    }

    public UserInviteMethod(String email, Boolean setActive){
        this.email= email;
        this.setActive = setActive;
    }

    protected String email;
    protected Boolean setActive = true;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSetActive() {
        return setActive;
    }

    public void setSetActive(boolean setActive) {
        this.setActive = setActive;
    }

    @Override
    public String getMethodName() {
        return SlackWebApiConstants.USERS_INVITE;
    }

    @Override
    public void validate(List<ValidationError> errors) {
        if (email == null) {
            addError(errors, "email", Problem.REQUIRED);
        }
    }

    @Override
    protected void createParameters(Map<String, String> parameters) {
        parameters.put("email", email);
        parameters.put("setActive", setActive.toString());
    }

}
