package foods;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FoodsController {

	private DB db;
	private UserService userService;

	@Autowired
	public void setDb(DB db) {
		this.db = db;
	}
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	//SELECT 1 AS val
	//SELECT COUNT(*) FROM contents
	//SELECT source_id, orig_source_name, orig_content, orig_unit FROM contents LIMIT 5
	/*
	SELECT source_id, orig_source_name, orig_content, orig_unit 
	FROM contents 
	WHERE orig_food_common_name = "Milk, whole, konventional (not organic), 3.5 % fat" 
	AND orig_source_name IS NOT NULL
	*/

	ArrayList<ArrayList<String>> queries = new ArrayList<>();

	@PostMapping()
	public String handlePostQueries(String query) {
		queries = new ArrayList<>(db.find(query));
		return "redirect:/";
	}

	@GetMapping()
	public String handleGetQueries(Model model) {
		model.addAttribute("queries", queries);
		User user = userService.findFirst();
		System.out.println(user.toString());
		return "index";
	}

}