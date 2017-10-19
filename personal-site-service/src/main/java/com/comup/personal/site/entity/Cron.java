package com.comup.personal.site.entity;

import com.comup.personal.site.entity.property.Repeat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.Instant;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Cron extends BaseEntity {

    private static final long serialVersionUID = -4390291065049024195L;

    /**
     * 标题
     */
    @Column(nullable = false)
    private String title;

    /**
     * 开始日期
     */
    @Column(nullable = false)
    private Instant startTime;

    /**
     * 备注
     */
    private String content;

    /**
     * 重复性质
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "`Repeat`")
    private Repeat repeat;
}
