package day02.service;

import java.util.List;

import day02.dao.Goods;
import day02.vo.PageBean;

public interface GoodsService {
	/**
	 * ��ǰ��� �޼���. 
	 * @param goods ����� ��ǰ������ ���� ��ü
	 * @throws GoodsException ������ gno�� �����ϸ� �߻�
	 */
	public void add(Goods goods) throws GoodsException;

	public void update(Goods goods) throws GoodsException;

	public List<Goods> searchAll(PageBean pageBean);

	public void remove(int gno) throws GoodsException;

	public Goods search(int gno);

}





