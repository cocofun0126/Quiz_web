package day02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import day02.dao.Member;
import day02.dao.MemberDao;
import day02.vo.PageBean;
//@Component
@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	
	@Override
	public void add(Member member) throws MemberException {
		if(memberDao.search(member.getMemid())!=null  )
			throw new MemberException("미등록 회원");
		
		memberDao.insert(member);
	}

	@Override
	public List<Member> searchAll(PageBean pageBean) {
		return memberDao.searchAll(pageBean);
	}

	@Override
	public Member search(String memid) {
		return memberDao.search(memid);
	}
	
	

}
