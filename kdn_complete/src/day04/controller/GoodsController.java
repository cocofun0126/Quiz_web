package day04.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import day02.dao.Goods;
import day02.service.GoodsException;
import day02.service.GoodsService;
import day02.vo.PageBean;

@Controller
public class GoodsController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/goods_list.json")
	@ResponseBody
	public Map<String, Object> goods_list() {
		Map<String, Object> result = new HashMap<>();
		try {
			PageBean pagebean = new PageBean(null, null, 1);
			List<Goods> list = goodsService.searchAll(pagebean);
			result.put("code", "ok");
			result.put("data", list);
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/goods_update.json")
	@ResponseBody
	public Map<String, Object> goods_update(Goods goods) {
		Map<String, Object> result = new HashMap<>();
		try {
			goodsService.update(goods);
			result.put("code", "ok");
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	

//	@RequestMapping("/goods_remove.json")
//	@ResponseBody
//	public Map<String, Object> goods_remove(Goods goods) {
//		Map<String, Object> result = new HashMap<>();
//		try {
//			goodsService.remove(goods);
//			result.put("code", "ok");
//		} catch (Exception e) {
//			result.put("code", "fail");
//			result.put("msg", e.getMessage());
//		}
//		return result;
//	}
	
	@RequestMapping("/goods_remove.json")
	@ResponseBody
	public Map<String, Object> goods_remove(int gno) {
		Map<String, Object> result = new HashMap<>();
		try {
			goodsService.remove(gno);
			result.put("code", "ok");
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/goods_regist.json")
	@ResponseBody
	public Map<String, Object> goods_regist(Goods goods) {
		Map<String, Object> result = new HashMap<>();
		try {
			goodsService.add(goods);
			result.put("code", "ok");
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/goods_detail.json")
	@ResponseBody
	public Map<String, Object> goods_detail(@RequestParam("gno") int gno) {
		Map<String, Object> result = new HashMap<>();
		try {
			Goods goods = goodsService.search(gno);
			if (goods == null)
				throw new GoodsException("미등록된 상품입니다");

			result.put("code", "ok");
			result.put("data", goods);
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	@RequestMapping("/goods_search.json")
	@ResponseBody
	public Map<String, Object> goods_search(
			@RequestParam("key") String key,
			@RequestParam("word")String word
			){
		Map<String, Object> result = new HashMap<>();
		try {
			PageBean pagebean = new PageBean(key, word, 1);
			List<Goods> list = goodsService.searchAll(pagebean);
			result.put("code", "ok");
			result.put("data", list);
		} catch (Exception e) {
			result.put("code", "fail");
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	
}
