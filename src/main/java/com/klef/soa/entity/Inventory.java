package com.klef.soa.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
@Table(name="inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    @Column(name="Iname",length=100,nullable = false)
    private String name;

    @Column(name="Itype",length=100,nullable = false)
    private String type;

    @Column(name="Istatus",length=100,nullable = false)
    private String status;

    @Column(name="Iloc",length=100,nullable = false)
    private String location;

    @CreationTimestamp
    
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Inventory() {
    }

    public Long getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(Long inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

	@Override
	public String toString() {
		return "Inventory [inventoryId=" + inventoryId + ", name=" + name + ", type=" + type + ", status=" + status
				+ ", location=" + location + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

    
    
}