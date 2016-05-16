package day02.dao;

import java.util.List;


import day02.vo.PageBean;

public interface GoodsDao {
	/**
	 * ��ǰ���� ���
	 * @param goods ����� ��ǰ ���� ��ü
	 * @throws DataAccessException ������ ��ǰ�� ��Ͻ� �߻� 
	 */
	/**
	 * ��ǰ���� �˻�
	 * @param gno �˻��� ��ǰ ��ȣ
	 * @return �˻��� ��ǰ������ �����ϴ� ��ü
	 * @throws DataAccessException �ش��ȣ�� �̵�Ͻ� �߻�
	 */
	public List<Goods> searchAll(PageBean pageBean);

	void insert(Goods goods);

	void update(Goods goods);

	void delete(int gno);

	Goods search(int gno);
}





