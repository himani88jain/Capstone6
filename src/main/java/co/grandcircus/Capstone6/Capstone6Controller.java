package co.grandcircus.Capstone6;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class Capstone6Controller {

@Autowired
private UserRepo  userRepo;

@Autowired
private TaskRepo taskRepo;

@Autowired
private HttpSession session;

@RequestMapping("/")
public String welcomeOrLogin() {
	if(session.getAttribute("user")!=null){
	return "welcome";
	}else {
		return "login";
	}
}

@RequestMapping("/login-submit")
public String submitLoginForm(Model model,@RequestParam("email") String email,
								@RequestParam("password") String password) {
	Optional<User> foundUser =userRepo.findByEmailAndPassword(email, password);
	if(foundUser.isPresent()) {
		session.setAttribute("user", foundUser.get());
		return "redirect:/";
	}else {
		model.addAttribute("message","Incorrect email and password");
		return "login";
	}
}

@RequestMapping("/list-task")
public String taskList(Model model) {
	User user=(User)session.getAttribute("user");
	model.addAttribute("tasks",taskRepo.findByUserId(user.getId()));
	return "task-list";
}

@RequestMapping("/search-by-name")
public String searchTaskByName(Model model,@RequestParam("description") String desc) {
	User user=(User)session.getAttribute("user");
	List<Task> tasks =taskRepo.findTaskByUserIdAndName(desc,user.getId());
	model.addAttribute("tasks",tasks);
	return "task-list";
}

@RequestMapping("/search-by-completion")
public String searchTaskByCompletionStatus(Model model,@RequestParam("complete_status") String comp) {
	Boolean complete=true;
	if(comp.equals("Complete"))
		 complete=true;
	if(comp.equals("Incomplete"))
		 complete=false;
	User user=(User)session.getAttribute("user");
	List<Task> tasks =taskRepo.findByComplete(user.getId(),complete);
	model.addAttribute("tasks",tasks);
	return "task-list";
}

@RequestMapping("/sortby-duedate")
public String sortByDueDate(Model model) {
	User user=(User)session.getAttribute("user");
	List<Task> tasks=taskRepo.findByUserIdAndOrderByDuedateDesc(user.getId());
	model.addAttribute("tasks",tasks);
	return "task-list";
}

@RequestMapping("/add-task")
public String showAddTaskForm() {
	return "add-task";
}

@PostMapping("/add-task")
public String submitTaskForm(Task task) {
	User user=(User)session.getAttribute("user");
	user=userRepo.findById(user.getId()).get();
	task.setUser(user);
	taskRepo.save(task);
	return "redirect:/list-task";
}

@RequestMapping("/delete-task")
public String removeTask(@RequestParam("id") Long id) {
	taskRepo.deleteById(id);
	return "redirect:/list-task";
}

@RequestMapping("/changeTasktoComplete")
public String changeTask(@RequestParam("id") Long id) {
     Task task=taskRepo.findById(id).get();
     if(task.isComplete()==false)
    	 task.setComplete(true);
     else if(task.isComplete()==true)
    	 task.setComplete(false);
    taskRepo.save(task);
    return "redirect:/list-task";
}

@RequestMapping("/logout")
public String logout(RedirectAttributes redir) {
	session.invalidate();
	
	redir.addFlashAttribute("message", "Logged out.");
	return "redirect:/";
}
}
