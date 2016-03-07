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
package com.edison.eaction;


import com.edison.model.CouponBO;
import com.edison.model.PhoneInfo;

import java.util.List;

/**
 * 接收app层的各种Action
 *
 * @author xiaotufei
 * @date 16/3/6
 * @version 1.0
 */
public interface AppAction {



    public void phoneInfo(String phoneNum,ActionCallbackListener<PhoneInfo> listener );



    /**
     * 券列表
     *
     * @param currentPage 当前页数
     * @param listener    回调监听器
     */
    public void listCoupon(int currentPage, ActionCallbackListener<List<CouponBO>> listener);


}
