package day02.dao;

import java.util.List;


import day02.vo.PageBean;

public interface GoodsDao {
	/**
	 * 상품정보 등록
	 * @param goods 등록할 상품 정보 객체
	 * @throws DataAccessException 동일한 상품을 등록시 발생 
	 */
	/**
	 * 상품정보 검색
	 * @param gno 검색할 상품 번호
	 * @return 검색된 상품정보를 저장하는 객체
	 * @throws DataAccessException 해당번호가 미등록시 발생
	 */
	public List<Goods> searchAll(PageBean pageBean);

	void insert(Goods goods);

	void update(Goods goods);

	void delete(int gno);

	Goods search(int gno);
}





