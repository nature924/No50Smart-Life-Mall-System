
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 商品退货
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shangpinTuihuo")
public class ShangpinTuihuoController {
    private static final Logger logger = LoggerFactory.getLogger(ShangpinTuihuoController.class);

    @Autowired
    private ShangpinTuihuoService shangpinTuihuoService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private ShangpinOrderService shangpinOrderService;
    @Autowired
    private YonghuService yonghuService;
    @Autowired
    private ShangpinService shangpinService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shangpinTuihuoService.queryPage(params);

        //字典表数据转换
        List<ShangpinTuihuoView> list =(List<ShangpinTuihuoView>)page.getList();
        for(ShangpinTuihuoView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinTuihuoEntity shangpinTuihuo = shangpinTuihuoService.selectById(id);
        if(shangpinTuihuo !=null){
            //entity转view
            ShangpinTuihuoView view = new ShangpinTuihuoView();
            BeanUtils.copyProperties( shangpinTuihuo , view );//把实体数据重构到view中

                //级联表
                ShangpinOrderEntity shangpinOrder = shangpinOrderService.selectById(shangpinTuihuo.getShangpinOrderId());
                if(shangpinOrder != null){
                    BeanUtils.copyProperties( shangpinOrder , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinOrderId(shangpinOrder.getId());
                    view.setShangpinOrderYonghuId(shangpinOrder.getYonghuId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shangpinTuihuo.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShangpinTuihuoEntity shangpinTuihuo, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shangpinTuihuo:{}",this.getClass().getName(),shangpinTuihuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role)){
            shangpinTuihuo.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
            shangpinTuihuo.setShangpinTuihuoTypes(1);
        }

        Wrapper<ShangpinTuihuoEntity> queryWrapper = new EntityWrapper<ShangpinTuihuoEntity>()
            .eq("shangpin_order_id", shangpinTuihuo.getShangpinOrderId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinTuihuoEntity shangpinTuihuoEntity = shangpinTuihuoService.selectOne(queryWrapper);
        if(shangpinTuihuoEntity==null){
            shangpinTuihuo.setInsertTime(new Date());
            shangpinTuihuo.setShangpinTuihuoYesnoTypes(1);
            shangpinTuihuo.setCreateTime(new Date());
            shangpinTuihuoService.insert(shangpinTuihuo);

            ShangpinOrderEntity shangpinOrderEntity = shangpinOrderService.selectById(shangpinTuihuo.getShangpinOrderId());
            if(shangpinOrderEntity == null)
                return R.error("查不到商品订单");
            shangpinOrderEntity.setShangpinOrderTypes(6);
            shangpinOrderService.updateById(shangpinOrderEntity);


            return R.ok();
        }else {
            return R.error(511,"该订单已经申请过退货.");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShangpinTuihuoEntity shangpinTuihuo, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shangpinTuihuo:{}",this.getClass().getName(),shangpinTuihuo.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shangpinTuihuo.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShangpinTuihuoEntity> queryWrapper = new EntityWrapper<ShangpinTuihuoEntity>()
            .notIn("id",shangpinTuihuo.getId())
            .andNew()
            .eq("shangpin_order_id", shangpinTuihuo.getShangpinOrderId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinTuihuoEntity shangpinTuihuoEntity = shangpinTuihuoService.selectOne(queryWrapper);
        if(shangpinTuihuoEntity==null){
            shangpinTuihuoService.updateById(shangpinTuihuo);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该订单已经申请过退货.");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody ShangpinTuihuoEntity shangpinTuihuoEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,shangpinTuihuoEntity:{}",this.getClass().getName(),shangpinTuihuoEntity.toString());


        ShangpinTuihuoEntity shangpinTuihuo = shangpinTuihuoService.selectById(shangpinTuihuoEntity.getId());
        ShangpinOrderEntity shangpinOrderEntity = shangpinOrderService.selectById(shangpinTuihuo.getShangpinOrderId());
        if(shangpinOrderEntity== null)
            return R.error("查不到商品订单");
        if(shangpinTuihuoEntity.getShangpinTuihuoYesnoTypes() == 2){//通过
            shangpinTuihuoEntity.setShangpinTuihuoTypes(2);
        }else if(shangpinTuihuoEntity.getShangpinTuihuoYesnoTypes() == 3){//拒绝
            shangpinTuihuoEntity.setShangpinTuihuoTypes(3);
            shangpinOrderEntity.setShangpinOrderTypes(7);
            shangpinOrderService.updateById(shangpinOrderEntity);
        }
        shangpinTuihuoEntity.setShangpinTuihuoShenheTime(new Date());//审核时间
        shangpinTuihuoService.updateById(shangpinTuihuoEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        shangpinTuihuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
    * 退货成功
    */
    @RequestMapping("/tuihuochenggong")
    public R tuihuochenggong(@RequestParam("id") Integer id){
        logger.debug("tuihuochenggong:,,Controller:{},,id:{}",this.getClass().getName(),id.toString());
        ShangpinTuihuoEntity shangpinTuihuoEntity = shangpinTuihuoService.selectById(id);
        if(shangpinTuihuoEntity == null)
            return R.error("查不到退货订单");
        ShangpinOrderEntity shangpinOrderEntity = shangpinOrderService.selectById(shangpinTuihuoEntity.getShangpinOrderId());
        if(shangpinOrderEntity == null)
            return R.error("查不到购买订单");
        ShangpinEntity shangpinEntity = shangpinService.selectById(shangpinOrderEntity.getShangpinId());
        if(shangpinEntity == null)
            return R.error("查不到商品");
        shangpinOrderEntity.setShangpinOrderTypes(8);
        shangpinTuihuoEntity.setShangpinTuihuoTypes(6);
        YonghuEntity yonghuEntity = yonghuService.selectById(shangpinOrderEntity.getYonghuId());
        if(yonghuEntity == null)
            return R.error("查不到购买的用户");

        Integer shangpinOrderPaymentTypes = shangpinOrderEntity.getShangpinOrderPaymentTypes();

        Double zhekou = 1.0;
        // 获取折扣
        Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                .eq("dic_code", "huiyuandengji_types")
                .eq("dic_name", "会员等级类型")
                .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                ;
        DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
        if(dictionaryEntity != null ){
            zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
        }


        //判断是什么支付方式 1代表余额 2代表积分
        if(shangpinOrderPaymentTypes == 1){//余额支付
            //计算金额
            Double money = shangpinOrderEntity.getShangpinOrderTruePrice();
            //计算所获得积分
            Double buyJifen = new BigDecimal(shangpinEntity.getShangpinPrice()).multiply(new BigDecimal(shangpinOrderEntity.getBuyNumber())).doubleValue();
            yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
            yonghuEntity.setYonghuSumJifen(yonghuEntity.getYonghuSumJifen() - buyJifen); //设置总积分

            yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分

            if(yonghuEntity.getYonghuSumJifen()  < 10000)
                yonghuEntity.setHuiyuandengjiTypes(1);
            else if(yonghuEntity.getYonghuSumJifen()  < 100000)
                yonghuEntity.setHuiyuandengjiTypes(2);
            else if(yonghuEntity.getYonghuSumJifen()  < 1000000)
                yonghuEntity.setHuiyuandengjiTypes(3);
            shangpinEntity.setShangpinKucunNumber(shangpinEntity.getShangpinKucunNumber() + shangpinOrderEntity.getBuyNumber());

        }


        yonghuService.updateById(yonghuEntity);//更新用户信息
        shangpinService.updateById(shangpinEntity);//更新订单中商品的信息
        shangpinOrderService.updateById(shangpinOrderEntity);//更改商品订单表数据
        shangpinTuihuoService.updateById(shangpinTuihuoEntity);//更改退货表数据
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShangpinTuihuoEntity> shangpinTuihuoList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShangpinTuihuoEntity shangpinTuihuoEntity = new ShangpinTuihuoEntity();
//                            shangpinTuihuoEntity.setShangpinTuihuoUuidNumber(data.get(0));                    //退货流水号 要改的
//                            shangpinTuihuoEntity.setShangpinOrderId(Integer.valueOf(data.get(0)));   //商品订单 要改的
//                            shangpinTuihuoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoContent("");//详情和图片
//                            shangpinTuihuoEntity.setInsertTime(date);//时间
//                            shangpinTuihuoEntity.setShangpinTuihuoCourierName(data.get(0));                    //退货快递公司 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoCourierNumber(data.get(0));                    //退货单号 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoTypes(Integer.valueOf(data.get(0)));   //退货状态 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoYesnoTypes(Integer.valueOf(data.get(0)));   //审核状态 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoYesnoText(data.get(0));                    //审核意见 要改的
//                            shangpinTuihuoEntity.setShangpinTuihuoShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            shangpinTuihuoEntity.setCreateTime(date);//时间
                            shangpinTuihuoList.add(shangpinTuihuoEntity);


                            //把要查询是否重复的字段放入map中
                                //退货流水号
                                if(seachFields.containsKey("shangpinTuihuoUuidNumber")){
                                    List<String> shangpinTuihuoUuidNumber = seachFields.get("shangpinTuihuoUuidNumber");
                                    shangpinTuihuoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shangpinTuihuoUuidNumber = new ArrayList<>();
                                    shangpinTuihuoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shangpinTuihuoUuidNumber",shangpinTuihuoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //退货流水号
                        List<ShangpinTuihuoEntity> shangpinTuihuoEntities_shangpinTuihuoUuidNumber = shangpinTuihuoService.selectList(new EntityWrapper<ShangpinTuihuoEntity>().in("shangpin_tuihuo_uuid_number", seachFields.get("shangpinTuihuoUuidNumber")));
                        if(shangpinTuihuoEntities_shangpinTuihuoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShangpinTuihuoEntity s:shangpinTuihuoEntities_shangpinTuihuoUuidNumber){
                                repeatFields.add(s.getShangpinTuihuoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [退货流水号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shangpinTuihuoService.insertBatch(shangpinTuihuoList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shangpinTuihuoService.queryPage(params);

        //字典表数据转换
        List<ShangpinTuihuoView> list =(List<ShangpinTuihuoView>)page.getList();
        for(ShangpinTuihuoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShangpinTuihuoEntity shangpinTuihuo = shangpinTuihuoService.selectById(id);
            if(shangpinTuihuo !=null){


                //entity转view
                ShangpinTuihuoView view = new ShangpinTuihuoView();
                BeanUtils.copyProperties( shangpinTuihuo , view );//把实体数据重构到view中

                //级联表
                    ShangpinOrderEntity shangpinOrder = shangpinOrderService.selectById(shangpinTuihuo.getShangpinOrderId());
                if(shangpinOrder != null){
                    BeanUtils.copyProperties( shangpinOrder , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShangpinOrderId(shangpinOrder.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shangpinTuihuo.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShangpinTuihuoEntity shangpinTuihuo, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shangpinTuihuo:{}",this.getClass().getName(),shangpinTuihuo.toString());
        Wrapper<ShangpinTuihuoEntity> queryWrapper = new EntityWrapper<ShangpinTuihuoEntity>()
            .eq("shangpin_tuihuo_uuid_number", shangpinTuihuo.getShangpinTuihuoUuidNumber())
            .eq("shangpin_order_id", shangpinTuihuo.getShangpinOrderId())
            .eq("yonghu_id", shangpinTuihuo.getYonghuId())
            .eq("shangpin_tuihuo_courier_name", shangpinTuihuo.getShangpinTuihuoCourierName())
            .eq("shangpin_tuihuo_courier_number", shangpinTuihuo.getShangpinTuihuoCourierNumber())
            .eq("shangpin_tuihuo_types", shangpinTuihuo.getShangpinTuihuoTypes())
            .eq("shangpin_tuihuo_yesno_types", shangpinTuihuo.getShangpinTuihuoYesnoTypes())
            .eq("shangpin_tuihuo_yesno_text", shangpinTuihuo.getShangpinTuihuoYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShangpinTuihuoEntity shangpinTuihuoEntity = shangpinTuihuoService.selectOne(queryWrapper);
        if(shangpinTuihuoEntity==null){
            shangpinTuihuo.setInsertTime(new Date());
            shangpinTuihuo.setShangpinTuihuoYesnoTypes(1);
            shangpinTuihuo.setCreateTime(new Date());
        shangpinTuihuoService.insert(shangpinTuihuo);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
