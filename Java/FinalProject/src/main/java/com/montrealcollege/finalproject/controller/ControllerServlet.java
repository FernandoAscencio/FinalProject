package com.montrealcollege.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.montrealcollege.finalproject.model.Application;
import com.montrealcollege.finalproject.model.CurriculumVitae;
import com.montrealcollege.finalproject.model.Education;
import com.montrealcollege.finalproject.model.Job;
import com.montrealcollege.finalproject.model.Login;
import com.montrealcollege.finalproject.model.Session;
import com.montrealcollege.finalproject.model.Skills;
import com.montrealcollege.finalproject.model.User;
import com.montrealcollege.finalproject.model.WorkExperience;
import com.montrealcollege.finalproject.service.AppService;
import com.montrealcollege.finalproject.service.EducationService;
import com.montrealcollege.finalproject.service.JobService;
import com.montrealcollege.finalproject.service.SkillsService;
import com.montrealcollege.finalproject.service.UserService;
import com.montrealcollege.finalproject.service.WorkExpericenceService;

@Controller
@SessionAttributes("session")
public class ControllerServlet {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(ControllerServlet.class);

	public ControllerServlet() {
		System.out.println("ControllerServlet()");
	}

	@Autowired
	private UserService us;

	@Autowired
	private AppService as;

	@Autowired
	private JobService js;

	@Autowired
	private EducationService es;

	@Autowired
	private SkillsService ss;

	@Autowired
	private WorkExpericenceService wes;

	@ModelAttribute("session")
	public Session getSession() {
		return new Session();
	}

