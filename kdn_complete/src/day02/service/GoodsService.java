package day02.service;

import java.util.List;

import day02.dao.Goods;
import day02.vo.PageBean;

public interface GoodsService {
	/**
	 * 상품등록 메서드. 
	 * @param goods 등록할 상품정보를 담은 객체
	 * @throws GoodsException 동일한 gno가 존재하면 발생
	 */
	public void add(Goods goods) throws GoodsException;

	public void update(Goods goods) throws GoodsException;

	public List<Goods> searchAll(PageBean pageBean);

	public void remove(int gno) throws GoodsException;

	public Goods search(int gno);

}





