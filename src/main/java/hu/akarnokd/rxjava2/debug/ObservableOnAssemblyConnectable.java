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

package hu.akarnokd.rxjava2.debug;

import hu.akarnokd.rxjava2.debug.ObservableOnAssembly.OnAssemblyObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.observables.ConnectableObservable;

/**
 * Wraps a ObservableSource and inject the assembly info.
 *
 * @param <T> the value type
 */
final class ObservableOnAssemblyConnectable<T> extends ConnectableObservable<T> {

    final ConnectableObservable<T> source;

    final RxJavaAssemblyException assembled;

    ObservableOnAssemblyConnectable(ConnectableObservable<T> source) {
        this.source = source;
        this.assembled = new RxJavaAssemblyException();
    }

    @Override
    protected void subscribeActual(Observer<? super T> observer) {
        source.subscribe(new OnAssemblyObserver<T>(observer, assembled));
    }

    @Override
    public void connect(Consumer<? super Disposable> connection) {
        source.connect(connection);
    }
}
