/**
 * Copyright (C) 2015. Keegan小钢（http://keeganlee.me）
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.edison.netapi;


import com.edison.model.CouponBO;
import com.edison.model.PhoneInfo;

import java.util.List;

/**
 * Api接口
 *
 * @author xiaotufei
 * @date 16/03/06
 * @version 1.0
 */
public interface Api {


    public ApiResponse<PhoneInfo> phoneInfoByNumber(String phoneNum);


    /**
     * 券列表
     *
     * @param currentPage 当前页数
     * @param pageSize    每页显示数量
     * @return 成功时返回：{ "code": 0, "msg":"success", "objList":[...] }
     */
    public ApiResponse<List<CouponBO>> listNewCoupon(int currentPage, int pageSize);
}
