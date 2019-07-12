/**
 * Copyright 2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.thierrysquirrel.annotation;

import com.aliyun.openservices.ons.api.transaction.TransactionStatus;

import java.lang.annotation.*;

/**
 * ClassName: TransactionMessage
 * Description:
 * date: 2019/4/27 21:39
 *
 * @author ThierrySquirrel
 * @since JDK 1.8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface TransactionMessage {
	/**
	 * Message 所属的 Topic
	 *
	 * @return String
	 */
	String topic() default "";

	/**
	 * 订阅指定 Topic 下的 Tags：
	 * 1. * 表示订阅所有消息
	 * 2. TagA || TagB || TagC 表示订阅 TagA 或 TagB 或 TagC 的消息
	 *
	 * @return String
	 */
	String tag() default "*";

	/**
	 * 触发消息回查后的操作：默认提交（最终一致性）
	 * 未收到消息确认时，会触发消息回查
	 * 例如消费长时间未发送
	 * 注意，正常情况下不会触发消息回查
	 *
	 * @return TransactionStatus
	 */
	TransactionStatus transactionStatus() default TransactionStatus.CommitTransaction;
}
