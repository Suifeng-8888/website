package com.qh.hwebsite.common.base;
/*
 * @Author: zhangxd
 * @Version: v1.0
 * @CreateTime: 2019-09-04 09:46
 * @Package: com.elshou.sun.base.http
 * @Description: BaseQuery
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class BaseQuery<T> extends Pagination{

    private String name;
    private String search;
    private Long[] idList;
    private Long id;
    private Long userId;

    public QueryWrapper<T> toWrapper() {
        return new QueryWrapper<T>()
                .eq(notEmputy(userId), "user_id", userId)
                .eq(notEmputy(id), "id", id)
                .eq(notEmputy(name), "name", name)
                .in(notEmputy(idList), "id", (Object) idList)
                .likeLeft(notEmputy(search), "name", search)
                ;
    }

    protected static Boolean notEmputy(String s) {
       return s != null && ! s.isEmpty();
    }
    protected static Boolean notEmputy(Double s) {
       return s != null;
    }
    protected static Boolean notEmputy(Integer s) {
       return s != null;
    }
    protected static Boolean notEmputy(Long l) {
        return l != null && l > 0;
    }
    protected static Boolean notEmputy(Long[] l) {
        return l != null && l.length > 0;
    }

}
