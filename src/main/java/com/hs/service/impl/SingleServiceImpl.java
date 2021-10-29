package com.hs.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hs.entity.*;
import com.hs.mapper.*;
import com.hs.service.SingleService;
import com.hs.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * (Single)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 20:54:50
 */
@Service
public class SingleServiceImpl implements SingleService {
    private int size=3;
    @Resource
    private LocationMapper locationMapper;

    @Resource
    private SingleMapper singleMapper;

    @Resource
    private CartMapper cartMapper;

    @Resource
    private OrdersMapper ordersMapper;

    @Resource
    private CommodityMapper commodityMapper;

    @Resource
    private LogisticMapper logisticMapper;

    @Resource
    private StatisticMapper statisticMapper;
    /**
     * 通过ID查询单条数据
     *
     * @param sinId 主键
     * @return 实例对象
     */
    @Override
    public Single queryById(Integer sinId) {
        return this.singleMapper.queryById(sinId);
    }


    @Override
    public PageInfo<Single> queryAllByLimit(int page) {
        PageHelper.startPage(page,size);
        Single single=new Single();
        List<Single> singleList = singleMapper.queryAll1(single);
        PageInfo<Single> pageInfo=new PageInfo<>(singleList);
        return pageInfo;
    }

    @Override
    public PageInfo<Single> queryAllAndLimit(int page, Single single) {
        PageHelper.startPage(page,size);
        List<Single> singleList = singleMapper.queryAll(single);
        PageInfo<Single> pageInfo=new PageInfo<>(singleList);
        return pageInfo;
    }

    @Transactional
    @Override
    public int insert(int[] carIds, Location location1) {
        Location location = locationMapper.queryById(location1.getLocId());
        Single single=new Single();
        Double a,b=0.0;
        int i=0,i1=0,i2=0,i3=0,i4=0,i5=0,i6=0,i7=0,i8=0,d=0,e=0,f=0,g=0,h=0,j=0;
        //订单编号
        int c=IDUtil.getID();
        single.setOrdId(c);
        for (int carId : carIds){
            /**
             * 添加对应的单一订单
             */
            Cart cart = cartMapper.queryById(carId);//对了
            //变动数量
            d=cart.getConNum();
            CommodityVO commodityVO = commodityMapper.queryById(cart.getComId());
            /**
             * 修改商品数量
             */
            Commodity commodity=new Commodity();
            //修改商品数量
            commodity.setComId(commodityVO.getComId());
            e=commodityVO.getComNum()-d;
            if (e<=0){
                e=0;
            }
            //库存数
            commodity.setComNum(e);
            //销量
            commodity.setComVolume(commodityVO.getComVolume()+d);
            /**
             * 更改商品统计表
             */
            //查询对应商品是否存在
            Statistic statistic=new Statistic();
            statistic.setComId(cart.getComId());

            List<Statistic> statistics = statisticMapper.queryAll(statistic);
            if (statistics!=null){
                //如果存在，更新商品
                for (Statistic statistic1 : statistics) {
                    statistic1.setComId(cart.getComId());
                    statistic1.setStaDate(LocalDateTime.now());
                    statistic1.setStaNum(commodity.getComVolume());
                    statistic1.setStaPurchPrice(commodityVO.getComPurchPrice()*statistic1.getStaNum());
                    statistic1.setStaPrice(commodityVO.getComPrice()*statistic1.getStaNum());
                    i7 =i7+ statisticMapper.update(statistic1);
                }

            }else {
                statistic.setStaDate(LocalDateTime.now());
                statistic.setStaNum(commodity.getComVolume());
                statistic.setStaPurchPrice(commodityVO.getComPurchPrice()*statistic.getStaNum());
                statistic.setStaPrice(commodityVO.getComPrice()*statistic.getStaNum());
                i8 =i8+ statisticMapper.insert(statistic);
            }
            //对应商品id
            single.setCommodity(commodity);
            //商品数量
            single.setSinNum(d);
            //单一订单价格
            a=commodityVO.getComPrice()*cart.getConNum();
            single.setSinPrice(a);
            b=a+b;
            //单一订单时间
            single.setGmtCreate(LocalDateTime.now());
            single.setGmtModified(LocalDateTime.now());
            //更新商品数量
            i5 =i5+ commodityMapper.update(commodity);
            //在单一订单表中插入数据
             i =i+ singleMapper.insert(single);
            /**
             * 清空购物车对应id
             */
            i1 =i1+ cartMapper.deleteById(carId);
        }
        /**
         * 订单添加
         */
        Orders orders=new Orders();
        //订单id
        orders.setOrdId(c);
        Consumer consumer=new Consumer();
        consumer.setConId(location.getConId());
        //订单对应用户id
        orders.setConsumer(consumer);
        //订单对应地址id
        orders.setLocation(location);
        //订单对应金额
        orders.setOrdTotalPrice(b);
        //订单状态
        double v = Math.random()*100/25;
        //快递方式，随机
        i6 = (int) Math.floor(v);
        if (i6==0){
            orders.setOrdRemark("邮政");
        }else if (i6==1){
            orders.setOrdRemark("顺丰");
        }else if (i6==2){
            orders.setOrdRemark("中通");
        }else if (i6==3){
            orders.setOrdRemark("邮政");
        }else {
            orders.setOrdRemark("圆通");
        }
        orders.setOrdStatus("未发货");
        orders.setGmtCreate(LocalDateTime.now());
        orders.setGmtModified(LocalDateTime.now());
        i2 = ordersMapper.insert(orders);
        /**
         * 新增物流表
         */
        Logistic logistic=new Logistic();
        logistic.setLogId(UUID.randomUUID().toString());
        //物流对应订单编号
        logistic.setOrders(orders);
        //物流状态，从订单中获取
        logistic.setLogStatus(orders.getOrdStatus());
        //物流时间
        logistic.setLogCreate(LocalDateTime.now());
        //预期到达日期
        logistic.setLogEstimate(LocalDateTime.now().plusDays(2).plusHours(16));
        i3 = logisticMapper.insert(logistic);//不对

        //前两个分别为订单表和物流表，后依次为单一订单表，购物车表，商品表，i7和i8都是统计表
        i4=i2+i3+i+i1+i5+i7+i8;
//        System.out.println(i);
//        System.out.println(i1);
//        System.out.println(i2);
//        System.out.println(i3);
//        System.out.println(i4);
//        System.out.println(i5);
//        System.out.println(i7);
//        System.out.println(i8);
        return i4;
    }


    /**
     * 修改数据
     *
     * @param single 实例对象
     * @return 实例对象
     */
    @Override
    public int update(Single single) {
        return this.singleMapper.update(single);
    }

    /**
     * 通过主键删除数据
     *
     * @param sinId 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(Integer sinId) {
        return this.singleMapper.deleteById(sinId);
    }
}