package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 商品退货
 *
 * @author 
 * @email
 */
@TableName("shangpin_tuihuo")
public class ShangpinTuihuoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShangpinTuihuoEntity() {

	}

	public ShangpinTuihuoEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 退货流水号
     */
    @TableField(value = "shangpin_tuihuo_uuid_number")

    private String shangpinTuihuoUuidNumber;


    /**
     * 商品订单
     */
    @TableField(value = "shangpin_order_id")

    private Integer shangpinOrderId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 退货原因
     */
    @TableField(value = "shangpin_tuihuo_content")

    private String shangpinTuihuoContent;


    /**
     * 申请退货时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 退货快递公司
     */
    @TableField(value = "shangpin_tuihuo_courier_name")

    private String shangpinTuihuoCourierName;


    /**
     * 退货单号
     */
    @TableField(value = "shangpin_tuihuo_courier_number")

    private String shangpinTuihuoCourierNumber;


    /**
     * 退货状态
     */
    @TableField(value = "shangpin_tuihuo_types")

    private Integer shangpinTuihuoTypes;


    /**
     * 审核状态
     */
    @TableField(value = "shangpin_tuihuo_yesno_types")

    private Integer shangpinTuihuoYesnoTypes;


    /**
     * 审核意见
     */
    @TableField(value = "shangpin_tuihuo_yesno_text")

    private String shangpinTuihuoYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shangpin_tuihuo_shenhe_time")

    private Date shangpinTuihuoShenheTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：退货流水号
	 */
    public String getShangpinTuihuoUuidNumber() {
        return shangpinTuihuoUuidNumber;
    }
    /**
	 * 获取：退货流水号
	 */

    public void setShangpinTuihuoUuidNumber(String shangpinTuihuoUuidNumber) {
        this.shangpinTuihuoUuidNumber = shangpinTuihuoUuidNumber;
    }
    /**
	 * 设置：商品订单
	 */
    public Integer getShangpinOrderId() {
        return shangpinOrderId;
    }
    /**
	 * 获取：商品订单
	 */

    public void setShangpinOrderId(Integer shangpinOrderId) {
        this.shangpinOrderId = shangpinOrderId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：退货原因
	 */
    public String getShangpinTuihuoContent() {
        return shangpinTuihuoContent;
    }
    /**
	 * 获取：退货原因
	 */

    public void setShangpinTuihuoContent(String shangpinTuihuoContent) {
        this.shangpinTuihuoContent = shangpinTuihuoContent;
    }
    /**
	 * 设置：申请退货时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：申请退货时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：退货快递公司
	 */
    public String getShangpinTuihuoCourierName() {
        return shangpinTuihuoCourierName;
    }
    /**
	 * 获取：退货快递公司
	 */

    public void setShangpinTuihuoCourierName(String shangpinTuihuoCourierName) {
        this.shangpinTuihuoCourierName = shangpinTuihuoCourierName;
    }
    /**
	 * 设置：退货单号
	 */
    public String getShangpinTuihuoCourierNumber() {
        return shangpinTuihuoCourierNumber;
    }
    /**
	 * 获取：退货单号
	 */

    public void setShangpinTuihuoCourierNumber(String shangpinTuihuoCourierNumber) {
        this.shangpinTuihuoCourierNumber = shangpinTuihuoCourierNumber;
    }
    /**
	 * 设置：退货状态
	 */
    public Integer getShangpinTuihuoTypes() {
        return shangpinTuihuoTypes;
    }
    /**
	 * 获取：退货状态
	 */

    public void setShangpinTuihuoTypes(Integer shangpinTuihuoTypes) {
        this.shangpinTuihuoTypes = shangpinTuihuoTypes;
    }
    /**
	 * 设置：审核状态
	 */
    public Integer getShangpinTuihuoYesnoTypes() {
        return shangpinTuihuoYesnoTypes;
    }
    /**
	 * 获取：审核状态
	 */

    public void setShangpinTuihuoYesnoTypes(Integer shangpinTuihuoYesnoTypes) {
        this.shangpinTuihuoYesnoTypes = shangpinTuihuoYesnoTypes;
    }
    /**
	 * 设置：审核意见
	 */
    public String getShangpinTuihuoYesnoText() {
        return shangpinTuihuoYesnoText;
    }
    /**
	 * 获取：审核意见
	 */

    public void setShangpinTuihuoYesnoText(String shangpinTuihuoYesnoText) {
        this.shangpinTuihuoYesnoText = shangpinTuihuoYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getShangpinTuihuoShenheTime() {
        return shangpinTuihuoShenheTime;
    }
    /**
	 * 获取：审核时间
	 */

    public void setShangpinTuihuoShenheTime(Date shangpinTuihuoShenheTime) {
        this.shangpinTuihuoShenheTime = shangpinTuihuoShenheTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShangpinTuihuo{" +
            "id=" + id +
            ", shangpinTuihuoUuidNumber=" + shangpinTuihuoUuidNumber +
            ", shangpinOrderId=" + shangpinOrderId +
            ", yonghuId=" + yonghuId +
            ", shangpinTuihuoContent=" + shangpinTuihuoContent +
            ", insertTime=" + insertTime +
            ", shangpinTuihuoCourierName=" + shangpinTuihuoCourierName +
            ", shangpinTuihuoCourierNumber=" + shangpinTuihuoCourierNumber +
            ", shangpinTuihuoTypes=" + shangpinTuihuoTypes +
            ", shangpinTuihuoYesnoTypes=" + shangpinTuihuoYesnoTypes +
            ", shangpinTuihuoYesnoText=" + shangpinTuihuoYesnoText +
            ", shangpinTuihuoShenheTime=" + shangpinTuihuoShenheTime +
            ", createTime=" + createTime +
        "}";
    }
}
