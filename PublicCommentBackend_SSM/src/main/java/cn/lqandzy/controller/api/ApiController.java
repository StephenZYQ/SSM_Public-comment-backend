package cn.lqandzy.controller.api;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.lqandzy.bean.Ad;
import cn.lqandzy.bean.BusinessList;
import cn.lqandzy.bean.CommentList;
import cn.lqandzy.bean.Detail;
import cn.lqandzy.bean.OrderList;

@RestController
@RequestMapping("api")
/**
 * 
 * @author Administrator
 * 
 */
public class ApiController {
	@RequestMapping(value="/homead",method={RequestMethod.GET})
	public List<Ad> homead() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="[{\"title\":\"暑假5折\",\"img\":\"http://localhost:8089/pic/timg.jpg\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"特价出国\",\"img\":\"http://localhost:8089/pic/timg1.jpg\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"亮亮车\",\"img\":\"http://localhost:8089/pic/timg2.jpg\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"学钢琴\",\"img\":\"http://localhost:8089/pic/timg3.jpg\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"电影\",\"img\":\"http://localhost:8089/pic/timg4.jpg\",\"link\":\"http://www.imooc.com/wap/index\"},{\"title\":\"旅游热线\",\"img\":\"http://localhost:8089/pic/timg5.jpg\",\"link\":\"http://www.imooc.com/wap/index\"}]";
		return objectMapper.readValue(src, new TypeReference<List<Ad>>(){});
	}
	
	@RequestMapping(value="/homelist/{city}/{page}",method={RequestMethod.GET})
	public BusinessList homelist() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="{\"hasMore\":true,\"data\":[{\"img\":\"http://localhost:8089/pic/timg.png\",\"title\":\"汉堡大大\",\"subTitle\":\"叫我汉堡大大，还你多彩口味\",\"price\":\"28\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"2554116589825297\"},{\"img\":\"http://localhost:8089/pic/timg.jpg\",\"title\":\"北京开源饭店\",\"subTitle\":\"[望京]自助晚餐\",\"price\":\"98\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"29996959128849454\"},{\"img\":\"http://localhost:8089/pic/timg2.jpg\",\"title\":\"服装定制\",\"subTitle\":\"原价xx元，现价xx元，可修改一次\",\"price\":\"1980\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"03790378676293504\"},{\"img\":\"http://localhost:8089/pic/timg3.jpg\",\"title\":\"婚纱摄影\",\"subTitle\":\"免费试穿，拍照留念\",\"price\":\"2899\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"683643453476581\"},{\"img\":\"http://localhost:8089/pic/timg1.jpg\",\"title\":\"麻辣串串烧\",\"subTitle\":\"双人免费套餐等你抢购\",\"price\":\"0\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"9332220056550227\"}]}";
		return objectMapper.readValue(src, new TypeReference<BusinessList>(){});
	}
	
	@RequestMapping(value="/search/{page}/{city}/{category}/{keyword}",method={RequestMethod.GET})
	public BusinessList search() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="{\"hasMore\":true,\"data\":[{\"img\":\"http://localhost:8089/pic/timg.png\",\"title\":\"汉堡大大\",\"subTitle\":\"叫我汉堡大大，还你多彩口味\",\"price\":\"28\",\"distance\":\"120m\",\"mumber\":\"389\",\"id\":\"2554116589825297\"},{\"img\":\"http://localhost:8089/pic/timg.jpg\",\"title\":\"北京开源饭店\",\"subTitle\":\"[望京]自助晚餐\",\"price\":\"98\",\"distance\":\"140m\",\"mumber\":\"689\",\"id\":\"29996959128849454\"},{\"img\":\"http://localhost:8089/pic/timg2.jpg\",\"title\":\"服装定制\",\"subTitle\":\"原价xx元，现价xx元，可修改一次\",\"price\":\"1980\",\"distance\":\"160\",\"mumber\":\"106\",\"id\":\"03790378676293504\"},{\"img\":\"http://localhost:8089/pic/timg3.jpg\",\"title\":\"婚纱摄影\",\"subTitle\":\"免费试穿，拍照留念\",\"price\":\"2899\",\"distance\":\"160\",\"mumber\":\"58\",\"id\":\"683643453476581\"},{\"img\":\"http://localhost:8089/pic/timg1.jpg\",\"title\":\"麻辣串串烧\",\"subTitle\":\"双人免费套餐等你抢购\",\"price\":\"0\",\"distance\":\"160\",\"mumber\":\"1426\",\"id\":\"9332220056550227\"}]}";
		return objectMapper.readValue(src, new TypeReference<BusinessList>(){});
	}
	
	@RequestMapping(value="/detail/info/{id}",method={RequestMethod.GET})
	public Detail info() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="{\"img\":\"http://localhost:8089/pic/timg2.jpg\",\"title\":\"天下第一锅\",\"star\":4,\"price\":\"88\",\"subTitle\":\"重庆 & 四川 麻辣火锅\",\"desc\":\"营业时间 11:00 - 21:00 <br> 电话订购 11:00 - 19:00 <br> 网络订购 11:00 - 19:00\"}";
		return objectMapper.readValue(src, new TypeReference<Detail>(){});
	}
	
	@RequestMapping(value="/detail/comment/{page}/{id}",method={RequestMethod.GET})
	public CommentList comment() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="{\"hasMore\":true,\"data\":[{\"username\":\"133****3355\",\"comment\":\"非常好吃，棒棒的，下次再来\",\"star\":5},{\"username\":\"135****3452\",\"comment\":\"羊肉够分量，不错\",\"star\":4},{\"username\":\"137****1242\",\"comment\":\"有自助的水果，非常喜欢\",\"star\":4},{\"username\":\"131****3980\",\"comment\":\"桌子环境有点糟糕，不喜欢\",\"star\":2},{\"username\":\"135****3565\",\"comment\":\"基本还可以，中规中矩吧，虽然没有啥惊喜\",\"star\":3},{\"username\":\"130****9879\",\"comment\":\"感觉很棒，服务员态度非常好\",\"star\":5},{\"username\":\"186****7570\",\"comment\":\"要是能多给开点发票就好了，哈哈啊\",\"star\":4}]}";
		return objectMapper.readValue(src, new TypeReference<CommentList>(){});
	}
	
	@RequestMapping(value="/orderlist/{username}",method={RequestMethod.GET})
	public List<OrderList> orderList() throws Exception{
		ObjectMapper objectMapper=new ObjectMapper();
		String src="[{\"id\":1507536360327,\"img\":\"http://localhost:8089/pic/timg.jpg\",\"title\":\"汉堡大王\",\"count\":3,\"price\":\"167\",\"commentState\":0},{\"id\":1507536360327,\"img\":\"http://localhost:8089/pic/timg1.jpg\",\"title\":\"麻辣香锅\",\"count\":1,\"price\":\"188\",\"commentState\":0},{\"id\":1507536360327,\"img\":\"http://localhost:8089/pic/timg2.jpg\",\"title\":\"好吃自出餐\",\"count\":2,\"price\":\"110\",\"commentState\":2}]";
		return objectMapper.readValue(src, new TypeReference<List<OrderList>>(){});
	}
	
	@RequestMapping(value="/submitComment",method={RequestMethod.GET})
	public void submitComment() throws Exception{
		
	}
	
	
}
