package com.mydiary.member.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mydiary.member.contants.Member;
import com.mydiary.member.service.MemberService;
import com.mydiary.member.vo.MemberVO;

@Controller
public class MemberController {

	MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/")
	public ModelAndView viewMainPage(HttpSession session) {
		ModelAndView view = new ModelAndView();
		
		MemberVO user = (MemberVO) session.getAttribute(Member.USER);
		
		view.setViewName("member/profile");
		view.addObject("profile", memberService.readMemberOne(user.getUserId()));
		return view;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String viewLoginPage() {

		return "member/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLoginAction(MemberVO memberVO, HttpServletRequest request) {

		HttpSession session = request.getSession();

		MemberVO loginMember = memberService.readMember(memberVO);

		if (loginMember != null) {
			session.setAttribute(Member.USER, loginMember);
			return "redirect:/";
		}

		return "redirect:/login";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String viewSignupPage() {
		return "member/signup";
	}
	

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView doRegistAction(@ModelAttribute("signupForm") @Valid MemberVO memberVO, 
			Errors errors) {
		if (errors.hasErrors()) {
			return new ModelAndView("member/signup");
		}
		if (memberService.createMember(memberVO)) {
			return new ModelAndView("redirect:/login");
		}

		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping("/api/exists/email")
	@ResponseBody 
	public Map<String, Boolean> apiIsExistsEmail(@RequestParam String email){
		boolean isExists = memberService.readCountMemberEmail(email);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		response.put("response", isExists);

		return response;
	}
	

	@RequestMapping(value = "/profile/modify", method=RequestMethod.GET)
	public ModelAndView viewProfileModifyPage(HttpSession session) {
		
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		MemberVO profile = memberService.readMemberOne(member.getUserId());
		
		int userId = member.getUserId();
		
		if(userId != profile.getUserId()) {
			return new ModelAndView("error/404");
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("member/profileModify");
		view.addObject("profile", profile);
		return view;

	}
	
	@RequestMapping(value="/profile/modify", method=RequestMethod.POST)
	public String doProfileModifyPage(
			@ModelAttribute("profileForm") @Valid MemberVO profileVO, Errors errors, HttpSession session) {
		
		
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		
		System.out.println(member.getUserId());
		
		MemberVO originalVO = memberService.readMemberOne(member.getUserId());
		

		System.out.println(profileVO.getLikeThing());
		System.out.println(originalVO.getLikeThing());
		
		MemberVO newProfile = new MemberVO();
		newProfile.setUserId(originalVO.getUserId());
		newProfile.setEmail(originalVO.getEmail());
		boolean isModify = false;
		
		if(originalVO.getProfilePicture() == null) {
			originalVO.setProfilePicture("");
		}
		profileVO.save();
		System.out.println(profileVO.getProfilePicture());
		System.out.println(originalVO.getProfilePicture());
		
		if( !originalVO.getProfilePicture().equals(profileVO.getProfilePicture())) {
			newProfile.setProfilePicture(profileVO.getProfilePicture());
			isModify = true;
		}
		
		if( !originalVO.getName().equals(profileVO.getName())) {
			newProfile.setName(profileVO.getName());
			isModify = true;
		}
		
		if(!originalVO.getLikeThing().equals(profileVO.getLikeThing())) {
			newProfile.setLikeThing(profileVO.getLikeThing());
			isModify = true;
		}
		
		if(!originalVO.getHateThing().equals(profileVO.getHateThing())) {
			newProfile.setHateThing(profileVO.getHateThing());
			isModify = true;
		}
		
		
		
		if(!originalVO.getProfileMemo().equals(profileVO.getProfileMemo())) {
			newProfile.setProfileMemo(profileVO.getProfileMemo());
			isModify = true;
		}
		
		
		if(isModify) {

			memberService.updateProfile(newProfile);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping("/delete/member")
	public String deleteMember(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		
		memberService.deleteMember(member.getUserId());
		
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String doLogoutAction(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
