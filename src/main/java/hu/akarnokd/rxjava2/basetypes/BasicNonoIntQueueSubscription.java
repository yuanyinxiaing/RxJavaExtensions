/*
 * Copyright 2016-2019 David Karnok
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

package hu.akarnokd.rxjava2.basetypes;

import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.internal.fuseable.QueueSubscription;

/**
 * Base class for atomic integer, async-fuseable intermediate operators.
 */
abstract class BasicNonoIntQueueSubscription extends AtomicInteger implements QueueSubscription<Void> {

    private static final long serialVersionUID = -4226314340037668732L;

    @Override
    public final boolean offer(Void e) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override
    public final boolean offer(Void v1, Void v2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override
    public final void clear() {
        // no-op
    }

    @Override
    public final boolean isEmpty() {
        return true;
    }

    @Override
    public final Void poll() throws Exception {
        return null;
    }

    @Override
    public final void request(long n) {
        // no-op
    }

    @Override
    public final int requestFusion(int mode) {
        return mode & ASYNC;
    }
}