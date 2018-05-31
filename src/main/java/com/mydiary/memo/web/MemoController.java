package com.mydiary.memo.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mydiary.member.contants.Member;
import com.mydiary.member.vo.MemberVO;
import com.mydiary.memo.service.MemoService;
import com.mydiary.memo.vo.MemoVO;

@Controller
public class MemoController {

	private MemoService memoService;

	public void setMemoService(MemoService memoService) {
		this.memoService = memoService;
	}

	@RequestMapping("/memo")
	public ModelAndView viewMemoPage(HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		List<MemoVO> memoList = memoService.readMemoAll(member.getUserId());
		ModelAndView view = new ModelAndView();
		view.setViewName("memo/memo");
		view.addObject("memoList", memoList);
		return view;
	}

	@RequestMapping(value = "/memo/write", method = RequestMethod.GET)
	public String viewMemoWritePage() {
		return "memo/memoWrite";
	}

	@RequestMapping(value = "/memo/write", method = RequestMethod.POST)
	public ModelAndView doMemoWritePage(@ModelAttribute("memoWriteForm") @Valid MemoVO memoVO, Errors errors,
			HttpSession session) {

		if (errors.hasErrors()) {
			ModelAndView view = new ModelAndView();
			view.setViewName("memo/write");
			view.addObject("memoVO", memoVO);
			return view;
		}
		
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		memoVO.setMemberId(member.getUserId());

		if (memoService.insertMemo(memoVO)) {
			return new ModelAndView("redirect:/memo");
		}

		return new ModelAndView("redirect:/memo/write");
	}

	@RequestMapping("/memo/view/{id}")
	public ModelAndView viewMemoPageOne(@PathVariable int id) {
		MemoVO memo = memoService.readMemoOne(id);
	
		ModelAndView view = new ModelAndView();
		view.setViewName("memo/memoView");
		view.addObject("memo", memo);
		return view;
	}

	@RequestMapping(value = "/memo/modify/{id}", method = RequestMethod.GET)
	public ModelAndView viewMemoModifyPage(HttpSession session, @PathVariable int id) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);

		int userId = member.getUserId();
		MemoVO memo = memoService.readMemoOne(id);

		if (userId != memo.getMemberId()) {
			return new ModelAndView("error/404");
		}
		
		ModelAndView view = new ModelAndView();
		view.setViewName("memo/write");
		view.addObject("memoVO", memo);
		view.addObject("mode", "modify");
		
		return view;
	}
	
	@RequestMapping("/memo/delete/{id}")
	public String doDeleteMemo(@PathVariable int id) {
		
		memoService.deleteMemo(id);
		
		return "redirect:/memo";
	}

	@RequestMapping(value = "/memo/modify/{id}", method = RequestMethod.POST)
	public String doMemoModifye(@PathVariable int id, 
			@ModelAttribute("profileForm") @Valid MemoVO memoVO, Errors errors, 
			HttpSession session) {
		MemberVO member = (MemberVO) session.getAttribute(Member.USER);
		
		if(member.getUserId() != memoVO.getMemberId()) {
			return "error/404";
		}
		
		MemoVO originalVO = memoService.readMemoOne(id);
		
		MemoVO newMemo = new MemoVO();
		newMemo.setMemberId(originalVO.getMemberId());
		newMemo.setMemoId(originalVO.getMemoId());
		boolean isModify = false;

		if( !originalVO.getMemoTitle().equals(memoVO.getMemoTitle())) {
			newMemo.setMemoTitle(memoVO.getMemoTitle());
			isModify = true;
		}
		
		if( !originalVO.getMemoBody().equals(memoVO.getMemoBody())) {
			newMemo.setMemoBody(memoVO.getMemoBody());
			isModify = true;
		}
		
		if(isModify) {

			memoService.updateMemo(newMemo);
		}
		
		return "redirect:/memo";
	}

}