	@RequestMapping(method = RequestMethod.GET)
	public String start(Model model) {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listJobs(@ModelAttribute("session") Session session, Model model) {
		List<Job> jobs = js.listJob();
		if (session.isLogedIn()) {
			User user = us.getUser(session.getUserId());
			model.addAttribute("type", user.getType());
		}
		model.addAttribute("jobs", jobs);
		return "home";
	}

	@RequestMapping(value = "/jobs", method = RequestMethod.GET)
	public String listJobsByUser(@ModelAttribute("session") Session session, Model model) {
		List<Job> jobs = js.listJobByUser(session.getUserId());
		if (jobs == null)
			return "JobCreationForm";
		else {
			model.addAttribute("jobs", jobs);
			model.addAttribute("company", true);
			return "ViewJobs";
		}
	}

	@RequestMapping(value = "/job", method = RequestMethod.GET)
	public String viewJob(@RequestParam("id") int id, Model model) {
		Job job = js.getJob(id);
		User user = job.getCompany();
		
		model.addAttribute("company", user);
		model.addAttribute("job", job);
		
		return "JobView";
	}

	@RequestMapping(value = "/newJob", method = RequestMethod.GET)
	public String newJob(Model model) {
		model.addAttribute("job", new Job());
		return "JobCreationForm";
	}

	@RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
	public String deleteJob(@RequestParam("id") Integer id) {
		js.deleteJob(id);
		return "ViewJobs";
	}

	@RequestMapping(value = "/editJob", method = RequestMethod.GET)
	public String editJob(@RequestParam("id") Integer id, Model model) {
		model.addAttribute("job", js.getJob(id));
		return "JobCreationForm";
	}

	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public String saveJob(@Valid @ModelAttribute(value = "job") Job job, BindingResult errors,
			@ModelAttribute("session") Session session) {
		User user = us.getUser(session.getUserId());
		if (errors.hasErrors()) {
			return "JobCreationForm";
		} else {
			job.setCompany(user);
			if (job.getId() == 0) {
				js.addJob(job);
			} else {
				js.updateJob(job);
			}
			return "redirect:/index";
		}
	}

	@RequestMapping(value = "/apply", method = RequestMethod.GET)
	public String applyJob(@RequestParam("id") Integer id, @ModelAttribute("session") Session session, 
			Model model) {
		User user = us.getUser(session.getUserId());
		Job job = js.getJob(id);
		Application app = new Application();
		
		if (as.getAppByUserJob(session.getUserId(), id) == null) {
			app.setJob(job);
			app.setUser(user);
			as.addApplication(app);
			System.out.println("Applied!");
			return "redirect:/index";
		} else {
			model.addAttribute("job", js.getJob(id));
			System.out.println("Not Applied!");
			return "JobView";
		}
	}
	
	@RequestMapping(value="/applicants", method=RequestMethod.GET)
	public String listApplicants(@RequestParam("id") Integer jobId, Model model) {
		List<User> users = new ArrayList<>(); 
		for(Application a : as.getAppByJob(jobId)) {
			users.add(a.getUser());
		}
		model.addAttribute("applicants", users);
		return "ViewApplicants";
	}
	
	@RequestMapping(value="/viewCV", method=RequestMethod.GET)
	public String viewCV (@RequestParam("id") Integer id, Model model) {
		CurriculumVitae cv = new CurriculumVitae(id);

		cv.setEmployment(wes.listWorkExperienceByUser(id));
		cv.setSchooling(es.listEducationByUser(id));
		cv.setSkills(ss.listSkillsByUser(id));
		
		model.addAttribute("readonly", true);
		model.addAttribute("cv", cv);
		return "CVForm";
	}
	
	@RequestMapping(value="/applied", method=RequestMethod.GET)
	public String jobsApplied(@ModelAttribute("session") Session session, Model model) {
		List<Job> jobs = new ArrayList<>();
		for(Application a : as.getAppByUser(session.getUserId())) {
			jobs.add(a.getJob());
		}
		model.addAttribute("jobs", jobs);
		return "ViewJobs";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String newUser(Model model) {
		model.addAttribute("user", new User());
		return "RegistrationForm";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String editUser(@ModelAttribute("session") Session session, Model model) {
		model.addAttribute("user", us.getUser(session.getUserId()));
		return "RegistrationForm";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute(value = "user") User user, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			return "JobCreationForm";
		} else {
			if (user.getId() == 0) {
				us.addUser(user);
				Login log = new Login(user.getLogin(), user.getPassword());
				model.addAttribute("login", log);
				return "redirect:/processing";
			} else {
				us.updateUser(user);
				return "redirect:/index";
			}
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String logIn(Model model) {
		model.addAttribute("login", new Login());
		return "LoginForm";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(@ModelAttribute("session") Session session, Model model) {
		session.setUserId(0);
		session.setLogedIn(false);
		return "redirect:/index";
	}

	@RequestMapping(value = "/processing", method = RequestMethod.POST)
	public String loginProcess(@ModelAttribute("login") Login login, @ModelAttribute("session") Session session,
			Model model) {

		User user = us.validateUser(login);
		if (user != null) {
			session.setUserId(user.getId());
			session.setLogedIn(true);
			return "redirect:/index";
		} else {
			model.addAttribute("msr", "Wrong Credentials");
			return "LoginForm";
		}
	}

	@RequestMapping(value = "/curriculumVitae", method = RequestMethod.GET)
	public String newCV(@ModelAttribute("session") Session session, Model model) {

		int userID = session.getUserId();
		CurriculumVitae cv = new CurriculumVitae(userID);
		WorkExperience we = new WorkExperience();
		Education edu = new Education();

		cv.setEmployment(wes.listWorkExperienceByUser(userID));
		if (cv.getEmployment() == null)
			cv.setEmployment(new ArrayList<WorkExperience>());

		cv.setSchooling(es.listEducationByUser(userID));
		if (cv.getSchooling() == null)
			cv.setSchooling(new ArrayList<Education>());
		
		cv.setSkills(ss.listSkillsByUser(userID));
		if (cv.getSkills() == null)
			cv.setSkills(new Skills());

		model.addAttribute("cv", cv);
		model.addAttribute("we", we);
		model.addAttribute("edu", edu);
		model.addAttribute("readonly", false);
		return "CVForm";
	}

	@RequestMapping(value = "/saveCV", method = RequestMethod.POST)
	public String saveCV(@ModelAttribute(value = "cv") CurriculumVitae cv, BindingResult errors, Model model) {
		User user = us.getUser(cv.getUserId());
		List<WorkExperience> employment = cv.getEmployment();
		List<Education> schooling = cv.getSchooling();
		Skills skills = cv.getSkills();
		// add skills to table
		user.setSkills(skills);
		skills.setUser(user);
		if (skills.getId() == 0) {
			ss.addSkills(skills);
		} else {
			ss.updateSkills(skills);
		}
		// add work experience to table
		if (employment != null) {
			for (WorkExperience we : employment) {
				we.setUser(user);
				if (we.getId() == 0) {
					wes.addWorkExperience(we);
				} else {
					wes.updateWorkExperience(we);
				}
			}
		}

		// add education to table
		if (schooling != null) {
			for (Education edu : schooling) {
				edu.setUser(user);
				if (edu.getId() == 0) {
					es.addEducation(edu);
				} else {
					es.updateEducation(edu);
				}
			}
		}
		return "redirect:/index";
	}

	@RequestMapping(value = "/addEducation", method = RequestMethod.POST)
	public String addEducation(@Valid @ModelAttribute(value = "edu") Education edu, BindingResult errors,
			@ModelAttribute("session") Session session, Model model) {
		User user = us.getUser(session.getUserId());
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "CVForm";
		} else {
			edu.setUser(user);
			if (edu.getId() == 0) {
				es.addEducation(edu);
			} else {
				es.updateEducation(edu);
			}
			return "redirect:/curriculumVitae";
		}
	}

	@RequestMapping(value = "/deleteEdu", method = RequestMethod.GET)
	public String deleteEducation(@RequestParam("id") Integer id) {
		es.deleteEducation(id);
		return "redirect:/curriculumVitae";
	}

	@RequestMapping(value = "/addWorkExp", method = RequestMethod.POST)
	public String addWorkExp(@Valid @ModelAttribute(value = "we") WorkExperience we, BindingResult errors,
			@ModelAttribute("session") Session session, Model model) {
		User user = us.getUser(session.getUserId());
		if (errors.hasErrors()) {
			System.out.println(errors);
			return "CVForm";
		} else {
			we.setUser(user);
			if (we.getId() == 0) {
				wes.addWorkExperience(we);
				;
			} else {
				wes.updateWorkExperience(we);
			}
			return "redirect:/curriculumVitae";
		}
	}

	@RequestMapping(value = "/deleteWorkExp", method = RequestMethod.GET)
	public String deleteWorkExp(@RequestParam("id") Integer id) {
		wes.deleteWorkExperience(id);
		return "redirect:/curriculumVitae";
	}
}
