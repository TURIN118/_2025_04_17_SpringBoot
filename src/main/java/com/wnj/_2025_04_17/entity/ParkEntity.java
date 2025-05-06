package com.wnj._2025_04_17.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "park_list")
public class ParkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "park_id")
    private Integer parkId;

    /**
     * 停车场名称（唯一）
     */
    @Column(name = "park_name", nullable = false, length = 255)
    private String parkName;

    /**
     * 停车场类型（如：室内/室外/立体）
     */
    @Column(name = "park_type", nullable = false, length = 255)
    private String parkType;

    /**
     * 停车场地址
     */
    @Column(name = "address", nullable = false, length = 255)
    private String address;

    /**
     * 总车位数量（默认0）
     */
    @Column(name = "total_spaces", nullable = false)
    private Integer totalSpaces = 0;

    /**
     * 当前可用车位（默认0）
     */
    @Column(name = "available_spaces", nullable = false)
    private Integer availableSpaces = 0;

    /**
     * 每小时收费标准（默认0.00）
     */
    @Column(name = "hourly_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal hourlyRate = BigDecimal.ZERO;

    /**
     * 开放时间（默认00:00:00）
     */
    @Column(name = "open_time", nullable = false)
    private LocalTime openTime = LocalTime.of(0, 0, 0);

    /**
     * 关闭时间（默认23:59:59）
     */
    @Column(name = "close_time", nullable = false)
    private LocalTime closeTime = LocalTime.of(23, 59, 59);

    /**
     * 联系电话
     */
    @Column(name = "contact_phone", length = 20)
    private String contactPhone;

    /**
     * 是否营业（1=营业中，0=暂停营业，默认1）
     */
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    /**
     * 创建时间（自动生成）
     */
    @CreationTimestamp
    @Column(name = "create_time", nullable = false, updatable = false)
    private LocalDateTime createTime;

    /**
     * 更新时间（自动更新）
     */
    @UpdateTimestamp
    @Column(name = "update_time", nullable = false)
    private LocalDateTime updateTime;
}
