package com.example.tema2.async;

public interface Callback<R> {
    void runResultOnUiThread(R result);
}
