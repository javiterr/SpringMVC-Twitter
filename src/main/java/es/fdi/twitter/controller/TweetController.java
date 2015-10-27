package es.fdi.twitter.controller;


import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import es.fdi.twitter.entities.Tweet;
import es.fdi.twitter.service.TweetService;


@Controller
public class TweetController {

	@Autowired
	private TweetService tweet_service;
	
    public TweetController() {
		super();
	}
	
    
    @ModelAttribute("allTweets")
    public List<Tweet> listaDeTweets() {
        return this.tweet_service.getLista();
    }
    
    /*
	@RequestMapping(value="/welcome.htm")
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
		List<Tweet> tweets = this.tweet.getList();
		
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("tweets", tweets);
		
		return new ModelAndView("welcome","model", myModel);
	}
	*/
	
	
    @RequestMapping({"/","/welcome"})
    public String showTweets(Tweet t) {
        return "welcome";
    }
    
    
	@RequestMapping(value="/welcome", params={"publicar"})
	public String publicar(Tweet t,BindingResult bindingResult, ModelMap model){
		if (bindingResult.hasErrors()) {
            return "welcome";
        }
		t.setFecha(Calendar.getInstance().getTime());
		this.tweet_service.addTweet(t);
		model.clear();
		
		return "redirect:/welcome";
	}
	
	
}
