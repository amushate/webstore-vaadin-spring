/**
 * 
 */
package com.annswered.online.shop.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author amushate
 *
 */
@Entity
@Table(name="stock_item")
public class StockItem implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stockitem_id")
	private int stockitemId;
	
	@Column(name="image")
	private String image;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="status")
	private ItemStatus status;
	
	@Column(name="measure")
	private ItemMeasure measure;
	
	@Column(name="created_by")
	private User createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate;
	
	@Column(name="suspended_by")
	private User suspendedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="suspend_date")
	private Date suspendDate;
	
	@Column(name="suspended")
	private boolean suspended;

	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getStockitemId() {
		return stockitemId;
	}

	public void setStockitemId(int stockitemId) {
		this.stockitemId = stockitemId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public void setStatus(ItemStatus status) {
		this.status = status;
	}

	public ItemMeasure getMeasure() {
		return measure;
	}

	public void setMeasure(ItemMeasure measure) {
		this.measure = measure;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getSuspendDate() {
		return suspendDate;
	}

	public void setSuspendDate(Date suspendDate) {
		this.suspendDate = suspendDate;
	}

	public boolean isSuspended() {
		return suspended;
	}

	public void setSuspended(boolean suspended) {
		this.suspended = suspended;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getSuspendedBy() {
		return suspendedBy;
	}

	public void setSuspendedBy(User suspendedBy) {
		this.suspendedBy = suspendedBy;
	}
	
	
}
