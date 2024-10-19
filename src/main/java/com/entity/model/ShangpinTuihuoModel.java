package com.entity.model;

import com.entity.ShangpinTuihuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 商品退货
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShangpinTuihuoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 退货流水号
     */
    private String shangpinTuihuoUuidNumber;


    /**
     * 商品订单
     */
    private Integer shangpinOrderId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 退货原因
     */
    private String shangpinTuihuoContent;


    /**
     * 申请退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 退货快递公司
     */
    private String shangpinTuihuoCourierName;


    /**
     * 退货单号
     */
    private String shangpinTuihuoCourierNumber;


    /**
     * 退货状态
     */
    private Integer shangpinTuihuoTypes;


    /**
     * 审核状态
     */
    private Integer shangpinTuihuoYesnoTypes;


    /**
     * 审核意见
     */
    private String shangpinTuihuoYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shangpinTuihuoShenheTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：退货流水号
	 */
    public String getShangpinTuihuoUuidNumber() {
        return shangpinTuihuoUuidNumber;
    }


    /**
	 * 设置：退货流水号
	 */
    public void setShangpinTuihuoUuidNumber(String shangpinTuihuoUuidNumber) {
        this.shangpinTuihuoUuidNumber = shangpinTuihuoUuidNumber;
    }
    /**
	 * 获取：商品订单
	 */
    public Integer getShangpinOrderId() {
        return shangpinOrderId;
    }


    /**
	 * 设置：商品订单
	 */
    public void setShangpinOrderId(Integer shangpinOrderId) {
        this.shangpinOrderId = shangpinOrderId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：退货原因
	 */
    public String getShangpinTuihuoContent() {
        return shangpinTuihuoContent;
    }


    /**
	 * 设置：退货原因
	 */
    public void setShangpinTuihuoContent(String shangpinTuihuoContent) {
        this.shangpinTuihuoContent = shangpinTuihuoContent;
    }
    /**
	 * 获取：申请退货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：申请退货时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：退货快递公司
	 */
    public String getShangpinTuihuoCourierName() {
        return shangpinTuihuoCourierName;
    }


    /**
	 * 设置：退货快递公司
	 */
    public void setShangpinTuihuoCourierName(String shangpinTuihuoCourierName) {
        this.shangpinTuihuoCourierName = shangpinTuihuoCourierName;
    }
    /**
	 * 获取：退货单号
	 */
    public String getShangpinTuihuoCourierNumber() {
        return shangpinTuihuoCourierNumber;
    }


    /**
	 * 设置：退货单号
	 */
    public void setShangpinTuihuoCourierNumber(String shangpinTuihuoCourierNumber) {
        this.shangpinTuihuoCourierNumber = shangpinTuihuoCourierNumber;
    }
    /**
	 * 获取：退货状态
	 */
    public Integer getShangpinTuihuoTypes() {
        return shangpinTuihuoTypes;
    }


    /**
	 * 设置：退货状态
	 */
    public void setShangpinTuihuoTypes(Integer shangpinTuihuoTypes) {
        this.shangpinTuihuoTypes = shangpinTuihuoTypes;
    }
    /**
	 * 获取：审核状态
	 */
    public Integer getShangpinTuihuoYesnoTypes() {
        return shangpinTuihuoYesnoTypes;
    }


    /**
	 * 设置：审核状态
	 */
    public void setShangpinTuihuoYesnoTypes(Integer shangpinTuihuoYesnoTypes) {
        this.shangpinTuihuoYesnoTypes = shangpinTuihuoYesnoTypes;
    }
    /**
	 * 获取：审核意见
	 */
    public String getShangpinTuihuoYesnoText() {
        return shangpinTuihuoYesnoText;
    }


    /**
	 * 设置：审核意见
	 */
    public void setShangpinTuihuoYesnoText(String shangpinTuihuoYesnoText) {
        this.shangpinTuihuoYesnoText = shangpinTuihuoYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getShangpinTuihuoShenheTime() {
        return shangpinTuihuoShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setShangpinTuihuoShenheTime(Date shangpinTuihuoShenheTime) {
        this.shangpinTuihuoShenheTime = shangpinTuihuoShenheTime;
    }
    /**
	 * 获取：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
