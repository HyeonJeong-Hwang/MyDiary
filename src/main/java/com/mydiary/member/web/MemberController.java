package com.mydiary.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public ModelAndView doRegistAction(@ModelAttribute("signupForm") @Valid MemberVO memberVO, Errors errors) {
		if (errors.hasErrors()) {
			return new ModelAndView("member/signup");
		}
		if (memberService.createMember(memberVO)) {
			return new ModelAndView("redirect:/login");
		}

		return new ModelAndView("redirect:/login");
	}
}
