package day02.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import day02.vo.PageBean;
@Repository
public class GoodsDaoImpl implements GoodsDao{
	//타입에 따른 자동 할당. annotaion사용시엔 setter필요없음.
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	
	@Override
	public void insert(Goods goods)  {
		int rows = sessionTemplate.insert("insertGoods", goods);
	}

	@Override
	public Goods search(int gno)  {
		Goods goods=null;
		goods = sessionTemplate.selectOne("selectOne", gno);
		return goods;
	}

	@Override
	public List<Goods> searchAll(PageBean pageBean) {
		String key = pageBean.getKey();
		String word = pageBean.getWord();
		
		List<Goods> list = null;
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("end", pageBean.getEnd());
		map.put("key", key);
		map.put("word", word);

		list = sessionTemplate.selectList("selectAll", map);
		
		return list;
	}

	@Override
	public void update(Goods goods) {
		int rows = sessionTemplate.update("updateGoods", goods);
	}

	@Override
	public void delete(int gno) {
		int rows = sessionTemplate.delete("deleteGoods", gno);
	}
}

	
	
