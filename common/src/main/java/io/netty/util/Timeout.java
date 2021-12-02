/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.util;

/**
 * A handle associated with a {@link TimerTask} that is returned by a
 * {@link Timer}.
 */
// 表示HashedWheelTimer时间轮中的一个任务对象，即任务对象的句柄
public interface Timeout {

    /**
     * Returns the {@link Timer} that created this handle.
     */
    // 返回当前任务所在的时间轮对象
    Timer timer();

    /**
     * Returns the {@link TimerTask} which is associated with this handle.
     */
    // 返回任务对象
    TimerTask task();

    /**
     * Returns {@code true} if and only if the {@link TimerTask} associated
     * with this handle has been expired.
     */
    // 到达任务执行时间的状态，或者说是任务被执行过的状态，这个状态在任务被执行后更新
    boolean isExpired();

    /**
     * Returns {@code true} if and only if the {@link TimerTask} associated
     * with this handle has been cancelled.
     */
    // 任务是否被取消
    boolean isCancelled();

    /**
     * Attempts to cancel the {@link TimerTask} associated with this handle.
     * If the task has been executed or cancelled already, it will return with
     * no side effect.
     *
     * @return True if the cancellation completed successfully, otherwise false
     */
    // 取消执行任务
    boolean cancel();
}
