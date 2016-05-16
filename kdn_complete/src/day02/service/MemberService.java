package day02.service;

import java.util.List;

import day02.dao.Goods;
import day02.dao.Member;
import day02.vo.PageBean;

public interface MemberService {
	public void add(Member member) throws GoodsException;

	public List<Member> searchAll(PageBean pageBean);

	public Member search(String memid);
}





