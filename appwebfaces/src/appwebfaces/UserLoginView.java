package appwebfaces;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import util.SessionUtils;
@ManagedBean(name="userLoginView")
public class UserLoginView implements Serializable {

	private static final long serialVersionUID = 1094801825228386363L;

	private String password;
	private String msg;
	private String username;
 
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	private boolean validate() {
		return username != null && username.equals("admin") && password != null && password.equals("admin") ? true
				: false;
	}

	// validate login
	public String logueo() throws IOException {
		System.out.println("Validando al usuario logueado..........."+username+" ::: "+password);
		String resultado = "login";
		boolean valid = validate(); // LoginDAO.validate(user, pwd);
		if (valid) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", username);
			resultado = "succes";
			
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		    ec.redirect(ec.getRequestContextPath() + "/home.xhtml");
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Incorrect Username and Passowrd", "Please enter correct username and Password"));
			resultado = "login";
		}
		return resultado;
	}

	// logout event, invalidate session
	public String logout() {
		HttpSession session = SessionUtils.getSession();
		session.invalidate();
		return "login";
	}

}
