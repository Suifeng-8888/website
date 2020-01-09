package com.qh.hwebsite.system.entity.query;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qh.hwebsite.common.base.BaseQuery;
import com.qh.hwebsite.system.entity.EmployInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmployQquey extends BaseQuery<EmployInfo> {

    private Long pid;
    @Override
    public QueryWrapper<EmployInfo> toWrapper() {
        return super.toWrapper().groupBy("pid");
    }
}
