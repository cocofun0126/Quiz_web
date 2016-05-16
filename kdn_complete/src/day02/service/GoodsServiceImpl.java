package day02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import day02.dao.Goods;
import day02.dao.GoodsDao;
import day02.vo.PageBean;
//@Component
@Service
public class GoodsServiceImpl implements GoodsService{
	@Autowired
	private GoodsDao goodsDao;
	
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Override
	public void add(Goods goods) throws GoodsException {
		if(goodsDao.search(goods.getGno())!=null  )
			throw new GoodsException(" 등록된 상품입니다.");
		
		goodsDao.insert(goods);
	}

	@Override
	public List<Goods> searchAll(PageBean pageBean) {
		return goodsDao.searchAll(pageBean);
	}

	@Override
	public Goods search(int gno) {
		return goodsDao.search(gno);
	}

	@Override
	public void update(Goods goods) throws GoodsException {
		if(goodsDao.search(goods.getGno())==null  )
			throw new GoodsException(" 없는 상품입니다.");
		
		goodsDao.update(goods);
	}

//	@Override
//	public void remove(Goods goods) throws GoodsException {
//		if (goodsDao.search(goods.getGno()) == null)
//			throw new GoodsException(" 없 상품입니다.");
//		goodsDao.delete(goods.getGno());
//	}
	@Override
	public void remove(int gno) throws GoodsException {
		if (goodsDao.search(gno) == null)
			throw new GoodsException(" 없 상품입니다.");
		goodsDao.delete(gno);
	}

}
