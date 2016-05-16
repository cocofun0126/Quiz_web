package day02.dao;

import java.util.List;


import day02.vo.PageBean;

public interface MemberDao {
	public List<Member> searchAll(PageBean pageBean);

	void insert(Member member);

	Member search(String memid);

	void update(Member Member);

	void delete(String memid);
}





