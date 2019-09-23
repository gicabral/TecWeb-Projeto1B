package mvc.controller;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import mvc.model.*;

@Controller
public class ControllerMain {
	
	@RequestMapping("/")
	public String execute() {
		return "index";
		
	}
	
	@RequestMapping(value = "paginaInicial", method = RequestMethod.POST)
	public String form1(Pessoas pessoas, HttpSession session) throws SQLException {
		DAO dao = new DAO();
		dao.login(pessoas);
		String usuario = pessoas.getUsuario();
		String senha = pessoas.getSenha();
		
		session.setAttribute("usuario", usuario);
		session.setAttribute("senha", senha);
		System.out.println("hashahahahahhahahahhahahahahah");

		if (usuario.isEmpty()) {
				return "redirect:/";
		} else if (senha == null){
				return "redirect:/";
		}else {
			return "redirect:PaginaInicial";

		}
	}
	@RequestMapping(value = "Register", method = RequestMethod.POST)
	public String register(Pessoas pessoas, @RequestParam (name = "confirmarsenha") String Confirmarsenha, HttpSession session) throws SQLException {
		String usuario = pessoas.getUsuario();
		String senha = pessoas.getSenha();
		String confirmarsenha = pessoas.getConfirmarsenha();
		if (senha.contentEquals(confirmarsenha)) {
			if(senha.isEmpty()) {
				return "redirect:register";

			}
			DAO dao = new DAO();
			dao.register(pessoas);
			session.setAttribute("üsuario", usuario);
			session.setAttribute("senha", senha);
			return "redirect:/";
		} else {
			return "redirect:register";
		}
		

		
	}
	
	@RequestMapping("PaginaInicial")
	public String login() {
		return "paginaInicial";
		
	}
	@RequestMapping("viewusers")
	public String viewusers() {
		return "viewusers";
		
	}
	
	@RequestMapping("register")
	public String register() {
		return "register";
		
	}
	@RequestMapping("adduserform")
	public String newQuestion() {
		return "adduserform";
		
	}
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String adduser(User user, HttpSession session) {
		String name = user.getName();
		String question = user.getQuestion();
		String importance = user.getImportance();

		int i = DAO.save(user);
		
		if(name.isEmpty()) {
			i = 0;
		}
		if(question.isEmpty()) {
			i = 0;
		}
		if(importance.isEmpty()) {
			i = 0;
		}
		if(i>0) {
			user.setName(name);
			user.setQuestion(question);
			user.setImportance(importance);
			return "redirect:success";

		}else {
			return "redirect:error";
		}

		
	}
	
	@RequestMapping("success")
	public String success() {
		return "adduser-success";
		
	}
	
	@RequestMapping("normal")
	public String normal() {
		return "adduserform";
		
	}
	
	@RequestMapping("error")
	public String error() {
		return "adduser-error";
		
	}
	
	@RequestMapping(value = "edituser", method = RequestMethod.POST)
	public String edituser(User user, HttpSession session) {
		int id = user.getId();
		String name = user.getName();
		String question = user.getQuestion();
		String importance = user.getImportance();
		user = DAO.getRecordById(id);
		user.setName(name);
		user.setQuestion(question);
		user.setImportance(importance);
		DAO.update(user);
		return "redirect:ViewUsers";
	}
	
	@RequestMapping("ViewUsers")
	public String view() {
		return "viewusers";
		
	}
	
	@RequestMapping("answer")
	public String answer() {
		return "answer";
		
	}
	
	@RequestMapping("note")
	public String note() {
		return "note";
		
	}
	
	@RequestMapping("editform")
	public String editform() {
		return "editform";
		
	}
	
	@RequestMapping(value = "editAnswer", method = RequestMethod.POST)
	public String editanswer(User user, HttpSession session) {
		int id = user.getId();
		String answer = user.getAnswer();
		user = DAO.getRecordById(id);
		user.setAnswer(answer);
		DAO.updateAnswer(user);
		return "redirect:ViewUsers";
	}
	

	
	@RequestMapping(value = "deleteuser", method = RequestMethod.GET)
	public String deleteuser(User user, HttpSession session) {
		int id = user.getId();
		user = DAO.getRecordById(id);
		DAO.delete(user);
		return "redirect:ViewUsers";
	}
	
	@RequestMapping(value = "order")
	public String order(User u, HttpSession session) {
		int id = u.getId();
		u = DAO.getRecordById(id);
		DAO.deleteImportance(u);
		return "redirect:ViewUsers";
	}
	
	

	
	

	

}