package day02.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import day02.vo.PageBean;
@Repository
public class MemberDaoImpl implements MemberDao{
	//타입에 따른 자동 할당. annotaion사용시엔 setter필요없음.
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	@Override
	public void insert(Member Member)  {
		int rows = sessionTemplate.insert("insertMember", Member);
	}

	@Override
	public Member search(String memid)  {
		Member Member=null;
		Member = sessionTemplate.selectOne("selectOneMember", memid);
		return Member;
	}

	@Override
	public List<Member> searchAll(PageBean pageBean) {
		String key = pageBean.getKey();
		String word = pageBean.getWord();
		
		List<Member> list = null;
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("end", pageBean.getEnd());
		map.put("key", key);
		map.put("word", word);

		list = sessionTemplate.selectList("selectAllMember", map);
		
		return list;
	}

	@Override
	public void update(Member Member) {
		int rows = sessionTemplate.update("updateMember", Member);
	}

	@Override
	public void delete(String memid) {
		int rows = sessionTemplate.delete("deleteMember", memid);
	}
}

	
	
